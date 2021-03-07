package org.jesperancinha.jtd.jee.mastery1.servlet.show;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ConcertManager implements Serializable {

    @Inject
    private EntityManager entityManager;

    @Resource
    private EJBContext ejbContext;

    @Resource
    private SessionContext sctx;

    private String concertStatement;

    public String getConcertStatement() {
        return concertStatement;
    }

    public void setConcertStatement(String concertStatement) {
        this.concertStatement = concertStatement;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public ConcertEntity goToConcert() {
        final ConcertEntity concertEntity = new ConcertEntity();
        concertEntity.setStatement("We are going to see P!nk Live!!");
        concertEntity.setUuid(UUID.randomUUID());
        entityManager.persist(concertEntity);
        ejbContext.setRollbackOnly();
        sctx.setRollbackOnly();
        return concertEntity;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public String getStatement(UUID uuid) {
        final ConcertEntity concertEntity = entityManager.find(ConcertEntity.class, uuid);
        if (Objects.isNull(concertEntity)) {
            return null;
        }
        return concertEntity.getStatement();
    }

}
