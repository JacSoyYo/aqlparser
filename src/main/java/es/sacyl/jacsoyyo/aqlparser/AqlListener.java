/**
 * 
 */
package es.sacyl.jacsoyyo.aqlparser;

import es.jacsoyyo.aqlparser.AqlBaseListener;
import es.jacsoyyo.aqlparser.AqlParser.SelectExprContext;
import es.jacsoyyo.aqlparser.AqlParser.SelectVarContext;

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
		System.out.println("Empieza la select");
		super.enterSelectExpr(ctx);
	}

	@Override
	public void exitSelectExpr(SelectExprContext ctx) {
		System.out.println("Termina la select");
		super.exitSelectExpr(ctx);
	}

	@Override
	public void enterSelectVar(SelectVarContext ctx) {
		System.out.println("Empieza una select var");
		super.enterSelectVar(ctx);
	}

	@Override
	public void exitSelectVar(SelectVarContext ctx) {
		System.out.println("Termina una select var");
		super.exitSelectVar(ctx);
	}

}
