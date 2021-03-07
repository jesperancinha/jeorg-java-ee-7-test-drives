package org.jesperancinha.jtd.jee.teeth.service;

import org.jesperancinha.jtd.jee.teeth.domain.Jaw;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class JawService {

    @Inject
    private EntityManager entityManager;

    public Jaw updateItRight(final Jaw jaw) {
        return entityManager.merge(jaw);
    }
}
