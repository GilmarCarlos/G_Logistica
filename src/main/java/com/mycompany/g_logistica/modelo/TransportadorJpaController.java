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
public class TransportadorJpaController implements Serializable {

   
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        emf = Persistence.createEntityManagerFactory("GLogisticaPU");
        return emf.createEntityManager();
    }

    public void create(Transportador transportador) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(transportador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Transportador transportador) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            transportador = em.merge(transportador);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = transportador.getIdTransportador();
                if (findTransportador(id) == null) {
                    throw new NonexistentEntityException("The transportador with id " + id + " no longer exists.");
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
            Transportador transportador;
            try {
                transportador = em.getReference(Transportador.class, id);
                transportador.getIdTransportador();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The transportador with id " + id + " no longer exists.", enfe);
            }
            em.remove(transportador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public List<Transportador> findTransportadorVeiculo(String veiculo){
      EntityManager em = null;
        try {
            em = getEntityManager();
            TypedQuery<Transportador> query = em.createQuery("select t from Transportador t where t.veiculo = '" + veiculo + "'", Transportador.class);
            return query.getResultList();
            
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Transportador> findTransportadorPeriodo(ConsultaData data){
     EntityManager em = null;
      try{
         em = getEntityManager();
         TypedQuery<Transportador> query = em.createQuery("select t from Transportador t where t.dtSaida between '" + data.getDtIni() + "' and '" + data.getDtFim() + "'", Transportador.class);
         return query.getResultList();
      }finally{
        if(em != null){
          em.close();
        }
     }
    }
    
    public List<Transportador> findTransportadorMotorista(String motorista){
      EntityManager em = null;
        try {
            em = getEntityManager();
            TypedQuery<Transportador> query = em.createQuery("select t from Transportador t where t.motorista like '%" + motorista + "%'", Transportador.class);
            return query.getResultList();
            
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
     public List<Transportador> findTransportadorTransportador(String nomeTransp){
      EntityManager em = null;
        try {
            em = getEntityManager();
            TypedQuery<Transportador> query = em.createQuery("select t from Transportador t where t.nomeTransp like '%" + nomeTransp + "%'", Transportador.class);
            return query.getResultList();
            
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public List<Transportador> findTransportadorEntities() {
        return findTransportadorEntities(true, -1, -1);
    }

    public List<Transportador> findTransportadorEntities(int maxResults, int firstResult) {
        return findTransportadorEntities(false, maxResults, firstResult);
    }

    private List<Transportador> findTransportadorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Transportador.class));
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

    public Transportador findTransportador(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Transportador.class, id);
        } finally {
            em.close();
        }
    }

    public int getTransportadorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Transportador> rt = cq.from(Transportador.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
