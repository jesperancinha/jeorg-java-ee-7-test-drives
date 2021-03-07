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
import org.jesperancinha.jtd.jee.teeth.domain.ToothType;
import org.jesperancinha.jtd.jee.teeth.domain2.Tooth;
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

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.ORANGE;
import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class ToothService2Test {

    @Inject
    ToothService2 toothService;

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addClasses(ToothService2.class, Tooth.class, ToothType.class,  Resources.class, UserTransaction.class, EntityManager.class,
                        Consolerizer.class, ConsolerizerTexts.class, ConsolerizerColor.class, ConsolerizerGraphs.class)
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsWebInfResource("test-ds.xml");
    }

    @Test
    public void findTooth()
            throws HeuristicRollbackException, RollbackException, SystemException, NamingException, HeuristicMixedException,
            NotSupportedException {
        final var tooth = new Tooth();
        final var uuid = UUID.randomUUID();
        tooth.setUuid(uuid);
        final Tooth tooth1 = toothService.updateItRight(tooth);
        ORANGE.printGenericLn(tooth1);
        final Tooth toothResult = toothService.findTooth(uuid);
        ORANGE.printGenericLn(toothResult);
        assertEquals(tooth1.getUuid(), toothResult.getUuid());
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
