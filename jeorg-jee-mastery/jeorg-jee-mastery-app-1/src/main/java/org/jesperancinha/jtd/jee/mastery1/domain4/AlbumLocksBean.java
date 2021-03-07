package org.jesperancinha.jtd.jee.mastery1.domain4;

import org.jesperancinha.jtd.jee.mastery1.domain2.Album;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Named
@SessionScoped
public class AlbumLocksBean implements Serializable {

    @Inject
    private AlbumLocksDao albumLocksDao;

    AlbumLocksBean() {
        final var allExamples = new LinkedList<>(getExamples());
        final int index = (int) (allExamples.size() * Math.random());
        final Album album = allExamples.get(index);
        this.albumName = album.getAlbum();
        this.artist = album.getArtist();
        this.year = album.getYear();
        this.lyric1 = album.getLyric1();
        this.lyric2 = album.getLyric2();
        this.lyric3 = album.getLyric3();
        allExamples.remove(index);
        final Album album2 = allExamples.get((int) (allExamples.size() * Math.random()));
        this.albumName2 = album2.getAlbum();
        this.artist2 = album2.getArtist();
        this.year2 = album2.getYear();
        this.lyric21 = album2.getLyric1();
        this.lyric22 = album2.getLyric2();
        this.lyric23 = album2.getLyric3();
    }

    private String albumName;
    private String albumName2;

    private String artist;
    private String artist2;

    private Long year;
    private Long year2;

    private String lyric1;
    private String lyric21;

    private String lyric2;
    private String lyric22;

    private String lyric3;
    private String lyric23;

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumName2() {
        return albumName2;
    }

    public void setAlbumName2(String albumName2) {
        this.albumName2 = albumName2;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getArtist2() {
        return artist2;
    }

    public void setArtist2(String artist2) {
        this.artist2 = artist2;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Long getYear2() {
        return year2;
    }

    public void setYear2(Long year2) {
        this.year2 = year2;
    }

    public String getLyric1() {
        return lyric1;
    }

    public String getLyric21() {
        return lyric21;
    }

    public void setLyric21(String lyric21) {
        this.lyric21 = lyric21;
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

    public String getLyric22() {
        return lyric22;
    }

    public void setLyric22(String lyric22) {
        this.lyric22 = lyric22;
    }

    public String getLyric3() {
        return lyric3;
    }

    public void setLyric3(String lyric3) {
        this.lyric3 = lyric3;
    }

    public String getLyric23() {
        return lyric23;
    }

    public void setLyric23(String lyric23) {
        this.lyric23 = lyric23;
    }

    public List<Album> getExamples() {
        final var album = new Album();
        album.setAlbum("Whaler");
        album.setArtist("Sophie B. Hawkins");
        album.setYear(1994L);
        album.setLyric1("right");
        album.setLyric2("beside");
        album.setLyric3("you");
        final var album2 = new Album();
        album2.setAlbum("Hercules and Love Affair");
        album2.setArtist("Hercules and Love Affair");
        album2.setYear(2008L);
        album2.setLyric1("raise");
        album2.setLyric2("me");
        album2.setLyric3("up");
        final var album3 = new Album();
        album3.setAlbum("Last Night");
        album3.setArtist("Moby");
        album3.setYear(2007L);
        album3.setLyric1("could");
        album3.setLyric2("you");
        album3.setLyric3("lie");
        return Arrays.asList(album, album2, album3);
    }

    public void submit() {
        final Album album = new Album();
        album.setAlbum(albumName);
        album.setArtist(artist);
        album.setYear(year);
        album.setLyric1(lyric1);
        album.setLyric2(lyric2);
        album.setLyric3(lyric3);
        final Album album2 = new Album();
        album2.setAlbum(albumName2);
        album2.setArtist(artist2);
        album2.setYear(year2);
        album2.setLyric1(lyric21);
        album2.setLyric2(lyric22);
        album2.setLyric3(lyric23);
        albumLocksDao.saveWithOptimisticLock(album);
        albumLocksDao.saveWithOptimisticLock(album2);
    }

    public void submitPessimistic() {
        final Album album = new Album();
        album.setAlbum(albumName);
        album.setArtist(artist);
        album.setYear(year);
        album.setLyric1(lyric1);
        album.setLyric2(lyric2);
        album.setLyric3(lyric3);
        final Album album2 = new Album();
        album2.setAlbum(albumName2);
        album2.setArtist(artist2);
        album2.setYear(year2);
        album2.setLyric1(lyric21);
        album2.setLyric2(lyric22);
        album2.setLyric3(lyric23);
        albumLocksDao.saveWithPessimisticLock(album);
        albumLocksDao.saveWithPessimisticLock(album2);
    }

    public void getAlbums() {
        final var album = albumLocksDao.getAlbum(lyric1, lyric2, lyric3);
        if (Objects.nonNull(album)) {
            this.albumName = album.getAlbum();
            this.artist = album.getArtist();
            this.year = album.getYear();
        } else {
            this.albumName = "";
            this.artist = "";
            this.year = 1900L;
        }
        final var album2 = albumLocksDao.getAlbum(lyric21, lyric22, lyric23);
        if (Objects.nonNull(album)) {
            this.albumName2 = album2.getAlbum();
            this.artist2 = album2.getArtist();
            this.year2 = album2.getYear();
        } else {
            this.albumName2 = "";
            this.artist2 = "";
            this.year2 = 1900L;
        }
    }
}
