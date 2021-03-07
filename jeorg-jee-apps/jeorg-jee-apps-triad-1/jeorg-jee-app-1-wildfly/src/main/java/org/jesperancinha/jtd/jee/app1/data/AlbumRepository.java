package org.jesperancinha.jtd.jee.app1.data;

import org.jesperancinha.jtd.jee.app1.domain.Album;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@ApplicationScoped
public class AlbumRepository {

    @Inject
    private EntityManager em;

    public Album findById(Long id) {
        return em.find(Album.class, id);
    }

    public Album findByName(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Album> c = cb.createQuery(Album.class);
        Root<Album> member = c.from(Album.class);
        c.select(member).where(cb.equal(member.get("albumName"), name));
        return em.createQuery(c).getSingleResult();
    }

    public List<Album> findAllOrderedByName() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Album> criteria = cb.createQuery(Album.class);
        Root<Album> member = criteria.from(Album.class);
        criteria.select(member).orderBy(cb.asc(member.get("albumName")));
        return em.createQuery(criteria).getResultList();
    }

}