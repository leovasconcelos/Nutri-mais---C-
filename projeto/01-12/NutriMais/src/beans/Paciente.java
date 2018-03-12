/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import beans.Anamnese;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Leonardo Vasconcelos
 */
@Entity
@Table(name = "paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p"),
    @NamedQuery(name = "Paciente.findByIdPaciente", query = "SELECT p FROM Paciente p WHERE p.idPaciente = :idPaciente"),
    @NamedQuery(name = "Paciente.findByEndereco", query = "SELECT p FROM Paciente p WHERE p.endereco = :endereco"),
    @NamedQuery(name = "Paciente.findByBairro", query = "SELECT p FROM Paciente p WHERE p.bairro = :bairro"),
    @NamedQuery(name = "Paciente.findByCidade", query = "SELECT p FROM Paciente p WHERE p.cidade = :cidade"),
    @NamedQuery(name = "Paciente.findByCep", query = "SELECT p FROM Paciente p WHERE p.cep = :cep"),
    @NamedQuery(name = "Paciente.findByProfissao", query = "SELECT p FROM Paciente p WHERE p.profissao = :profissao"),
    @NamedQuery(name = "Paciente.findByEtnia", query = "SELECT p FROM Paciente p WHERE p.etnia = :etnia"),
    @NamedQuery(name = "Paciente.findByEstadocivil", query = "SELECT p FROM Paciente p WHERE p.estadocivil = :estadocivil"),
    @NamedQuery(name = "Paciente.findByIndicacao", query = "SELECT p FROM Paciente p WHERE p.indicacao = :indicacao"),
    @NamedQuery(name = "Paciente.findByConvMedico", query = "SELECT p FROM Paciente p WHERE p.convMedico = :convMedico"),
    @NamedQuery(name = "Paciente.findByCart", query = "SELECT p FROM Paciente p WHERE p.cart = :cart"),
    @NamedQuery(name = "Paciente.findByHospital", query = "SELECT p FROM Paciente p WHERE p.hospital = :hospital"),
    @NamedQuery(name = "Paciente.findByMedico", query = "SELECT p FROM Paciente p WHERE p.medico = :medico"),
    @NamedQuery(name = "Paciente.findByNome", query = "SELECT p FROM Paciente p WHERE p.nome = :nome"),
    @NamedQuery(name = "Paciente.findByTelefone", query = "SELECT p FROM Paciente p WHERE p.telefone = :telefone"),
    @NamedQuery(name = "Paciente.findByEmail", query = "SELECT p FROM Paciente p WHERE p.email = :email"),
    @NamedQuery(name = "Paciente.findByDataDeNascimento", query = "SELECT p FROM Paciente p WHERE p.dataDeNascimento = :dataDeNascimento"),
    @NamedQuery(name = "Paciente.findByNomelike", query = "SELECT p FROM Paciente p WHERE p.nome LIKE :nome"),// criei,
    @NamedQuery(name = "Paciente.max", query = "SELECT Max(p.idPaciente) FROM Paciente p")   
})
public class Paciente implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente")
    private Collection<Dieta> dietaCollection;

    @Column(name = "dataDeNascimento")
    private Integer dataDeNascimento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente")
    private Collection<Antropometria> antropometriaCollection;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "sexo")
    private String sexo;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_paciente")
    private Integer idPaciente;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "cep")
    private String cep;
    @Column(name = "profissao")
    private String profissao;
    @Column(name = "etnia")
    private String etnia;
    @Column(name = "estadocivil")
    private String estadocivil;
    @Column(name = "indicacao")
    private String indicacao;
    @Column(name = "convMedico")
    private String convMedico;
    @Column(name = "cart")
    private String cart;
    @Column(name = "hospital")
    private String hospital;
    @Column(name = "medico")
    private String medico;
    @Column(name = "nome")
    private String nome;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente")
    private Collection<Anamnese> anamneseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente")
    private Collection<Usuario> usuarioCollection;

    public Paciente() {
    }

    public Paciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Paciente(Integer idPaciente, int dataDeNascimento) {
        this.idPaciente = idPaciente;
        this.dataDeNascimento = dataDeNascimento;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEtnia() {
        return etnia;
    }

    public void setEtnia(String etnia) {
        this.etnia = etnia;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }

    public String getIndicacao() {
        return indicacao;
    }

    public void setIndicacao(String indicacao) {
        this.indicacao = indicacao;
    }

    public String getConvMedico() {
        return convMedico;
    }

    public void setConvMedico(String convMedico) {
        this.convMedico = convMedico;
    }

    public String getCart() {
        return cart;
    }

    public void setCart(String cart) {
        this.cart = cart;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @XmlTransient
    public Collection<Anamnese> getAnamneseCollection() {
        return anamneseCollection;
    }

    public void setAnamneseCollection(Collection<Anamnese> anamneseCollection) {
        this.anamneseCollection = anamneseCollection;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPaciente != null ? idPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.idPaciente == null && other.idPaciente != null) || (this.idPaciente != null && !this.idPaciente.equals(other.idPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nutrimais.Paciente[ idPaciente=" + idPaciente + " ]";
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Integer getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Integer dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    @XmlTransient
    public Collection<Antropometria> getAntropometriaCollection() {
        return antropometriaCollection;
    }

    public void setAntropometriaCollection(Collection<Antropometria> antropometriaCollection) {
        this.antropometriaCollection = antropometriaCollection;
    }

    @XmlTransient
    public Collection<Dieta> getDietaCollection() {
        return dietaCollection;
    }

    public void setDietaCollection(Collection<Dieta> dietaCollection) {
        this.dietaCollection = dietaCollection;
    }
    
}
