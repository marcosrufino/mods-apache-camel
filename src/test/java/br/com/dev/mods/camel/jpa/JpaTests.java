package br.com.dev.mods.camel.jpa;

import br.com.dev.mods.camel.xquery.XqueryRoute;
import org.apache.camel.CamelContext;
import org.apache.camel.Service;
import org.apache.camel.builder.NotifyBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jpa.JpaComponent;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.apache.camel.test.spring.junit5.CamelTestContextBootstrapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author marcosrufino
 * @created 14/03/2020 - 12:33
 **/
//@DataJpaTest
public class JpaTests extends CamelTestSupport {


    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteJpa();
    }

    @Override
    public CamelContext context() {
        return super.context();
    }


   // @Autowired
    //private TestEntityManager entityManager;
    @Test
    public void testJpa(){
        // This is a notify wait condition
        NotifyBuilder notify = new
                NotifyBuilder(context).from("jpa:*").whenDone(1).create();

        /*JpaComponent component =
                (JpaComponent)context.getComponent("jpa");

        component.setEntityManagerFactory(entityManager.getEntityManager().getEntityManagerFactory());
*/
        Object o = template.requestBody("jpa:br.com.dev.mods.camel.jpa.People?namedQuery=sync0&initialDelay=15s&delay=15s&consumeDelete=false");
        //assertEquals("<books><title>MSXML3: A Comprehensive Guide</title><title>Microsoft .NET: The Programming Bible</title><title>Visual Studio 7: A Comprehensive Guide</title><title>XML Developer's Guide</title></books>", requestBody);
    }
}
