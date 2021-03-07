package org.jesperancinha.jtd.jee.soul.domain;

import java.util.Date;

public class Album {

    private String albumName;

    private Date publishingDate;

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Date getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(Date publishingDate) {
        this.publishingDate = publishingDate;
    }

    @Override
    public String toString() {
        return "Album{" + "albumName='" + albumName + '\'' + ", publishingDate=" + publishingDate + '}';
    }
}
