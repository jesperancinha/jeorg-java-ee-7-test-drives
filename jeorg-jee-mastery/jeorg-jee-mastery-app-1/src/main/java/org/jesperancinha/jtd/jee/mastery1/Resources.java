package org.jesperancinha.jtd.jee.mastery1;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.logging.Logger;

public class Resources {
    @PersistenceContext
    private EntityManager em;

    @Produces
    public EntityManager getEntityManager() {
        return em;
    }

    @Produces
    public Logger getLogger(InjectionPoint ip) {
        String category = ip.getMember()
                .getDeclaringClass()
                .getName();
        return Logger.getLogger(category);
    }

    @Produces
    @RequestScoped
    public FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }
}
