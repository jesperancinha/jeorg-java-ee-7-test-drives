package org.jesperancinha.jtd.jee.mastery2.domain;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.UUID;

@Stateless
public class MerchandiseDAO {

    @PersistenceContext(unitName = "primary")
    private EntityManager entityManager;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void createMerchandise(Merchandise merchandise) throws Exception {
        entityManager.persist(merchandise);
    }

    public Merchandise getMerchandise(UUID uuid) {
        return entityManager.find(Merchandise.class, uuid);
    }
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void createMerchandise(MerchandiseOne merchandiseOne) throws Exception {
        entityManager.persist(merchandiseOne);
    }

    public MerchandiseOne getMerchandiseOne(UUID uuid) {
        return entityManager.find(MerchandiseOne.class, uuid);
    }

}
