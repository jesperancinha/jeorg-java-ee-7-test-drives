package org.jesperancinha.jtd.jee.mastery1.domain3;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Named
@SessionScoped
public class AlbumBean3 implements Serializable {

    @Inject
    private AlbumDao3 albumDao3;

    AlbumBean3() {
        final List<Album> allExamples = getExamples();
        final Album album = allExamples.get((int) (allExamples.size() * Math.random()));
        final AlbumDetails albumDetails = album.getAlbumDetails();
        this.albumName = albumDetails.getAlbum();
        this.artist = albumDetails.getArtist();
        this.year = albumDetails.getYear();
        final Lyric lyric = album.getLyric();
        this.lyric1 = lyric.getLyric1();
        this.lyric2 = lyric.getLyric2();
        this.lyric3 = lyric.getLyric3();
    }

    private String albumName;

    private String artist;

    private Long year;

    private String lyric1;

    private String lyric2;

    private String lyric3;

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public String getLyric1() {
        return lyric1;
    }

    public void setLyric1(String lyric1) {
        this.lyric1 = lyric1;
    }

    public String getLyric2() {
        return lyric2;
    }

    public void setLyric2(String lyric2) {
        this.lyric2 = lyric2;
    }

    public String getLyric3() {
        return lyric3;
    }

    public void setLyric3(String lyric3) {
        this.lyric3 = lyric3;
    }

    public List<Album> getExamples() {
        final var album = new Album();
        final AlbumDetails albumDetails = new AlbumDetails();
        album.setAlbumDetails(albumDetails);
        albumDetails.setAlbum("Whaler");
        albumDetails.setArtist("Sophie B. Hawkins");
        albumDetails.setYear(1994L);
        final Lyric lyric = new Lyric();
        album.setLyric(lyric);
        lyric.setLyric1("right");
        lyric.setLyric2("beside");
        lyric.setLyric3("you");
        return Collections.singletonList(album);
    }

    public void submit() {
        final Album album = new Album();
        final AlbumDetails albumDetails = new AlbumDetails();
        album.setAlbumDetails(albumDetails);
        albumDetails.setAlbum(albumName);
        albumDetails.setArtist(artist);
        albumDetails.setYear(year);
        final Lyric lyric = new Lyric();
        album.setLyric(lyric);
        lyric.setLyric1(lyric1);
        lyric.setLyric2(lyric2);
        lyric.setLyric3(lyric3);
        albumDao3.createAlbum(album);
    }

    public void getAlbum() {
        final var album = albumDao3.getAlbum(lyric1, lyric2, lyric3);
        if (Objects.nonNull(album)) {
            final AlbumDetails albumDetails = album.getAlbumDetails();
            this.albumName = albumDetails.getAlbum();
            this.artist = albumDetails.getArtist();
            this.year = albumDetails.getYear();
        } else {
            this.albumName = "";
            this.artist = "";
            this.year = 1900L;
        }
    }
}
