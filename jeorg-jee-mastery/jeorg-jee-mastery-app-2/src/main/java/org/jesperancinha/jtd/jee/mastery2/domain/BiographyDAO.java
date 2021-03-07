package org.jesperancinha.jtd.jee.mastery2.domain;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.UUID;

@Stateless
public class BiographyDAO implements Serializable {
    @PersistenceContext(unitName = "primary")
    private EntityManager entityManager;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void createBiography(Biography biography) {
        entityManager.persist(biography);
    }

    public Biography getBiography(UUID uuid) {
        return entityManager.find(Biography.class, uuid);
    }
}
