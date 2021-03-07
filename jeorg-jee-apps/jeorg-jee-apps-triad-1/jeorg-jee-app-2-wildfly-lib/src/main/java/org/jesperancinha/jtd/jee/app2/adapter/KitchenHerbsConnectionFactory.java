package org.jesperancinha.jtd.jee.app2.adapter;

import javax.resource.Referenceable;
import javax.resource.ResourceException;
import java.io.Serializable;

public interface KitchenHerbsConnectionFactory extends Serializable, Referenceable {
    public KitchenHerbsConnection getConnection() throws ResourceException;

}