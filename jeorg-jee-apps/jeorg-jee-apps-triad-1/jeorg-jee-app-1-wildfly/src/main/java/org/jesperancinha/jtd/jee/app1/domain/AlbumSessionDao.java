package org.jesperancinha.jtd.jee.app1.domain;

import java.io.Serializable;

public interface AlbumSessionDao extends Serializable {
    Album realUpdateAlbum(Album album);

    Album getAlbum(Long id);
}
