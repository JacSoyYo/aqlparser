package es.jacsoyyo.aqlparser;

public class SimpleEhrQueryTest extends AbstractAqlQueryTest {

	@Override
	protected String aqlQueryString() {
		return "SELECT e/ehr_id/value as id FROM EHR e;";
	}

}
