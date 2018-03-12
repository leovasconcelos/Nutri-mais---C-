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
@Table(name = "anamnese")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anamnese.findAll", query = "SELECT a FROM Anamnese a"),
    @NamedQuery(name = "Anamnese.findByIdAna", query = "SELECT a FROM Anamnese a WHERE a.idAna = :idAna"),
    @NamedQuery(name = "Anamnese.findByMotivo", query = "SELECT a FROM Anamnese a WHERE a.motivo = :motivo"),
    @NamedQuery(name = "Anamnese.findByTempoSentada", query = "SELECT a FROM Anamnese a WHERE a.tempoSentada = :tempoSentada"),
    @NamedQuery(name = "Anamnese.findByAntecendentesCirurgicos", query = "SELECT a FROM Anamnese a WHERE a.antecendentesCirurgicos = :antecendentesCirurgicos"),
    @NamedQuery(name = "Anamnese.findByTratamentoEstetico", query = "SELECT a FROM Anamnese a WHERE a.tratamentoEstetico = :tratamentoEstetico"),
    @NamedQuery(name = "Anamnese.findByAntecedentesAlergicos", query = "SELECT a FROM Anamnese a WHERE a.antecedentesAlergicos = :antecedentesAlergicos"),
    @NamedQuery(name = "Anamnese.findByFuncionamentoIntestinalReg", query = "SELECT a FROM Anamnese a WHERE a.funcionamentoIntestinalReg = :funcionamentoIntestinalReg"),
    @NamedQuery(name = "Anamnese.findByAtividadeFisica", query = "SELECT a FROM Anamnese a WHERE a.atividadeFisica = :atividadeFisica"),
    @NamedQuery(name = "Anamnese.findByFumante", query = "SELECT a FROM Anamnese a WHERE a.fumante = :fumante"),
    @NamedQuery(name = "Anamnese.findByAlimentacaoBalanceada", query = "SELECT a FROM Anamnese a WHERE a.alimentacaoBalanceada = :alimentacaoBalanceada"),
    @NamedQuery(name = "Anamnese.findByIngestaoLiquidos", query = "SELECT a FROM Anamnese a WHERE a.ingestaoLiquidos = :ingestaoLiquidos"),
    @NamedQuery(name = "Anamnese.findByGestante", query = "SELECT a FROM Anamnese a WHERE a.gestante = :gestante"),
    @NamedQuery(name = "Anamnese.findByFilhos", query = "SELECT a FROM Anamnese a WHERE a.filhos = :filhos"),
    @NamedQuery(name = "Anamnese.findByProblemaOrtopedico", query = "SELECT a FROM Anamnese a WHERE a.problemaOrtopedico = :problemaOrtopedico"),
    @NamedQuery(name = "Anamnese.findByTratamentoMedico", query = "SELECT a FROM Anamnese a WHERE a.tratamentoMedico = :tratamentoMedico"),
    @NamedQuery(name = "Anamnese.findByAcidosPele", query = "SELECT a FROM Anamnese a WHERE a.acidosPele = :acidosPele"),
    @NamedQuery(name = "Anamnese.findByTratamentoOrtomolecular", query = "SELECT a FROM Anamnese a WHERE a.tratamentoOrtomolecular = :tratamentoOrtomolecular"),
    @NamedQuery(name = "Anamnese.findByMarcoPasso", query = "SELECT a FROM Anamnese a WHERE a.marcoPasso = :marcoPasso"),
    @NamedQuery(name = "Anamnese.findByMetaisCorpo", query = "SELECT a FROM Anamnese a WHERE a.metaisCorpo = :metaisCorpo"),
    @NamedQuery(name = "Anamnese.findByAntecedentesOncologicos", query = "SELECT a FROM Anamnese a WHERE a.antecedentesOncologicos = :antecedentesOncologicos"),
    @NamedQuery(name = "Anamnese.findByCicloMenstrual", query = "SELECT a FROM Anamnese a WHERE a.cicloMenstrual = :cicloMenstrual"),
    @NamedQuery(name = "Anamnese.findByMetodoAnticoncepcional", query = "SELECT a FROM Anamnese a WHERE a.metodoAnticoncepcional = :metodoAnticoncepcional"),
    @NamedQuery(name = "Anamnese.findByVarizes", query = "SELECT a FROM Anamnese a WHERE a.varizes = :varizes"),
    @NamedQuery(name = "Anamnese.findByLesoes", query = "SELECT a FROM Anamnese a WHERE a.lesoes = :lesoes"),
    @NamedQuery(name = "Anamnese.findByHipertensao", query = "SELECT a FROM Anamnese a WHERE a.hipertensao = :hipertensao"),
    @NamedQuery(name = "Anamnese.findByHipotensao", query = "SELECT a FROM Anamnese a WHERE a.hipotensao = :hipotensao"),
    @NamedQuery(name = "Anamnese.findByEpilepsia", query = "SELECT a FROM Anamnese a WHERE a.epilepsia = :epilepsia"),
    @NamedQuery(name = "Anamnese.findByDiabetes", query = "SELECT a FROM Anamnese a WHERE a.diabetes = :diabetes"),
    @NamedQuery(name = "Anamnese.findByObservacoes", query = "SELECT a FROM Anamnese a WHERE a.observacoes = :observacoes")})
