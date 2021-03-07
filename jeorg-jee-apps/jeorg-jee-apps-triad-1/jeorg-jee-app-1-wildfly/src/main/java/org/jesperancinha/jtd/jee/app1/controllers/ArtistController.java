package org.jesperancinha.jtd.jee.app1.controllers;

import org.jesperancinha.jtd.jee.app1.domain.Artist;
import org.jesperancinha.jtd.jee.app1.domain.ArtistDao;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

import static org.jesperancinha.console.consolerizer8.Consolerizer.setupFastDefault;
import static org.jesperancinha.console.consolerizer8.ConsolerizerColor.YELLOW;

@Named
@RequestScoped
public class ArtistController {

    @Inject
    private ArtistDao artistDao;

    @Inject
    private FacesContext facesContext;

    @Produces
    @Named
    private Artist newArtist;

    public List<Artist> getArtistList() {
        setupFastDefault();
        YELLOW.printGenericLn("The artist list has been called!");
        return artistDao.getAllArtists();
    }

    public void createArtist() {
        setupFastDefault();
        YELLOW.printGenericLn("The album %s is going to be created!", newArtist);
        try {
            artistDao.createArtist(newArtist);
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
            facesContext.addMessage(null, m);
        }
    }

    @PostConstruct
    public void initNewMember() {
        newArtist = new Artist();
    }

}
