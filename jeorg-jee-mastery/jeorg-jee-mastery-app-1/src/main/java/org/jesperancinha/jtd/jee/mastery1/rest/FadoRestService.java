package org.jesperancinha.jtd.jee.mastery1.rest;

import org.jesperancinha.jtd.jee.mastery1.beans.Record;

import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.YELLOW;

@Path("/fado")
public class FadoRestService {

    /**
     * Perform requests to this endpoint with curl.
     * Check the differences between sending just HEAD or a GET request.
     * See Readme.md
     *
     * @return List of fado records {@link Record}
     */
    @GET
    @Path("/bands")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Record> getAllFados() {
        BLUE.printGenericTitleLn("getAllFadosHead GET");
        BLUE.printGenericLn("If you see this log, then you probably made a GET request.");
        BLUE.printGenericLn("Or maybe not. You probably noticed that your are not getting response with a HEAD request");
        BLUE.printGenericLn("Try doing this with just HEAD");
        final var record1 = new Record();
        record1.setName("Humanos LP");
        record1.setArtist("Humanos");
        record1.setYear("2019");
        record1.setType("LP");
        final List<Record> records = Arrays.asList(record1);
        YELLOW.printGenericLn(records);
        return records;
    }

    @HEAD
    @Path("/bands/head")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Record> getAllFadosHead() {
        BLUE.printGenericTitleLn("getAllFadosHead HEAD");
        BLUE.printGenericLn("If you see this log, then you probably made a GET request.");
        BLUE.printGenericLn("Or maybe not. You probably noticed that your are not getting response with a HEAD request");
        BLUE.printGenericLn("Try doing this with just HEAD");
        final var record1 = new Record();
        record1.setName("Humanos LP");
        record1.setArtist("Humanos");
        record1.setYear("2019");
        record1.setType("LP");
        final List<Record> records = Arrays.asList(record1);
        YELLOW.printGenericLn(records);
        return records;
    }
}
