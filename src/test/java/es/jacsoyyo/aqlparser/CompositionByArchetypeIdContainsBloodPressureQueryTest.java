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

	// @formatter:off
	/*
SELECT  
    pa.*
FROM    
    CDR_COMPOSITION C,
    XMLTable('
               declare namespace xsi = "http://www.w3.org/2001/XMLSchema-instance";
               declare namespace v1 = "http://schemas.openehr.org/v1";
               for $comp in /v1:composition[@archetype_node_id="openEHR-EHR-COMPOSITION.contenedor.v1"]
               for $obs in $comp//*[@archetype_node_id="openEHR-EHR-OBSERVATION.blood_pressure.v1"]
               for $evn in $obs/v1:data[@archetype_node_id="at0001"]/v1:events[@archetype_node_id="at0006"]
               where $evn/v1:data[@archetype_node_id="at0003"]/v1:items[@archetype_node_id="at0004"]/v1:value[v1:magnitude > 120.0]
               return 
                      <res>
                        <cid>{$comp/v1:uid/v1:value}</cid>
                        <sis>{$evn/v1:data[@archetype_node_id="at0003"]/v1:items[@archetype_node_id="at0004"]/v1:value/v1:magnitude}</sis>
                        <dia>{$evn/v1:data[@archetype_node_id="at0003"]/v1:items[@archetype_node_id="at0005"]/v1:value/v1:magnitude}</dia>
                      </res>'
               PASSING C.XML
               COLUMNS
                        cid XMLType PATH '/res/cid/node()',
                        sis XMLType PATH '/res/sis/node()',
                        dia XMLType PATH '/res/dia/node()'
               ) pa
WHERE 1=1
AND C.EHR_ID ='b59c90bb-afed-42f4-aeee-54c8fb6da746'
AND XMLExists('declare default element namespace "http://schemas.openehr.org/v1";
          declare namespace xsi = "http://www.w3.org/2001/XMLSchema-instance";
          /*[@archetype_node_id="openEHR-EHR-COMPOSITION.contenedor.v1"]//*[@archetype_node_id="openEHR-EHR-OBSERVATION.blood_pressure.v1"]'
          PASSING C.XML)
;
	*/
	// @formatter:on
}
