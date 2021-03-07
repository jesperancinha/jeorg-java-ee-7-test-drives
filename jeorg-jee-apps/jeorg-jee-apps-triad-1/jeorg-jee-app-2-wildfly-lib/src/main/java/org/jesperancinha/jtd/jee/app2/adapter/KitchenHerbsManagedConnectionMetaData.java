package org.jesperancinha.jtd.jee.app2.adapter;

import javax.resource.ResourceException;
import javax.resource.spi.ManagedConnectionMetaData;

public class KitchenHerbsManagedConnectionMetaData implements ManagedConnectionMetaData {
    public KitchenHerbsManagedConnectionMetaData() {
    }

    @Override
    public String getEISProductName() throws ResourceException {
        return "HelloWorld Resource Adapter";
    }

    @Override
    public String getEISProductVersion() throws ResourceException {
        return "1.0";
    }

    @Override
    public int getMaxConnections() throws ResourceException {
        return 0;
    }

    @Override
    public String getUserName() throws ResourceException {
        return null;
    }
}