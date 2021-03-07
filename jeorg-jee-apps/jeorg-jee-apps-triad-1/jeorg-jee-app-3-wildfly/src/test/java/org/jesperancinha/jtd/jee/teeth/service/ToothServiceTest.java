package org.jesperancinha.jtd.jee.teeth.service;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jesperancinha.console.consolerizer.console.Consolerizer;
import org.jesperancinha.console.consolerizer.common.ConsolerizerColor;
import org.jesperancinha.console.consolerizer.console.ConsolerizerGraphs;
import org.jesperancinha.console.consolerizer.console.ConsolerizerTexts;
import org.jesperancinha.jtd.jee.teeth.Resources;
import org.jesperancinha.jtd.jee.teeth.domain.AbstractToothType;
import org.jesperancinha.jtd.jee.teeth.domain.FinalToothType;
import org.jesperancinha.jtd.jee.teeth.domain.InterfaceToothType;
import org.jesperancinha.jtd.jee.teeth.domain.Jaw;
import org.jesperancinha.jtd.jee.teeth.domain.Nerve;
import org.jesperancinha.jtd.jee.teeth.domain.Tooth;
import org.jesperancinha.jtd.jee.teeth.domain.ToothType;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJBException;
import javax.inject.Inject;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import java.util.UUID;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BRIGHT_MAGENTA;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.ORANGE;
import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class ToothServiceTest {

    @Inject
    ToothService toothService;

    @Inject
    JawService jawService;

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addClasses(FinalToothType.class, InterfaceToothType.class, AbstractToothType.class, ToothType.class,
                        Nerve.class, Jaw.class, JawService.class, ToothService.class, Tooth.class, ToothType.class, Resources.class,
                        UserTransaction.class, EntityManager.class,
                        Consolerizer.class, ConsolerizerTexts.class, ConsolerizerColor.class, ConsolerizerGraphs.class)
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsWebInfResource("test-ds.xml");
    }

    @Test
    public void createTooth_whenGood_thenOk()
            throws HeuristicRollbackException, RollbackException, SystemException, NamingException, HeuristicMixedException,
            NotSupportedException {
        Consolerizer.setupFastDefault();

        final var tooth = new Tooth();
        final var uuid = UUID.randomUUID();
        tooth.setUuid(uuid);

        final var jaw = new Jaw();
        jaw.setUuid(UUID.randomUUID());
        final Jaw jaw1 = jawService.updateItRight(jaw);

        tooth.setJaw(jaw);

        final Tooth tooth1 = toothService.updateItRight(tooth);
        ORANGE.printGenericLn(tooth1);
        final Tooth toothResult = toothService.findTooth(uuid);

        ORANGE.printGenericLn(toothResult);
        assertEquals(tooth1.getUuid(), toothResult.getUuid());
        assertEquals(jaw1.getUuid(), toothResult.getJaw()
                .getUuid());
        MAGENTA.printGenericLn("from: https://docs.oracle.com/javaee/5/tutorial/doc/bnbqa.html");
        BRIGHT_MAGENTA.printGenericLn("The class must be annotated with the javax.persistence.Entity annotation.");
        BRIGHT_MAGENTA.printGenericLn("The class must have a public or protected, no-argument constructor. The class may have other constructors.");
        BRIGHT_MAGENTA.printGenericLn("The class must not be declared final. No methods or persistent instance variables must be declared final.");
        BRIGHT_MAGENTA.printGenericLn("If an entity instance be passed by value as a detached object, such as through a session bean’s remote business interface, the class must implement the Serializable interface.");
        BRIGHT_MAGENTA.printGenericLn("Entities may extend both entity and non-entity classes, and non-entity classes may extend entity classes.");
        BRIGHT_MAGENTA.printGenericLn("Persistent instance variables must be declared private, protected, or package-private, and can only be accessed directly by the entity class’s methods. Clients must access the entity’s state through accessor or business methods.");
    }

    @Test(expected = EJBException.class)
    public void updateToothJustMerge() {
        final var tooth = new Tooth();
        final var uuid = UUID.randomUUID();
        tooth.setUuid(uuid);
        toothService.updateToothJustMerge(tooth);
    }

    @Test(expected = EJBException.class)
    public void updateToothGetEntityManager() {
        final var tooth = new Tooth();
        final var uuid = UUID.randomUUID();
        tooth.setUuid(uuid);
        toothService.updateToothGetEntityManager(tooth);
    }
}
