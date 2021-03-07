package org.jesperancinha.jtd.jee.mastery2.domain;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.UUID;

@Stateless
public class ConcertDAO implements Serializable {

    @PersistenceContext(unitName = "primary")
    private EntityManager entityManager;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void createConcertAndThenNot(Concert concert) throws Exception {
        entityManager.persist(concert);
        throw new Exception();
    }

    public Concert getConcert(UUID uuid) {
        return entityManager.find(Concert.class, uuid);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void createConcert(Concert concert) {
        entityManager.persist(concert);
    }
}
