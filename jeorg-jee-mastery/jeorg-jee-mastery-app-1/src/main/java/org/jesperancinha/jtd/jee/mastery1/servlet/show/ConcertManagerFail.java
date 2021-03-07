package org.jesperancinha.jtd.jee.mastery1.servlet.show;

import org.jesperancinha.console.consolerizer.console.Consolerizer;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.YELLOW;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ConcertManagerFail implements Serializable {

    @Resource
    private EJBContext ejbContext;

    @Inject
    private EntityManager entityManager;

    @Inject
    private UserTransaction userTransaction;

    private String concertStatement;

    public String getConcertStatement() {
        return concertStatement;
    }

    public void setConcertStatement(String concertStatement) {
        this.concertStatement = concertStatement;
    }

    public ConcertEntity goToConcert() throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
        final ConcertEntity concertEntity = new ConcertEntity();
        try {
            userTransaction.begin();
            final String statement = "We are going to see P!nk Live!!";
            this.concertStatement = statement;
            concertEntity.setStatement(statement);
            concertEntity.setUuid(UUID.randomUUID());
            entityManager.persist(concertEntity);
//            userTransaction.setRollbackOnly();
            ejbContext.setRollbackOnly();
        } catch (IllegalStateException e) {
            Consolerizer.setupFastDefault();
            YELLOW.printExpectedException("Only CONTAINER managed beans can be rolled back via the EJBContext", e.getMessage());
            YELLOW.printGenericLn("In this case, %s", concertStatement);
        }
        userTransaction.commit();
        return concertEntity;
    }

    public ConcertEntity goToConcertWorking() throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
        final ConcertEntity concertEntity = new ConcertEntity();
        userTransaction.begin();
        final String statement = "We are going to see P!nk Live!!";
        this.concertStatement = statement;
        concertEntity.setStatement(statement);
        concertEntity.setUuid(UUID.randomUUID());
        entityManager.persist(concertEntity);
        userTransaction.rollback();
        try {
            userTransaction.commit();
        } catch (IllegalStateException e) {
            RED.printExpectedException("In this case, we called the correct rollback. This way, the commit won't work", e.getMessage());
        }
        return concertEntity;
    }

    public String getStatement(UUID uuid) throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
        userTransaction.begin();
        final ConcertEntity concertEntity = entityManager.find(ConcertEntity.class, uuid);
        if (Objects.isNull(concertEntity)) {
            userTransaction.rollback();
            return null;
        }
        final String statement = concertEntity.getStatement();
        userTransaction.commit();
        return statement;
    }

}
