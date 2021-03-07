package org.jesperancinha.jtd.jee.soap;

import javax.jws.WebService;

@WebService(
        name = "kitchen-herbs",
        endpointInterface = "org.jesperancinha.jtd.jee.soap.KitchenHerbsServer")
public class KitchenHerbsServerImpl
        implements KitchenHerbsServer {

    public String sayHelloWorld(String name) {
        return "Hello World ! My name is " + name + ".";
    }

}