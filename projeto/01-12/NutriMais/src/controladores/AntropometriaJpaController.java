/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import beans.Antropometria;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import beans.Paciente;
import controladores.exceptions.NonexistentEntityException;
import controladores.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Leonardo Vasconcelos
 */
public class AntropometriaJpaController implements Serializable {

    public AntropometriaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Antropometria antropometria) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente paciente = antropometria.getPaciente();
            if (paciente != null) {
                paciente = em.getReference(paciente.getClass(), paciente.getIdPaciente());
                antropometria.setPaciente(paciente);
            }
            em.persist(antropometria);
            if (paciente != null) {
                paciente.getAntropometriaCollection().add(antropometria);
                paciente = em.merge(paciente);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAntropometria(antropometria.getIdAntro()) != null) {
                throw new PreexistingEntityException("Antropometria " + antropometria + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Antropometria antropometria) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Antropometria persistentAntropometria = em.find(Antropometria.class, antropometria.getIdAntro());
            Paciente pacienteOld = persistentAntropometria.getPaciente();
            Paciente pacienteNew = antropometria.getPaciente();
            if (pacienteNew != null) {
                pacienteNew = em.getReference(pacienteNew.getClass(), pacienteNew.getIdPaciente());
                antropometria.setPaciente(pacienteNew);
            }
            antropometria = em.merge(antropometria);
            if (pacienteOld != null && !pacienteOld.equals(pacienteNew)) {
                pacienteOld.getAntropometriaCollection().remove(antropometria);
                pacienteOld = em.merge(pacienteOld);
            }
            if (pacienteNew != null && !pacienteNew.equals(pacienteOld)) {
                pacienteNew.getAntropometriaCollection().add(antropometria);
                pacienteNew = em.merge(pacienteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = antropometria.getIdAntro();
                if (findAntropometria(id) == null) {
                    throw new NonexistentEntityException("The antropometria with id " + id + " no longer exists.");
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
            Antropometria antropometria;
            try {
                antropometria = em.getReference(Antropometria.class, id);
                antropometria.getIdAntro();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The antropometria with id " + id + " no longer exists.", enfe);
            }
            Paciente paciente = antropometria.getPaciente();
            if (paciente != null) {
                paciente.getAntropometriaCollection().remove(antropometria);
                paciente = em.merge(paciente);
            }
            em.remove(antropometria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Antropometria> findAntropometriaEntities() {
        return findAntropometriaEntities(true, -1, -1);
    }

    public List<Antropometria> findAntropometriaEntities(int maxResults, int firstResult) {
        return findAntropometriaEntities(false, maxResults, firstResult);
    }

    private List<Antropometria> findAntropometriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Antropometria.class));
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

    public Antropometria findAntropometria(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Antropometria.class, id);
        } finally {
            em.close();
        }
    }

    public int getAntropometriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Antropometria> rt = cq.from(Antropometria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
        
    public int Max() {
        EntityManager em = getEntityManager();// conexao com o banco
        try{
            return ((int) em.createNamedQuery("Antropometria.max") 
                    .getSingleResult());
        } 
        finally {
            em.close();
        }
    }
    
        
    public int ultimaAntro(Paciente p)
    {
        EntityManager em = getEntityManager();// conexao com o banco
        try{
            return ((int) em.createNamedQuery("Antropometria.ultimaAntro")// pega o nome no beans com o nome da funcao/
                    .setParameter("p",p)//dps coloca o parametro 
                    .getSingleResult());//.intValue();// e pega o resultado
        } 
        finally {
            em.close();
        }
    }
    
}
