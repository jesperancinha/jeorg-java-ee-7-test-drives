package org.jesperancinha.jtd.jee.mastery2.domain;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Named
@SessionScoped
public class VenueBean implements Serializable {
    @Inject
    private VenueDAO venueDAO;
    private Venue venue;
    private Venue readVenue;
    public VenueBean(){
        this.venue = new Venue();
        venue.setName("Royal Albert Hall");
    }
    public Venue getVenue() {
        return venue;
    }
    public void setVenue(Venue venue) {
        this.venue = venue;
    }
    public Venue getReadVenue() {
        return readVenue;
    }
    public void setReadVenue(Venue readVenue) {
        this.readVenue = readVenue;
    }
    public void submit(){
        venue.setLocalDateTime(LocalDateTime.now());
        venue.setUuid(UUID.randomUUID());
        venueDAO.createVenue(venue);
        readVenue = venueDAO.getVenue(venue.getUuid());
    }
}
