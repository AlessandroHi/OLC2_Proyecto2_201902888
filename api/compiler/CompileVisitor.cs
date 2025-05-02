using System.Diagnostics.Eventing.Reader;
using System.Globalization;
using System.Reflection.Metadata;
using System.Security.Cryptography.X509Certificates;
using analyzer;
using Antlr4.Runtime.Misc;
using Microsoft.AspNetCore.Mvc.ModelBinding;
using Microsoft.Extensions.Logging.Console;


public class FuncionMetadata
{
     public int FrameSize;

     public StackObject.StackObjectType ReturnType;
}




public class CompilerVisitor : LanguageBaseVisitor<Object?>
{



 
     public ARMGenerator c = new ARMGenerator(); 

    private String continueLabel = "";// Etiqueta para el continue

    private String breakLabel = "";// Etiqueta para el break

    private String returnLabel = "";// Etiqueta para el return

    private Dictionary<string, FuncionMetadata> functions = new Dictionary<string, FuncionMetadata>();
    private string? insideFunction = null;
    private int framePointerOffset = 0;

    public CompilerVisitor()
    {
      //todo: constructor
    }



    // VisitProgram
    public override Object? VisitProgram(LanguageParser.ProgramContext context)
    {
        foreach(var dcl in context.dcl())
        {
            Visit(dcl);
        }
        return null;
    }


    // VisitVarDcl
public override Object? VisitVarDcl(LanguageParser.VarDclContext context)
{
    // Obtener el nombre de la variable
    var varName = context.ID().GetText();
    c.Comment($"Declarar variable: {varName}");

    // Verificar si hay una expresión de inicialización
    if (context.expr() != null)
    {
        // Evaluar la expresión de inicialización
        Visit(context.expr());
    }
    else
    {
        // Asignar valor por defecto según el tipo
        var typeName = context.type()?.GetText()?.ToLower() ?? "undefined";

        switch (typeName)
        {
            case "int":
                c.PushConstant(c.IntObject(), 0);
                break;
            case "float64":
                c.PushConstant(c.FloatObject(), 0.0);
                break;
            case "string":
                c.PushConstant(c.StringObject(), "");
                break;
            case "bool":
                c.PushConstant(c.BoolObject(), false);
                break;
            case "rune":
                c.PushConstant(c.RuneObject(), '\0');
                break;
            default:
                throw new Exception($"Error: Tipo no soportado o indefinido para la variable '{varName}'.");
        }
    }

    // Manejo de variables locales dentro de funciones
    if (insideFunction != null)
    {
        // Obtener el objeto local del frame
        var localObject = c.GetFrameLocal(framePointerOffset);
        var valueObject = c.PopObject(Register.X0);

        // Calcular el offset en el frame y almacenar el valor
        c.Mov(Register.X1, framePointerOffset * 8);
        c.Sub(Register.X1, Register.FP, Register.X1);
        c.Str(Register.X0, Register.X1);

        // Actualizar el tipo del objeto local
        localObject.Type = valueObject.Type;
        framePointerOffset++;

        return null;
    }

    // Manejo de variables globales
    c.TagObject(varName);
    return null;
}


    // VisitBlockStmt
    public override Object? VisitBlockStmt(LanguageParser.BlockStmtContext context)
    {
         c.Comment("Inicia bloque");
         c.NewScope();
           foreach(var dcl in context.dcl())
           {
               Visit(dcl);
           }
           int byteToremove = c.endScope();

           if(byteToremove > 0)
           {
              c.Comment($"Remover {byteToremove} bytes del stack");
              c.Mov(Register.X0, byteToremove);
              c.Add(Register.SP, Register.SP, Register.X0);
               c.Comment($"Remover {byteToremove} bytes del stack");
           }
         return null;
    }


    // VisitAssign
public override Object? VisitAssign(LanguageParser.AssignContext context)
{
    // Obtener el nombre de la variable
    var assig = context.expr(0);

    if (assig is LanguageParser.IdentifierContext idContext)
    {
        string varName = idContext.ID().GetText();
        c.Comment($"Asignar valor a variable: {varName}");

        // Evaluar la expresión del lado derecho
        Visit(context.expr(1));
        var value = c.PopObject(Register.X0); // Valor a asignar

        // Verificar si la variable existe
        try
        {
            var (offset, varObject) = c.GetObject(varName);

            if (insideFunction != null)
            {
                // Asignación dentro de una función (manejo de frame pointer)
                c.Mov(Register.X1, varObject.Offset * 8); // Calcular offset en el frame
                c.Sub(Register.X1, Register.FP, Register.X1);
                c.Str(Register.X0, Register.X1); // Guardar el valor en el stack
            }
            else
            {
                // Asignación global (manejo de stack general)
                c.Mov(Register.X1, offset);
                c.Add(Register.X1, Register.SP, Register.X1);
                c.Str(Register.X0, Register.X1); // Guardar el valor en el stack
            }

            // Actualizar el tipo de la variable
            varObject.Type = value.Type;

            // Apilar el valor asignado
            c.Push(Register.X0);
            c.PushObject(c.CloneObject(varObject));
        }
        catch (ArgumentException)
        {
            throw new Exception($"Error: La variable '{varName}' no está declarada.");
        }
    }
    else
    {
        throw new Exception("Error: Asignación inválida. El lado izquierdo debe ser una variable.");
    }

    return null;
}


    // VisitExprStmt
    public override Object? VisitExprStmt(LanguageParser.ExprStmtContext context)
    {
           Visit(context.expr());
           c.PopObject(Register.X0); // pop a nivel virtual

         return null;
    }


