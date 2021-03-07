package org.jesperancinha.jtd.jee.mastery2.domain;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ProducerDAO implements Serializable {

    @PersistenceContext(unitName = "primary")
    private EntityManager entityManager;

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void createNewProducer(Producer producer) {
        entityManager.persist(producer);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void createNewProducer2(Producer2 producer) {
        entityManager.persist(producer);
    }
}
