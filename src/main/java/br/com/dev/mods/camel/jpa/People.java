package br.com.dev.mods.camel.jpa;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Consume;
import org.apache.camel.Exchange;
import org.apache.camel.component.jpa.Consumed;
import org.apache.camel.component.jpa.PreConsumed;

import javax.persistence.*;

/**
 * @author marcosrufino
 * @created 14/03/2020 - 10:57
 **/
@Data
@Entity
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "sync0", query = "select x from People x where x.sync = 0")
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String first_name;
    private String last_name;
    private String career;
    private int sync;

    /*@PreConsumed
    public void beforeGoToNextStep(Exchange exchange) {
        People body = exchange.getIn().getBody(People.class);
        body.sync = 1;
        exchange.getIn().setBody(body);
        log.info("Calling beforeGoToNextStep");
    }*/
    @Consumed
    public void goToNextStep() {
        sync = 1;
        log.info("Calling GoToNextStep");
    }
}
