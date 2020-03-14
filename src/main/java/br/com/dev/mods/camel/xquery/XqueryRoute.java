package br.com.dev.mods.camel.xquery;

import org.apache.camel.builder.RouteBuilder;

import static org.apache.camel.component.xquery.XQueryBuilder.xquery;

/**
 * @author marcosrufino
 * @created 14/03/2020 - 10:06
 **/

public class XqueryRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:start")
                .transform(xquery("<books>{for $x in /catalog/book where $x/price>30 order by $x/title return $x/title}</books>"));
    }
}
