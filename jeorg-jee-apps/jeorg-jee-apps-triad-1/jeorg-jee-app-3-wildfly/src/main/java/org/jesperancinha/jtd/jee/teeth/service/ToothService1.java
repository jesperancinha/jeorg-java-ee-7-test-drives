package org.jesperancinha.jtd.jee.teeth.service;

import org.jesperancinha.console.consolerizer.console.Consolerizer;
import org.jesperancinha.jtd.jee.teeth.domain.ToothType;
import org.jesperancinha.jtd.jee.teeth.domain1.Tooth;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
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
import java.util.UUID;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BRIGHT_MAGENTA;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.YELLOW;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ToothService1 {

    @PersistenceContext(unitName = "primary")
    private EntityManager entityManager;

    public ToothService1(){
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

        YELLOW.printGenericLn("Because we are using %s, this means we cannot perform UserTransaction code.");
        YELLOW.printGenericLn("This gets done by the container itself");
        YELLOW.printGenericLn("And so the code changes a bit to avoid the following error:");
        YELLOW.printGenericLn("javax.naming.NameNotFoundException: UserTransaction\n"
                + "        at deployment.test.war//org.jesperancinha.jtd.jee.teeth.service.ToothService1Test.findTooth(ToothService1Test.java:53)\n"
                + "Caused by: java.lang.IllegalStateException: WFLYEJB0137: Only session and message-driven beans with bean-managed transaction demarcation are allowed to access UserTransaction\n"
                + "        at deployment.test.war//org.jesperancinha.jtd.jee.teeth.service.ToothService1Test.findTooth(ToothService1Test.java:53)");
        // javax.naming.NameNotFoundException: UserTransaction
        //        at deployment.test.war//org.jesperancinha.jtd.jee.teeth.service.ToothService1Test.findTooth(ToothService1Test.java:53)
        //Caused by: java.lang.IllegalStateException: WFLYEJB0137: Only session and message-driven beans with bean-managed transaction demarcation are allowed to access UserTransaction
        //        at deployment.test.war//org.jesperancinha.jtd.jee.teeth.service.ToothService1Test.findTooth(ToothService1Test.java:53)
        // var utx = (UserTransaction) context.lookup("java:comp/UserTransaction");
//        utx.begin();
        final Tooth mergedTooth = entityManager.merge(tooth);
        BRIGHT_MAGENTA.printGenericLn("Tooth 1 %s has been created!", tooth);
        mergedTooth.setToothType(ToothType.getRandom());
        mergedTooth.setToothTypeNumber(ToothType.getRandom());
        entityManager.lock(mergedTooth, LockModeType.OPTIMISTIC);
        final Tooth reMergedTooth = entityManager.merge(mergedTooth);
//        utx.commit();
        return reMergedTooth;
    }

    public Tooth updateToothJustMerge(final Tooth tooth) {
        return entityManager.merge(tooth);
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
