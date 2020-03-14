package br.com.dev.mods.camel.transformation.typeconverter;

import br.com.dev.mods.camel.transformation.MyPersonGreeter;
import br.com.dev.mods.camel.transformation.MyPersonTypeConverter;
import org.apache.camel.*;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;


/**
 * @author marcosrufino
 * @created 08/03/2020 - 17:56
 **/

public class MyPersonTypeConveterTests extends CamelTestSupport {

   
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {

        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                CamelContext context = getContext();
                context.getTypeConverterRegistry().addTypeConverters(new MyPersonTypeConverter());

                onException(IllegalArgumentException.class)
                        .handled(true)
                        .to("mock:error")
                        .transform(constant("Malformed Person String"));

                from("direct:start")
                        .bean(MyPersonGreeter.class, "sayHello")
                        .to("mock:person");
            }
        };
    }

    @Test
    public void testConvertMyPerson() throws InterruptedException {
        getMockEndpoint("mock:person").expectedBodiesReceived("Hello Marcos Rufino");
        template.sendBody("direct:start", "Marcos|Rufino");
        assertMockEndpointsSatisfied();
    }

    @Test
    public void testConvertMyPersonFailure() throws Exception {
        getMockEndpoint("mock:person").expectedMessageCount(0);
        getMockEndpoint("mock:error").expectedMessageCount(1);

        template.sendBody("direct:start", "Invalid formatted string");

        assertMockEndpointsSatisfied();
    }
}
