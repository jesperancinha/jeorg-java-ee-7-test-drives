package org.jesperancinha.jtd.jee.girl.bands.rest;

import org.jesperancinha.jtd.jee.girl.bands.jaxb.Registry;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;

@Path("/registry")
@RequestScoped
public class BandRegistryRestService {

    @GET
    @Produces(APPLICATION_JSON)
    public Registry getAllBandRegistry() throws JAXBException {
        final var jc = JAXBContext.newInstance(Registry.class);
        final var unmarshaller = jc.createUnmarshaller();
        final Registry registry = (Registry) unmarshaller.unmarshal(getClass().getResourceAsStream("/registry.xml"));

        registry.getBandList()
                .forEach(band -> band.getMemberList()
                        .forEach(member -> GREEN.printGenericLn(member.getName())));
        return registry;
    }
}