    // VisitIdentifier
    public override Object? VisitIdentifier(LanguageParser.IdentifierContext context)
    {     
     var id = context.ID().GetText();
     c.Comment($"Identifier: {id}");

     var (offset, obj) = c.GetObject(id);


      if(insideFunction != null)
      {
         c.Mov(Register.X0, obj.Offset);
         c.Sub(Register.X0, Register.FP, Register.X0);
         c.Ldr(Register.X0, Register.X0); // load value
         c.Push(Register.X0); // push value
         var clonedObj = c.CloneObject(obj);
         clonedObj.Id = null;
         c.PushObject(clonedObj);
         return null;
    
      }



     c.Mov(Register.X0, offset);
     c.Add(Register.X0, Register.SP, Register.X0);
     c.Ldr(Register.X0, Register.X0); // load value
     c.Push(Register.X0); // push value

     var newObj = c.CloneObject(obj);
     newObj.Id = null;
     c.PushObject(newObj);
         return null;
    }



    // VisitParens
    public override Object? VisitParens(LanguageParser.ParensContext context)
    {
     Visit(context.expr());
        return null;
     
    }

    //Visiti Print
public override Object? VisitPrint(LanguageParser.PrintContext context)
{
    c.Comment("Print");
    
    foreach (var expr in context.expr()) // Visitar cada expresión a imprimir
    {
        Visit(expr);  
        var isFloat = c.TopObject().Type == StackObject.StackObjectType.Float;
        var valor = c.PopObject(isFloat ? Register.D0 : Register.X0); // Sale el valor a imprimir

        // Imprimir el valor según su tipo
        if (valor.Type == StackObject.StackObjectType.Int)
        {
            c.PrintInteger(Register.X0);
        }
        else if (valor.Type == StackObject.StackObjectType.String)
        {
            c.PrintString(Register.X0);
        }
        else if (valor.Type == StackObject.StackObjectType.Float)
        {
            c.PrintDouble();
        }
        else if (valor.Type == StackObject.StackObjectType.Bool)
        {
            c.PrintBool(Register.X0);
        }
        else if (valor.Type == StackObject.StackObjectType.Rune)
        {
            c.PrintRune(Register.X0);
        }
        else
        {
            throw new Exception($"Unknown type: {valor.Type}");
        }
        
        // Agregar espacio después de cada expresión (excepto la última)
        if (expr != context.expr().Last())
        {
            c.Comment("Imprimir espacio");
            c.Mov("x0", ' ');  // Cargar carácter espacio en x0
            c.Mov("x1", 1);     // Longitud 1
            c.Mov("x2", 1);     // File descriptor (stdout)
            c.Mov("w8", 64);    // Syscall write
            c.Svc();
        }
    }
    
    // Imprimir salto de línea al final
    c.Comment("Salto de línea");
    c.Adr("x1", "newline");
    c.Mov("x2", 1);
    c.Mov("x0", 1);
    c.Mov("w8", 64);
    c.Svc();

    return null;
}
    // VisitInt
    public override Object? VisitInt(LanguageParser.IntContext context)
    {
      var value = context.INT().GetText();
      c.Comment($"Integer: {value}");
      var IntObject = c.IntObject();
      c.PushConstant(IntObject, int.Parse(value));

      return null;
    }


    // VisitFloat
    public override Object? VisitFloat(LanguageParser.FloatContext context)
    {
         var value = context.FLOAT().GetText();
         c.Comment($"Float: {value}");

         var floatObject = c.FloatObject();
         c.PushConstant(floatObject, double.Parse(value, CultureInfo.InvariantCulture));
         return null;
        
    }


    // VisitBoolean
    public override Object? VisitBoolean(LanguageParser.BooleanContext context)  
    {
         var value = context.BOOL().GetText();
         c.Comment($"Boolean: {value}");
         c.PushConstant(c.BoolObject(), value == "true" ? true : false);
         return null;
    }


    // VisitString
    public override Object? VisitString(LanguageParser.StringContext context)
    {

       var value = context.STRING().GetText().Trim('"');
       c.Comment($"String: {value}");
       var stringObject = c.StringObject();
       c.PushConstant(stringObject, value);

       return null;
    }

    //VisitRune
    public override Object? VisitRune(LanguageParser.RuneContext context)
    {   
        var value = context.RUNE().GetText().Trim('\'');
        c.Comment($"Rune: {value}");
        var runeObject = c.RuneObject();
        c.PushConstant(runeObject, value[0]);
        return null;
        
    }

    //VisitNill
    public override Object? VisitNill(LanguageParser.NillContext context)
    {
         return null;
    }
    
