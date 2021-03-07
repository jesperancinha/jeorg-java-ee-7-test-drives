package org.jesperancinha.jtd.jee.mastery2.rest;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/record")
public class RecordJSONService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Record getRecordAsJSON(@MatrixParam("name") String albumName, @MatrixParam("artist") String artist){
        final Record record = new Record();
        record.setName(albumName);
        record.setArtist(artist);
        return record;
    }
}
