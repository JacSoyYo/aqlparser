package es.jacsoyyo.aqlparser;

public class CompositionByArchetypeIdContainsBloodPressureQueryTest extends AbstractAqlQueryTest {

	@Override
	protected String aqlQueryString() {
		return "FROM EHR [ehr_id/value='1234'] CONTAINS COMPOSITION c [openEHR-EHR-COMPOSITION.encounter.v1] CONTAINS "
				+ "OBSERVATION o [openEHR-EHR-OBSERVATION.blood_pressure.v1]";
	}

}
