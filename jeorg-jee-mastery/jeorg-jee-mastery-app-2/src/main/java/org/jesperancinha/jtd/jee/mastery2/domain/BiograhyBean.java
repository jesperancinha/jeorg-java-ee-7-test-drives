package org.jesperancinha.jtd.jee.mastery2.domain;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.UUID;

@Named
@SessionScoped
public class BiograhyBean implements Serializable {

    private String title;

    private Long releaseYear;

    private Concert concert;

    private UUID biographyId;

    private UUID concertId;

    public BiograhyBean() {
        this.title = "Madonna - An intimate biography";
        this.releaseYear = 2001L;
        this.concert = new Concert();
        this.concert.setName("Acoustic Kirchen Tour");
    }

    @Inject
    private BiographyDAO biographyDAO;

    @Inject
    private ConcertDAO concertDAO;

    public String getTitle() {
        return title;
    }

    public Long getReleaseYear() {
        return releaseYear;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseYear(Long releaseYear) {
        this.releaseYear = releaseYear;
    }

    public UUID getConcertId() {
        return concertId;
    }

    public void setConcertId(UUID concertId) {
        this.concertId = concertId;
    }

    public UUID getBiographyId() {
        return biographyId;
    }

    public void setBiographyId(UUID biographyId) {
        this.biographyId = biographyId;
    }

    public Concert getConcert() {
        return concert;
    }

    public void setConcert(Concert concert) {
        this.concert = concert;
    }

    public void submitValue() {
        final Biography biography = new Biography();
        biography.setId(UUID.randomUUID());
        biography.setTitle(title);
        biography.setReleaseYear(releaseYear);
        biographyDAO.createBiography(biography);
        this.biographyId = biography.getId();
        concert.setUuid(UUID.randomUUID());
        concertDAO.createConcert(concert);
        this.concertId = concert.getUuid();
    }

    public void refresh() {
        this.concert = concertDAO.getConcert(concertId);
        final Biography biograhy = biographyDAO.getBiography(biographyId);
        this.title = biograhy.getTitle();
        this.releaseYear = biograhy.getReleaseYear();
    }
}
