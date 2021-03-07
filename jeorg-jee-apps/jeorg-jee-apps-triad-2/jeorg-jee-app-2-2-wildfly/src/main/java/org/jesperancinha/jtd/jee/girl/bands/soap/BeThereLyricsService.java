package org.jesperancinha.jtd.jee.girl.bands.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface BeThereLyricsService {

    @WebMethod
    String sayYoullBeThere(String name);
}