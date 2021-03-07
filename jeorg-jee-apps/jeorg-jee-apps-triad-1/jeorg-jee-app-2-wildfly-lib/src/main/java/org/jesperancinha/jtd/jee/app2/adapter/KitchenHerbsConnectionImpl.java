package org.jesperancinha.jtd.jee.app2.adapter;

public class KitchenHerbsConnectionImpl implements KitchenHerbsConnection {

    private KitchenHerbsManagedConnection mc;

    private KitchenHerbsManagedConnectionFactory mcf;

    public KitchenHerbsConnectionImpl(KitchenHerbsManagedConnection mc, KitchenHerbsManagedConnectionFactory mcf) {
        this.mc = mc;
        this.mcf = mcf;
    }

    public String openKitchen() {
        return openKitchen(((KitchenHerbsResourceAdapter) mcf.getResourceAdapter()).getName());
    }

    public String openKitchen(String name) {
        return mc.openKitchen(name);
    }

    public void close() {
        mc.closeHandle(this);
    }
}