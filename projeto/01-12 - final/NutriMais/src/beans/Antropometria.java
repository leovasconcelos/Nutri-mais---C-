/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.text.DecimalFormat;
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
@Table(name = "antropometria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Antropometria.findAll", query = "SELECT a FROM Antropometria a"),
    @NamedQuery(name = "Antropometria.findByIdAntro", query = "SELECT a FROM Antropometria a WHERE a.idAntro = :idAntro"),
    @NamedQuery(name = "Antropometria.findByPeso", query = "SELECT a FROM Antropometria a WHERE a.peso = :peso"),
    @NamedQuery(name = "Antropometria.findByEstatura", query = "SELECT a FROM Antropometria a WHERE a.estatura = :estatura"),
    @NamedQuery(name = "Antropometria.findByImc", query = "SELECT a FROM Antropometria a WHERE a.imc = :imc"),
    @NamedQuery(name = "Antropometria.findByPeito", query = "SELECT a FROM Antropometria a WHERE a.peito = :peito"),
    @NamedQuery(name = "Antropometria.findByAbdominal", query = "SELECT a FROM Antropometria a WHERE a.abdominal = :abdominal"),
    @NamedQuery(name = "Antropometria.findByCoxa", query = "SELECT a FROM Antropometria a WHERE a.coxa = :coxa"),
    @NamedQuery(name = "Antropometria.findByCircAbdomen", query = "SELECT a FROM Antropometria a WHERE a.circAbdomen = :circAbdomen"),
    @NamedQuery(name = "Antropometria.findByCircPerna", query = "SELECT a FROM Antropometria a WHERE a.circPerna = :circPerna"),
    @NamedQuery(name = "Antropometria.findByCircBraco", query = "SELECT a FROM Antropometria a WHERE a.circBraco = :circBraco"),
    @NamedQuery(name = "Antropometria.findByCircPanturrilha", query = "SELECT a FROM Antropometria a WHERE a.circPanturrilha = :circPanturrilha"),
    @NamedQuery(name = "Antropometria.findByTriceps", query = "SELECT a FROM Antropometria a WHERE a.triceps = :triceps"),
    @NamedQuery(name = "Antropometria.findBySubescapular", query = "SELECT a FROM Antropometria a WHERE a.subescapular = :subescapular"),
    @NamedQuery(name = "Antropometria.findBySuprailiaca", query = "SELECT a FROM Antropometria a WHERE a.suprailiaca = :suprailiaca"),
    @NamedQuery(name = "Antropometria.findByAxiliarMedia", query = "SELECT a FROM Antropometria a WHERE a.axiliarMedia = :axiliarMedia"),
    @NamedQuery(name = "Antropometria.findByAntropometriacol", query = "SELECT a FROM Antropometria a WHERE a.antropometriacol = :antropometriacol"),
    @NamedQuery(name = "Antropometria.findByDensidadeCorporal", query = "SELECT a FROM Antropometria a WHERE a.densidadeCorporal = :densidadeCorporal"),
    @NamedQuery(name = "Antropometria.findByPorcentagemGordura", query = "SELECT a FROM Antropometria a WHERE a.porcentagemGordura = :porcentagemGordura"),
    @NamedQuery(name = "Antropometria.findByPesoGordura", query = "SELECT a FROM Antropometria a WHERE a.pesoGordura = :pesoGordura"),
    @NamedQuery(name = "Antropometria.findByPesoMassaMagra", query = "SELECT a FROM Antropometria a WHERE a.pesoMassaMagra = :pesoMassaMagra"),
    @NamedQuery(name = "Antropometria.findByPesoIdeal", query = "SELECT a FROM Antropometria a WHERE a.pesoIdeal = :pesoIdeal"),
    @NamedQuery(name = "Antropometria.findByAdequacaoPeso", query = "SELECT a FROM Antropometria a WHERE a.adequacaoPeso = :adequacaoPeso"),
    @NamedQuery(name = "Antropometria.findByClassificacaoAdequacaoPeso", query = "SELECT a FROM Antropometria a WHERE a.classificacaoAdequacaoPeso = :classificacaoAdequacaoPeso"),
    @NamedQuery(name = "Antropometria.findByAjustePesoIdeal", query = "SELECT a FROM Antropometria a WHERE a.ajustePesoIdeal = :ajustePesoIdeal"),
    @NamedQuery(name = "Antropometria.findBySomatoriaDobras", query = "SELECT a FROM Antropometria a WHERE a.somatoriaDobras = :somatoriaDobras"),
    @NamedQuery(name = "Antropometria.findByData", query = "SELECT a FROM Antropometria a WHERE a.data = :data"),
    @NamedQuery(name = "Antropometria.max", query = "SELECT MAX(a.idAntro) FROM Antropometria a"),
    @NamedQuery(name = "Antropometria.ultimaAntro", query = "SELECT MAX(a.idAntro) FROM Antropometria a  WHERE a.paciente = :p")
})
public class Antropometria implements Serializable {

