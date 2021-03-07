package org.jesperancinha.jtd.jee.mastery1.domain2;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Named
@SessionScoped
public class AlbumBean implements Serializable {

    @Inject
    private AlbumDao albumDao;

    AlbumBean() {
        final List<Album> allExamples = getExamples();
        final Album album = allExamples.get((int) (allExamples.size() * Math.random()));
        this.albumName = album.getAlbum();
        this.artist = album.getArtist();
        this.year = album.getYear();
        this.lyric1 = album.getLyric1();
        this.lyric2 = album.getLyric2();
        this.lyric3 = album.getLyric3();
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
        album.setAlbum("Whaler");
        album.setArtist("Sophie B. Hawkins");
        album.setYear(1994L);
        album.setLyric1("right");
        album.setLyric2("beside");
        album.setLyric3("you");
        return Arrays.asList(album);
    }

    public void submit() {
        final Album album = new Album();
        album.setAlbum(albumName);
        album.setArtist(artist);
        album.setYear(year);
        album.setLyric1(lyric1);
        album.setLyric2(lyric2);
        album.setLyric3(lyric3);
        albumDao.createAlbum(album);
    }

    public void getAlbum() {
        final var album = albumDao.getAlbum(lyric1, lyric2, lyric3);
        if (Objects.nonNull(album)) {
            this.albumName = album.getAlbum();
            this.artist = album.getArtist();
            this.year = album.getYear();
        } else {
            this.albumName = "";
            this.artist = "";
            this.year = 1900L;
        }
    }
}