    // VisitAddSub
    public override Object? VisitAddSub(LanguageParser.AddSubContext context)
    {   
          var operador = context.op.Text;
        c.Comment("Estoy en AddSub");

        // Visitar operandos
        c.Comment("Evaluando expresión izquierda");
        Visit(context.expr(0));
        c.Comment("Evaluando expresión derecha");
        Visit(context.expr(1));

        // Detectar tipos de operandos
        var isDerFloat = c.TopObject().Type == StackObject.StackObjectType.Float;
        var isDerString = c.TopObject().Type == StackObject.StackObjectType.String;
        var der = c.PopObject(isDerFloat ? Register.D0 : Register.X0); // Derecha

        var isIzqFloat = c.TopObject().Type == StackObject.StackObjectType.Float;
        var isIzqString = c.TopObject().Type == StackObject.StackObjectType.String;
        var izq = c.PopObject(isIzqFloat ? Register.D1 : Register.X1); // Izquierda

        var tipoIzq = izq.Type;
        var tipoDer = der.Type;

        // Caso: operación entre flotantes o combinación entero/float
        if (isDerFloat || isIzqFloat)
        {
            // Convertir enteros a float si es necesario
            if (!isIzqFloat) c.Scvtf(Register.D1, Register.X1); // izq
            if (!isDerFloat) c.Scvtf(Register.D0, Register.X0); // der

            if (operador == "+")
                c.Fadd(Register.D0, Register.D1, Register.D0); // D0 = izq + der
            else if (operador == "-")
                c.Fsub(Register.D0, Register.D1, Register.D0); // D0 = izq - der

            c.Push(Register.D0);
            c.PushObject(c.FloatObject());
            return null;
        }

        // Caso: operación entre cadenas (solo +)
        if (isIzqString && isDerString)
        {
            if (operador == "+")
            {
                c.Comment("Concatenación de strings");
                c.Push(Register.X0); // izq
                c.Push(Register.X1); // der
                c.ConcatenarString();     // resultado en X0
                c.Push(Register.X0);
                c.PushObject(c.StringObject());
            }
            return null;
        }

        // Caso: operación entre enteros
        if (tipoIzq == StackObject.StackObjectType.Int &&
            tipoDer == StackObject.StackObjectType.Int)
        {
            if (operador == "+")
            {
                c.Add(Register.X0, Register.X1, Register.X0); // X0 = izq + der
            }
            else if (operador == "-")
            {
                c.Sub(Register.X0, Register.X1, Register.X0); // X0 = izq - der
            }

            c.Push(Register.X0);
            c.PushObject(c.CloneObject(izq));
            return null;
        }

        // Si no se pudo procesar
        c.Comment("Operación no soportada entre los tipos dados.");
        return null;

    }


    // VisitMulDiv
public override Object? VisitMulDivMod(LanguageParser.MulDivModContext context)
{
    var operador = context.op.Text;
    c.Comment("Estoy MulDivMod");
    
    // Evalúa expresiones
    c.Comment("izquierda: ");
    Visit(context.expr(0));
    c.Comment("derecha: ");
    Visit(context.expr(1));

    // Determina tipos
    var isRightFloat = c.TopObject().Type == StackObject.StackObjectType.Float;
    var right = c.PopObject(isRightFloat ? Register.D1 : Register.X1);

    var isLeftFloat = c.TopObject().Type == StackObject.StackObjectType.Float;
    var left = c.PopObject(isLeftFloat ? Register.D0 : Register.X0);

    var leftType = left.Type;
    var rightType = right.Type;

    // Si uno es float, promovemos ambos a float
if (isLeftFloat || isRightFloat)
{
    if (!isLeftFloat) c.Scvtf(Register.D0, Register.X0); // int → float
    if (!isRightFloat) c.Scvtf(Register.D1, Register.X1); // int → float

    switch (operador)
    {
        case "*":
            c.Fmul(Register.D0, Register.D0, Register.D1);
            break;
        case "/":
            c.Fdiv(Register.D0, Register.D0, Register.D1);
            break;
        case "%":
            throw new NotSupportedException("El operador % no es válido entre floats.");
    }

    c.Push(Register.D0);
    c.PushObject(c.CloneObject(isLeftFloat ? left : right)); // 
    return null;
}


    // Si ambos son enteros
    if (leftType == StackObject.StackObjectType.Int && rightType == StackObject.StackObjectType.Int)
    {
        switch (operador)
        {
            case "*":
                c.Mul(Register.X0, Register.X0, Register.X1);
                break;
            case "/":
                c.Sdiv(Register.X0, Register.X0, Register.X1);
                break;
            case "%":
                c.Mod(Register.X0, Register.X0, Register.X1);
                break;
        }

        c.Push(Register.X0);
        c.PushObject(c.CloneObject(left));
        return null;
    }

    throw new NotSupportedException($"Operación {operador} no soportada para tipos {leftType} y {rightType}");
}




    //VisitIncDec
    public override Object? VisitIncDecAssign(LanguageParser.IncDecAssignContext context)
    {
         return null;

    }


    // VisitNegate
    public override Object? VisitNegate(LanguageParser.NegateContext context)
    {
 
        c.Comment("Negación Aritmética - (cambiar signo)");
    
        // Evaluar la expresión (ejemplo: -5 → primero se evalúa 5)
        Visit(context.expr());
        
        // Obtener el valor de la pila
        c.PopObject(Register.X0);  // X0 = valor a negar (ej: 5)
        
        // Negar el valor (X0 = -X0)
        c.Neg(Register.X0, Register.X0);  // Instrucción ARM para negación aritmética
        
        // Devolver el resultado
        c.Push(Register.X0);  // Push del valor negado (ej: -5)
        return null;
    }

    //VisitIncrement
    public override Object? VisitIncrement(LanguageParser.IncrementContext context)
    {
        c.Comment("Incremento");

        var id = context.ID().GetText();
        var (puntero, varObjeto) = c.GetObject(id);
        c.Mov(Register.X0, puntero);
        c.Add(Register.X0, Register.SP, Register.X0); // Calcular dirección
        c.Ldr(Register.X0, Register.X0);              // Cargar valor actual

        var isFloat = varObjeto.Type == StackObject.StackObjectType.Float;

        if (isFloat)
        {
            // Float: convertir a float, sumar 1.0, volver a convertir a int
            c.Scvtf("d0", "x0");
            c.Fmov1("d1", 1.0);                   // d1 = 1.0
            c.Fadd("d0", "d0", "d1");            // d0 = d0 + d1
            c.Fcvtns("x0", "d0");                // x0 = (int)d0
        }
        else
        {
            // Int: suma directa
            c.Add("x0", "x0", "#1");
        }

        // Guardar el nuevo valor
        c.Mov(Register.X1, puntero);
        c.Add(Register.X1, Register.SP, Register.X1);
        c.Str("x0", "x1");

        // Apilar resultado
        c.Push("x0");
        var nuevoValor = c.CloneObject(varObjeto);
        nuevoValor.Id = null;
        c.PushObject(nuevoValor);

        return null;

    }

