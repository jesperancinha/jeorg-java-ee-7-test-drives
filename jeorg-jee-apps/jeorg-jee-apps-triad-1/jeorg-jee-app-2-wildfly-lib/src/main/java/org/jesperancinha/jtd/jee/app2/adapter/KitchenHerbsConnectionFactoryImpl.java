package org.jesperancinha.jtd.jee.app2.adapter;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.resource.ResourceException;
import javax.resource.spi.ConnectionManager;

import static org.jesperancinha.console.consolerizer8.Consolerizer.setupFastDefault;
import static org.jesperancinha.console.consolerizer8.ConsolerizerColor.ORANGE;
import static org.jesperancinha.console.consolerizer8.ConsolerizerGraphs.printUnicornsLn;

public class KitchenHerbsConnectionFactoryImpl implements KitchenHerbsConnectionFactory {
    private static final long serialVersionUID = 1L;

    private Reference reference;

    private KitchenHerbsManagedConnectionFactory mcf;
    private ConnectionManager connectionManager;

    public KitchenHerbsConnectionFactoryImpl(KitchenHerbsManagedConnectionFactory mcf, ConnectionManager cxManager) {
        this.mcf = mcf;
        this.connectionManager = cxManager;
    }

    @Override
    public KitchenHerbsConnection getConnection() throws ResourceException {
        return (KitchenHerbsConnection) connectionManager.allocateConnection(mcf, null);
    }

    @Override
    public Reference getReference() throws NamingException {
        return reference;
    }

    @Override
    public void setReference(Reference reference) {
        this.reference = reference;
    }

    public String toString() {
        setupFastDefault();
        printUnicornsLn(100);
        ORANGE.printGenericLn(
                "This instance is of a different type because it is being loaded in a different module");
        ORANGE.printGenericLn("We are not going to fix this in this module.");
        ORANGE.printGenericLn(
                "This module is here just to give an idea on how different modules can work together");
        ORANGE.printGenericLn(
                "Using @Resource, we were able to inject an instance from a different module into our own");
        ORANGE.printGenericLn("We did this, by using JNDI technology");
        ORANGE.printGenericLn("JNDI stads for Java Naming and Directory Interface");
        ORANGE.printGenericLn(
                "Our Java Connector API resource is discoverable with the use of the Referenceable interface");
        ORANGE.printGenericLn("We haven't seen the connector in action in this case.");
        printUnicornsLn(100);
        return KitchenHerbsConnectionFactoryImpl.class.toString();
    }
}