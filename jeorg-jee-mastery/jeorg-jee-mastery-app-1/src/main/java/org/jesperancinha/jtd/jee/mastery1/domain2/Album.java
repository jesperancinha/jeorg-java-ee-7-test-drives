package org.jesperancinha.jtd.jee.mastery1.domain2;

import org.eclipse.jgit.annotations.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Version;

@Entity(name = "album")
@IdClass(AlbumCompositeKey.class)
public class Album {

    @Id
    @NonNull
    @Column
    private String lyric1;

    @Id
    @NonNull
    @Column
    private String lyric2;

    @Id
    @NonNull
    @Column
    private String lyric3;

    @Column
    private String album;

    @Column
    private String artist;

    @Column
    private Long year;

    @Version
    private long version;

    public String getLyric1() {
        return lyric1;
    }

    public String getLyric2() {
        return lyric2;
    }

    public String getLyric3() {
        return lyric3;
    }

    public String getAlbum() {
        return album;
    }

    public String getArtist() {
        return artist;
    }

    public Long getYear() {
        return year;
    }

    public void setLyric1(String lyric1) {
        this.lyric1 = lyric1;
    }

    public void setLyric2(String lyric2) {
        this.lyric2 = lyric2;
    }

    public void setLyric3(String lyric3) {
        this.lyric3 = lyric3;
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
