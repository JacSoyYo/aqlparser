package es.jacsoyyo.aqlparser;


public class EhrQuerySelectStatusTest extends AbstractAqlQueryTest {

	@Override
	protected String aqlQueryString() {
		return "SELECT e/ehr_id/value, e/ehr_status/subject/external_ref/id/value "
				+ "FROM EHR e;";
	}

}
