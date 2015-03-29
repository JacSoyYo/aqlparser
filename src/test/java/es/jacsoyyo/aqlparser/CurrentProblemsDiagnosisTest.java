package es.jacsoyyo.aqlparser;

public class CurrentProblemsDiagnosisTest extends AbstractAqlQueryTest {

	@Override
	protected String aqlQueryString() {
		return "SELECT e/ehr_status/subject/external_ref/id/value, diagnosis/data/items[at0002.1]/value "
				+ "FROM EHR e CONTAINS Composition c[openEHR-EHR-COMPOSITION.problem_list.v1] CONTAINS Evaluation diagnosis[openEHR-EHR-EVALUATION.problem-diagnosis.v1] "
				+ "WHERE c/name/value='Current Problems' AND diagnosis/data/items[at0002.1]/value/defining_code matches { terminology://Snomed-CT/hierarchy?rootConceptId=50043002 };";
	}

}
