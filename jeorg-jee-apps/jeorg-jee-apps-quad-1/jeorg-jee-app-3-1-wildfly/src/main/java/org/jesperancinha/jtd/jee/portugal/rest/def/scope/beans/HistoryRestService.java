package org.jesperancinha.jtd.jee.portugal.rest.def.scope.beans;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.Serializable;
import java.util.List;

@Path("/history/def")
@SessionScoped
public class HistoryRestService implements Serializable {

    @Inject
    private HistorySingletonDeliveryDefault historySingletonDeliveryDefault;

    @Inject
    private HistoryStatefulDeliveryDefault historyStatefulDeliveryDefault;

    @Inject
    private HistoryStatelessDeliveryDefault historyStatelessDeliveryDefault;

    @GET
    @Path("/singleton")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getSomeHistory() {
        return historySingletonDeliveryDefault.getSomeHistory();
    }

    @GET
    @Path("/singleton/pop")
    @Produces(MediaType.APPLICATION_JSON)
    public String getLatestElementOfHistory() {
        return historySingletonDeliveryDefault.getLatestElementOfHistory();
    }

    @GET
    @Path("/stateful")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getSomeHistoryStateful() {
        return historyStatefulDeliveryDefault.getSomeHistory();
    }

    @GET
    @Path("/stateful/pop")
    @Produces(MediaType.APPLICATION_JSON)
    public String getLatestElementOfHistoryStateful() {
        return historyStatefulDeliveryDefault.getLatestElementOfHistory();
    }

    @GET
    @Path("/stateless")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getSomeHistoryStateless() {
        return historyStatelessDeliveryDefault.getSomeHistory();
    }

    @GET
    @Path("/stateless/pop")
    @Produces(MediaType.APPLICATION_JSON)
    public String getLatestElementOfHistoryStateless() {
        return historyStatelessDeliveryDefault.getLatestElementOfHistory();
    }
}
