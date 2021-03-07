package org.jesperancinha.jtd.jee.mastery1.domain3;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.Serializable;

@Transactional
@TransactionManagement(TransactionManagementType.BEAN)
public class AlbumDao3 implements Serializable {

    @Inject
    private EntityManager entityManager;

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void createAlbum(Album album) {
        entityManager.persist(album);
    }

    public Album getAlbum(String l1, String l2, String l3) {
        final Lyric lyric = new Lyric();
        lyric.setLyric1(l1);
        lyric.setLyric2(l2);
        lyric.setLyric3(l3);
        return entityManager.find(Album.class, lyric);
    }
}
