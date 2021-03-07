package org.jesperancinha.jtd.jee.teeth.service;

import org.jesperancinha.console.consolerizer.console.Consolerizer;
import org.jesperancinha.jtd.jee.teeth.domain.ToothType;
import org.jesperancinha.jtd.jee.teeth.domain2.Tooth;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import java.util.UUID;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BRIGHT_MAGENTA;

@Stateless
@TransactionManagement(javax.ejb.TransactionManagementType.BEAN)
public class ToothService2 {

    @PersistenceContext(unitName = "primary")
    private EntityManager entityManager;

    public ToothService2(){
        Consolerizer.setupFastDefault();
    }

    // WFLYJPA0059: javax.persistence.PersistenceContext injection target is invalid.  Only setter methods are allowed:
    // @PersistenceContext(unitName = "primary")
    // from ResourceInjectionAnnotationParsingProcessor: https://stackoverflow.com/questions/18019947/resource-injection-target-is-invalid-only-setter-methods-are-allowed
    public Tooth findTooth(UUID uuid) {
        return entityManager.find(Tooth.class, uuid);
    }

    public Tooth updateItRight(final Tooth tooth)
            throws NamingException, HeuristicMixedException, HeuristicRollbackException, NotSupportedException, SystemException, RollbackException {
        var context = new InitialContext();
        var utx = (UserTransaction) context.lookup("java:comp/UserTransaction");
        utx.begin();
        final Tooth mergedTooth = entityManager.merge(tooth);
        BRIGHT_MAGENTA.printGenericLn("Tooth 2 %s has been created!", tooth);
        mergedTooth.setToothType(ToothType.getRandom());
        mergedTooth.setToothTypeNumber(ToothType.getRandom());
        entityManager.lock(mergedTooth, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
        final Tooth reMergedTooth = entityManager.merge(mergedTooth);
        utx.commit();
        return reMergedTooth;
    }

    // WFLYEJB0034: EJB Invocation failed on component ToothService for method
    // public void org.jesperancinha.jtd.jee.teeth.service.ToothService.updateToothJustMerge(org.jesperancinha.jtd.jee.teeth.domain.Tooth):
    // javax.ejb.EJBException: javax.persistence.TransactionRequiredException:
    // WFLYJPA0060: Transaction is required to perform this operation
    // (either use a transaction or extended persistence context)
    public void updateToothJustMerge(final Tooth tooth) {
        entityManager.merge(tooth);
    }

    // WFLYEJB0034: EJB Invocation failed on component ToothService for method
    // public void org.jesperancinha.jtd.jee.teeth.service.ToothService.updateToothGetEntityManager(org.jesperancinha.jtd.jee.teeth.domain.Tooth):
    // javax.ejb.EJBException: java.lang.IllegalStateException:
    // A JTA EntityManager cannot use getTransaction()
    public void updateToothGetEntityManager(final Tooth tooth) {
        final var transaction1 = entityManager.getTransaction();
        BRIGHT_MAGENTA.printGenericLn(transaction1);
        transaction1
                .begin();
        entityManager.merge(tooth);
        final var transaction2 = entityManager.getTransaction();
        BRIGHT_MAGENTA.printGenericLn(transaction2);
        transaction2
                .commit();
    }
}
