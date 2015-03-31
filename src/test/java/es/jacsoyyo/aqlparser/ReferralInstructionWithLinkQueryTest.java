package es.jacsoyyo.aqlparser;

public class ReferralInstructionWithLinkQueryTest extends AbstractAqlQueryTest {

	@Override
	protected String aqlQueryString() {
		return "SELECT c/uid/value, instruction "
				+ "FROM EHR e [ehr_id/value=$ehrid] CONTAINS COMPOSITION c "
				+ "CONTAINS INSTRUCTION instruction[openEHR-EHR-INSTRUCTION.referral.v1] "
				+ "WHERE EXISTS instruction/links[target='ehr://327000002/87284370-2D4B-4e3d-A3F3-F303D2F4F34B@latest_trunk_version']";
	}

}
