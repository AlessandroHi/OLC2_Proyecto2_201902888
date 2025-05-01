using System.Diagnostics.Eventing.Reader;
using System.Globalization;
using System.Reflection.Metadata;
using System.Security.Cryptography.X509Certificates;
using analyzer;
using Antlr4.Runtime.Misc;
using Microsoft.AspNetCore.Mvc.ModelBinding;
using Microsoft.Extensions.Logging.Console;
using System.Globalization;


public class CompilerVisitor : LanguageBaseVisitor<Object?>
{



 
     public ARMGenerator c = new ARMGenerator(); 

    private String? continueLabel = null;// Etiqueta para el continue

    private String? breakLabel = null;// Etiqueta para el break

    private String? returnLabel = null;// Etiqueta para el return
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

         Visit(context.expr());
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
     return null;
    }

    //Visiti Print
     public override Object? VisitPrint(LanguageParser.PrintContext context)
     {
       c.Comment("Print");
       Visit(context.expr());
       c.Comment("Poping value");

       var isFloat = c.TopObject().Type == StackObject.StackObjectType.Float;
       var value = c.PopObject(isFloat? Register.D0 : Register.X0); // pop a nivel virtual
       

       if (value.Type == StackObject.StackObjectType.Int)
       {
          c.PrintInteger(Register.X0);
          
       } else if (value.Type == StackObject.StackObjectType.String)
       {
          c.PrintString(Register.X0);
       }
       else if (value.Type == StackObject.StackObjectType.Float)
       {
          c.PrintDouble();
       }
       else
       {
          throw new Exception($"Unknown type: {value.Type}");
       }
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
         return null;
    }


    // VisitRelational
    public override Object? VisitRelational(LanguageParser.RelationalContext context)
    {
         c.Comment("Relational operator");

         var op = context.op.Text;
         Visit(context.expr(0));
         Visit(context.expr(1));
         
         var isRightFloat = c.TopObject().Type == StackObject.StackObjectType.Float;
         var right = c.PopObject(isRightFloat ? Register.D0 : Register.X0); // pop a nivel virtual
         var isLeftFloat = c.TopObject().Type == StackObject.StackObjectType.Float;
         var left = c.PopObject(isLeftFloat ? Register.D1 : Register.X1); // pop a nivel virtual

           if (isLeftFloat || isRightFloat) //  para floats
           {
                
                return null;
           }


           c.Cmp(Register.X1, Register.X0);

           var trueLabel = c.GetLabel();
           var endlabe = c.GetLabel();

       
            switch (op)
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

            c.Mov(Register.X0, 0);
            c.Push(Register.X0);
            c.B(endlabe);
            c.SetLabel(trueLabel);
            c.Mov(Register.X0, 1);
            c.Push(Register.X0);
            c.SetLabel(endlabe);

            c.PushObject(c.BoolObject());


         return null;
    }

    //VisitLogical
    public override Object? VisitLogical(LanguageParser.LogicalContext context)
    {
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

    public object VisitForBody(LanguageParser.ForStmtContext context)
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
         return null;
    }


    //VisitCallee
    public override Object? VisitCallee(LanguageParser.CalleeContext context)
    {
         return null;
    }


    //VisitFuncDcl
    public override Object? VisitFuncDcl(LanguageParser.FuncDclContext context)
    {
         return null;

    }


}

