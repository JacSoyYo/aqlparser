/**
 * 
 */
package es.sacyl.jacsoyyo.aqlparser;

import es.jacsoyyo.aqlparser.AqlBaseListener;
import es.jacsoyyo.aqlparser.AqlParser.ArchetypedClassExprContext;
import es.jacsoyyo.aqlparser.AqlParser.ContainsContext;
import es.jacsoyyo.aqlparser.AqlParser.EhrContainsContext;
import es.jacsoyyo.aqlparser.AqlParser.FromContext;
import es.jacsoyyo.aqlparser.AqlParser.FromEHRContext;
import es.jacsoyyo.aqlparser.AqlParser.OrderByContext;
import es.jacsoyyo.aqlparser.AqlParser.SelectExprContext;
import es.jacsoyyo.aqlparser.AqlParser.SelectVarContext;
import es.jacsoyyo.aqlparser.AqlParser.SimpleClassExprContext;
import es.jacsoyyo.aqlparser.AqlParser.WhereContext;

/**
 * @author jacobo
 *
 */
public class AqlListener extends AqlBaseListener {

	/**
	 * 
	 */
	public AqlListener() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void enterSelectExpr(SelectExprContext ctx) {
		System.out.println("SELECT");
		super.enterSelectExpr(ctx);
	}

	@Override
	public void enterSelectVar(SelectVarContext ctx) {
		System.out.println("\tselectVar");
		super.enterSelectVar(ctx);
	}

	@Override
	public void enterFrom(FromContext ctx) {
		System.out.println("FROM");
		super.enterFrom(ctx);
	}

	@Override
	public void enterEhrContains(EhrContainsContext ctx) {
		System.out.println("\tEHR CONTAINS");
		super.enterEhrContains(ctx);
	}

	@Override
	public void enterFromEHR(FromEHRContext ctx) {
		System.out.println("\t\tFROM EHR: " + ctx.IDENTIFIER().getText());
		super.enterFromEHR(ctx);
	}

	@Override
	public void enterContains(ContainsContext ctx) {
		System.out.println("\t\tCONTAINS");
		super.enterContains(ctx);
	}

	@Override
	public void enterSimpleClassExpr(SimpleClassExprContext ctx) {
		System.out.println("\t\t\tSIMPLE CLASS EXPRESSION");
		super.enterSimpleClassExpr(ctx);
	}

	@Override
	public void enterArchetypedClassExpr(ArchetypedClassExprContext ctx) {
		System.out.println("\t\t\t\t" + ctx.IDENTIFIER(0));
		super.enterArchetypedClassExpr(ctx);
	}

	@Override
	public void enterWhere(WhereContext ctx) {
		System.out.println("WHERE");
		super.enterWhere(ctx);
	}

	@Override
	public void enterOrderBy(OrderByContext ctx) {
		System.out.println("ORDER BY");
		super.enterOrderBy(ctx);
	}

}
