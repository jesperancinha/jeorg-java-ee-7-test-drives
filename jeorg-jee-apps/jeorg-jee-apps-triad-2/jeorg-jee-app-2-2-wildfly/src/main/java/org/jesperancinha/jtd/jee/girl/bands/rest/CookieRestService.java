package org.jesperancinha.jtd.jee.girl.bands.rest;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Cookie;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/cookie")
@RequestScoped
public class CookieRestService {

    @GET
    @Produces(APPLICATION_JSON)
    public String doGet(
            @CookieParam("beThereCookie")
                    Cookie beThereCookie) {
        return beThereCookie.getValue();
    }
}
