package es.jacsoyyo.aqlparser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import es.jacsoyyo.aqlparser.AqlParser.QueryContext;
import es.sacyl.jacsoyyo.aqlparser.AqlListener;

public class AqlTest {

	@Test
	public void secondTest() {
		ANTLRInputStream inputStream = new ANTLRInputStream(
				"SELECT e/ehr_status/subject/external_ref/id/value, diagnosis/data/items[at0002.1]/value "
						+ "FROM EHR e CONTAINS Composition c[openEHR-EHR-COMPOSITION.problem_list.v1] CONTAINS Evaluation diagnosis[openEHR-EHR-EVALUATION.problem-diagnosis.v1] "
						+ "WHERE c/name/value='Current Problems' AND diagnosis/data/items[at0002.1]/value/defining_code matches { terminology://Snomed-CT/hierarchy?rootConceptId=50043002 };");
		AqlLexer aqlLexer = new AqlLexer(inputStream);
		CommonTokenStream tokenStream = new CommonTokenStream(aqlLexer);
		AqlParser aqlParser = new AqlParser(tokenStream);
		aqlParser.setBuildParseTree(true);
		aqlParser.setProfile(true);
		// aqlParser.setTrace(true);
		QueryContext queryContext = aqlParser.query();
		ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
		AqlListener aqlListener = new AqlListener();
		parseTreeWalker.walk(aqlListener, queryContext);
		System.out.println("ble");
	}
}
