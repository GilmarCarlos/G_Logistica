/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.g_logistica.modelo;

import com.mycompany.g_logistica.modelo.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author hexp_
 */
public class RotaJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        emf = Persistence.createEntityManagerFactory("GLogisticaPU");
        return emf.createEntityManager();
    }

    public void create(Rota rota) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(rota);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Rota rota) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            rota = em.merge(rota);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = rota.getIdRota();
                if (findRota(id) == null) {
                    throw new NonexistentEntityException("The rota with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Rota rota;
            try {
                rota = em.getReference(Rota.class, id);
                rota.getIdRota();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The rota with id " + id + " no longer exists.", enfe);
            }
            em.remove(rota);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Rota> findRotaT(Integer idTransportador){
       EntityManager em = null;
       try{
           em = getEntityManager();
           TypedQuery<Rota> query = em.createQuery("select r from Rota r where r.idTransportador = " + idTransportador, Rota.class);
           return query.getResultList();
       }finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    
    public List<Rota> findRotaEntities() {
        return findRotaEntities(true, -1, -1);
    }

    public List<Rota> findRotaEntities(int maxResults, int firstResult) {
        return findRotaEntities(false, maxResults, firstResult);
    }

    private List<Rota> findRotaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Rota.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Rota findRota(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Rota.class, id);
        } finally {
            em.close();
        }
    }

    public int getRotaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Rota> rt = cq.from(Rota.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
