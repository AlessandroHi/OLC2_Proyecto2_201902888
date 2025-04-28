// Generated from /home/alessandro/Escritorio/Proyecto2_OLC2/OLC2_Proyecto2_201902888/api/grammars/Language.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LanguageParser}.
 */
public interface LanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LanguageParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(LanguageParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(LanguageParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#dcl}.
	 * @param ctx the parse tree
	 */
	void enterDcl(LanguageParser.DclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#dcl}.
	 * @param ctx the parse tree
	 */
	void exitDcl(LanguageParser.DclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#varDcl}.
	 * @param ctx the parse tree
	 */
	void enterVarDcl(LanguageParser.VarDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#varDcl}.
	 * @param ctx the parse tree
	 */
	void exitVarDcl(LanguageParser.VarDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#matrix}.
	 * @param ctx the parse tree
	 */
	void enterMatrix(LanguageParser.MatrixContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#matrix}.
	 * @param ctx the parse tree
	 */
	void exitMatrix(LanguageParser.MatrixContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#slice}.
	 * @param ctx the parse tree
	 */
	void enterSlice(LanguageParser.SliceContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#slice}.
	 * @param ctx the parse tree
	 */
	void exitSlice(LanguageParser.SliceContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#funcDcl}.
	 * @param ctx the parse tree
	 */
	void enterFuncDcl(LanguageParser.FuncDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#funcDcl}.
	 * @param ctx the parse tree
	 */
	void exitFuncDcl(LanguageParser.FuncDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#structDcl}.
	 * @param ctx the parse tree
	 */
	void enterStructDcl(LanguageParser.StructDclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#structDcl}.
	 * @param ctx the parse tree
	 */
	void exitStructDcl(LanguageParser.StructDclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(LanguageParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(LanguageParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprStmt}
	 * labeled alternative in {@link LanguageParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterExprStmt(LanguageParser.ExprStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprStmt}
	 * labeled alternative in {@link LanguageParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitExprStmt(LanguageParser.ExprStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockStmt}
	 * labeled alternative in {@link LanguageParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterBlockStmt(LanguageParser.BlockStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockStmt}
	 * labeled alternative in {@link LanguageParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitBlockStmt(LanguageParser.BlockStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link LanguageParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(LanguageParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link LanguageParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(LanguageParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SwitchStmt}
	 * labeled alternative in {@link LanguageParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStmt(LanguageParser.SwitchStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SwitchStmt}
	 * labeled alternative in {@link LanguageParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStmt(LanguageParser.SwitchStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForStmt}
	 * labeled alternative in {@link LanguageParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(LanguageParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForStmt}
	 * labeled alternative in {@link LanguageParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(LanguageParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForCondStmt}
	 * labeled alternative in {@link LanguageParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterForCondStmt(LanguageParser.ForCondStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForCondStmt}
	 * labeled alternative in {@link LanguageParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitForCondStmt(LanguageParser.ForCondStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForRange}
	 * labeled alternative in {@link LanguageParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterForRange(LanguageParser.ForRangeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForRange}
	 * labeled alternative in {@link LanguageParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitForRange(LanguageParser.ForRangeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BreakStmt}
	 * labeled alternative in {@link LanguageParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterBreakStmt(LanguageParser.BreakStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BreakStmt}
	 * labeled alternative in {@link LanguageParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitBreakStmt(LanguageParser.BreakStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ContinueStmt}
	 * labeled alternative in {@link LanguageParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterContinueStmt(LanguageParser.ContinueStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ContinueStmt}
	 * labeled alternative in {@link LanguageParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitContinueStmt(LanguageParser.ContinueStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnStmt}
	 * labeled alternative in {@link LanguageParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(LanguageParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnStmt}
	 * labeled alternative in {@link LanguageParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(LanguageParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#cases}.
	 * @param ctx the parse tree
	 */
	void enterCases(LanguageParser.CasesContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#cases}.
	 * @param ctx the parse tree
	 */
	void exitCases(LanguageParser.CasesContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#defaultSwitch}.
	 * @param ctx the parse tree
	 */
	void enterDefaultSwitch(LanguageParser.DefaultSwitchContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#defaultSwitch}.
	 * @param ctx the parse tree
	 */
	void exitDefaultSwitch(LanguageParser.DefaultSwitchContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(LanguageParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(LanguageParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Callee}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCallee(LanguageParser.CalleeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Callee}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCallee(LanguageParser.CalleeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Slices}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSlices(LanguageParser.SlicesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Slices}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSlices(LanguageParser.SlicesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(LanguageParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(LanguageParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Logical}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogical(LanguageParser.LogicalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Logical}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogical(LanguageParser.LogicalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Index}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIndex(LanguageParser.IndexContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Index}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIndex(LanguageParser.IndexContext ctx);
	/**
	 * Enter a parse tree produced by the {@code String}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterString(LanguageParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code String}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitString(LanguageParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Int}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInt(LanguageParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInt(LanguageParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDivMod}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDivMod(LanguageParser.MulDivModContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDivMod}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDivMod(LanguageParser.MulDivModContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Identifier}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(LanguageParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Identifier}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(LanguageParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Increment}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIncrement(LanguageParser.IncrementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Increment}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIncrement(LanguageParser.IncrementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Embedded}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEmbedded(LanguageParser.EmbeddedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Embedded}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEmbedded(LanguageParser.EmbeddedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Equality}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEquality(LanguageParser.EqualityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Equality}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEquality(LanguageParser.EqualityContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Boolean}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(LanguageParser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Boolean}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(LanguageParser.BooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MatrixIndex}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMatrixIndex(LanguageParser.MatrixIndexContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MatrixIndex}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMatrixIndex(LanguageParser.MatrixIndexContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Decrement}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDecrement(LanguageParser.DecrementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Decrement}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDecrement(LanguageParser.DecrementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IncDecAssign}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIncDecAssign(LanguageParser.IncDecAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IncDecAssign}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIncDecAssign(LanguageParser.IncDecAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(LanguageParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(LanguageParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InStruct}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInStruct(LanguageParser.InStructContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InStruct}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInStruct(LanguageParser.InStructContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Relational}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRelational(LanguageParser.RelationalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Relational}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRelational(LanguageParser.RelationalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Float}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFloat(LanguageParser.FloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Float}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFloat(LanguageParser.FloatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Not}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNot(LanguageParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNot(LanguageParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAssign(LanguageParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAssign(LanguageParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Negate}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNegate(LanguageParser.NegateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Negate}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNegate(LanguageParser.NegateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Rune}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRune(LanguageParser.RuneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Rune}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRune(LanguageParser.RuneContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Nill}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNill(LanguageParser.NillContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Nill}
	 * labeled alternative in {@link LanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNill(LanguageParser.NillContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FuncCall}
	 * labeled alternative in {@link LanguageParser#call}.
	 * @param ctx the parse tree
	 */
	void enterFuncCall(LanguageParser.FuncCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FuncCall}
	 * labeled alternative in {@link LanguageParser#call}.
	 * @param ctx the parse tree
	 */
	void exitFuncCall(LanguageParser.FuncCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Get}
	 * labeled alternative in {@link LanguageParser#call}.
	 * @param ctx the parse tree
	 */
	void enterGet(LanguageParser.GetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Get}
	 * labeled alternative in {@link LanguageParser#call}.
	 * @param ctx the parse tree
	 */
	void exitGet(LanguageParser.GetContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(LanguageParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(LanguageParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#props}.
	 * @param ctx the parse tree
	 */
	void enterProps(LanguageParser.PropsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#props}.
	 * @param ctx the parse tree
	 */
	void exitProps(LanguageParser.PropsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(LanguageParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(LanguageParser.TypeContext ctx);
}