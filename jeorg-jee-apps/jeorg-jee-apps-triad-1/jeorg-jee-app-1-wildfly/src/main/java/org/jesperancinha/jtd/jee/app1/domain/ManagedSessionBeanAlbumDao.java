package org.jesperancinha.jtd.jee.app1.domain;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

public class ManagedSessionBeanAlbumDao implements AlbumSessionDao {

    @Inject
    private EntityManager entityManager;

    @Inject
    private UserTransaction utx;

    @Inject
    private FacesContext facesContext;

    @Override
    public Album realUpdateAlbum(Album album) {
        try {
            utx.begin();
            final Album persistedAlbum = entityManager.merge(album);
            utx.commit();
            return persistedAlbum;
        } catch (NotSupportedException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        } catch (HeuristicMixedException e) {
            e.printStackTrace();
        } catch (HeuristicRollbackException e) {
            e.printStackTrace();
        } catch (RollbackException e) {
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful, you cannot update an id");
            facesContext.addMessage(null, m);
        }
        return album;
    }

    @Override
    public Album getAlbum(Long id) {
        Album album = null;
        try {
            utx.begin();
            album = entityManager.find(Album.class, id);
            utx.commit();
        } catch (NotSupportedException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        } catch (HeuristicMixedException e) {
            e.printStackTrace();
        } catch (HeuristicRollbackException e) {
            e.printStackTrace();
        } catch (RollbackException e) {
            e.printStackTrace();
        }
        return album;
    }

}
