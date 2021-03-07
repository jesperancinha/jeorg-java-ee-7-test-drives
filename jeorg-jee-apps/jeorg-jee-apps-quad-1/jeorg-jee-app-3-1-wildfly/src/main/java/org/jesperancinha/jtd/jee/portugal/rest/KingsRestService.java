package org.jesperancinha.jtd.jee.portugal.rest;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;

@Path("/kings/{text1}.{text2}.subjects")
@RequestScoped
public class KingsRestService {

    private static final List<String> KINGS_BURGUNDY = List.of("Afonso I", "Sancho I", "Afonso II", "Sancho II", "Afonso III", "Dinis I", "Afonso IV",
            "Pedro I", "Fernando I");

    @GET
    @Path("/burgundy")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> allKings(
            @PathParam("text1")
                    String text1,
            @PathParam("text2")
                    String text2
    ) {
        GREEN.printGenericLn("We can get text1 and text2 as input path params -> %s, %s", text1, text2);
        GREEN.printGenericLn("This happens regardless of how complicated the path is established both on the class or on the method.");
        return KINGS_BURGUNDY;
    }

    @GET
    @Path("/burgundy/{id: BUR\\d+}")
    public String getKingById(
            @PathParam("id")
                    String id) {
        return KINGS_BURGUNDY.get(Integer.parseInt(id.replace("BUR", "")));
    }
}
