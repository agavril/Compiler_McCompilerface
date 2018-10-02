// Generated from Compiler.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CompilerParser}.
 */
public interface CompilerListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CompilerParser#expr_list_tail}.
	 * @param ctx the parse tree
	 */
	void enterExpr_list_tail(@NotNull CompilerParser.Expr_list_tailContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#expr_list_tail}.
	 * @param ctx the parse tree
	 */
	void exitExpr_list_tail(@NotNull CompilerParser.Expr_list_tailContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#id_list}.
	 * @param ctx the parse tree
	 */
	void enterId_list(@NotNull CompilerParser.Id_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#id_list}.
	 * @param ctx the parse tree
	 */
	void exitId_list(@NotNull CompilerParser.Id_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(@NotNull CompilerParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(@NotNull CompilerParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#param_decl_list}.
	 * @param ctx the parse tree
	 */
	void enterParam_decl_list(@NotNull CompilerParser.Param_decl_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#param_decl_list}.
	 * @param ctx the parse tree
	 */
	void exitParam_decl_list(@NotNull CompilerParser.Param_decl_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void enterAssign_expr(@NotNull CompilerParser.Assign_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void exitAssign_expr(@NotNull CompilerParser.Assign_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#any_type}.
	 * @param ctx the parse tree
	 */
	void enterAny_type(@NotNull CompilerParser.Any_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#any_type}.
	 * @param ctx the parse tree
	 */
	void exitAny_type(@NotNull CompilerParser.Any_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#postfix_expr}.
	 * @param ctx the parse tree
	 */
	void enterPostfix_expr(@NotNull CompilerParser.Postfix_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#postfix_expr}.
	 * @param ctx the parse tree
	 */
	void exitPostfix_expr(@NotNull CompilerParser.Postfix_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#addop}.
	 * @param ctx the parse tree
	 */
	void enterAddop(@NotNull CompilerParser.AddopContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#addop}.
	 * @param ctx the parse tree
	 */
	void exitAddop(@NotNull CompilerParser.AddopContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIf_stmt(@NotNull CompilerParser.If_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIf_stmt(@NotNull CompilerParser.If_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#func_declarations}.
	 * @param ctx the parse tree
	 */
	void enterFunc_declarations(@NotNull CompilerParser.Func_declarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#func_declarations}.
	 * @param ctx the parse tree
	 */
	void exitFunc_declarations(@NotNull CompilerParser.Func_declarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#else_part}.
	 * @param ctx the parse tree
	 */
	void enterElse_part(@NotNull CompilerParser.Else_partContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#else_part}.
	 * @param ctx the parse tree
	 */
	void exitElse_part(@NotNull CompilerParser.Else_partContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull CompilerParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull CompilerParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCond(@NotNull CompilerParser.CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCond(@NotNull CompilerParser.CondContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#base_stmt}.
	 * @param ctx the parse tree
	 */
	void enterBase_stmt(@NotNull CompilerParser.Base_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#base_stmt}.
	 * @param ctx the parse tree
	 */
	void exitBase_stmt(@NotNull CompilerParser.Base_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#func_body}.
	 * @param ctx the parse tree
	 */
	void enterFunc_body(@NotNull CompilerParser.Func_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#func_body}.
	 * @param ctx the parse tree
	 */
	void exitFunc_body(@NotNull CompilerParser.Func_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#compop}.
	 * @param ctx the parse tree
	 */
	void enterCompop(@NotNull CompilerParser.CompopContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#compop}.
	 * @param ctx the parse tree
	 */
	void exitCompop(@NotNull CompilerParser.CompopContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#var_type}.
	 * @param ctx the parse tree
	 */
	void enterVar_type(@NotNull CompilerParser.Var_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#var_type}.
	 * @param ctx the parse tree
	 */
	void exitVar_type(@NotNull CompilerParser.Var_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#mulop}.
	 * @param ctx the parse tree
	 */
	void enterMulop(@NotNull CompilerParser.MulopContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#mulop}.
	 * @param ctx the parse tree
	 */
	void exitMulop(@NotNull CompilerParser.MulopContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void enterExpr_list(@NotNull CompilerParser.Expr_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void exitExpr_list(@NotNull CompilerParser.Expr_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#stmt_list}.
	 * @param ctx the parse tree
	 */
	void enterStmt_list(@NotNull CompilerParser.Stmt_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#stmt_list}.
	 * @param ctx the parse tree
	 */
	void exitStmt_list(@NotNull CompilerParser.Stmt_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(@NotNull CompilerParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(@NotNull CompilerParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(@NotNull CompilerParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(@NotNull CompilerParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(@NotNull CompilerParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(@NotNull CompilerParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#keyword}.
	 * @param ctx the parse tree
	 */
	void enterKeyword(@NotNull CompilerParser.KeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#keyword}.
	 * @param ctx the parse tree
	 */
	void exitKeyword(@NotNull CompilerParser.KeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssign_stmt(@NotNull CompilerParser.Assign_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssign_stmt(@NotNull CompilerParser.Assign_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void enterReturn_stmt(@NotNull CompilerParser.Return_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void exitReturn_stmt(@NotNull CompilerParser.Return_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stmt(@NotNull CompilerParser.While_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stmt(@NotNull CompilerParser.While_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#pgm_body}.
	 * @param ctx the parse tree
	 */
	void enterPgm_body(@NotNull CompilerParser.Pgm_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#pgm_body}.
	 * @param ctx the parse tree
	 */
	void exitPgm_body(@NotNull CompilerParser.Pgm_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#param_decl}.
	 * @param ctx the parse tree
	 */
	void enterParam_decl(@NotNull CompilerParser.Param_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#param_decl}.
	 * @param ctx the parse tree
	 */
	void exitParam_decl(@NotNull CompilerParser.Param_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#loop_stmt}.
	 * @param ctx the parse tree
	 */
	void enterLoop_stmt(@NotNull CompilerParser.Loop_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#loop_stmt}.
	 * @param ctx the parse tree
	 */
	void exitLoop_stmt(@NotNull CompilerParser.Loop_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#call_expr}.
	 * @param ctx the parse tree
	 */
	void enterCall_expr(@NotNull CompilerParser.Call_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#call_expr}.
	 * @param ctx the parse tree
	 */
	void exitCall_expr(@NotNull CompilerParser.Call_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#control_stmt}.
	 * @param ctx the parse tree
	 */
	void enterControl_stmt(@NotNull CompilerParser.Control_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#control_stmt}.
	 * @param ctx the parse tree
	 */
	void exitControl_stmt(@NotNull CompilerParser.Control_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#string_decl}.
	 * @param ctx the parse tree
	 */
	void enterString_decl(@NotNull CompilerParser.String_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#string_decl}.
	 * @param ctx the parse tree
	 */
	void exitString_decl(@NotNull CompilerParser.String_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#str}.
	 * @param ctx the parse tree
	 */
	void enterStr(@NotNull CompilerParser.StrContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#str}.
	 * @param ctx the parse tree
	 */
	void exitStr(@NotNull CompilerParser.StrContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#read_stmt}.
	 * @param ctx the parse tree
	 */
	void enterRead_stmt(@NotNull CompilerParser.Read_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#read_stmt}.
	 * @param ctx the parse tree
	 */
	void exitRead_stmt(@NotNull CompilerParser.Read_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#func_decl}.
	 * @param ctx the parse tree
	 */
	void enterFunc_decl(@NotNull CompilerParser.Func_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#func_decl}.
	 * @param ctx the parse tree
	 */
	void exitFunc_decl(@NotNull CompilerParser.Func_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#factor_prefix}.
	 * @param ctx the parse tree
	 */
	void enterFactor_prefix(@NotNull CompilerParser.Factor_prefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#factor_prefix}.
	 * @param ctx the parse tree
	 */
	void exitFactor_prefix(@NotNull CompilerParser.Factor_prefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#id_tail}.
	 * @param ctx the parse tree
	 */
	void enterId_tail(@NotNull CompilerParser.Id_tailContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#id_tail}.
	 * @param ctx the parse tree
	 */
	void exitId_tail(@NotNull CompilerParser.Id_tailContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void enterVar_decl(@NotNull CompilerParser.Var_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void exitVar_decl(@NotNull CompilerParser.Var_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#param_decl_tail}.
	 * @param ctx the parse tree
	 */
	void enterParam_decl_tail(@NotNull CompilerParser.Param_decl_tailContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#param_decl_tail}.
	 * @param ctx the parse tree
	 */
	void exitParam_decl_tail(@NotNull CompilerParser.Param_decl_tailContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#write_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWrite_stmt(@NotNull CompilerParser.Write_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#write_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWrite_stmt(@NotNull CompilerParser.Write_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(@NotNull CompilerParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(@NotNull CompilerParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#expr_prefix}.
	 * @param ctx the parse tree
	 */
	void enterExpr_prefix(@NotNull CompilerParser.Expr_prefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#expr_prefix}.
	 * @param ctx the parse tree
	 */
	void exitExpr_prefix(@NotNull CompilerParser.Expr_prefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(@NotNull CompilerParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(@NotNull CompilerParser.PrimaryContext ctx);
}