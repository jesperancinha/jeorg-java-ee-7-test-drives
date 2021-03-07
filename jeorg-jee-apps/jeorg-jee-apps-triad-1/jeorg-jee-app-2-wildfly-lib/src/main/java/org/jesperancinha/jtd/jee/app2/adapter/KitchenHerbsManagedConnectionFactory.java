package org.jesperancinha.jtd.jee.app2.adapter;

import javax.resource.ResourceException;
import javax.resource.spi.ConnectionDefinition;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionFactory;
import javax.resource.spi.ResourceAdapter;
import javax.resource.spi.ResourceAdapterAssociation;
import javax.security.auth.Subject;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;

@ConnectionDefinition(connectionFactory = KitchenHerbsConnectionFactory.class,
        connectionFactoryImpl = KitchenHerbsConnectionFactoryImpl.class,
        connection = KitchenHerbsConnection.class,
        connectionImpl = KitchenHerbsConnectionImpl.class)
public class KitchenHerbsManagedConnectionFactory
        implements ManagedConnectionFactory, ResourceAdapterAssociation {

    private static final long serialVersionUID = 1L;

    private ResourceAdapter ra;

    private PrintWriter logwriter;

    public KitchenHerbsManagedConnectionFactory() {
        this.ra = null;
        this.logwriter = null;
    }

    public Object createConnectionFactory() throws ResourceException {
        throw new ResourceException("This resource adapter doesn't support non-managed environments");
    }

    public Object createConnectionFactory(ConnectionManager cxManager) throws ResourceException {
        return new KitchenHerbsConnectionFactoryImpl(this, cxManager);
    }

    public ManagedConnection createManagedConnection(Subject subject, ConnectionRequestInfo cxRequestInfo)
            throws ResourceException {
        return new KitchenHerbsManagedConnection(this);
    }

    public ManagedConnection matchManagedConnections(Set connectionSet, Subject subject,
                                                     ConnectionRequestInfo cxRequestInfo) throws ResourceException {
        ManagedConnection result = null;

        Iterator it = connectionSet.iterator();
        while (result == null && it.hasNext()) {
            ManagedConnection mc = (ManagedConnection) it.next();
            if (mc instanceof KitchenHerbsManagedConnection) {
                KitchenHerbsManagedConnection hwmc = (KitchenHerbsManagedConnection) mc;
                result = hwmc;
            }
        }

        return result;
    }

    public PrintWriter getLogWriter() throws ResourceException {
        return logwriter;
    }

    public void setLogWriter(PrintWriter out) throws ResourceException {
        logwriter = out;
    }

    public ResourceAdapter getResourceAdapter() {
        return ra;
    }

    public void setResourceAdapter(ResourceAdapter ra) {
        this.ra = ra;
    }

    @Override
    public int hashCode() {
        return 17;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null)
            return false;
        if (other == this)
            return true;
        if (!(other instanceof KitchenHerbsConnectionFactory))
            return false;
        return true;
    }

}