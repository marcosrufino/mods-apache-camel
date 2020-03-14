package br.com.dev.mods.camel.transformation;

import org.springframework.stereotype.Component;

/**
 * @author marcosrufino
 * @created 08/03/2020 - 18:15
 **/
@Component
public class MyPersonGreeter {

    public String sayHello(MyPerson person){
        return "Hello "+ person.getFirstName() +" "+ person.getLastName();
    }

}