public class Anamnese implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_ana")
    private Integer idAna;
    @Column(name = "motivo")
    private String motivo;
    @Column(name = "tempoSentada")
    private String tempoSentada;
    @Column(name = "antecendentesCirurgicos")
    private String antecendentesCirurgicos;
    @Column(name = "tratamentoEstetico")
    private String tratamentoEstetico;
    @Column(name = "antecedentesAlergicos")
    private String antecedentesAlergicos;
    @Column(name = "funcionamentoIntestinalReg")
    private String funcionamentoIntestinalReg;
    @Column(name = "atividadeFisica")
    private String atividadeFisica;
    @Column(name = "fumante")
    private String fumante;
    @Column(name = "alimentacaoBalanceada")
    private String alimentacaoBalanceada;
    @Column(name = "ingestaoLiquidos")
    private String ingestaoLiquidos;
    @Column(name = "gestante")
    private Boolean gestante;
    @Column(name = "filhos")
    private Integer filhos;
    @Column(name = "problemaOrtopedico")
    private String problemaOrtopedico;
    @Column(name = "tratamentoMedico")
    private String tratamentoMedico;
    @Column(name = "acidosPele")
    private String acidosPele;
    @Column(name = "tratamentoOrtomolecular")
    private String tratamentoOrtomolecular;
    @Column(name = "marcoPasso")
    private String marcoPasso;
    @Column(name = "metaisCorpo")
    private String metaisCorpo;
    @Column(name = "antecedentesOncologicos")
    private String antecedentesOncologicos;
    @Column(name = "cicloMenstrual")
    private String cicloMenstrual;
    @Column(name = "metodoAnticoncepcional")
    private String metodoAnticoncepcional;
    @Column(name = "varizes")
    private String varizes;
    @Column(name = "lesoes")
    private String lesoes;
    @Column(name = "hipertensao")
    private Boolean hipertensao;
    @Column(name = "hipotensao")
    private Boolean hipotensao;
    @Column(name = "epilepsia")
    private Boolean epilepsia;
    @Column(name = "diabetes")
    private Boolean diabetes;
    @Column(name = "observacoes")
    private String observacoes;
    @JoinColumn(name = "paciente", referencedColumnName = "id_paciente")
    @ManyToOne(optional = false)
    private Paciente paciente;

    public Anamnese() {
    }

    public Anamnese(Integer idAna) {
        this.idAna = idAna;
    }

    public Integer getIdAna() {
        return idAna;
    }

    public void setIdAna(Integer idAna) {
        this.idAna = idAna;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getTempoSentada() {
        return tempoSentada;
    }

    public void setTempoSentada(String tempoSentada) {
        this.tempoSentada = tempoSentada;
    }

    public String getAntecendentesCirurgicos() {
        return antecendentesCirurgicos;
    }

    public void setAntecendentesCirurgicos(String antecendentesCirurgicos) {
        this.antecendentesCirurgicos = antecendentesCirurgicos;
    }

    public String getTratamentoEstetico() {
        return tratamentoEstetico;
    }

    public void setTratamentoEstetico(String tratamentoEstetico) {
        this.tratamentoEstetico = tratamentoEstetico;
    }

    public String getAntecedentesAlergicos() {
        return antecedentesAlergicos;
    }

    public void setAntecedentesAlergicos(String antecedentesAlergicos) {
        this.antecedentesAlergicos = antecedentesAlergicos;
    }

    public String getFuncionamentoIntestinalReg() {
        return funcionamentoIntestinalReg;
    }

    public void setFuncionamentoIntestinalReg(String funcionamentoIntestinalReg) {
        this.funcionamentoIntestinalReg = funcionamentoIntestinalReg;
    }

    public String getAtividadeFisica() {
        return atividadeFisica;
    }

    public void setAtividadeFisica(String atividadeFisica) {
        this.atividadeFisica = atividadeFisica;
    }

    public String getFumante() {
        return fumante;
    }

    public void setFumante(String fumante) {
        this.fumante = fumante;
    }

    public String getAlimentacaoBalanceada() {
        return alimentacaoBalanceada;
    }

    public void setAlimentacaoBalanceada(String alimentacaoBalanceada) {
        this.alimentacaoBalanceada = alimentacaoBalanceada;
    }

    public String getIngestaoLiquidos() {
        return ingestaoLiquidos;
    }

    public void setIngestaoLiquidos(String ingestaoLiquidos) {
        this.ingestaoLiquidos = ingestaoLiquidos;
    }

    public Boolean getGestante() {
        return gestante;
    }

    public void setGestante(Boolean gestante) {
        this.gestante = gestante;
    }

    public Integer getFilhos() {
        return filhos;
    }

    public void setFilhos(Integer filhos) {
        this.filhos = filhos;
    }

    public String getProblemaOrtopedico() {
        return problemaOrtopedico;
    }

    public void setProblemaOrtopedico(String problemaOrtopedico) {
        this.problemaOrtopedico = problemaOrtopedico;
    }

    public String getTratamentoMedico() {
        return tratamentoMedico;
    }

    public void setTratamentoMedico(String tratamentoMedico) {
        this.tratamentoMedico = tratamentoMedico;
    }

    public String getAcidosPele() {
        return acidosPele;
    }

    public void setAcidosPele(String acidosPele) {
        this.acidosPele = acidosPele;
    }

    public String getTratamentoOrtomolecular() {
        return tratamentoOrtomolecular;
    }

    public void setTratamentoOrtomolecular(String tratamentoOrtomolecular) {
        this.tratamentoOrtomolecular = tratamentoOrtomolecular;
    }

    public String getMarcoPasso() {
        return marcoPasso;
    }

    public void setMarcoPasso(String marcoPasso) {
        this.marcoPasso = marcoPasso;
    }

    public String getMetaisCorpo() {
        return metaisCorpo;
    }

    public void setMetaisCorpo(String metaisCorpo) {
        this.metaisCorpo = metaisCorpo;
    }

    public String getAntecedentesOncologicos() {
        return antecedentesOncologicos;
    }

    public void setAntecedentesOncologicos(String antecedentesOncologicos) {
        this.antecedentesOncologicos = antecedentesOncologicos;
    }

    public String getCicloMenstrual() {
        return cicloMenstrual;
    }

    public void setCicloMenstrual(String cicloMenstrual) {
        this.cicloMenstrual = cicloMenstrual;
    }

    public String getMetodoAnticoncepcional() {
        return metodoAnticoncepcional;
    }

    public void setMetodoAnticoncepcional(String metodoAnticoncepcional) {
        this.metodoAnticoncepcional = metodoAnticoncepcional;
    }

    public String getVarizes() {
        return varizes;
    }

    public void setVarizes(String varizes) {
        this.varizes = varizes;
    }

    public String getLesoes() {
        return lesoes;
    }

    public void setLesoes(String lesoes) {
        this.lesoes = lesoes;
    }

    public Boolean getHipertensao() {
        return hipertensao;
    }

    public void setHipertensao(Boolean hipertensao) {
        this.hipertensao = hipertensao;
    }

    public Boolean getHipotensao() {
        return hipotensao;
    }

    public void setHipotensao(Boolean hipotensao) {
        this.hipotensao = hipotensao;
    }

    public Boolean getEpilepsia() {
        return epilepsia;
    }

    public void setEpilepsia(Boolean epilepsia) {
        this.epilepsia = epilepsia;
    }

    public Boolean getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(Boolean diabetes) {
        this.diabetes = diabetes;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
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
        hash += (idAna != null ? idAna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anamnese)) {
            return false;
        }
        Anamnese other = (Anamnese) object;
        if ((this.idAna == null && other.idAna != null) || (this.idAna != null && !this.idAna.equals(other.idAna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nutrimais.Anamnese[ idAna=" + idAna + " ]";
    }
    
}
