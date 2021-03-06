package org.jesperancinha.jtd.jee.mastery2.beans;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class Album {

    private Publisher publisher;

    private String album;

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    @Inject
    public void setPublisher(
            // '@Inject' not applicable to parameter
            // @Inject
            Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Album{" +
                "publisher=" + publisher +
                ", album='" + album + '\'' +
                '}';
    }
}

