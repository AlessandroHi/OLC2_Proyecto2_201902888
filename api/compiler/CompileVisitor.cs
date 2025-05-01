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
    var varName = context.ID().GetText();
    c.Comment($"Declarar variable: {varName}");

    // Verificar si hay una expresión
    if (context.expr() != null)
    {
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

        }
    }

    if (insideFunction != null)
    {
        var localObject = c.GetFrameLocal(framePointerOffset);
        var valueObject = c.PopObject(Register.X0);

        c.Mov(Register.X1, framePointerOffset * 8);
        c.Sub(Register.X1, Register.FP, Register.X1);
        c.Str(Register.X0, Register.X1);

        localObject.Type = valueObject.Type;
        framePointerOffset++;

        return null;  
    }
    
    // Etiquetar el objeto en la pila
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
         var assig = context.expr(0);

         if(assig is LanguageParser.IdentifierContext idContext){
          string varName = idContext.ID().GetText();
          c.Comment($"Asignar valor a variable: {varName}");
          Visit(context.expr(1));
          var value = c.PopObject(Register.X0); // pop a nivel virtual
          var (offset, varObject) = c.GetObject(varName);

          if (insideFunction != null)
          {
            c.Mov(Register.X1, varObject.Offset * 8); // REVISAR ESTO
            c.Sub(Register.X1, Register.FP, Register.X1);
            c.Str(Register.X0, Register.X1);
            return null;
          }


          c.Mov(Register.X1, offset);
          c.Add(Register.X1, Register.SP, Register.X1);
          c.Str(Register.X0, Register.X1);

          c.Push(Register.X0);
          c.PushObject(c.CloneObject(varObject));
  
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
         var op = context.op.Text;

         Visit(context.expr(0));

         Visit(context.expr(1));


         var isRightFloat = c.TopObject().Type == StackObject.StackObjectType.Float;
         var right = c.PopObject(isRightFloat ? Register.D0 : Register.X0); // pop a nivel virtual
         var isLeftFloat = c.TopObject().Type == StackObject.StackObjectType.Float;
         var left = c.PopObject(isLeftFloat ? Register.D1 : Register.X1); // pop a nivel virtual

         // se agrega validaciones semanticas 

          if (isLeftFloat || isRightFloat) //  para floats
          {
               if(!isLeftFloat) c.Scvtf(Register.D1, Register.X1);
               if(!isRightFloat) c.Scvtf(Register.D0, Register.X0);
               
               if (op == "+")
               {
                    c.Fadd(Register.D0, Register.D0, Register.D1);
               }
               else if (op == "-")
               {
                    c.Fsub(Register.D0, Register.D1, Register.D0);
               }
               else
               {
                    throw new Exception($"Unknown operator: {op}");
               }

               c.Comment($"Pushing {op} result");
               c.Push(Register.D0);
               c.PushObject(c.CloneObject(
                    isLeftFloat ? left: right
               ));

               return null;
          }

          if (op == "+")
           {
                c.Add(Register.X0, Register.X0, Register.X1);
           }
           else if (op == "-")
           {
                c.Sub(Register.X0, Register.X1, Register.X0);
           }
           else
           {
                throw new Exception($"Unknown operator: {op}");
           }
          c.Push(Register.X0);
          c.PushObject(c.CloneObject(left));


         return null;

    }


    // VisitMulDiv
    public override Object? VisitMulDivMod(LanguageParser.MulDivModContext context)
    {   
          var operador = context.op.Text;
        c.Comment("Estoy MulDivMod");
        c.Comment("izquierda: " );
        Visit(context.expr(0)); // visit 1; Pila[5]
        c.Comment("derecha: " );
        Visit(context.expr(1));  // visit 2; Pila[2,5]
        var isDerFloat = c.TopObject().Type == StackObject.StackObjectType.Float;
        var der = c.PopObject(isDerFloat ? Register.D0 : Register.X0);//Sale el 2
        var isIzqFloat = c.TopObject().Type == StackObject.StackObjectType.Float;
        var izq = c.PopObject(isIzqFloat ? Register.D1 : Register.X1); //Sale el 5
        var tipoIzq = izq.Type;
        var tipoDer = der.Type;
        if(isDerFloat || isIzqFloat)
        {
            if(isIzqFloat) c.Scvtf(Register.D0, Register.X0);
            if(isDerFloat) c.Scvtf(Register.D1, Register.X1);
            if(operador == "*"){
                c.Fmul(Register.D0, Register.D0, Register.D1);
            }
            else if(operador == "/"){
                c.Fdiv(Register.D0, Register.D1, Register.D0);
            }
          
            c.Push(Register.D0);
            c.PushObject(c.CloneObject(isIzqFloat ? izq : der));
            
            return null;
        }//enteros
        if(operador == "*")
        {
            if(tipoIzq == StackObject.StackObjectType.Int && tipoDer == StackObject.StackObjectType.Int)
            {
                c.Mul(Register.X0, Register.X0, Register.X1);
            }//Corregir
            
        }
        else if(operador == "/")
        {
            if(tipoIzq == StackObject.StackObjectType.Int && tipoDer == StackObject.StackObjectType.Int)
            {
                c.Sdiv(Register.X0, Register.X1, Register.X0);
            }//Aqui corregir
            
        }
        else if(operador == "%")
        {
            if(tipoIzq == StackObject.StackObjectType.Int && tipoDer == StackObject.StackObjectType.Int)
            {
                c.Mod(Register.X0, Register.X1, Register.X0);
            }
            
        }
        c.Push(Register.X0);
        c.PushObject(c.CloneObject(izq));
        
    
        return null;

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
       }else if(context.op.Text == "||"){

        c.Comment("Estoy en Or");
        Visit(context.expr(0));
        c.PopObject(Register.X0);
        var isOr = c.GetLabel();
        var endLabel = c.GetLabel();

        c.Cmp(Register.X0, "#0"); // Primero debo comparar el primer valor
        c.Bne(isOr);

        Visit(context.expr(1));
        c.PopObject(Register.X0);
        c.Cmp(Register.X0, "#0");//Ahora comparo el 2do
        c.Bne(isOr);

        c.Mov(Register.X0, 0);//Aqui pasa la magia 
        c.Push(Register.X0);
        c.PushObject(c.BoolObject());//Guardo en mi pila simulada
        c.B(endLabel);

        c.SetLabel(isOr);
        c.Mov(Register.X0, 1);
        c.Push(Register.X0);
        c.PushObject(c.BoolObject());

        c.SetLabel(endLabel);
        return null;
       }
    

         
         return null;
    }


    // VisitNot
    public override Object? VisitNot(LanguageParser.NotContext context)
    {

         return null;
    }

    //VisitSlice
    public override Object? VisitSlice(LanguageParser.SliceContext context)
    {
         return null;
    }

    //VisitSlices retorna la lista de expresiones
    public override Object? VisitSlices(LanguageParser.SlicesContext context)
    {
         return null;
    }

    //VisitIndex
    public override Object? VisitIndex(LanguageParser.IndexContext context)
    {
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
         return null;
    }


    // VisitCases

    public override Object? VisitCases(LanguageParser.CasesContext context)
    {
         return null;
    }



    //VisitDefaultCase
    public override Object? VisitDefaultSwitch(LanguageParser.DefaultSwitchContext context)
    {   
         return null;

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


    //VisitCallee
    public override Object? VisitCallee(LanguageParser.CalleeContext context)
    {
         
         if(context.expr() is not LanguageParser.IdentifierContext idContext) return null;

         c.Comment("Estoy en la llamada a funcion");

         string funcionName = idContext.ID().GetText();
         var call = context.call()[0];

         if(call is not LanguageParser.FuncCallContext callContext) return null;

         var postFuncCallLabel = c.GetLabel();    

         int baseOffset = 2;
         int stackElementsSize = 8;     

         c.Mov(Register.X0, baseOffset * stackElementsSize);
         c.Sub(Register.SP, Register.SP, Register.X0);

         if(callContext.args() != null)
         {
            c.Comment("Llamando a funcion parametros");
            foreach(var param in callContext.args().expr())
            {
                Visit(param);
            }
         }

         c.Mov(Register.X0, stackElementsSize *(baseOffset + callContext.args().expr().Length));
         c.Add(Register.SP, Register.SP, Register.X0);

         c.Mov(Register.X0, stackElementsSize);
         c.Sub(Register.X0, Register.SP, Register.X0);

         c.Adr(Register.X1 ,postFuncCallLabel);
         c.Push(Register.X1);

         c.Push(Register.FP);
         c.Add(Register.FP, Register.X0, Register.XZR);


         int frameSize = functions[funcionName].FrameSize;
         c.Mov(Register.X0, (frameSize - 2)* stackElementsSize);
         c.Sub(Register.SP, Register.SP, Register.X0);

         c.Comment($"Llamando a funcion: {funcionName}");
         c.Bl(funcionName);
         c.Comment($"Fin de funcion: {funcionName}");
         c.SetLabel(postFuncCallLabel);
         
         // OBtener el valor de retorno 
         var returnOffset = frameSize - 1;
         c.Mov(Register.X4, returnOffset * stackElementsSize);
         c.Sub(Register.X4, Register.FP, Register.X4);
         c.Ldr(Register.X4, Register.X4);

         c.Mov(Register.X1, stackElementsSize);
         c.Sub(Register.X1, Register.SP, Register.X1);
         c.Ldr(Register.FP, Register.X1); // load value

         c.Mov(Register.X0, stackElementsSize * frameSize );
         c.Add(Register.SP, Register.SP, Register.X0); // pop a nivel virtual

         c.Push(Register.X4); // push value

         c.PushObject(new StackObject()
         {
             Type = functions[funcionName].ReturnType,
             Id = null,
             Offset = 0,
             Length = 8
         });

         c.Comment("End of function call");


         return null;

    }


    //VisitFuncDcl
    public override Object? VisitFuncDcl(LanguageParser.FuncDclContext context)
    {

         c.Comment("Estoy en la declaracion de funcion");

         int baseOffset = 2;
         int paramsOffset = 0;

         if(context.@params() != null)
         {
            paramsOffset = context.@params().param().Length;
         }

         FrameVisitor frameVisitor = new FrameVisitor(baseOffset + paramsOffset);

         foreach(var dcl in context.dcl())
           {
               frameVisitor.Visit(dcl);
           }

          var frame = frameVisitor.Frame;
          int LocalOffset = frame.Count;
          int returnOffset = 1;

          int totalFrameSize = baseOffset + paramsOffset + LocalOffset + returnOffset;

          string funcionName = context.ID().GetText();
          c.Comment($"Declarando funcion: {funcionName}");
          StackObject.StackObjectType funcionType = GetType(context.type().GetText());

          functions.Add(funcionName, new FuncionMetadata()
          {
              FrameSize = totalFrameSize,
              ReturnType = funcionType
          });


          var prevInstruction = c.instructions;
          c.instructions = new List<string>();

          var paramCounter = 0;

          foreach(var param in context.@params().param())
          {
             c.PushObject( new StackObject()
             {
                 Type = GetType(param.type().GetText()),
                 Id = param.ID().GetText(),
                 Offset = baseOffset + paramCounter,
                 Length = 8
             });

             paramCounter++;
          }


          foreach(FrameElement element in frame)
          {
              c.PushObject(new StackObject()
              {
                  Type = StackObject.StackObjectType.Undefined,
                  Id = element.Name,
                  Offset = element.Offset,
                  Length = 8
              });
          }

          insideFunction = funcionName;
          framePointerOffset = 0;

          returnLabel = c.GetLabel();    

          c.Comment($"Inicia funcion: {funcionName}");

          c.SetLabel(funcionName);

          foreach(var dcl in context.dcl())
          {
              Visit(dcl);
          }

          c.SetLabel(returnLabel);

          c.Add(Register.X0, Register.FP, Register.XZR);
          c.Ldr(Register.LR, Register.X0);
          c.Br(Register.LR);

          c.Comment($"Fin de funcion: {funcionName}");

          for (int i = 0; i < paramsOffset + LocalOffset; i++)
          {
              c.PopObject();
          }

          foreach(var instruction in c.instructions)
          {
              c.funcInstructions.Add(instruction);
          }

          c.instructions = prevInstruction;
          insideFunction = null;

          return null;

    }

    private StackObject.StackObjectType GetType(string name)
    {
        switch (name)
        {
            case "int":
                return StackObject.StackObjectType.Int;
            case "float":
                return StackObject.StackObjectType.Float;
            case "string":
                return StackObject.StackObjectType.String;
            case "bool":
                return StackObject.StackObjectType.Bool;
            default:
                throw new Exception($"Unknown type: {name}");
        }
    }
}

