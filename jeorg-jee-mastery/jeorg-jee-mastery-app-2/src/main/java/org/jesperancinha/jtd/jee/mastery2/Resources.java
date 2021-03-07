package org.jesperancinha.jtd.jee.mastery2;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Produces;

public class Resources {

    @PersistenceContext(unitName = "primary")
    private EntityManager em;

    @Produces
    private EntityManager getEntityManager() {
        return em;
    }

    @javax.enterprise.inject.Produces
    @RequestScoped
    public FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }
}
