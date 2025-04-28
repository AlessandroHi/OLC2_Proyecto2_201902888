using System.Diagnostics.Eventing.Reader;
using System.Globalization;
using System.Reflection.Metadata;
using System.Security.Cryptography.X509Certificates;
using analyzer;
using Antlr4.Runtime.Misc;
using Microsoft.Extensions.Logging.Console;
using Proyecto1_OLC2;

public class CompilerVisitor : LanguageBaseVisitor<Object?>
{



 
     public ARMGenerator c = new ARMGenerator();

    public CompilerVisitor()
    {
      
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
         return null;
    }


    // VisitBlockStmt
    public override Object? VisitBlockStmt(LanguageParser.BlockStmtContext context)
    {
         return null;
    }


    // VisitAssign
    public override Object? VisitAssign(LanguageParser.AssignContext context)
    {

         return null;
    }


    // VisitExprStmt
    public override Object? VisitExprStmt(LanguageParser.ExprStmtContext context)
    {
         return null;
    }


    // VisitIdentifier
    public override Object? VisitIdentifier(LanguageParser.IdentifierContext context)
    {
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
       c.Pop(Register.X0);
       c.PrintInteger(Register.X0); //validar tipos 
       return null;
     }


    // VisitInt
    public override Object? VisitInt(LanguageParser.IntContext context)
    {
      var value = context.INT().GetText();
      c.Comment($"Integer: {value}");
      c.Mov(Register.X0, int.Parse(value));
      c.Push(Register.X0);
        return null;
    }


    // VisitFloat
    public override Object? VisitFloat(LanguageParser.FloatContext context)
    {
         return null;
        
    }


    // VisitBoolean
    public override Object? VisitBoolean(LanguageParser.BooleanContext context)  
    {
         return null;
    }


    // VisitString
    public override Object? VisitString(LanguageParser.StringContext context)
    {
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

         c.Pop(Register.X1);
         c.Pop(Register.X0);

          if (op == "+")
           {
                c.Add(Register.X0, Register.X0, Register.X1);
           }
           else if (op == "-")
           {
                c.Sub(Register.X0, Register.X0, Register.X1);
           }
           else
           {
                throw new Exception($"Unknown operator: {op}");
           }
          c.Push(Register.X0);


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


    //VisitMatrix
    public override Object? VisitMatrix(LanguageParser.MatrixContext context)
    {
         return null;

    }

    //VisitMatrixIndex
    public override Object? VisitMatrixIndex([NotNull] LanguageParser.MatrixIndexContext context)
    {
         return null;
    }


    // VisitIfStmt
    public override Object? VisitIfStmt(LanguageParser.IfStmtContext context)
    {
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
         return null;
    }


    //VisitForCondStmt
    public override Object? VisitForCondStmt(LanguageParser.ForCondStmtContext context)
    {
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
        return null;
    }

    //VisitContinueStmt
    public override Object? VisitContinueStmt(LanguageParser.ContinueStmtContext context)
    {
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

    public Object? Visitcall(Invocable invocable, LanguageParser.ArgsContext context)
    {
       return null;
    }

    //VisitFuncDcl
    public override Object? VisitFuncDcl(LanguageParser.FuncDclContext context)
    {
         return null;

    }


}

