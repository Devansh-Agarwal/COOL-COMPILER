// Generated from CoolParser.g4 by ANTLR 4.5
package cool;

    import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CoolParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CoolParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CoolParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(CoolParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolParser#class_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_list(CoolParser.Class_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolParser#class_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_(CoolParser.Class_Context ctx);
	/**
	 * Visit a parse tree produced by {@link CoolParser#feature_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeature_list(CoolParser.Feature_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolParser#feature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeature(CoolParser.FeatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolParser#form_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForm_list(CoolParser.Form_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolParser#formal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormal(CoolParser.FormalContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolParser#case_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCase_list(CoolParser.Case_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolParser#case_single}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCase_single(CoolParser.Case_singleContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolParser#expr_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_block(CoolParser.Expr_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolParser#expr_comma_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_comma_expr(CoolParser.Expr_comma_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolParser#let_base}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet_base(CoolParser.Let_baseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolParser#let_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet_stmt(CoolParser.Let_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(CoolParser.ExprContext ctx);
}