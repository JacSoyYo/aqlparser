package es.jacsoyyo.aqlparser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

public class AqlTest {

	@Test
	public void unTest() {
		ANTLRInputStream inputStream = new ANTLRInputStream(
				"SELECT o/data[at0002]/events[at0003]/data/items[at0015]/items[at0018]/name "
						+ "FROM Ehr [uid=$ehrUid] CONTAINS Composition c CONTAINS Observation o[openEHR-EHR-OBSERVATION.microbiology.v1] "
						+ "WHERE o/data[at0002]/events[at0003]/data/items[at0015]/items[at0018]/items[at0019]/items[at0021]/name/defining_code/code_string matches {'18919-1', '18961-3', '19000-9'}");
		AqlLexer aqlLexer = new AqlLexer(inputStream);
		CommonTokenStream tokenStream = new CommonTokenStream(aqlLexer);
		AqlParser aqlParser = new AqlParser(tokenStream);
		aqlParser.select();
	}
}
