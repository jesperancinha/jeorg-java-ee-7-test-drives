package org.jesperancinha.jtd.jee.teeth;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Resources {
    @PersistenceContext
    @Produces
    private EntityManager em;
}