    //VisitDecrement
    public override Object? VisitDecrement(LanguageParser.DecrementContext context)
    {
         return null;
    }


    // VisitEquality
    public override Object? VisitEquality(LanguageParser.EqualityContext context)
    {     
         var operador = context.op.Text;

         

        // Visita ambas expresiones
        Visit(context.expr(0)); // izquierda
        Visit(context.expr(1)); // derecha


        var isDerFloat = c.TopObject().Type == StackObject.StackObjectType.Float;
        var der = c.PopObject(isDerFloat ? Register.D1 : Register.X1); // Derecha en D1 o X1
        var isIzqFloat = c.TopObject().Type == StackObject.StackObjectType.Float;
        var izq = c.PopObject(isIzqFloat ? Register.D0 : Register.X0); // Izquierda en D0 o X0

        var trueLabel = c.GetLabel();
        var endLabel = c.GetLabel();

        if (isDerFloat || isIzqFloat)
        {
            // Convertir enteros a float si es necesario
            if (!isIzqFloat) c.Scvtf(Register.D0, Register.X0); // Izq a float
            if (!isDerFloat) c.Scvtf(Register.D1, Register.X1); // Der a float

            // Comparación flotante
            c.Fcmp(Register.D0, Register.D1);

            switch (operador)
            {
                case "==":
                    c.Beq(trueLabel);
                    break;
                case "!=":
                    c.Bne(trueLabel);
                    break;              
            }
        }
        else
        {
            // Comparación entera
            c.Cmp(Register.X0, Register.X1); // izq vs der

            switch (operador)
            {
                case "==":
                    c.Beq(trueLabel);
                    break;
                case "!=":
                    c.Bne(trueLabel);
                    break;    
            }
        }

        // Si no se cumple, falso
        c.Mov(Register.X0, 0);
        c.Push(Register.X0);
        c.B(endLabel);

        // Si se cumple, verdadero
        c.SetLabel(trueLabel);
        c.Mov(Register.X0, 1);
        c.Push(Register.X0);
        // Final

        c.SetLabel(endLabel);
        c.PushObject(c.BoolObject());

        return null;
     
    }


    // VisitRelational
    public override Object? VisitRelational(LanguageParser.RelationalContext context)
    {
        c.Comment("Estoy en Relacional");
        var operador = context.op.Text;

        // Visita ambas expresiones
        Visit(context.expr(0)); // izquierda
        Visit(context.expr(1)); // derecha

        var isDerFloat = c.TopObject().Type == StackObject.StackObjectType.Float;
        var der = c.PopObject(isDerFloat ? Register.D1 : Register.X1); // Derecha en D1 o X1
        var isIzqFloat = c.TopObject().Type == StackObject.StackObjectType.Float;
        var izq = c.PopObject(isIzqFloat ? Register.D0 : Register.X0); // Izquierda en D0 o X0

        var trueLabel = c.GetLabel();
        var endLabel = c.GetLabel();

        if (isDerFloat || isIzqFloat)
        {
            // Convertir enteros a float si es necesario
            if (!isIzqFloat) c.Scvtf(Register.D0, Register.X0); // Izq a float
            if (!isDerFloat) c.Scvtf(Register.D1, Register.X1); // Der a float

            // Comparación flotante
            c.Fcmp(Register.D0, Register.D1);

            switch (operador)
            {
                case "<":
                    c.Blt(trueLabel);
                    break;
                case ">":
                    c.Bgt(trueLabel);
                    break;
                case "<=":
                    c.Ble(trueLabel);
                    break;
                case ">=":
                    c.Bge(trueLabel);
                    break;
                
            }
        }
        else
        {
            // Comparación entera
            c.Cmp(Register.X0, Register.X1); // izq vs der

            switch (operador)
            {
                case "<":
                    c.Blt(trueLabel);
                    break;
                case ">":
                    c.Bgt(trueLabel);
                    break;
                case "<=":
                    c.Ble(trueLabel);
                    break;
                case ">=":
                    c.Bge(trueLabel);
                    break;
                
            }
        }

        // Si no se cumple, falso
        c.Mov(Register.X0, 0);
        c.Push(Register.X0);
        c.B(endLabel);

        // Si se cumple, verdadero
        c.SetLabel(trueLabel);
        c.Mov(Register.X0, 1);
        c.Push(Register.X0);

        // Final
        c.SetLabel(endLabel);
        c.PushObject(c.BoolObject());

        return null;
    }

