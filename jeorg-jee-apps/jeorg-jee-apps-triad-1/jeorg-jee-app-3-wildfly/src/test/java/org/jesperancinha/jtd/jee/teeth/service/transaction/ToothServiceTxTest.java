package org.jesperancinha.jtd.jee.teeth.service.transaction;

import junit.framework.TestCase;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import org.jesperancinha.console.consolerizer.common.ConsolerizerColor;
import org.jesperancinha.console.consolerizer.console.Consolerizer;
import org.jesperancinha.console.consolerizer.console.ConsolerizerGraphs;
import org.jesperancinha.console.consolerizer.console.ConsolerizerTexts;
import org.jesperancinha.jtd.jee.teeth.Resources;
import org.jesperancinha.jtd.jee.teeth.domain.AbstractToothType;
import org.jesperancinha.jtd.jee.teeth.domain.FinalToothType;
import org.jesperancinha.jtd.jee.teeth.domain.Jaw;
import org.jesperancinha.jtd.jee.teeth.domain.Nerve;
import org.jesperancinha.jtd.jee.teeth.domain.Tooth;
import org.jesperancinha.jtd.jee.teeth.domain.ToothType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.EJBTransactionRequiredException;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.ORANGE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;

@RunWith(Arquillian.class)
public class ToothServiceTxTest extends TestCase {

    @EJB
    private ToothServiceTx toothService;

    @Resource
    private UserTransaction userTransaction;

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addClasses(ToothServiceTx.class, Tooth.class, Jaw.class, Nerve.class, AbstractToothType.class,
                        ToothType.class, FinalToothType.class, Resources.class, UserTransaction.class, EntityManager.class,
                        Consolerizer.class, ConsolerizerTexts.class, ConsolerizerColor.class, ConsolerizerGraphs.class)
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsWebInfResource("test-ds.xml");
    }

    @Before
    public void setUp() {
        BLUE.printGenericLn("References");
        BLUE.printGenericLn("- https://blog.frankel.ch/transaction-management-ejb3-vs-spring/");
    }

    @Test
    public void addToothNone() throws Exception {
        toothService.addToothNone(createTooth());
        toothService.addToothNone(createTooth());
        GREEN.printGenericLn("By default, a transaction is created with the entity manager");
        GREEN.printGenericLn("Notice that the transactions are different per creation");
    }

    @Test
    public void addToothSupported() throws Exception {
        userTransaction.begin();
        toothService.addToothSupports(createTooth());
        toothService.addToothSupports(createTooth());
        userTransaction.commit();
    }

    @Test
    public void addToothMandatory() throws Exception {
        userTransaction.begin();
        toothService.addToothMandatory(createTooth());
        toothService.addToothMandatory(createTooth());
        userTransaction.commit();
        GREEN.printGenericLn("MANDATORY means that a transaction is mandatory");
    }

    @Test(expected = EJBTransactionRequiredException.class)
    public void addToothMandatory_whenNoTransaction_thenFail() {
        toothService.addToothMandatory(createTooth());
        toothService.addToothMandatory(createTooth());
    }

    @Test
    public void addToothRequired() throws Exception {
        userTransaction.begin();
        toothService.addTootRequired(createTooth());
        toothService.addTootRequired(createTooth());
        userTransaction.commit();
        GREEN.printGenericLn("Notice that the transaction remains the same!");
        GREEN.printGenericLn("REQUIRED in this case means that you need a transaction when merging an object");
        GREEN.printGenericLn("REQUIRED is not MANDATORY in the sense that a transaction if created if one does not exist");
    }

    @Test
    public void addToothRequiredRollback() {
        try {
            toothService.addTootRequiredRollback(createTooth());
        } catch (Exception e) {
            RED.printGenericLn("This is expected! -> %s", e.getMessage());

        }
        ORANGE.printGenericLn(toothService.getA());
        GREEN.printGenericLn("Note that a has been rollback to its initial value of 10 before the transaction");
    }

    @Test
    public void addToothRequiredNoRollback() {
        toothService.addTootRequiredNoRollback(createTooth());
        ORANGE.printGenericLn(toothService.getA());
        GREEN.printGenericLn("Since no rollback occured, this means that a is changed.");
    }

    @Test
    public void addToothRequired_whenNoTransaction_thenStillOk() throws Exception {
        toothService.addTootRequired(createTooth());
        toothService.addTootRequired(createTooth());
        GREEN.printGenericLn("Notice that the transaction remains the same!");
        GREEN.printGenericLn("REQUIRED in this case means that you need a transaction when merging an object");
        GREEN.printGenericLn("REQUIRED is not MANDATORY in the sense that a transaction if created if one does not exist");
    }

    @Test
    public void addToothRequiresNew() throws Exception {
        userTransaction.begin();
        toothService.addTootRequiresNew(createTooth());
        toothService.addTootRequiresNew(createTooth());
        userTransaction.commit();
        GREEN.printGenericLn("Notice that the transactions are different per creation");
    }

    @Test
    public void addToothRequiresNew_whenNoTransaction_thenStartNew() throws Exception {
        toothService.addTootRequiresNew(createTooth());
        toothService.addTootRequiresNew(createTooth());
        GREEN.printGenericLn("Notice that the transactions are different per creation");
        GREEN.printGenericLn("In this case REQUIRES_NEW works just like REQUIRED");
        GREEN.printGenericLn("Only difference is that a new transaction is created everytime.");
    }

    @Test
    public void addToothNotSupported() throws Exception {
        userTransaction.begin();
        toothService.addToothNotSupported(createTooth());
        toothService.addToothNotSupported(createTooth());
        userTransaction.commit();
        GREEN.printGenericLn("NOT_SUPPORTED means that the transaction is suspended and so there is not transaction available at merge moment");
        GREEN.printGenericLn("This differs from NEVER in the sense that NEVER means that no transaction is allowed to be created");
    }

    @Test
    public void addToothNotSupported_whenNoTransaction_thenStillOkToCallMethod() throws Exception {
        toothService.addToothNotSupported(createTooth());
        toothService.addToothNotSupported(createTooth());
        GREEN.printGenericLn("NOT_SUPPORTED means that the transaction is suspended and so there is not transaction available at merge moment");
        GREEN.printGenericLn("This differs from NEVER in the sense that NEVER means that no transaction is allowed to be created");
    }

    @Test
    public void addToothNever() throws Exception {
        toothService.addToothNever(createTooth());
        GREEN.printGenericLn("Remember that the EntityManage needs a transaction to perform updates.");
        GREEN.printGenericLn("However the method being called doesn't necessary need to have a transaction");
        GREEN.printGenericLn("Marking it with TransactionAttributeType.NEVER means that no transaction is created");
        GREEN.printGenericLn("Marking it with TransactionAttributeType.NEVER means if a transaction is going on, it will fail an not even enter the method");
    }

    // WFLYEJB0063: Transaction present on server in Never call (EJB3 13.6.2.6)
    @Test(expected = EJBException.class)
    public void addToothNever_whenTransaction_thenFail() throws Exception {
        userTransaction.begin();
        toothService.addToothNever(createTooth());
        userTransaction.commit();
    }

    private Tooth createTooth() {
        final Tooth tooth = new Tooth();
        tooth.setUuid(java.util.UUID.randomUUID());
        return tooth;
    }
}
