package org.jesperancinha.jtd.jee.app1.domain;


import org.jesperancinha.console.consolerizer8.Consolerizer;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import java.util.List;

import static org.jesperancinha.console.consolerizer8.ConsolerizerColor.RED;


public class ManagedBeanArtistDao implements ArtistDao {

    @Inject
    private EntityManager entityManager;

    @Inject
    private UserTransaction utx;

    @Override
    public Artist getArtistForName(String name) {
        try {
            Artist album;
            try {
                utx.begin();
                Query query = entityManager.createQuery("select a from Artist a where a.name = :name");
                query.setParameter("name", name);
                album = (Artist) query.getSingleResult();
            } catch (NoResultException e) {
                RED.printGenericLn(e);
                album = null;

            }
            utx.commit();
            return album;
        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (SystemException se) {
                RED.printGenericLn(se);
                throw new RuntimeException(se);
            }
            throw new RuntimeException(e);
        }
        // Unreachable statement
        // return null;
    }

    @Override
    public void createArtist(Artist artist) {
        try {
            try {
                utx.begin();
                entityManager.persist(artist);
            } finally {
                utx.commit();
            }
        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (SystemException se) {
                RED.printGenericLn(se);
                throw new RuntimeException(se);
            }
            RED.printGenericLn(e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Artist> getAllArtists() {
        Consolerizer.printRainbowTitleLn("Getting all albums via %s", ManagedBeanArtistDao.class.getName());
        try {
            List<Artist> albumList;
            try {
                utx.begin();
                Query query = entityManager.createQuery("select a from Artist a");
                albumList = query.getResultList();
            } catch (NoResultException e) {
                RED.printGenericLn(e);
                albumList = null;

            }
            utx.commit();
            return albumList;
        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (SystemException se) {
                RED.printGenericLn(se);
                throw new RuntimeException(se);
            }
            throw new RuntimeException(e);
        }
    }
}
