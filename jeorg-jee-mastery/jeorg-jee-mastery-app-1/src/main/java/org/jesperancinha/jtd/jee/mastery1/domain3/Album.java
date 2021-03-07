package org.jesperancinha.jtd.jee.mastery1.domain3;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "albudetail")
@Table(name = "albumdetail")
public class Album {

    @EmbeddedId
    private Lyric lyric;

    @Embedded
    private AlbumDetails albumDetails;

    public Lyric getLyric() {
        return lyric;
    }

    public void setLyric(Lyric lyric) {
        this.lyric = lyric;
    }

    public AlbumDetails getAlbumDetails() {
        return albumDetails;
    }

    public void setAlbumDetails(AlbumDetails albumDetails) {
        this.albumDetails = albumDetails;
    }
}
