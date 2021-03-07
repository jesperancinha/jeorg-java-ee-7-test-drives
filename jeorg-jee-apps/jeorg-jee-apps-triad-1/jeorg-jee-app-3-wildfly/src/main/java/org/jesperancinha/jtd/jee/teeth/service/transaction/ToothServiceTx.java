package org.jesperancinha.jtd.jee.teeth.service.transaction;

import org.jesperancinha.console.consolerizer.console.Consolerizer;
import org.jesperancinha.jtd.jee.teeth.domain.Tooth;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TransactionRequiredException;
import javax.transaction.TransactionSynchronizationRegistry;

import static org.jesperancinha.console.consolerizer.console.Consolerizer.printRainbowTitleLn;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ToothServiceTx {

    public ToothServiceTx(){
        Consolerizer.setupFastDefault();
    }

    @PersistenceContext(unitName = "primary",
            type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    private int a = 10;

    public int getA() {
        return a;
    }

    @Resource
    TransactionSynchronizationRegistry tsr;

    public Tooth addToothNone(final Tooth tooth) {
        return mergeTooth(tooth);
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Tooth addToothSupports(final Tooth tooth) {
        return mergeTooth(tooth);
    }

    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public Tooth addToothMandatory(final Tooth tooth) {
        return mergeTooth(tooth);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Tooth addTootRequired(final Tooth tooth) {
        return mergeTooth(tooth);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Tooth addTootRequiredRollback(final Tooth tooth) {
        this.a = 1000;
        MAGENTA.printGenericLn("We just made a=%d", this.a);
        throw new RuntimeException();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Tooth addTootRequiredNoRollback(final Tooth tooth) {
        this.a = 1000;
        return mergeTooth(tooth);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Tooth addTootRequiresNew(final Tooth tooth) {
        return mergeTooth(tooth);
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Tooth addToothNotSupported(final Tooth tooth) {
        try {
            return mergeTooth(tooth);
        } catch (TransactionRequiredException e) {
            RED.printGenericLn("This is expected! The transaction has been suspended -> %s", e);
            return null;
        }
    }

    @TransactionAttribute(TransactionAttributeType.NEVER)
    public Tooth addToothNever(final Tooth tooth) {
        GREEN.printGenericLn(tsr.getTransactionKey());
        try {
            final Tooth merge = entityManager.merge(tooth);
        } catch (TransactionRequiredException ejbException) {
            RED.printGenericLn("This is expected! Note that this TransactionRequiredException comes from javax.persistence -> %s", ejbException);
        }
        GREEN.printGenericLn(tsr.getTransactionKey());
        return null;
    }

    private Tooth mergeTooth(Tooth tooth) {
        printRainbowTitleLn(tooth);
        GREEN.printGenericLn(tsr.getTransactionKey());
        final Tooth merge = entityManager.merge(tooth);
        GREEN.printGenericLn(tsr.getTransactionKey());
        return merge;
    }
}
