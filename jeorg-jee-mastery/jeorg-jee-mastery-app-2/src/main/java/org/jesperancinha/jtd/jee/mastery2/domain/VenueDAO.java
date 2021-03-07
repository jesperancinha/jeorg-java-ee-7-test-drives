package org.jesperancinha.jtd.jee.mastery2.domain;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.UUID;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class VenueDAO implements Serializable {

    @PersistenceContext(unitName = "primary")
    private EntityManager entityManager;

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void createVenue(Venue venue){
        entityManager.persist(venue);
    }

    public Venue getVenue(final UUID uuid){
        return entityManager.find(Venue.class, uuid);
    }
}
