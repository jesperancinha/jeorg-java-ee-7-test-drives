package org.jesperancinha.jtd.jee.app2.rest;

import org.jesperancinha.jtd.jee.app2.domain.Herb;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static org.jesperancinha.console.consolerizer8.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer8.ConsolerizerColor.YELLOW;

@Path("/herbs")
@RequestScoped
public class KitchenHerbsResourceRESTService {

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public void listAllAlbums(final Herb herb) {
        MAGENTA.printGenericTitleLn("We've received this herb %s", herb);
        YELLOW.printGenericLn("javax.ws.rs provide REST methods");
        YELLOW.printGenericLn("javax.xml.bind provide the bind methods for the data");
    }

    @GET
    @Path("/parsley")
    @Produces(MediaType.APPLICATION_XML)
    public Herb listAllAlbums() {
        final Herb herb = new Herb();
        herb.setName("Parsley");
        herb.setColor("Green");
        herb.setGrams(1000L);
        return herb;
    }
}