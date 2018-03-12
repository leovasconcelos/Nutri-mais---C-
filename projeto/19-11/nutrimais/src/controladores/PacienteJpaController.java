/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import beans.Anamnese;
import beans.Antropometria;
import beans.Dieta;
import beans.Paciente;
import beans.Usuario;
import beans.exceptions.IllegalOrphanException;
import beans.exceptions.NonexistentEntityException;
import beans.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Leonardo Vasconcelos
 */
public class PacienteJpaController implements Serializable {

    public PacienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Paciente paciente) throws PreexistingEntityException, Exception {
        if (paciente.getAnamneseCollection() == null) {
            paciente.setAnamneseCollection(new ArrayList<Anamnese>());
        }
        if (paciente.getUsuarioCollection() == null) {
            paciente.setUsuarioCollection(new ArrayList<Usuario>());
        }
        if (paciente.getAntropometriaCollection() == null) {
            paciente.setAntropometriaCollection(new ArrayList<Antropometria>());
        }
        if (paciente.getDietaCollection() == null) {
            paciente.setDietaCollection(new ArrayList<Dieta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Anamnese> attachedAnamneseCollection = new ArrayList<Anamnese>();
            for (Anamnese anamneseCollectionAnamneseToAttach : paciente.getAnamneseCollection()) {
                anamneseCollectionAnamneseToAttach = em.getReference(anamneseCollectionAnamneseToAttach.getClass(), anamneseCollectionAnamneseToAttach.getIdAna());
                attachedAnamneseCollection.add(anamneseCollectionAnamneseToAttach);
            }
            paciente.setAnamneseCollection(attachedAnamneseCollection);
            Collection<Usuario> attachedUsuarioCollection = new ArrayList<Usuario>();
            for (Usuario usuarioCollectionUsuarioToAttach : paciente.getUsuarioCollection()) {
                usuarioCollectionUsuarioToAttach = em.getReference(usuarioCollectionUsuarioToAttach.getClass(), usuarioCollectionUsuarioToAttach.getIdUsuario());
                attachedUsuarioCollection.add(usuarioCollectionUsuarioToAttach);
            }
            paciente.setUsuarioCollection(attachedUsuarioCollection);
            Collection<Antropometria> attachedAntropometriaCollection = new ArrayList<Antropometria>();
            for (Antropometria antropometriaCollectionAntropometriaToAttach : paciente.getAntropometriaCollection()) {
                antropometriaCollectionAntropometriaToAttach = em.getReference(antropometriaCollectionAntropometriaToAttach.getClass(), antropometriaCollectionAntropometriaToAttach.getIdAntro());
                attachedAntropometriaCollection.add(antropometriaCollectionAntropometriaToAttach);
            }
            paciente.setAntropometriaCollection(attachedAntropometriaCollection);
            Collection<Dieta> attachedDietaCollection = new ArrayList<Dieta>();
            for (Dieta dietaCollectionDietaToAttach : paciente.getDietaCollection()) {
                dietaCollectionDietaToAttach = em.getReference(dietaCollectionDietaToAttach.getClass(), dietaCollectionDietaToAttach.getIdDieta());
                attachedDietaCollection.add(dietaCollectionDietaToAttach);
            }
            paciente.setDietaCollection(attachedDietaCollection);
            em.persist(paciente);
            for (Anamnese anamneseCollectionAnamnese : paciente.getAnamneseCollection()) {
                Paciente oldPacienteOfAnamneseCollectionAnamnese = anamneseCollectionAnamnese.getPaciente();
                anamneseCollectionAnamnese.setPaciente(paciente);
                anamneseCollectionAnamnese = em.merge(anamneseCollectionAnamnese);
                if (oldPacienteOfAnamneseCollectionAnamnese != null) {
                    oldPacienteOfAnamneseCollectionAnamnese.getAnamneseCollection().remove(anamneseCollectionAnamnese);
                    oldPacienteOfAnamneseCollectionAnamnese = em.merge(oldPacienteOfAnamneseCollectionAnamnese);
                }
            }
            for (Usuario usuarioCollectionUsuario : paciente.getUsuarioCollection()) {
                Paciente oldPacienteOfUsuarioCollectionUsuario = usuarioCollectionUsuario.getPaciente();
                usuarioCollectionUsuario.setPaciente(paciente);
                usuarioCollectionUsuario = em.merge(usuarioCollectionUsuario);
                if (oldPacienteOfUsuarioCollectionUsuario != null) {
                    oldPacienteOfUsuarioCollectionUsuario.getUsuarioCollection().remove(usuarioCollectionUsuario);
                    oldPacienteOfUsuarioCollectionUsuario = em.merge(oldPacienteOfUsuarioCollectionUsuario);
                }
            }
            for (Antropometria antropometriaCollectionAntropometria : paciente.getAntropometriaCollection()) {
                Paciente oldPacienteOfAntropometriaCollectionAntropometria = antropometriaCollectionAntropometria.getPaciente();
                antropometriaCollectionAntropometria.setPaciente(paciente);
                antropometriaCollectionAntropometria = em.merge(antropometriaCollectionAntropometria);
                if (oldPacienteOfAntropometriaCollectionAntropometria != null) {
                    oldPacienteOfAntropometriaCollectionAntropometria.getAntropometriaCollection().remove(antropometriaCollectionAntropometria);
                    oldPacienteOfAntropometriaCollectionAntropometria = em.merge(oldPacienteOfAntropometriaCollectionAntropometria);
                }
            }
            for (Dieta dietaCollectionDieta : paciente.getDietaCollection()) {
                Paciente oldPacienteOfDietaCollectionDieta = dietaCollectionDieta.getPaciente();
                dietaCollectionDieta.setPaciente(paciente);
                dietaCollectionDieta = em.merge(dietaCollectionDieta);
                if (oldPacienteOfDietaCollectionDieta != null) {
                    oldPacienteOfDietaCollectionDieta.getDietaCollection().remove(dietaCollectionDieta);
                    oldPacienteOfDietaCollectionDieta = em.merge(oldPacienteOfDietaCollectionDieta);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPaciente(paciente.getIdPaciente()) != null) {
                throw new PreexistingEntityException("Paciente " + paciente + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Paciente paciente) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente persistentPaciente = em.find(Paciente.class, paciente.getIdPaciente());
            Collection<Anamnese> anamneseCollectionOld = persistentPaciente.getAnamneseCollection();
            Collection<Anamnese> anamneseCollectionNew = paciente.getAnamneseCollection();
            Collection<Usuario> usuarioCollectionOld = persistentPaciente.getUsuarioCollection();
            Collection<Usuario> usuarioCollectionNew = paciente.getUsuarioCollection();
            Collection<Antropometria> antropometriaCollectionOld = persistentPaciente.getAntropometriaCollection();
            Collection<Antropometria> antropometriaCollectionNew = paciente.getAntropometriaCollection();
            Collection<Dieta> dietaCollectionOld = persistentPaciente.getDietaCollection();
            Collection<Dieta> dietaCollectionNew = paciente.getDietaCollection();
            List<String> illegalOrphanMessages = null;
            for (Anamnese anamneseCollectionOldAnamnese : anamneseCollectionOld) {
                if (!anamneseCollectionNew.contains(anamneseCollectionOldAnamnese)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Anamnese " + anamneseCollectionOldAnamnese + " since its paciente field is not nullable.");
                }
            }
            for (Usuario usuarioCollectionOldUsuario : usuarioCollectionOld) {
                if (!usuarioCollectionNew.contains(usuarioCollectionOldUsuario)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Usuario " + usuarioCollectionOldUsuario + " since its paciente field is not nullable.");
                }
            }
            for (Antropometria antropometriaCollectionOldAntropometria : antropometriaCollectionOld) {
                if (!antropometriaCollectionNew.contains(antropometriaCollectionOldAntropometria)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Antropometria " + antropometriaCollectionOldAntropometria + " since its paciente field is not nullable.");
                }
            }
            for (Dieta dietaCollectionOldDieta : dietaCollectionOld) {
                if (!dietaCollectionNew.contains(dietaCollectionOldDieta)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Dieta " + dietaCollectionOldDieta + " since its paciente field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Anamnese> attachedAnamneseCollectionNew = new ArrayList<Anamnese>();
            for (Anamnese anamneseCollectionNewAnamneseToAttach : anamneseCollectionNew) {
                anamneseCollectionNewAnamneseToAttach = em.getReference(anamneseCollectionNewAnamneseToAttach.getClass(), anamneseCollectionNewAnamneseToAttach.getIdAna());
                attachedAnamneseCollectionNew.add(anamneseCollectionNewAnamneseToAttach);
            }
            anamneseCollectionNew = attachedAnamneseCollectionNew;
            paciente.setAnamneseCollection(anamneseCollectionNew);
            Collection<Usuario> attachedUsuarioCollectionNew = new ArrayList<Usuario>();
            for (Usuario usuarioCollectionNewUsuarioToAttach : usuarioCollectionNew) {
                usuarioCollectionNewUsuarioToAttach = em.getReference(usuarioCollectionNewUsuarioToAttach.getClass(), usuarioCollectionNewUsuarioToAttach.getIdUsuario());
                attachedUsuarioCollectionNew.add(usuarioCollectionNewUsuarioToAttach);
            }
            usuarioCollectionNew = attachedUsuarioCollectionNew;
            paciente.setUsuarioCollection(usuarioCollectionNew);
            Collection<Antropometria> attachedAntropometriaCollectionNew = new ArrayList<Antropometria>();
            for (Antropometria antropometriaCollectionNewAntropometriaToAttach : antropometriaCollectionNew) {
                antropometriaCollectionNewAntropometriaToAttach = em.getReference(antropometriaCollectionNewAntropometriaToAttach.getClass(), antropometriaCollectionNewAntropometriaToAttach.getIdAntro());
                attachedAntropometriaCollectionNew.add(antropometriaCollectionNewAntropometriaToAttach);
            }
            antropometriaCollectionNew = attachedAntropometriaCollectionNew;
            paciente.setAntropometriaCollection(antropometriaCollectionNew);
            Collection<Dieta> attachedDietaCollectionNew = new ArrayList<Dieta>();
            for (Dieta dietaCollectionNewDietaToAttach : dietaCollectionNew) {
                dietaCollectionNewDietaToAttach = em.getReference(dietaCollectionNewDietaToAttach.getClass(), dietaCollectionNewDietaToAttach.getIdDieta());
                attachedDietaCollectionNew.add(dietaCollectionNewDietaToAttach);
            }
            dietaCollectionNew = attachedDietaCollectionNew;
            paciente.setDietaCollection(dietaCollectionNew);
            paciente = em.merge(paciente);
            for (Anamnese anamneseCollectionNewAnamnese : anamneseCollectionNew) {
                if (!anamneseCollectionOld.contains(anamneseCollectionNewAnamnese)) {
                    Paciente oldPacienteOfAnamneseCollectionNewAnamnese = anamneseCollectionNewAnamnese.getPaciente();
                    anamneseCollectionNewAnamnese.setPaciente(paciente);
                    anamneseCollectionNewAnamnese = em.merge(anamneseCollectionNewAnamnese);
                    if (oldPacienteOfAnamneseCollectionNewAnamnese != null && !oldPacienteOfAnamneseCollectionNewAnamnese.equals(paciente)) {
                        oldPacienteOfAnamneseCollectionNewAnamnese.getAnamneseCollection().remove(anamneseCollectionNewAnamnese);
                        oldPacienteOfAnamneseCollectionNewAnamnese = em.merge(oldPacienteOfAnamneseCollectionNewAnamnese);
                    }
                }
            }
            for (Usuario usuarioCollectionNewUsuario : usuarioCollectionNew) {
                if (!usuarioCollectionOld.contains(usuarioCollectionNewUsuario)) {
                    Paciente oldPacienteOfUsuarioCollectionNewUsuario = usuarioCollectionNewUsuario.getPaciente();
                    usuarioCollectionNewUsuario.setPaciente(paciente);
                    usuarioCollectionNewUsuario = em.merge(usuarioCollectionNewUsuario);
                    if (oldPacienteOfUsuarioCollectionNewUsuario != null && !oldPacienteOfUsuarioCollectionNewUsuario.equals(paciente)) {
                        oldPacienteOfUsuarioCollectionNewUsuario.getUsuarioCollection().remove(usuarioCollectionNewUsuario);
                        oldPacienteOfUsuarioCollectionNewUsuario = em.merge(oldPacienteOfUsuarioCollectionNewUsuario);
                    }
                }
            }
            for (Antropometria antropometriaCollectionNewAntropometria : antropometriaCollectionNew) {
                if (!antropometriaCollectionOld.contains(antropometriaCollectionNewAntropometria)) {
                    Paciente oldPacienteOfAntropometriaCollectionNewAntropometria = antropometriaCollectionNewAntropometria.getPaciente();
                    antropometriaCollectionNewAntropometria.setPaciente(paciente);
                    antropometriaCollectionNewAntropometria = em.merge(antropometriaCollectionNewAntropometria);
                    if (oldPacienteOfAntropometriaCollectionNewAntropometria != null && !oldPacienteOfAntropometriaCollectionNewAntropometria.equals(paciente)) {
                        oldPacienteOfAntropometriaCollectionNewAntropometria.getAntropometriaCollection().remove(antropometriaCollectionNewAntropometria);
                        oldPacienteOfAntropometriaCollectionNewAntropometria = em.merge(oldPacienteOfAntropometriaCollectionNewAntropometria);
                    }
                }
            }
            for (Dieta dietaCollectionNewDieta : dietaCollectionNew) {
                if (!dietaCollectionOld.contains(dietaCollectionNewDieta)) {
                    Paciente oldPacienteOfDietaCollectionNewDieta = dietaCollectionNewDieta.getPaciente();
                    dietaCollectionNewDieta.setPaciente(paciente);
                    dietaCollectionNewDieta = em.merge(dietaCollectionNewDieta);
                    if (oldPacienteOfDietaCollectionNewDieta != null && !oldPacienteOfDietaCollectionNewDieta.equals(paciente)) {
                        oldPacienteOfDietaCollectionNewDieta.getDietaCollection().remove(dietaCollectionNewDieta);
                        oldPacienteOfDietaCollectionNewDieta = em.merge(oldPacienteOfDietaCollectionNewDieta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = paciente.getIdPaciente();
                if (findPaciente(id) == null) {
                    throw new NonexistentEntityException("The paciente with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente paciente;
            try {
                paciente = em.getReference(Paciente.class, id);
                paciente.getIdPaciente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paciente with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Anamnese> anamneseCollectionOrphanCheck = paciente.getAnamneseCollection();
            for (Anamnese anamneseCollectionOrphanCheckAnamnese : anamneseCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Paciente (" + paciente + ") cannot be destroyed since the Anamnese " + anamneseCollectionOrphanCheckAnamnese + " in its anamneseCollection field has a non-nullable paciente field.");
            }
            Collection<Usuario> usuarioCollectionOrphanCheck = paciente.getUsuarioCollection();
            for (Usuario usuarioCollectionOrphanCheckUsuario : usuarioCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Paciente (" + paciente + ") cannot be destroyed since the Usuario " + usuarioCollectionOrphanCheckUsuario + " in its usuarioCollection field has a non-nullable paciente field.");
            }
            Collection<Antropometria> antropometriaCollectionOrphanCheck = paciente.getAntropometriaCollection();
            for (Antropometria antropometriaCollectionOrphanCheckAntropometria : antropometriaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Paciente (" + paciente + ") cannot be destroyed since the Antropometria " + antropometriaCollectionOrphanCheckAntropometria + " in its antropometriaCollection field has a non-nullable paciente field.");
            }
            Collection<Dieta> dietaCollectionOrphanCheck = paciente.getDietaCollection();
            for (Dieta dietaCollectionOrphanCheckDieta : dietaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Paciente (" + paciente + ") cannot be destroyed since the Dieta " + dietaCollectionOrphanCheckDieta + " in its dietaCollection field has a non-nullable paciente field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(paciente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Paciente> findPacienteEntities() {
        return findPacienteEntities(true, -1, -1);
    }

    public List<Paciente> findPacienteEntities(int maxResults, int firstResult) {
        return findPacienteEntities(false, maxResults, firstResult);
    }

    private List<Paciente> findPacienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Paciente.class));
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

    public Paciente findPaciente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Paciente.class, id);
        } finally {
            em.close();
        }
    }

        public List<Paciente> findByNomelike(String nome)
    {
        EntityManager em = getEntityManager();// conexao com o banco
        try{
            return em.createNamedQuery("Paciente.findByNomelike")// pega o nome no beans com o nome da funcao/
                    .setParameter("nome","%" + nome + "%")//dps coloca o parametro 
                    .getResultList(); // e pega o resultado
        } 
        finally {
            em.close();
        }
    }
    
    public int getPacienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Paciente> rt = cq.from(Paciente.class);
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
            return ((Long) em.createNamedQuery("Paciente.max") 
                    .getSingleResult()).intValue(); 
        } 
        finally {
            em.close();
        }
    }
}
