/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import beans.Dieta;
import beans.Paciente;
import beans.exceptions.NonexistentEntityException;
import beans.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Leonardo Vasconcelos
 */
public class DietaJpaController implements Serializable {

    public DietaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Dieta dieta) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente paciente = dieta.getPaciente();
            if (paciente != null) {
                paciente = em.getReference(paciente.getClass(), paciente.getIdPaciente());
                dieta.setPaciente(paciente);
            }
            em.persist(dieta);
            if (paciente != null) {
                paciente.getDietaCollection().add(dieta);
                paciente = em.merge(paciente);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDieta(dieta.getIdDieta()) != null) {
                throw new PreexistingEntityException("Dieta " + dieta + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Dieta dieta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dieta persistentDieta = em.find(Dieta.class, dieta.getIdDieta());
            Paciente pacienteOld = persistentDieta.getPaciente();
            Paciente pacienteNew = dieta.getPaciente();
            if (pacienteNew != null) {
                pacienteNew = em.getReference(pacienteNew.getClass(), pacienteNew.getIdPaciente());
                dieta.setPaciente(pacienteNew);
            }
            dieta = em.merge(dieta);
            if (pacienteOld != null && !pacienteOld.equals(pacienteNew)) {
                pacienteOld.getDietaCollection().remove(dieta);
                pacienteOld = em.merge(pacienteOld);
            }
            if (pacienteNew != null && !pacienteNew.equals(pacienteOld)) {
                pacienteNew.getDietaCollection().add(dieta);
                pacienteNew = em.merge(pacienteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = dieta.getIdDieta();
                if (findDieta(id) == null) {
                    throw new NonexistentEntityException("The dieta with id " + id + " no longer exists.");
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
            Dieta dieta;
            try {
                dieta = em.getReference(Dieta.class, id);
                dieta.getIdDieta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dieta with id " + id + " no longer exists.", enfe);
            }
            Paciente paciente = dieta.getPaciente();
            if (paciente != null) {
                paciente.getDietaCollection().remove(dieta);
                paciente = em.merge(paciente);
            }
            em.remove(dieta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Dieta> findDietaEntities() {
        return findDietaEntities(true, -1, -1);
    }

    public List<Dieta> findDietaEntities(int maxResults, int firstResult) {
        return findDietaEntities(false, maxResults, firstResult);
    }

    private List<Dieta> findDietaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Dieta.class));
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

    public Dieta findDieta(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Dieta.class, id);
        } finally {
            em.close();
        }
    }

    public int getDietaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Dieta> rt = cq.from(Dieta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
        
    public int conta(Paciente p)
    {
        EntityManager em = getEntityManager();// conexao com o banco
        try{
            return ((Long) em.createNamedQuery("Dieta.conta")// pega o nome no beans com o nome da funcao/
                    .setParameter("p",p)//dps coloca o parametro 
                    . getSingleResult()).intValue(); // e pega o resultado
        } 
        finally {
            em.close();
        }
    }
    
    public Dieta findDietaByIdSegunda(int id)
    {
        EntityManager em = getEntityManager();// conexao com o banco
        try{
            return ( (Dieta) em.createNamedQuery("Dieta.findDietaByIdSegunda")// pega o nome no beans com o nome da funcao/
                    .setParameter("id", id )//dps coloca o parametro
                    .getSingleResult()); // e pega o resultado
        } 
        finally {
            em.close();
        }
    }

        public Dieta findDietaByIdTerca(int id)
    {
        EntityManager em = getEntityManager();// conexao com o banco
        try{
            return ( (Dieta) em.createNamedQuery("Dieta.findDietaByIdTerça")// pega o nome no beans com o nome da funcao/
                    .setParameter("id", id )//dps coloca o parametro
                    .getSingleResult()); // e pega o resultado
        } 
        finally {
            em.close();
        }
    }
            
    public Dieta findDietaByIdQuarta(int id)
    {
        EntityManager em = getEntityManager();// conexao com o banco
        try{
            return ( (Dieta) em.createNamedQuery("Dieta.findDietaByIdQuarta")// pega o nome no beans com o nome da funcao/
                    .setParameter("id", id )//dps coloca o parametro
                    .getSingleResult()); // e pega o resultado
        } 
        finally {
            em.close();
        }
    }
    
    public Dieta findDietaByIdQuinta(int id)
    {
        EntityManager em = getEntityManager();// conexao com o banco
        try{
            return ( (Dieta) em.createNamedQuery("Dieta.findDietaByIdQuinta")// pega o nome no beans com o nome da funcao/
                    .setParameter("id", id )//dps coloca o parametro
                    .getSingleResult()); // e pega o resultado
        } 
        finally {
            em.close();
        }
    }
                
    
    public Dieta findDietaByIdSexta(int id)
    {
        EntityManager em = getEntityManager();// conexao com o banco
        try{
            return ( (Dieta) em.createNamedQuery("Dieta.findDietaByIdSexta")// pega o nome no beans com o nome da funcao/
                    .setParameter("id", id )//dps coloca o parametro
                    .getSingleResult()); // e pega o resultado
        } 
        finally {
            em.close();
        }
    }
                    
    
    public Dieta findDietaByIdSabado(int id)
    {
        EntityManager em = getEntityManager();// conexao com o banco
        try{
            return ( (Dieta) em.createNamedQuery("Dieta.findDietaByIdSabado")// pega o nome no beans com o nome da funcao/
                    .setParameter("id", id )//dps coloca o parametro
                    .getSingleResult()); // e pega o resultado
        } 
        finally {
            em.close();
        }
    }
                        
    
    public Dieta findDietaByIdDomingo(int id)
    {
        EntityManager em = getEntityManager();// conexao com o banco
        try{
            return ( (Dieta) em.createNamedQuery("Dieta.findDietaByIdDomingo")// pega o nome no beans com o nome da funcao/
                    .setParameter("id", id )//dps coloca o parametro
                    .getSingleResult()); // e pega o resultado
        } 
        finally {
            em.close();
        }
    }
                                                        
    public Dieta findDietaByIdDia(Integer id,String dia)
    {
        System.out.println(id+" "+ dia);
        EntityManager em = getEntityManager();// conexao com o banco
        try{
            return  ( (Dieta) em.createNamedQuery("Dieta.findDietaByIdDia")// pega o nome no beans com o nome da funcao/
                    .setParameter("id", id )//dps coloca o parametro
                    .setParameter("dia", dia)
                    .getSingleResult()); // e pega o resultado
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
        finally {
            em.close();
        }
    }
        
    public void apaga(int id, Paciente p)
    {
        EntityManager em = getEntityManager();// conexao com o banco
        try{
             em.createNamedQuery("Dieta.apaga")// pega o nome no beans com o nome da funcao/
                    .setParameter("id", id )//dps coloca o parametro
                    .setParameter("p", p)
                    .executeUpdate();
        } 
        finally {
            em.close();
        }
    }
    
    public int maxId(Paciente p)
    {
        EntityManager em = getEntityManager();
        try{
            return ((int) em.createNamedQuery("Dieta.maxId")
                    .setParameter("p",p)
                    .getSingleResult()); 
        } 
        finally {
            em.close();
        }
    }
    
}
