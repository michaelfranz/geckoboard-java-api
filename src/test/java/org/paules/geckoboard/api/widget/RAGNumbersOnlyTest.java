package org.paules.geckoboard.api.widget;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.junit.Assert;
import org.junit.Test;
import org.paules.geckoboard.helper.JsonTestHelper;

public class RAGNumbersOnlyTest {

    @Test
    public void testJson() throws JsonProcessingException, IOException {
        RAGNumbersOnly widget = new RAGNumbersOnly( "1234" );
        widget.setRed( "Test-red", 123 );
        widget.setAmber( "Test-amber", 1234 );
        widget.setGreen( "Test-green", 12345 );

        JsonNode data = JsonTestHelper.getJsonFromWidget( widget );
        Assert.assertNotNull( data.get( "data" ) );
        JsonNode node = data.get( "data" );

        assertEquals( 3, node.get( "item" ).size() );
        assertEquals( "Test-red", node.get( "item" ).get( 0 ).get( "text" ).asText() );
        assertEquals( 123, node.get( "item" ).get( 0 ).get( "value" ).asInt() );

        assertEquals( "Test-amber", node.get( "item" ).get( 1 ).get( "text" ).asText() );
        assertEquals( 1234, node.get( "item" ).get( 1 ).get( "value" ).asInt() );

        assertEquals( "Test-green", node.get( "item" ).get( 2 ).get( "text" ).asText() );
        assertEquals( 12345, node.get( "item" ).get( 2 ).get( "value" ).asInt() );
    }

}
