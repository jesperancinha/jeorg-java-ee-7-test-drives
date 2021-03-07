package org.jesperancinha.jtd.jee.app1.domain;

import java.util.List;

public interface ArtistDao {

    Artist getArtistForName(String name);

    void createArtist(Artist artist);

    List<Artist> getAllArtists();
}
