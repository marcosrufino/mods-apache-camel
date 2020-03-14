package br.com.dev.mods.camel.jpa;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author marcosrufino
 * @created 14/03/2020 - 11:16
 **/
@Component
public class RouteJpa extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("jpa:br.com.dev.mods.camel.jpa.People?namedQuery=sync0&initialDelay=15s&delay=15s&consumeDelete=false&persistenceUnit=camel")
                .to("mock:mock");

    }
}
