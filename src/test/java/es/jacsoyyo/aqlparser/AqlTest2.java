package es.jacsoyyo.aqlparser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import es.jacsoyyo.aqlparser.AqlParser.QueryContext;
import es.sacyl.jacsoyyo.aqlparser.AqlListener;

public class AqlTest2 {

	@Test
	public void unTest() {
		ANTLRInputStream inputStream = new ANTLRInputStream(
				"SELECT o/data[at0002]/events[at0003]/data/items[at0015]/items[at0018]/name "
						+ "FROM Ehr [uid=$ehrUid] CONTAINS Composition c CONTAINS Observation o[openEHR-EHR-OBSERVATION.microbiology.v1] "
						+ "WHERE o/data[at0002]/events[at0003]/data/items[at0015]/items[at0018]/items[at0019]/items[at0021]/name/defining_code/code_string matches {'18919-1', '18961-3', '19000-9'};");
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