    //VisitLogical
    public override Object? VisitLogical(LanguageParser.LogicalContext context)
    { 
       if (context.op.Text == "&&"){
          c.Comment("Estoy en And");
            // Evaluar primera expresión
            // Evaluar expr1
        Visit(context.expr(0));
        c.PopObject(Register.X0); // X0 = resultado expr1

        var falseLabel = c.GetLabel();
        var endLabel = c.GetLabel();

        // Si expr1 == 0, salto a falso
        c.Cmp(Register.X0, "#0");
        c.Beq(falseLabel); // Cortocircuito

        // Evaluar expr2 solo si expr1 fue verdadera
        Visit(context.expr(1));
        c.PopObject(Register.X0); // X0 = resultado expr2

        // Si expr2 == 0, también es falso
        c.Cmp(Register.X0, "#0");
        c.Beq(falseLabel);

        // Ambas fueron verdaderas
        c.Mov(Register.X0, 1);
        c.B(endLabel);

        // Al menos una fue falsa
        c.SetLabel(falseLabel);
        c.Mov(Register.X0, 0);

        // Fin
        c.SetLabel(endLabel);
        c.Push(Register.X0);
        c.PushObject(c.BoolObject());
        return null;
       }else if (context.op.Text == "||")
{
    c.Comment("Estoy en Or");

    Visit(context.expr(0));
    c.PopObject(Register.X0);
    var trueLabel = c.GetLabel();
    var endLabel = c.GetLabel();

    c.Cmp(Register.X0, "#0");
    c.Bne(trueLabel); // Si expr1 es verdadero, corto

    Visit(context.expr(1));
    c.PopObject(Register.X0);
    c.Cmp(Register.X0, "#0");
    c.Bne(trueLabel);

    // Ambos fueron falsos
    c.Mov(Register.X0, 0);
    c.B(endLabel);

    // Al menos uno fue verdadero
    c.SetLabel(trueLabel);
    c.Mov(Register.X0, 1);

    // Fin
    c.SetLabel(endLabel);
    c.Push(Register.X0);
    c.PushObject(c.BoolObject());
    return null;
}

    

         
         return null;
    }


    // VisitNot
    public override Object? VisitNot(LanguageParser.NotContext context)
    {
    c.Comment("Estoy en Not");

    // Evaluar la expresión booleana
    Visit(context.expr());
    c.PopObject(Register.X0); // X0 = resultado de expr

    // Negación lógica: X0 = (X0 == 0) ? 1 : 0
    c.Cmp(Register.X0, "#0");
    c.Cset(Register.X0, Register.EQ); // Si es 0 → 1, si no → 0

    c.Push(Register.X0);
    c.PushObject(c.BoolObject());
         return null;
    }

    //VisitSlice
public override object VisitSliceDcl([NotNull] LanguageParser.SliceDclContext context)
{
    string sliceName = context.ID().GetText();
    c.Comment($"Declaración del Slice: {sliceName}");

    // Inicializar el puntero base del slice en el heap
    c.Push(Register.HP);

    // Evaluar y almacenar los valores del slice
    if (context.expr() != null && context.expr().Length > 0)
    {
        foreach (var value in context.expr())
        {
            Visit(value);                           // Evalúa la expresión
            var valueObject = c.PopObject(Register.X0); // Valor de la expresión

            // Validar el tipo del valor (opcional, según los requisitos del slice)
            if (valueObject.Type != StackObject.StackObjectType.Int)
            {
                throw new Exception($"Error: El slice '{sliceName}' solo admite valores enteros.");
            }

            c.Str(Register.X0, Register.HP, 8);     // Guarda entero (64 bits) en heap
            c.Addi(Register.HP, Register.HP, 8);    // Avanza a la siguiente posición
        }
    }
    else
    {
        c.Comment($"El Slice '{sliceName}' se declara vacío.");
    }

    // Agregar un terminador nulo para indicar el final del slice
    c.Mov(Register.X0, 0);
    c.Str(Register.X0, Register.HP, 8);
    c.Addi(Register.HP, Register.HP, 8);

    // Simulación de objeto tipo slice
    var sliceObject = c.SliceObject();
    sliceObject.Id = sliceName; // Asignar el ID al objeto slice
    c.PushObject(sliceObject);

    // Registrar el slice en el stack
    if (insideFunction != null)
    {
        // Si estamos dentro de una función, registrar como variable local
        var localObject = c.GetFrameLocal(framePointerOffset);
        localObject.Type = sliceObject.Type;
        localObject.Id = sliceName;
        localObject.Offset = framePointerOffset;
        framePointerOffset++;
    }
    else
    {
        // Si es global, registrar en el stack global
        c.TagObject(sliceName);
    }

    return null;
}


public override object VisitSliceAsign([NotNull] LanguageParser.SliceAsignContext context)
{
    string id = context.ID().GetText();
    c.Comment($"Asignación al Slice: {id}");

    // Evaluar el valor a asignar y el índice
    Visit(context.expr(1)); // valor → X0
    Visit(context.expr(0)); // índice → X2

    c.PopObject(Register.X2); // índice
    c.PopObject(Register.X0); // valor a asignar

    // Obtener la dirección base del slice
    var (offset, tipo) = c.GetObject(id);
    c.Mov(Register.X1, offset); 
    c.Add(Register.X1, Register.HP, Register.X1); // X1 → puntero base del slice

    // Inicializar contador
    c.Mov(Register.X3, 0); // contador

    // Etiquetas
    string loop = c.GetLabel();
    string fin = c.GetLabel();
    string error = c.GetLabel();
    string exit = c.GetLabel();

    c.SetLabel(loop);
    c.Ldr(Register.X4, Register.X1, 8);      // cargar entero actual
    c.Cbz(Register.X4, error);               // si es 0, fuera de rango
    c.Cmp(Register.X3, Register.X2);         // contador == índice
    c.Beq(fin);                              // si sí, salta a asignar

    // avanzar a siguiente posición
    c.Addi(Register.X3, Register.X3, 1);    // contador++
    c.Addi(Register.X1, Register.X1, 8);    // mover puntero 8 bytes
    c.B(loop);                              // repetir

    // Asignación
    c.SetLabel(fin);
    c.Str(Register.X0, Register.X1, 8);     // guardar valor en posición
    c.B(exit);

    // Error
    c.SetLabel(error);
    c.Comment("Error: índice fuera de rango");

    c.SetLabel(exit);
    return null;
}

public override object VisitAccesoSlice([NotNull] LanguageParser.AccesoSliceContext context)
{
    string id = context.ID().GetText();
    c.Comment($"Acceso al Slice: {id}");

    // Evaluar el índice
    Visit(context.expr());
    c.PopObject(Register.X0); // índice

    // Obtener la dirección base del slice
    var (offset, tipo) = c.GetObject(id);
    c.Mov(Register.X1, offset);                 
    c.Add(Register.X1, Register.HP, Register.X1); // X1 → puntero base del slice

    // Inicializar contador
    c.Mov(Register.X3, 0); // contador

    // Etiquetas
    string loop = c.GetLabel();
    string fin = c.GetLabel();
    string error = c.GetLabel();
    string exit = c.GetLabel();

    c.SetLabel(loop);
    c.Ldr(Register.X4, Register.X1, 8);      // cargar entero actual
    c.Cbz(Register.X4, error);               // si es 0, fuera de rango
    c.Cmp(Register.X3, Register.X0);         // contador == índice
    c.Beq(fin);                              // si sí, saltar a lectura

    // avanzar
    c.Addi(Register.X3, Register.X3, 1);     
    c.Addi(Register.X1, Register.X1, 8);     // mover puntero 8 bytes
    c.B(loop);

    // Obtener el valor
    c.SetLabel(fin);
    c.Ldr(Register.X0, Register.X1, 8);      // cargar valor completo (64 bits)
    c.Push(Register.X0);                     // devolver valor
    c.B(exit);

    // Error
    c.SetLabel(error);
    c.Comment("Error: índice fuera de rango");

    c.SetLabel(exit);
    return null;
}



