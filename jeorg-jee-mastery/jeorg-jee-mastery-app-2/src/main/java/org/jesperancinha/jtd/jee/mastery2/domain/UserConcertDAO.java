package org.jesperancinha.jtd.jee.mastery2.domain;

import javax.enterprise.context.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import java.io.Serializable;

@SessionScoped
public class UserConcertDAO implements Serializable {

    @PersistenceContext(unitName = "primary")
    private EntityManager entityManager;

    public void updateConcert(final Concert concert) throws NamingException, SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
        Context ctx = new InitialContext();
        UserTransaction utx =
                (UserTransaction) ctx.lookup("java:comp/UserTransaction");
        utx.begin();
        entityManager.merge(concert);
        utx.commit();
    }
}
