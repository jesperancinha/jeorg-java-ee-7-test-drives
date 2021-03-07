package org.jesperancinha.jtd.jee.soul.beans;

public class LyricsExtended extends Lyric {

    public String superLyrics() {
        return String.format("%s sang this song: %s", getArtist(), getLyrics());
    }

}
