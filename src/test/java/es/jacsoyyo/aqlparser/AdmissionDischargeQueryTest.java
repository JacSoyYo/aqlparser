package es.jacsoyyo.aqlparser;

public class AdmissionDischargeQueryTest extends AbstractAqlQueryTest {

	@Override
	protected String aqlQueryString() {
		return "SELECT e/ehr_id/value "
				+ "FROM EHR e CONTAINS COMPOSITION c[openEHR-EHR-COMPOSITION.administrative_encounter.v1] "
				+ "CONTAINS ADMIN_ENTRY admission[openEHR-EHR-ADMIN_ENTRY.admission.v1] "
				+ "WHERE NOT EXISTS c/content[openEHR-EHR-ADMIN_ENTRY.discharge.v1];";
	}

}
