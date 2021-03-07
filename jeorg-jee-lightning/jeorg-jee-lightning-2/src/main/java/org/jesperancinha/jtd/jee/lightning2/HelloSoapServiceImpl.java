package org.jesperancinha.jtd.jee.lightning2;

import org.jesperancinha.console.consolerizer.common.ConsolerizerColor;

import javax.jws.WebService;

@WebService(
        name = "hello",
        endpointInterface = "org.jesperancinha.jtd.jee.lightning2.HelloSoapService")
public class HelloSoapServiceImpl
        implements HelloSoapService {

    public String sayHelloWorld(String name) {
        ConsolerizerColor.MAGENTA.printGenericLn(name);
        return "Hello World ! My name is " + name + "." +
                "\nRemember that youu don't need any annotation to run a @WebService. They all have default names.";
    }

}