package org.jesperancinha.jtd.jee.portugal.rest;

import org.jesperancinha.jtd.jee.portugal.beans.HistorySingletonDelivery;
import org.jesperancinha.jtd.jee.portugal.beans.HistoryStatefulDelivery;
import org.jesperancinha.jtd.jee.portugal.beans.HistoryStatelessDelivery;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.Serializable;
import java.util.List;

import static org.jesperancinha.console.consolerizer.console.Consolerizer.printRainbowTitleLn;

@Path("/history")
@SessionScoped
public class HistoryRestService implements Serializable {

    @Inject
    private HistorySingletonDelivery historySingletonDelivery;

    @Inject
    private HistoryStatefulDelivery historyStatefulDelivery;

    @Inject
    private HistoryStatelessDelivery historyStatelessDelivery;

    public HistoryRestService() {
        printRainbowTitleLn("Remember that you can use @Singleton, @Stateful and @Stateless in @Path annotated beans.");
        printRainbowTitleLn("For MDB's (Message Driven Beans), there is no reason to use these annotations.");
        printRainbowTitleLn("They just won't make any sense.");
    }

    @GET
    @Path("/singleton")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getSomeHistory() {
        return historySingletonDelivery.getSomeHistory();
    }

    @GET
    @Path("/singleton/pop")
    @Produces(MediaType.APPLICATION_JSON)
    public String getLatestElementOfHistory() {
        return historySingletonDelivery.getLatestElementOfHistory();
    }

    @GET
    @Path("/stateful")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getSomeHistoryStateful() {
        return historyStatefulDelivery.getSomeHistory();
    }

    @GET
    @Path("/stateful/pop")
    @Produces(MediaType.APPLICATION_JSON)
    public String getLatestElementOfHistoryStateful() {
        return historyStatefulDelivery.getLatestElementOfHistory();
    }

    @GET
    @Path("/stateless")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getSomeHistoryStateless() {
        return historyStatelessDelivery.getSomeHistory();
    }

    @GET
    @Path("/stateless/pop")
    @Produces(MediaType.APPLICATION_JSON)
    public String getLatestElementOfHistoryStateless() {
        return historyStatelessDelivery.getLatestElementOfHistory();
    }
}
