package org.jesperancinha.jtd.jee.app1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "albumName"))
public class Album implements java.io.Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;

    @Column(unique = true)
    @Size(min = 1,
            max = 100)
    private String albumName;

    @Column(updatable = false)
    @NotNull
    private String artist;

    @Column
    @NotNull
    private Long year;

    @Column
    @Email
//    @Null
    private String email;

    @Column
//    @Null
    @Digits(fraction = 2,
            integer = 12)
    private String sales;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Album{" + "id=" + id + ", albumName='" + albumName + '\'' + ", artist='" + artist + '\'' + ", year="
                + year + '}';
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }
}
