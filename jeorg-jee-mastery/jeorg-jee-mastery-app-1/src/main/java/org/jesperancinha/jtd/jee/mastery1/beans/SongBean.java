package org.jesperancinha.jtd.jee.mastery1.beans;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.Map;

@ManagedBean(name = "songBean",
        eager = true)
@SessionScoped
public class SongBean implements Serializable {

    private String song;

    private String artist;

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void submit() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params =
                fc.getExternalContext().getRequestParameterMap();
        final var song = params.get("song");
        final var artist = params.get("artist");
        this.song = song;
        this.artist = artist;
    }
}
