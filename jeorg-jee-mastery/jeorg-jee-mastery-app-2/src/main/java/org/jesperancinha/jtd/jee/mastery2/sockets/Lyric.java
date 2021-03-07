package org.jesperancinha.jtd.jee.mastery2.sockets;

public class Lyric {

    private String artist;

    private String song;

    private String lyricExtract;

    public String getArtist() {
        return artist;
    }

    public String getSong() {
        return song;
    }

    public String getLyricExtract() {
        return lyricExtract;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public void setLyricExtract(String lyricExtract) {
        this.lyricExtract = lyricExtract;
    }

    @Override
    public String toString() {
        return "Lyric{" +
                "artist='" + artist + '\'' +
                ", song='" + song + '\'' +
                ", lyricExtract='" + lyricExtract + '\'' +
                '}';
    }
}
