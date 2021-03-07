package org.jesperancinha.jtd.jee.mastery1.domain;

import java.io.Serializable;
import java.util.List;

public interface StoreRecordDao extends Serializable {
    StoreRecord getAlbumById(String name);

    void createAlbum(StoreRecord album);

    List<StoreRecord> getAllAlbums();
}
