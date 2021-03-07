package org.jesperancinha.jtd.jee.soul.beans;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class Lyric {

    private String artist;

    private String lyrics;

    public String getArtist() {
        return artist;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }
}
