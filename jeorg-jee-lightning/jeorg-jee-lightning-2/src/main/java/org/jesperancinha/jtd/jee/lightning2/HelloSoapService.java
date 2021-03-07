package org.jesperancinha.jtd.jee.lightning2;

import javax.jws.WebService;

@WebService
public interface HelloSoapService {

    String sayHelloWorld(String name);
}