package org.jesperancinha.jtd.jee.spain.secure;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

public class RoyalSecurityResource extends ResourceConfig {
    public RoyalSecurityResource() {
        super(PalaceWaitingRESTService.class);
        register(RolesAllowedDynamicFeature.class);
    }
}