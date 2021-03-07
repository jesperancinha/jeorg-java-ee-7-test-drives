package org.jesperancinha.jtd.jee.mastery1.domain3;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AlbumDetails {

    @Column
    private String album;

    @Column
    private String artist;

    @Column
    private Long year;

    public String getAlbum() {
        return album;
    }

    public String getArtist() {
        return artist;
    }

    public Long getYear() {
        return year;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setYear(Long year) {
        this.year = year;
    }
}
