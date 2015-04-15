package es.jacsoyyo.aqlparser;

public class CompositionByArchetypeIdContainsBloodPressureQueryTest extends
		AbstractAqlQueryTest {

	@Override
	protected String aqlQueryString() {
		return "SELECT "
				+ "c/uid/value, "
				+ "o/data[at0001]/events[at0006]/data[at0003]/items[at0004]/value/magnitude, "
				+ "o/data[at0001]/events[at0006]/data[at0003]/items[at0005]/value/magnitude "
				+ "FROM EHR [ehr_id/value='1234'] CONTAINS COMPOSITION c [openEHR-EHR-COMPOSITION.encounter.v1] CONTAINS "
				+ "OBSERVATION o [openEHR-EHR-OBSERVATION.blood_pressure.v1]";
	}

}
