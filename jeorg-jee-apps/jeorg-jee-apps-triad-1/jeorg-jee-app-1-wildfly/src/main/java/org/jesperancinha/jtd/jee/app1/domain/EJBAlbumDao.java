package org.jesperancinha.jtd.jee.app1.domain;

import javax.ejb.Stateful;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

import static org.jesperancinha.console.consolerizer8.ConsolerizerColor.RED;

@Stateful
@Alternative
public class EJBAlbumDao implements AlbumDao {
    @Inject
    private EntityManager entityManager;

    public Album getAlbumForName(String username) {
        try {
            Query query = entityManager.createQuery("select a from Album a where a.albumName = ?");
            query.setParameter(1, username);
            return (Album) query.getSingleResult();
        } catch (NoResultException e) {
            RED.printGenericLn(e);
            return null;
        }
    }

    public void createAlbum(Album album) {
        entityManager.persist(album);
    }

    @Override
    public List<Album> getAllAlbums() {
        return null;
    }
}
