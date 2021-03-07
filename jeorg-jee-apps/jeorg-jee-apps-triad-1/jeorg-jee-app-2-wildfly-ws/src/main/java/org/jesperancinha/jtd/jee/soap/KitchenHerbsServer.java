package org.jesperancinha.jtd.jee.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface KitchenHerbsServer {

    @WebMethod
    String sayHelloWorld(String name);
}