    // VisitIfStmt
    public override Object? VisitIfStmt(LanguageParser.IfStmtContext context)
    {

           /*
        if (context.ELSE() != null)
        {
            // Si hay un bloque else, visitar el bloque
            Visit(context.block());
        }
        else
        {
            // Si no hay bloque else, solo visitar la expresión
            Visit(context.expr());
        }   

        */
        c.Comment("Estoy en If");
        Visit(context.expr());//aqui hay un booleano
        c.Pop(Register.X0);
        var ifElse = context.stmt().Length > 1;
        if(ifElse){
            var elseLabel = c.GetLabel();
            var endLabel = c.GetLabel();
            c.Cbz(Register.X0, elseLabel);
            Visit(context.stmt(0));
            c.B(endLabel);
            c.SetLabel(elseLabel);
            Visit(context.stmt(1));
            c.SetLabel(endLabel);

        }
        else
        {
            var endLabel = c.GetLabel();
            c.Cbz(Register.X0, endLabel);
            Visit(context.stmt(0));
            c.SetLabel(endLabel);
        }
         

         return null;
    }


    //VisitSwitchStmt
public override Object? VisitSwitchStmt(LanguageParser.SwitchStmtContext context)
{
    c.Comment("Inicio de Switch Statement");

    // Evaluar la expresión del switch y almacenarla en X0
    Visit(context.expr());
    c.PopObject(Register.X0); // Valor del switch en X0
    c.Comment($"Valor del switch almacenado en {Register.X0}");

    // Guardar el valor del switch en la pila
    c.Str(Register.X0, "SP", -8); // SP = SP - 8; [SP] = X0
    c.Comment("Guardando el valor del switch en la pila");

    // Crear etiquetas para la salida del switch
    var endSwitchLabel = c.GetLabel();
    var defaultLabel = context.defaultSwitch() != null ? c.GetLabel() : endSwitchLabel;

    // Generar comparaciones para cada caso
    var caseLabels = new List<string>();
    foreach (var caseCtx in context.cases())
    {
        var caseLabel = c.GetLabel();
        caseLabels.Add(caseLabel);

        // Recuperar el valor del switch desde la pila (sin ajustar SP)
        c.Ldr(Register.X0, "SP", 0); // [SP] = X0, sin cambiar SP
        c.Comment("Recuperando el valor del switch desde la pila");

        // Evaluar la expresión del caso
        Visit(caseCtx.expr());
        c.PopObject(Register.X1); // Valor del caso en X1
        c.Comment($"Comparando {Register.X0} con {Register.X1}");

        // Comparar con el valor del switch
        c.Cmp(Register.X0, Register.X1);
        c.Beq(caseLabel); // Saltar al caso si son iguales
    }

    // Si no se encuentra una coincidencia, saltar al bloque default (si existe)
    if (context.defaultSwitch() != null)
    {
        c.Comment("No se encontró coincidencia, saltando al bloque default");
        c.B(defaultLabel);
    }
    else
    {
        c.Comment("No se encontró coincidencia, saltando al final del switch");
        c.B(endSwitchLabel);
    }

    // Generar bloques de código para cada caso
    for (int i = 0; i < context.cases().Length; i++)
    {
        c.SetLabel(caseLabels[i]);
        c.Comment($"Ejecutando caso {i + 1}");
        foreach (var stmt in context.cases()[i].stmt())
        {
            Visit(stmt); // Ejecutar las sentencias del caso
        }
        c.B(endSwitchLabel); // Saltar al final después de ejecutar el caso
    }

    // Generar el bloque default si existe
    if (context.defaultSwitch() != null)
    {
        c.SetLabel(defaultLabel);
        c.Comment("Ejecutando bloque default");
        foreach (var stmt in context.defaultSwitch().stmt())
        {
            Visit(stmt); // Ejecutar las sentencias del bloque default
        }
    }

    // Etiqueta final del switch
    c.SetLabel(endSwitchLabel);

    // Limpiar el valor del switch de la pila correctamente
    c.Add("SP", "SP", "#8"); // Restaurar el valor del stack pointer
    c.Comment("Limpiando el valor del switch de la pila");

    c.Comment("Fin de Switch Statement");

    return null; // El método debe retornar null para mantener la consistencia
}