    @Column(name = "data")
    private Integer data;
    @JoinColumn(name = "paciente", referencedColumnName = "id_paciente")
    @ManyToOne(optional = false)
    private Paciente paciente;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_antro")
    private Integer idAntro;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peso")
    private Double peso;
    @Column(name = "estatura")
    private Double estatura;
    @Column(name = "imc")
    private Double imc;
    @Column(name = "peito")
    private Double peito;
    @Column(name = "abdominal")
    private Double abdominal;
    @Column(name = "coxa")
    private Double coxa;
    @Column(name = "circAbdomen")
    private Double circAbdomen;
    @Column(name = "circPerna")
    private Double circPerna;
    @Column(name = "circBraco")
    private Double circBraco;
    @Column(name = "circPanturrilha")
    private Double circPanturrilha;
    @Column(name = "triceps")
    private Double triceps;
    @Column(name = "subescapular")
    private Double subescapular;
    @Column(name = "suprailiaca")
    private Double suprailiaca;
    @Column(name = "axiliarMedia")
    private Double axiliarMedia;
    @Column(name = "antropometriacol")
    private Double antropometriacol;
    @Column(name = "densidadeCorporal")
    private Double densidadeCorporal;
    @Column(name = "porcentagemGordura")
    private Double porcentagemGordura;
    @Column(name = "pesoGordura")
    private Double pesoGordura;
    @Column(name = "pesoMassaMagra")
    private Double pesoMassaMagra;
    @Column(name = "pesoIdeal")
    private Double pesoIdeal;
    @Column(name = "adequacaoPeso")
    private Double adequacaoPeso;
    @Column(name = "classificacaoAdequacaoPeso")
    private String classificacaoAdequacaoPeso;
    @Column(name = "ajustePesoIdeal")
    private Double ajustePesoIdeal;
    @Column(name = "somatoriaDobras")
    private Double somatoriaDobras;

    public Antropometria() {
    }

    public Antropometria(Integer idAntro) {
        this.idAntro = idAntro;
    }

    public Antropometria(Integer idAntro, int data) {
        this.idAntro = idAntro;
        this.data = data;
    }

    public Integer getIdAntro() {
        return idAntro;
    }

