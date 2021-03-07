package org.jesperancinha.jtd.jee.mastery1.edifact;

import org.jesperancinha.console.consolerizer.common.ConsolerizerColor;
import org.jesperancinha.jtd.jee.mastery1.beans.Record;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.UUID;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class StoreRecordStatementManagedDao implements StoreStatementDao {

    @Inject
    private EntityManager entityManager;

    @Override
    public Record getRecordStatementById(String id) {
        return entityManager.find(Record.class, id);
    }

    @Override
    public void createRecordStatement(Record record) {
        ConsolerizerColor.BRIGHT_BLUE.printGenericLn("We are using a new transaction bean per session %s because it is stateless -> %s", this.getClass(), this.hashCode());
        final Statement statement = new Statement();
        statement.setUuid(UUID.randomUUID());
        statement.setRecord(record);
        entityManager.persist(statement);
    }

    @Override
    public List<Statement> getAllRecordStatements() {
        Query query = entityManager.createQuery("select s from statement s");
        return (List<Statement>) query.getResultList();
    }
}
