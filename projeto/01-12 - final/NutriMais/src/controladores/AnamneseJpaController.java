/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import beans.Anamnese;
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
public class AnamneseJpaController implements Serializable {

    public AnamneseJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Anamnese anamnese) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente paciente = anamnese.getPaciente();
            if (paciente != null) {
                paciente = em.getReference(paciente.getClass(), paciente.getIdPaciente());
                anamnese.setPaciente(paciente);
            }
            em.persist(anamnese);
            if (paciente != null) {
                paciente.getAnamneseCollection().add(anamnese);
                paciente = em.merge(paciente);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAnamnese(anamnese.getIdAna()) != null) {
                throw new PreexistingEntityException("Anamnese " + anamnese + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Anamnese anamnese) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Anamnese persistentAnamnese = em.find(Anamnese.class, anamnese.getIdAna());
            Paciente pacienteOld = persistentAnamnese.getPaciente();
            Paciente pacienteNew = anamnese.getPaciente();
            if (pacienteNew != null) {
                pacienteNew = em.getReference(pacienteNew.getClass(), pacienteNew.getIdPaciente());
                anamnese.setPaciente(pacienteNew);
            }
            anamnese = em.merge(anamnese);
            if (pacienteOld != null && !pacienteOld.equals(pacienteNew)) {
                pacienteOld.getAnamneseCollection().remove(anamnese);
                pacienteOld = em.merge(pacienteOld);
            }
            if (pacienteNew != null && !pacienteNew.equals(pacienteOld)) {
                pacienteNew.getAnamneseCollection().add(anamnese);
                pacienteNew = em.merge(pacienteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = anamnese.getIdAna();
                if (findAnamnese(id) == null) {
                    throw new NonexistentEntityException("The anamnese with id " + id + " no longer exists.");
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
            Anamnese anamnese;
            try {
                anamnese = em.getReference(Anamnese.class, id);
                anamnese.getIdAna();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The anamnese with id " + id + " no longer exists.", enfe);
            }
            Paciente paciente = anamnese.getPaciente();
            if (paciente != null) {
                paciente.getAnamneseCollection().remove(anamnese);
                paciente = em.merge(paciente);
            }
            em.remove(anamnese);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Anamnese> findAnamneseEntities() {
        return findAnamneseEntities(true, -1, -1);
    }

    public List<Anamnese> findAnamneseEntities(int maxResults, int firstResult) {
        return findAnamneseEntities(false, maxResults, firstResult);
    }

    private List<Anamnese> findAnamneseEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Anamnese.class));
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

    public Anamnese findAnamnese(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Anamnese.class, id);
        } finally {
            em.close();
        }
    }

    public int getAnamneseCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Anamnese> rt = cq.from(Anamnese.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
