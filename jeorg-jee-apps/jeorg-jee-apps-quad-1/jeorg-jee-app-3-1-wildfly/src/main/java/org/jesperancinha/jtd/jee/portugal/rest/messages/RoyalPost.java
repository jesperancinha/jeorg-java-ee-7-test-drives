package org.jesperancinha.jtd.jee.portugal.rest.messages;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.ORANGE;

@Path("/history/messages")
public class RoyalPost {

    @POST
    @Path("/sendMessage")
    @Consumes("application/text")
    public Response createAccount(
            @Context
                    HttpServletRequest req, KingdomMessage kingdomMessage) {
        ORANGE.printGenericLn(kingdomMessage);
        return Response.ok()
                .entity(kingdomMessage)
                .build();
    }

    @POST
    @Path("/sendMessage/form")
    @Consumes("application/x-www-form-urlencoded")
    public Response createAccountViaForm(
            @Context
                    HttpServletRequest req,
            @FormParam("message")
                    String kingdomMessage) {
        ORANGE.printGenericLn(kingdomMessage);
        return Response.ok()
                .entity(kingdomMessage)
                .build();
    }

}

