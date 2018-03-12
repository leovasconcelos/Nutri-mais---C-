/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Leonardo Vasconcelos
 */
@Entity
@Table(name = "dieta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dieta.findAll", query = "SELECT d FROM Dieta d"),
    @NamedQuery(name = "Dieta.findByIdDieta", query = "SELECT d FROM Dieta d WHERE d.idDieta = :idDieta"),
    @NamedQuery(name = "Dieta.findByDia", query = "SELECT d FROM Dieta d WHERE d.dia = :dia"),
    @NamedQuery(name = "Dieta.findByCafeDaManha", query = "SELECT d FROM Dieta d WHERE d.cafeDaManha = :cafeDaManha"),
    @NamedQuery(name = "Dieta.findByLancheDaManha", query = "SELECT d FROM Dieta d WHERE d.lancheDaManha = :lancheDaManha"),
    @NamedQuery(name = "Dieta.findByAlmoco", query = "SELECT d FROM Dieta d WHERE d.almoco = :almoco"),
    @NamedQuery(name = "Dieta.findByLancheDaTarde", query = "SELECT d FROM Dieta d WHERE d.lancheDaTarde = :lancheDaTarde"),
    @NamedQuery(name = "Dieta.findByJantar", query = "SELECT d FROM Dieta d WHERE d.jantar = :jantar"),
    @NamedQuery(name = "Dieta.findByCeia", query = "SELECT d FROM Dieta d WHERE d.ceia = :ceia"),
    @NamedQuery(name = "Dieta.conta", query = "SELECT COUNT(d.idDieta) FROM Dieta d WHERE d.paciente = :p"),
    @NamedQuery(name = "Dieta.apaga", query = "DELETE FROM Dieta d Where d.idDieta = :id AND d.paciente =:p"),
    @NamedQuery(name = "Dieta.maxId", query = "SELECT MAX(d.idDieta) FROM Dieta d Where d.paciente =:p"),
    @NamedQuery(name = "Dieta.findDietaByIdSegunda", query = "SELECT d FROM Dieta d WHERE d.idDieta =:id AND d.dia ='Segunda'"),
    @NamedQuery(name = "Dieta.findDietaByIdTerça", query = "SELECT d FROM Dieta d WHERE d.idDieta =:id AND d.dia ='Terça'"),
    @NamedQuery(name = "Dieta.findDietaByIdQuarta", query = "SELECT d FROM Dieta d WHERE d.idDieta =:id AND d.dia ='Quarta'"),
    @NamedQuery(name = "Dieta.findDietaByIdQuinta", query = "SELECT d FROM Dieta d WHERE d.idDieta =:id AND d.dia ='Quinta'"),
    @NamedQuery(name = "Dieta.findDietaByIdSexta", query = "SELECT d FROM Dieta d WHERE d.idDieta =:id AND d.dia ='Sexta'"),
    @NamedQuery(name = "Dieta.findDietaByIdSabado", query = "SELECT d FROM Dieta d WHERE d.idDieta =:id AND d.dia ='Sabado'"),
    @NamedQuery(name = "Dieta.findDietaByIdDomingo", query = "SELECT d FROM Dieta d WHERE d.idDieta =:id AND d.dia ='Domingo'"),
    
    @NamedQuery(name = "Dieta.findDietaByIdDia", query = "SELECT d FROM Dieta d WHERE d.idDieta =:id AND d.dia =:dia")
    
})
public class Dieta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_dieta")
    private Integer idDieta;
    @Column(name = "dia")
    private String dia;
    @Column(name = "cafeDaManha")
    private String cafeDaManha;
    @Column(name = "lancheDaManha")
    private String lancheDaManha;
    @Column(name = "almoco")
    private String almoco;
    @Column(name = "lancheDaTarde")
    private String lancheDaTarde;
    @Column(name = "jantar")
    private String jantar;
    @Column(name = "Ceia")
    private String ceia;
    @JoinColumn(name = "paciente", referencedColumnName = "id_paciente")
    @ManyToOne(optional = false)
    private Paciente paciente;

    public Dieta() {
    }

    public Dieta(Integer idDieta) {
        this.idDieta = idDieta;
    }

    public Integer getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(Integer idDieta) {
        this.idDieta = idDieta;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getCafeDaManha() {
        return cafeDaManha;
    }

    public void setCafeDaManha(String cafeDaManha) {
        this.cafeDaManha = cafeDaManha;
    }

    public String getLancheDaManha() {
        return lancheDaManha;
    }

    public void setLancheDaManha(String lancheDaManha) {
        this.lancheDaManha = lancheDaManha;
    }

    public String getAlmoco() {
        return almoco;
    }

    public void setAlmoco(String almoco) {
        this.almoco = almoco;
    }

    public String getLancheDaTarde() {
        return lancheDaTarde;
    }

    public void setLancheDaTarde(String lancheDaTarde) {
        this.lancheDaTarde = lancheDaTarde;
    }

    public String getJantar() {
        return jantar;
    }

    public void setJantar(String jantar) {
        this.jantar = jantar;
    }

    public String getCeia() {
        return ceia;
    }

    public void setCeia(String ceia) {
        this.ceia = ceia;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDieta != null ? idDieta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dieta)) {
            return false;
        }
        Dieta other = (Dieta) object;
        if ((this.idDieta == null && other.idDieta != null) || (this.idDieta != null && !this.idDieta.equals(other.idDieta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Dieta[ idDieta=" + idDieta + " ]";
    }
    
}
