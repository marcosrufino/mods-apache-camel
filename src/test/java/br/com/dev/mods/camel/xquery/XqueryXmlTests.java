package br.com.dev.mods.camel.xquery;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author marcosrufino
 * @created 08/03/2020 - 19:37
 **/

public class XqueryXmlTests extends CamelTestSupport {

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new XqueryRoute();
    }


    @Test
    public void testXquey(){
        InputStream resource = getClass().getClassLoader().getResourceAsStream("books.xml");
        String stringXml = context().getTypeConverter().convertTo(String.class, resource);
        String requestBody = template.requestBody("direct:start", stringXml, String.class);
        assertEquals("<books><title>MSXML3: A Comprehensive Guide</title><title>Microsoft .NET: The Programming Bible</title><title>Visual Studio 7: A Comprehensive Guide</title><title>XML Developer's Guide</title></books>", requestBody);
    }


}
