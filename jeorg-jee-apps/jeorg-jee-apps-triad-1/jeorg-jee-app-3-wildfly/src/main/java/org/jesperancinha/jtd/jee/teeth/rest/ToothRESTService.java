package org.jesperancinha.jtd.jee.teeth.rest;

import org.jesperancinha.jtd.jee.teeth.domain.Jaw;
import org.jesperancinha.jtd.jee.teeth.domain.Tooth;
import org.jesperancinha.jtd.jee.teeth.service.JawService;
import org.jesperancinha.jtd.jee.teeth.service.ToothService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.naming.NamingException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.ORANGE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;

@Path("/tooth/rest/")
@RequestScoped
public class ToothRESTService {

    @Inject
    private ToothService toothService;

    @Inject
    private JawService jawService;

    /**
     * Note that EAGER was added in order to get all data before throwing back to the server
     * Lazy fetch makes no sense if we want to visualize data.
     * It does however if we want to perform operations of this sort only in the back end.
     * Also not the use of transient. We had to use EAGER and that means that an infinite loop would happen.
     * Notice that we don't need Serializable here.
     *
     * @return A list of all {@link Tooth}
     */
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tooth> listAllTeeth() {

        final var tooth = new Tooth();
        final var uuid = UUID.randomUUID();
        tooth.setUuid(uuid);

        final var jaw = new Jaw();
        jaw.setUuid(UUID.randomUUID());
        final Jaw jaw1 = jawService.updateItRight(jaw);
        tooth.setJaw(jaw);

        var tooth1 = (Tooth) null;
        var jaw2 = (Jaw) null;
        try {
            tooth1 = toothService.updateItRight(tooth);
            jaw1.getToothList()
                    .add(tooth1);
            jaw2 = jawService.updateItRight(jaw1);
        } catch (NamingException e) {
            RED.printThrowableAndExit(e);
        } catch (HeuristicMixedException e) {
            RED.printThrowableAndExit(e);
        } catch (HeuristicRollbackException e) {
            RED.printThrowableAndExit(e);
        } catch (NotSupportedException e) {
            RED.printThrowableAndExit(e);
        } catch (SystemException e) {
            RED.printThrowableAndExit(e);
        } catch (RollbackException e) {
            RED.printThrowableAndExit(e);
        }
        ORANGE.printGenericLn(tooth1);
        ORANGE.printGenericLn(jaw2);

        final List<Tooth> all = toothService.findAll();
        BLUE.printGenericLn(all);
        return all;
    }
}