    // VisitForStmt
    public override Object? VisitForStmt(LanguageParser.ForStmtContext context)
    {
         
      //Este es el for tipo for
        c.Comment("Estoy en el for clasico");
        var startLabel = c.GetLabel();
        var endLabel = c.GetLabel();
        var incrementLabel = c.GetLabel(); 

        var prevContinueLabel = continueLabel;
        var prevBreakLabel = breakLabel;

        continueLabel = incrementLabel;
        breakLabel = endLabel;

        c.NewScope();

        Visit(context.forInit());
        c.SetLabel(startLabel);
        Visit(context.expr(0));
        c.PopObject(Register.X0);
        c.Cbz(Register.X0, endLabel);
        Visit(context.stmt());
        c.SetLabel(incrementLabel);
        Visit(context.expr(1));
        c.B(startLabel);
        c.SetLabel(endLabel);

        c.Comment("End of for statement");

        var bytesToRemove = c.endScope();

        if(bytesToRemove > 0)
        {
            c.Comment("Removing " + bytesToRemove + "bytes from stack");
            c.Mov(Register.X0, bytesToRemove);
            c.Add(Register.SP, Register.SP, Register.X0 );
            c.Comment("stack pointer adjusted");
        }

        continueLabel = prevContinueLabel;
        breakLabel = prevBreakLabel;
        return null;
    }


    //VisitForCondStmt
    public override Object? VisitForCondStmt(LanguageParser.ForCondStmtContext context)
    {
          //Este es el for tipo while
        c.Comment("Estoy en for condicional");
    
        var startLable = c.GetLabel();
        var endLabel = c.GetLabel();

        var prevContinueLabel = continueLabel;
        var prevBreakLabel = breakLabel;

        continueLabel = startLable;
        breakLabel = endLabel;




        c.SetLabel(startLable);
        Visit(context.expr());
        c.PopObject(Register.X0);
        c.Cbz(Register.X0, endLabel);
        Visit(context.stmt());
        c.B(startLable);
        c.SetLabel(endLabel);

        c.Comment("End of while statement");

        
         // Restablecer etiquetas de continue y break
          continueLabel = prevContinueLabel;
          breakLabel = prevBreakLabel;  


        return null;

    }


    //VisitForRangeStmt
    public override Object? VisitForRange(LanguageParser.ForRangeContext context)
    {
         return null;
    }

    public object? VisitForBody(LanguageParser.ForStmtContext context)
    {
         return null;
    }
    //BODY DEL FOR


    //VisitBreakStmt
    public override Object? VisitBreakStmt(LanguageParser.BreakStmtContext context)
    {
        c.Comment("Estoy en break");
        if (breakLabel == null)
        {
            throw new Exception("Error: break statement outside of loop");
        }
        c.B(breakLabel);
        return null;
    }

    //VisitContinueStmt
    public override Object? VisitContinueStmt(LanguageParser.ContinueStmtContext context)
    {
         c.Comment("Estoy en continue");
        if (continueLabel == null)
        {
            throw new Exception("Error: continue statement outside of loop");
        }
        c.B(continueLabel);
        return null;
     
    }

    //VisitReturnStmt
    public override Object? VisitReturnStmt(LanguageParser.ReturnStmtContext context)
    {
        c.Comment("Estoy en return");
        
        if(context.expr() == null)
        {
          c.Br(returnLabel);
          return null;
        }

        if (insideFunction == null) throw new Exception("Error: return statement outside of function");


        Visit(context.expr());

        c.PopObject(Register.X0); // pop a nivel virtual

        var frameSize = functions[insideFunction].FrameSize;
        var returnOffset = frameSize - 1;
        c.Mov(Register.X1, returnOffset * 8);
        c.Sub(Register.X1, Register.FP, Register.X1);
        c.Str(Register.X0, Register.X1); // store return value
        c.B(returnLabel); // return to caller

        c.Comment("End of return statement");

         return null;
    }

    public override Object? VisitAtoiCall(LanguageParser.AtoiCallContext  context)
{
    c.Comment("Llamada a strconv.Atoi");

    // Evaluar el argumento (cadena)
    Visit(context.expr());
    var stringObject = c.PopObject(Register.X0);

    if (stringObject.Type != StackObject.StackObjectType.String)
    {
        throw new Exception("Error: strconv.Atoi solo acepta cadenas como argumento.");
    }

    // Llamar a la función atoi
    c.stdLib.Use("atoi");
    c.Bl("atoi");

    // Apilar el resultado como entero
    c.Push(Register.X0);
    c.PushObject(c.IntObject());
    return null;
}

public override Object? VisitParseFloatCall(LanguageParser.ParseFloatCallContext context)
{
    c.Comment("Llamada a strconv.ParseFloat");

    // Evaluar el argumento (cadena)
    Visit(context.expr());
    var stringObject = c.PopObject(Register.X0);

    if (stringObject.Type != StackObject.StackObjectType.String)
    {
        throw new Exception("Error: strconv.ParseFloat solo acepta cadenas como argumento.");
    }

    // Llamar a la función parse_float
    c.stdLib.Use("parse_float");
    c.Bl("parse_float");

    // Apilar el resultado como float
    c.Push(Register.D0);
    c.PushObject(c.FloatObject());
    return null;
}


