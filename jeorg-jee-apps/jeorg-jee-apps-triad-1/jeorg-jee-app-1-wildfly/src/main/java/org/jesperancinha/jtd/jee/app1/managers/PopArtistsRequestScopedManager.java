package org.jesperancinha.jtd.jee.app1.managers;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;

@RequestScoped
public class PopArtistsRequestScopedManager {

    @Produces
    @AudienceRequest
    public Long getAudienceNumber() {
        return (long) (Math.random() * 10_000_000);
    }

    @Produces
    @SalesRequest
    public Long getSales() {
        return (long) (Math.random() * 45_000_000);
    }
}
