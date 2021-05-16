package org.jesperancinha.jtd.jee.mastery1.domain3;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.IdClass;
import java.io.Serializable;

@Embeddable
@IdClass(AlbumCompositeKey.class)
public class Lyric implements Serializable {
    @Column
    private String lyric1;

    @Column
    private String lyric2;

    @Column
    private String lyric3;

    public String getLyric1() {
        return lyric1;
    }

    public String getLyric2() {
        return lyric2;
    }

    public String getLyric3() {
        return lyric3;
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
}
