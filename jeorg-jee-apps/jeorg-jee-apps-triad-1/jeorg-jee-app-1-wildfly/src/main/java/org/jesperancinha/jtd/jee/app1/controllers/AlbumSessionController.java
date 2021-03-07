package org.jesperancinha.jtd.jee.app1.controllers;

import org.jesperancinha.jtd.jee.app1.domain.Album;
import org.jesperancinha.jtd.jee.app1.domain.AlbumSessionDao;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Objects;

@Named
@SessionScoped
public class AlbumSessionController implements Serializable {

    @Inject
    private AlbumSessionDao albumSessionDao;

    @Inject
    private FacesContext facesContext;

    @Produces
    @Named
    private Album newSessionAlbum;

    private Long lastId;

    private String lastArtist;

    public void realCreateAlbum() {
        if (Objects.nonNull(lastId)) {
            final Album album = albumSessionDao.getAlbum(lastId);
            album.setArtist("None!");
            albumSessionDao.realUpdateAlbum(album);
            final Album album2 = albumSessionDao.getAlbum(lastId);
            this.lastArtist = album2.getArtist();

        } else {
            final Album album = albumSessionDao.realUpdateAlbum(newSessionAlbum);
            this.lastId = album.getId();
            this.lastArtist = album.getArtist();
        }
    }

    @PostConstruct
    public void initNewMember() {
        newSessionAlbum = new Album();
    }

    public void createAlbum(Album album) {
        this.newSessionAlbum = album;
        realCreateAlbum();
    }

    public Long getLastId() {
        return lastId;
    }

    public void setLastId(Long lastId) {
        this.lastId = lastId;
    }

    public String getLastArtist() {
        return lastArtist;
    }

    public void setLastArtist(String lastArtist) {
        this.lastArtist = lastArtist;
    }
}
