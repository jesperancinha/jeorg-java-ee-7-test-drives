package org.jesperancinha.jtd.jee.app1.managers;

import org.jesperancinha.jtd.jee.app1.beans.Sales;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class PopArtistsManager {

    @Produces
    @Audience
    public Long getAudienceNumber() {
        return (long) (Math.random() * 10_000_000);
    }

    @Produces
    @Sales
    public Long getSales() {
        return (long) (Math.random() * 45_000_000);
    }
}
