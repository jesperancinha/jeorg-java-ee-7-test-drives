package org.jesperancinha.jtd.jee.mastery1.domain4;

import org.jesperancinha.jtd.jee.mastery1.domain2.Album;
import org.jesperancinha.jtd.jee.mastery1.domain2.AlbumCompositeKey;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Objects;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;

@Transactional
@TransactionManagement(TransactionManagementType.BEAN)
public class AlbumLocksDao implements Serializable {

    @Inject
    private EntityManager entityManager;

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void createAlbum(Album album) {
        entityManager.persist(album);
    }

    public Album getAlbum(String l1, String l2, String l3) {
        final AlbumCompositeKey primaryKey = new AlbumCompositeKey();
        primaryKey.setLyric1(l1);
        primaryKey.setLyric2(l2);
        primaryKey.setLyric3(l3);
        return entityManager.find(Album.class, primaryKey);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void saveWithOptimisticLock(Album a1) {
        final AlbumCompositeKey primaryKey = new AlbumCompositeKey();
        primaryKey.setLyric1(a1.getLyric1());
        primaryKey.setLyric2(a1.getLyric2());
        primaryKey.setLyric3(a1.getLyric3());
        final Album album = entityManager.find(Album.class, primaryKey, LockModeType.OPTIMISTIC);
        if (Objects.isNull(album)) {
            entityManager.persist(a1);
            entityManager.lock(a1, LockModeType.OPTIMISTIC);
        } else {
            album.setAlbum(a1.getAlbum());
            album.setArtist(a1.getArtist());
            album.setYear(a1.getYear());
            entityManager.merge(album);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            RED.printThrowableAndExit(e);
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void saveWithPessimisticLock(Album a1) {
        final AlbumCompositeKey primaryKey = new AlbumCompositeKey();
        primaryKey.setLyric1(a1.getLyric1());
        primaryKey.setLyric2(a1.getLyric2());
        primaryKey.setLyric3(a1.getLyric3());
        final Album album = entityManager.find(Album.class, primaryKey, LockModeType.PESSIMISTIC_WRITE);
        if (Objects.isNull(album)) {
            entityManager.persist(a1);
            entityManager.lock(a1, LockModeType.NONE);
        } else {
            album.setAlbum(a1.getAlbum());
            album.setArtist(a1.getArtist());
            album.setYear(a1.getYear());
            entityManager.merge(album);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            RED.printThrowableAndExit(e);
        }
    }

}