    public void setIdAntro(Integer idAntro) {
        this.idAntro = idAntro;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getEstatura() {
        return estatura;
    }

    public void setEstatura(Double estatura) {
        this.estatura = estatura;
    }

    public Double getImc() {
        return imc;
    }

    public void setImc() {       
        this.imc = this.peso/(this.estatura*this.estatura);
    }

    public Double getPeito() {
        return peito;
    }

    public void setPeito(Double peito) {
        this.peito = peito;
    }

    public Double getAbdominal() {
        return abdominal;
    }

    public void setAbdominal(Double abdominal) {
        this.abdominal = abdominal;
    }

    public Double getCoxa() {
        return coxa;
    }

    public void setCoxa(Double coxa) {
        this.coxa = coxa;
    }

    public Double getCircAbdomen() {
        return circAbdomen;
    }

    public void setCircAbdomen(Double circAbdomen) {
        this.circAbdomen = circAbdomen;
    }

    public Double getCircPerna() {
        return circPerna;
    }

    public void setCircPerna(Double circPerna) {
        this.circPerna = circPerna;
    }

    public Double getCircBraco() {
        return circBraco;
    }

    public void setCircBraco(Double circBraco) {
        this.circBraco = circBraco;
    }

    public Double getCircPanturrilha() {
        return circPanturrilha;
    }

    public void setCircPanturrilha(Double circPanturrilha) {
        this.circPanturrilha = circPanturrilha;
    }

    public Double getTriceps() {
        return triceps;
    }

    public void setTriceps(Double triceps) {
        this.triceps = triceps;
    }

    public Double getSubescapular() {
        return subescapular;
    }

    public void setSubescapular(Double subescapular) {
        this.subescapular = subescapular;
    }

    public Double getSuprailiaca() {
        return suprailiaca;
    }

    public void setSuprailiaca(Double suprailiaca) {
        this.suprailiaca = suprailiaca;
    }

    public Double getAxiliarMedia() {
        return axiliarMedia;
    }

    public void setAxiliarMedia(Double axiliarMedia) {
        this.axiliarMedia = axiliarMedia;
    }

    public Double getAntropometriacol() {
        return antropometriacol;
    }

    public void setAntropometriacol(Double antropometriacol) {
        this.antropometriacol = antropometriacol;
    }

    public Double getDensidadeCorporal() {
        return densidadeCorporal;
    }

    public void setDensidadeCorporal(Double densidadeCorporal) {
        this.densidadeCorporal = densidadeCorporal;
    }

    public Double getPorcentagemGordura() {
        return porcentagemGordura;
    }

    public void setPorcentagemGordura(Double porcentagemGordura) {
        this.porcentagemGordura = porcentagemGordura;
    }

    public Double getPesoGordura() {
        return pesoGordura;
    }

    public void setPesoGordura() {
        this.pesoGordura = this.porcentagemGordura * this.peso /100;
    }

    public Double getPesoMassaMagra() {
        return pesoMassaMagra;
    }

    public void setPesoMassaMagra() {
        this.pesoMassaMagra = this.peso - this.pesoGordura;
    }

    public Double getPesoIdeal() {
        return pesoIdeal;
    }

    public void setPesoIdeal(int sexo) {
        if(sexo == 0)
        {
            this.pesoIdeal = 22*(this.estatura*this.estatura);
        }
        else
        {
            this.pesoIdeal = 20.8*(this.estatura*this.estatura);
        }
    }

    public Double getAdequacaoPeso() {
        return adequacaoPeso;
    }

    public void setAdequacaoPeso() {
        this.adequacaoPeso = (this.peso / this.pesoIdeal) * 100;   
    }

    public String getClassificacaoAdequacaoPeso() {
        return classificacaoAdequacaoPeso;
    }

    public void setClassificacaoAdequacaoPeso() {
        if(this.adequacaoPeso<=70)
        {    
            this.classificacaoAdequacaoPeso = "Subnutrição Grave";
        }
        if(this.adequacaoPeso>70 && this.adequacaoPeso <=80)
        {    
            this.classificacaoAdequacaoPeso = "Subnutrição Moderada";
        }
        if(this.adequacaoPeso>80 && this.adequacaoPeso <=90)
        {    
            this.classificacaoAdequacaoPeso = "Subnutrição Leve";
        }
        if(this.adequacaoPeso>90 && this.adequacaoPeso <=110)
        {    
            this.classificacaoAdequacaoPeso = "Eutrofia";
        }
        if(this.adequacaoPeso>110 && this.adequacaoPeso <=120)
        {    
            this.classificacaoAdequacaoPeso = "Sobrepeso";
        }
        if(this.adequacaoPeso>120)
        {    
            this.classificacaoAdequacaoPeso = "Obesidade";
        }
    }

    public Double getAjustePesoIdeal() {
        return ajustePesoIdeal;
    }

    public void setAjustePesoIdeal() {
        this.ajustePesoIdeal = (this.peso - this.pesoIdeal)*0.25 + this.pesoIdeal;
    }

    public Double getSomatoriaDobras() {
        return somatoriaDobras;
    }

    public void setSomatoriaDobras(Double somatoriaDobras) {
        this.somatoriaDobras = somatoriaDobras;
    }

    
    public void tecnicaSlaugtherMenor35(int sexo, double constante)
    {
        if(sexo == 0)
        {
            this.somatoriaDobras = this.triceps + this.subescapular;
            this.porcentagemGordura = (1.21 * this.somatoriaDobras) - (0.008*(this.somatoriaDobras * this.somatoriaDobras)) - constante;
        }
        if(sexo == 1)
        {
            this.somatoriaDobras = this.triceps + this.subescapular;
            this.porcentagemGordura = (1.33 * this.somatoriaDobras) - (0.013*(this.somatoriaDobras * this.somatoriaDobras)) - constante;
        }
    }
    
    public void tecnicaSlaugtherMaior35(int sexo)
    {
        if(sexo==0)//menino
        {
            
                this.somatoriaDobras = this.triceps + this.subescapular;
                this.porcentagemGordura = 0.783 * this.somatoriaDobras + 1.6;
                this.pesoGordura = (this.porcentagemGordura * this.peso) / 100;
            
        }
        if(sexo==1)//menina
        {
            
                this.somatoriaDobras = this.triceps + this.subescapular;
                this.porcentagemGordura = 0.546 * this.somatoriaDobras + 9.7;
                this.pesoGordura = (this.porcentagemGordura * this.peso) / 100;           
        }
    }
    
    public void tecnicaBoileau(double constante)
    {
        this.somatoriaDobras = this.triceps + this.subescapular;              
        this.porcentagemGordura = (1.35 * this.somatoriaDobras) - (0.012*(this.somatoriaDobras * this.somatoriaDobras)) - constante;                
    }
    
    public void tecnicaJackPoll3dobras(int idade)
    {
        this.somatoriaDobras = this.peito + this.abdominal +  this.coxa;
        this.densidadeCorporal = 1.099075 - 0.008209 * this.somatoriaDobras + 0.0000026 *(this.somatoriaDobras *this.somatoriaDobras ) - 0.0002017 * (idade) - 0.00005675 * this.circAbdomen + 0.00018596*this.circBraco;
        this.porcentagemGordura = (4.95/this.densidadeCorporal - 4.5) * 100;

    }
    
    public void tecnicaJackPoll7dobras(int idade)
    {
        this.somatoriaDobras = this.triceps + this.subescapular + this.suprailiaca + this.peito + this.axiliarMedia + this.abdominal + this.coxa;
        this.densidadeCorporal = 1.101 - 0.0004115 * this.somatoriaDobras + 0.00000069 * (this.somatoriaDobras* this.somatoriaDobras)- 0.00022631*idade-0.000059239*this.circAbdomen + 0.000190632*this.circBraco;
        this.porcentagemGordura = (4.95/this.densidadeCorporal - 4.5) * 100;

    }
    
    public void guedes(int sexo)
    {
        if(sexo == 0)// 0 e homen
        {
            this.somatoriaDobras = this.triceps + this.suprailiaca + this.abdominal;
            this.densidadeCorporal = 1.1714 - (0.0671* Math.log10(this.somatoriaDobras));
            this.porcentagemGordura = (4.95/this.densidadeCorporal - 4.5) * 100;

        }
        else
        {
            this.somatoriaDobras = this.subescapular + this.suprailiaca + this.coxa;
            this.densidadeCorporal = 1.1665 - (0.7063 * Math.log10(this.somatoriaDobras));
            this.porcentagemGordura = (4.95/this.densidadeCorporal - 4.5) * 100;

        }
        
    }
       
    public void lohman(int idade)
    {
        this.somatoriaDobras = this.triceps + this.subescapular + this.abdominal;
        this.densidadeCorporal = 1.0982 - 0.000815* this.somatoriaDobras + 0.00000084*(this.somatoriaDobras*this.somatoriaDobras);
        this.porcentagemGordura = (4.95/this.densidadeCorporal - 4.5) * 100;

    }
        
    public void faulkner()
    {
        this.somatoriaDobras = this.triceps + this.subescapular + this.suprailiaca + this.abdominal;
        this.porcentagemGordura = 5.783+0.153 * this.somatoriaDobras;

    }
        
    public void poll()
    {
        this.somatoriaDobras = this.peito + this.subescapular + this.coxa;
        this.densidadeCorporal = 1.09716 - 0.00065 * this.peito - 0.00055 * this.subescapular - 0.0008*this.coxa;
        this.porcentagemGordura = (4.95/this.densidadeCorporal - 4.5) * 100;

    }
    
    public void jackPollWard(int idade)
    {
        this.somatoriaDobras = this.triceps + this.suprailiaca + this.coxa;
        this.densidadeCorporal =1.0994921-0.0009929 * this.somatoriaDobras + 0.0000023*(this.somatoriaDobras*this.somatoriaDobras)-0.0001392*idade;
        this.porcentagemGordura = (4.95/this.densidadeCorporal - 4.5) * 100;

    }
       
    public void jackPollWardAtletas(int idade)
    {
        this.somatoriaDobras = this.triceps + this.suprailiaca + this.coxa;
        this.densidadeCorporal =1.1074921-0.0009929 * this.somatoriaDobras + 0.0000023*(this.somatoriaDobras*this.somatoriaDobras)-0.0001392*idade;
        this.porcentagemGordura = (4.95/this.densidadeCorporal - 4.5) * 100;

    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAntro != null ? idAntro.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Antropometria)) {
            return false;
        }
        Antropometria other = (Antropometria) object;
        if ((this.idAntro == null && other.idAntro != null) || (this.idAntro != null && !this.idAntro.equals(other.idAntro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nutrimais.Antropometria[ idAntro=" + idAntro + " ]";
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
}
