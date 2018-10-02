// Generated from Compiler.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CompilerParser}.
 */
public interface CompilerListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CompilerParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(CompilerParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(CompilerParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(CompilerParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(CompilerParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#pgm_body}.
	 * @param ctx the parse tree
	 */
	void enterPgm_body(CompilerParser.Pgm_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#pgm_body}.
	 * @param ctx the parse tree
	 */
	void exitPgm_body(CompilerParser.Pgm_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(CompilerParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(CompilerParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#string_decl}.
	 * @param ctx the parse tree
	 */
	void enterString_decl(CompilerParser.String_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#string_decl}.
	 * @param ctx the parse tree
	 */
	void exitString_decl(CompilerParser.String_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#str}.
	 * @param ctx the parse tree
	 */
	void enterStr(CompilerParser.StrContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#str}.
	 * @param ctx the parse tree
	 */
	void exitStr(CompilerParser.StrContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void enterVar_decl(CompilerParser.Var_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void exitVar_decl(CompilerParser.Var_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#var_type}.
	 * @param ctx the parse tree
	 */
	void enterVar_type(CompilerParser.Var_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#var_type}.
	 * @param ctx the parse tree
	 */
	void exitVar_type(CompilerParser.Var_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#any_type}.
	 * @param ctx the parse tree
	 */
	void enterAny_type(CompilerParser.Any_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#any_type}.
	 * @param ctx the parse tree
	 */
	void exitAny_type(CompilerParser.Any_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#id_list}.
	 * @param ctx the parse tree
	 */
	void enterId_list(CompilerParser.Id_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#id_list}.
	 * @param ctx the parse tree
	 */
	void exitId_list(CompilerParser.Id_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#id_tail}.
	 * @param ctx the parse tree
	 */
	void enterId_tail(CompilerParser.Id_tailContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#id_tail}.
	 * @param ctx the parse tree
	 */
	void exitId_tail(CompilerParser.Id_tailContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#param_decl_list}.
	 * @param ctx the parse tree
	 */
	void enterParam_decl_list(CompilerParser.Param_decl_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#param_decl_list}.
	 * @param ctx the parse tree
	 */
	void exitParam_decl_list(CompilerParser.Param_decl_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#param_decl}.
	 * @param ctx the parse tree
	 */
	void enterParam_decl(CompilerParser.Param_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#param_decl}.
	 * @param ctx the parse tree
	 */
	void exitParam_decl(CompilerParser.Param_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#param_decl_tail}.
	 * @param ctx the parse tree
	 */
	void enterParam_decl_tail(CompilerParser.Param_decl_tailContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#param_decl_tail}.
	 * @param ctx the parse tree
	 */
	void exitParam_decl_tail(CompilerParser.Param_decl_tailContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#func_declarations}.
	 * @param ctx the parse tree
	 */
	void enterFunc_declarations(CompilerParser.Func_declarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#func_declarations}.
	 * @param ctx the parse tree
	 */
	void exitFunc_declarations(CompilerParser.Func_declarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#func_decl}.
	 * @param ctx the parse tree
	 */
	void enterFunc_decl(CompilerParser.Func_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#func_decl}.
	 * @param ctx the parse tree
	 */
	void exitFunc_decl(CompilerParser.Func_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#func_body}.
	 * @param ctx the parse tree
	 */
	void enterFunc_body(CompilerParser.Func_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#func_body}.
	 * @param ctx the parse tree
	 */
	void exitFunc_body(CompilerParser.Func_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#stmt_list}.
	 * @param ctx the parse tree
	 */
	void enterStmt_list(CompilerParser.Stmt_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#stmt_list}.
	 * @param ctx the parse tree
	 */
	void exitStmt_list(CompilerParser.Stmt_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(CompilerParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(CompilerParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#base_stmt}.
	 * @param ctx the parse tree
	 */
	void enterBase_stmt(CompilerParser.Base_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#base_stmt}.
	 * @param ctx the parse tree
	 */
	void exitBase_stmt(CompilerParser.Base_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssign_stmt(CompilerParser.Assign_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssign_stmt(CompilerParser.Assign_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void enterAssign_expr(CompilerParser.Assign_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void exitAssign_expr(CompilerParser.Assign_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#read_stmt}.
	 * @param ctx the parse tree
	 */
	void enterRead_stmt(CompilerParser.Read_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#read_stmt}.
	 * @param ctx the parse tree
	 */
	void exitRead_stmt(CompilerParser.Read_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#write_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWrite_stmt(CompilerParser.Write_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#write_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWrite_stmt(CompilerParser.Write_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void enterReturn_stmt(CompilerParser.Return_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void exitReturn_stmt(CompilerParser.Return_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(CompilerParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(CompilerParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#expr_prefix}.
	 * @param ctx the parse tree
	 */
	void enterExpr_prefix(CompilerParser.Expr_prefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#expr_prefix}.
	 * @param ctx the parse tree
	 */
	void exitExpr_prefix(CompilerParser.Expr_prefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(CompilerParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(CompilerParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#factor_prefix}.
	 * @param ctx the parse tree
	 */
	void enterFactor_prefix(CompilerParser.Factor_prefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#factor_prefix}.
	 * @param ctx the parse tree
	 */
	void exitFactor_prefix(CompilerParser.Factor_prefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#postfix_expr}.
	 * @param ctx the parse tree
	 */
	void enterPostfix_expr(CompilerParser.Postfix_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#postfix_expr}.
	 * @param ctx the parse tree
	 */
	void exitPostfix_expr(CompilerParser.Postfix_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#call_expr}.
	 * @param ctx the parse tree
	 */
	void enterCall_expr(CompilerParser.Call_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#call_expr}.
	 * @param ctx the parse tree
	 */
	void exitCall_expr(CompilerParser.Call_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void enterExpr_list(CompilerParser.Expr_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#expr_list}.
	 * @param ctx the parse tree
	 */
	void exitExpr_list(CompilerParser.Expr_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#expr_list_tail}.
	 * @param ctx the parse tree
	 */
	void enterExpr_list_tail(CompilerParser.Expr_list_tailContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#expr_list_tail}.
	 * @param ctx the parse tree
	 */
	void exitExpr_list_tail(CompilerParser.Expr_list_tailContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(CompilerParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(CompilerParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#addop}.
	 * @param ctx the parse tree
	 */
	void enterAddop(CompilerParser.AddopContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#addop}.
	 * @param ctx the parse tree
	 */
	void exitAddop(CompilerParser.AddopContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#mulop}.
	 * @param ctx the parse tree
	 */
	void enterMulop(CompilerParser.MulopContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#mulop}.
	 * @param ctx the parse tree
	 */
	void exitMulop(CompilerParser.MulopContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIf_stmt(CompilerParser.If_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIf_stmt(CompilerParser.If_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#else_part}.
	 * @param ctx the parse tree
	 */
	void enterElse_part(CompilerParser.Else_partContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#else_part}.
	 * @param ctx the parse tree
	 */
	void exitElse_part(CompilerParser.Else_partContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCond(CompilerParser.CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCond(CompilerParser.CondContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#compop}.
	 * @param ctx the parse tree
	 */
	void enterCompop(CompilerParser.CompopContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#compop}.
	 * @param ctx the parse tree
	 */
	void exitCompop(CompilerParser.CompopContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stmt(CompilerParser.While_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stmt(CompilerParser.While_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#control_stmt}.
	 * @param ctx the parse tree
	 */
	void enterControl_stmt(CompilerParser.Control_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#control_stmt}.
	 * @param ctx the parse tree
	 */
	void exitControl_stmt(CompilerParser.Control_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#loop_stmt}.
	 * @param ctx the parse tree
	 */
	void enterLoop_stmt(CompilerParser.Loop_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#loop_stmt}.
	 * @param ctx the parse tree
	 */
	void exitLoop_stmt(CompilerParser.Loop_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CompilerParser#keyword}.
	 * @param ctx the parse tree
	 */
	void enterKeyword(CompilerParser.KeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompilerParser#keyword}.
	 * @param ctx the parse tree
	 */
	void exitKeyword(CompilerParser.KeywordContext ctx);
}