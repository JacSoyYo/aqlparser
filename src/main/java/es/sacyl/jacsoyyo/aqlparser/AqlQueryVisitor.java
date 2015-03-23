/**
 * 
 */
package es.sacyl.jacsoyyo.aqlparser;

import org.antlr.v4.runtime.tree.TerminalNode;

import es.jacsoyyo.aqlparser.AqlBaseVisitor;
import es.jacsoyyo.aqlparser.AqlParser.ContainsContext;
import es.jacsoyyo.aqlparser.AqlParser.EhrContainsContext;
import es.jacsoyyo.aqlparser.AqlParser.FromContext;
import es.jacsoyyo.aqlparser.AqlParser.FromEHRContext;
import es.jacsoyyo.aqlparser.AqlParser.IdentifiedPathContext;
import es.jacsoyyo.aqlparser.AqlParser.OrderByContext;
import es.jacsoyyo.aqlparser.AqlParser.QueryContext;
import es.jacsoyyo.aqlparser.AqlParser.SelectContext;
import es.jacsoyyo.aqlparser.AqlParser.SelectVarContext;
import es.jacsoyyo.aqlparser.AqlParser.WhereContext;

/**
 * @author jacobo
 *
 */
public class AqlQueryVisitor extends AqlBaseVisitor<String> {

	StringBuilder queryBuilder = new StringBuilder();

	@Override
	public String visitQuery(QueryContext ctx) {
		super.visitQuery(ctx);
		queryBuilder.append(";");
		return queryBuilder.toString();
	}

	@Override
	public String visitSelect(SelectContext ctx) {
		queryBuilder.append("SELECT ");
		return super.visitSelect(ctx);
	}

	@Override
	public String visitSelectVar(SelectVarContext ctx) {
		ctx.identifiedPath();
		ctx.asIdentifier();
		return super.visitSelectVar(ctx);
	}

	@Override
	public String visitIdentifiedPath(IdentifiedPathContext ctx) {
		ctx.IDENTIFIER();
		ctx.predicate(); // can we have a predicate in a selectVar?
		ctx.objectPath(); // need to know RM type to traslate the path
							// (e/ehr_id/value -> e.id)
		return super.visitIdentifiedPath(ctx);
	}

	@Override
	public String visitFrom(FromContext ctx) {
		queryBuilder.append("FROM ");
		return super.visitFrom(ctx);
	}

	@Override
	public String visitEhrContains(EhrContainsContext ctx) {
		this.visit(ctx.fromEHR());
		if (ctx.contains() != null) {
			queryBuilder.append("JOIN CDR_COMPOSITION c ON e.id = c.ehr_id ");
			this.visit(ctx.contains());
		}
		return defaultResult();
	}

	@Override
	public String visitFromEHR(FromEHRContext ctx) {
		queryBuilder.append("CDR_EHR ");
		if (ctx.IDENTIFIER() != null) {
			queryBuilder.append(ctx.IDENTIFIER().getText()).append(" ");
		}
		return super.visitFromEHR(ctx);
	}

	@Override
	public String visitContains(ContainsContext ctx) {
		queryBuilder.append("CONTAINS ");
		return super.visitContains(ctx);
	}

	@Override
	public String visitWhere(WhereContext ctx) {
		queryBuilder.append("WHERE ");
		return super.visitWhere(ctx);
	}

	@Override
	public String visitOrderBy(OrderByContext ctx) {
		queryBuilder.append("ORDER BY ");
		return super.visitOrderBy(ctx);
	}

	@Override
	public String visitTerminal(TerminalNode node) {
		// TODO Auto-generated method stub
		return node.getText();
	}

	@Override
	protected String aggregateResult(String aggregate, String nextResult) {
		StringBuilder sb = new StringBuilder(aggregate);
		sb.append(" ");
		sb.append(nextResult);

		return sb.toString();
	}

	@Override
	protected String defaultResult() {
		return "";
	}

}
