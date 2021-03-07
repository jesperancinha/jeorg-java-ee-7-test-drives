package org.jesperancinha.jtd.jee.app1.data;

import org.jesperancinha.jtd.jee.app1.domain.Album;
import org.jesperancinha.jtd.jee.app1.domain.Artist;
import org.jesperancinha.jtd.jee.app1.domain.ManagedBeanArtistDao;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

import static org.jesperancinha.console.consolerizer8.ConsolerizerColor.MAGENTA;

@RequestScoped
public class ArtistProducer {

    @Inject
    private ManagedBeanArtistDao managedBeanArtistDao;

    private List<Artist> artistList;

    @Produces
    @Named
    public List<Artist> getArtistList() {
        return artistList;
    }

    public void onAlbumListChanged(
            @Observes(notifyObserver = Reception.ALWAYS)
            final Album album) {
        MAGENTA.printGenericLn("Producing artist %s from a album %s", album.getArtist(), album);
        final Artist artist = new Artist();
        artist.setName(album.getArtist());
        managedBeanArtistDao.createArtist(artist);
        retrieveAllMembersOrderedByName();
    }

    @PostConstruct
    public void retrieveAllMembersOrderedByName() {
        artistList = managedBeanArtistDao.getAllArtists();
    }
}