    //VisitCallee
public override Object? VisitCallee(LanguageParser.CalleeContext context)
{
    if (context.expr() is not LanguageParser.IdentifierContext idContext) return null;

    c.Comment("Llamada a función");

    string functionName = idContext.ID().GetText();
    var call = context.call()[0];

    if (call is not LanguageParser.FuncCallContext callContext) return null;

    var postFuncCallLabel = c.GetLabel();

    // Reservar espacio para FP y LR
    int baseOffset = 2;
    int stackElementSize = 8;
    c.Mov(Register.X0, baseOffset * stackElementSize);
    c.Sub(Register.SP, Register.SP, Register.X0);

    // Pasar argumentos
    if (callContext.args() != null)
    {
        foreach (var param in callContext.args().expr())
        {
            Visit(param);
        }
    }

    // Ajustar el stack después de los argumentos
    c.Mov(Register.X0, stackElementSize * (baseOffset + callContext.args().expr().Length));
    c.Add(Register.SP, Register.SP, Register.X0);

    // Configurar FP y LR
    c.Mov(Register.X0, stackElementSize);
    c.Sub(Register.X0, Register.SP, Register.X0);
    c.Adr(Register.X1, postFuncCallLabel);
    c.Push(Register.X1);
    c.Push(Register.FP);
    c.Add(Register.FP, Register.X0, Register.XZR);

    // Reservar espacio para el frame local
    int frameSize = functions[functionName].FrameSize;
    c.Mov(Register.X0, (frameSize - 2) * stackElementSize);
    c.Sub(Register.SP, Register.SP, Register.X0);

    // Llamar a la función
    c.Comment($"Llamando a función: {functionName}");
    c.Bl(functionName);
    c.Comment($"Fin de función: {functionName}");
    c.SetLabel(postFuncCallLabel);

    // Recuperar el valor de retorno
    int returnOffset = frameSize - 1;
    c.Mov(Register.X4, returnOffset * stackElementSize);
    c.Sub(Register.X4, Register.FP, Register.X4);
    c.Ldr(Register.X4, Register.X4);

    // Restaurar FP y ajustar el stack
    c.Mov(Register.X1, stackElementSize);
    c.Sub(Register.X1, Register.SP, Register.X1);
    c.Ldr(Register.FP, Register.X1);
    c.Mov(Register.X0, stackElementSize * frameSize);
    c.Add(Register.SP, Register.SP, Register.X0);

    // Apilar el valor de retorno
    c.Push(Register.X4);
    c.PushObject(new StackObject
    {
        Type = functions[functionName].ReturnType,
        Id = null,
        Offset = 0,
        Length = 8
    });

    c.Comment("Fin de llamada a función");
    return null;
}


    //VisitFuncDcl
public override Object? VisitFuncDcl(LanguageParser.FuncDclContext context)
{
    c.Comment("Declaración de función");

    int baseOffset = 2; // FP y LR
    int paramsOffset = context.@params()?.param()?.Length ?? 0; // Manejar el caso de parámetros nulos

    // Calcular el tamaño del frame
    FrameVisitor frameVisitor = new FrameVisitor(baseOffset + paramsOffset);
    foreach (var dcl in context.dcl())
    {
        frameVisitor.Visit(dcl);
    }

    var frame = frameVisitor.Frame;
    int localOffset = frame.Count;
    int returnOffset = 1; // Espacio para el valor de retorno
    int totalFrameSize = baseOffset + paramsOffset + localOffset + returnOffset;

    string functionName = context.ID().GetText();
    c.Comment($"Función: {functionName}");
    StackObject.StackObjectType functionType = GetType(context.type()?.GetText() ?? "void");

    // Registrar metadatos de la función
    functions.Add(functionName, new FuncionMetadata
    {
        FrameSize = totalFrameSize,
        ReturnType = functionType
    });

    // Cambiar a un nuevo conjunto de instrucciones para la función
    var prevInstructions = c.instructions;
    c.instructions = new List<string>();

    // Manejo de parámetros
    int paramCounter = 0;
    foreach (var param in context.@params()?.param() ?? Enumerable.Empty<LanguageParser.ParamContext>())
    {
        c.PushObject(new StackObject
        {
            Type = GetType(param.type().GetText()),
            Id = param.ID().GetText(),
            Offset = baseOffset + paramCounter,
            Length = 8
        });
        paramCounter++;
    }

    // Manejo de variables locales
    foreach (var element in frame)
    {
        c.PushObject(new StackObject
        {
            Type = StackObject.StackObjectType.Undefined,
            Id = element.Name,
            Offset = element.Offset,
            Length = 8
        });
    }

    // Configurar etiquetas y contexto
    insideFunction = functionName;
    framePointerOffset = 0;
    returnLabel = c.GetLabel();

    // Generar código para la función
    c.Comment($"Inicio de función: {functionName}");
    c.SetLabel(functionName);

    foreach (var dcl in context.dcl())
    {
        Visit(dcl);
    }

    // Etiqueta de retorno
    c.SetLabel(returnLabel);
    c.Add(Register.X0, Register.FP, Register.XZR);
    c.Ldr(Register.LR, Register.X0);
    c.Br(Register.LR);

    c.Comment($"Fin de función: {functionName}");

    // Limpiar el stack
    for (int i = 0; i < paramsOffset + localOffset; i++)
    {
        c.PopObject();
    }

    // Guardar las instrucciones de la función
    foreach (var instruction in c.instructions)
    {
        c.funcInstructions.Add(instruction);
    }

    // Restaurar el contexto anterior
    c.instructions = prevInstructions;
    insideFunction = null;

    return null;
}
private StackObject.StackObjectType GetType(string name)
{
    switch (name)
    {
        case "int":
            return StackObject.StackObjectType.Int;
        case "float64":
            return StackObject.StackObjectType.Float;
        case "string":
            return StackObject.StackObjectType.String;
        case "bool":
            return StackObject.StackObjectType.Bool;
        case "void": // Agregar soporte para funciones sin retorno
            return StackObject.StackObjectType.Void;
        default:
            throw new Exception($"Unknown type: {name}");
    }
}
}

