package org.jesperancinha.jtd.jee.app2.adapter;

import javax.resource.NotSupportedException;
import javax.resource.ResourceException;
import javax.resource.spi.ConnectionEvent;
import javax.resource.spi.ConnectionEventListener;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.LocalTransaction;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionMetaData;
import javax.security.auth.Subject;
import javax.transaction.xa.XAResource;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class KitchenHerbsManagedConnection implements ManagedConnection {
    private KitchenHerbsManagedConnectionFactory mcf;

    private PrintWriter logWriter;

    private List<ConnectionEventListener> listeners;

    private Object connection;

    public KitchenHerbsManagedConnection(KitchenHerbsManagedConnectionFactory mcf) {
        this.mcf = mcf;
        this.logWriter = null;
        this.listeners = new ArrayList<>(1);
        this.connection = null;
    }

    public Object getConnection(Subject subject, ConnectionRequestInfo cxRequestInfo) throws ResourceException {
        connection = new KitchenHerbsConnectionImpl(this, mcf);

        return connection;
    }

    public void associateConnection(Object connection) throws ResourceException {
        this.connection = connection;
    }

    public void cleanup() throws ResourceException {
    }

    public void destroy() throws ResourceException {
        this.connection = null;
    }

    public void addConnectionEventListener(ConnectionEventListener listener) {
        if (listener == null)
            throw new IllegalArgumentException("No Listener!");

        listeners.add(listener);
    }

    public void removeConnectionEventListener(ConnectionEventListener listener) {
        if (listener == null)
            throw new IllegalArgumentException("No Listener!");

        listeners.remove(listener);
    }

    public PrintWriter getLogWriter() throws ResourceException {
        return logWriter;
    }

    public void setLogWriter(PrintWriter out) throws ResourceException {
        this.logWriter = out;
    }

    public LocalTransaction getLocalTransaction() throws ResourceException {
        throw new NotSupportedException("LocalTransaction not supported");
    }

    public XAResource getXAResource() throws ResourceException {
        throw new NotSupportedException("GetXAResource not supported");
    }

    public ManagedConnectionMetaData getMetaData() throws ResourceException {
        return new KitchenHerbsManagedConnectionMetaData();
    }

    String openKitchen(String name) {
        return String.format("Kitchen %s is open!", name);
    }

    void closeHandle(KitchenHerbsConnection handle) {
        ConnectionEvent event = new ConnectionEvent(this, ConnectionEvent.CONNECTION_CLOSED);
        event.setConnectionHandle(handle);

        for (ConnectionEventListener cel : listeners) {
            cel.connectionClosed(event);
        }
    }
}