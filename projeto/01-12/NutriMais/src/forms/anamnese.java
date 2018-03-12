/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import beans.Anamnese;
import beans.Paciente;
import controladores.AnamneseJpaController;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class anamnese extends javax.swing.JFrame {

    /**
     * Creates new form anamnese
     */
    public Paciente paciente = new Paciente();
    public int estado;
    private AnamneseJpaController anaDao;
    
    public void preencherCampos(Anamnese ana )
    {
        if(!ana.getTempoSentada().equals(""))
        {
            rbStempoSentado.setSelected(true);
            rbNtempoSentado.setSelected(false);
        }
        else if(ana.getTempoSentada().equals("Não"))
        {
            rbStempoSentado.setSelected(false);
            rbNtempoSentado.setSelected(true);
        }
        if(!ana.getAntecendentesCirurgicos().equals(""))
        {
            rbSanteCirurgico.setSelected(true);
            rbNanteCirurgico.setSelected(false); 
        }else if(ana.getAntecendentesCirurgicos().equals("Não"))
        {
            rbSanteCirurgico.setSelected(false);
            rbNanteCirurgico.setSelected(true);
        }
        if(!ana.getTratamentoEstetico().equals(""))
        {
            rbStratamentoEstetico.setSelected(true); 
            rbNtratamentoEstetico.setSelected(false);
        }else if(ana.getTratamentoEstetico().equals("Não"))
        {
            rbStratamentoEstetico.setSelected(false); 
            rbNtratamentoEstetico.setSelected(true);
        }
        if(!ana.getAntecedentesAlergicos().equals(""))
        {
            rbSanteAlergico.setSelected(true);
            rbNanteAlergico.setSelected(false);
        }else if(ana.getAntecedentesAlergicos().equals("Não"))
        {
            rbSanteAlergico.setSelected(false);
            rbNanteAlergico.setSelected(true);
        }
        if(!ana.getFuncionamentoIntestinalReg().equals(""))
        {
            rbSfuncIntestinalReg.setSelected(true);
            rbNfuncIntestinalReg.setSelected(false);
        }else if(ana.getFuncionamentoIntestinalReg().equals("Não"))
        {
            rbSfuncIntestinalReg.setSelected(false);
            rbNfuncIntestinalReg.setSelected(true);
        }
        if(!ana.getAtividadeFisica().equals(""))
        {
            rbSatividadeFisica.setSelected(true);
            rbNatividadeFisica.setSelected(false);
        }else if(ana.getAtividadeFisica().equals("Não"))
        {
            rbSatividadeFisica.setSelected(false);
            rbNatividadeFisica.setSelected(true);
        }
        if(!ana.getFumante().equals(""))
        {
            rbSfumante.setSelected(true);
            rbNfumante.setSelected(false);
        }else if(ana.getFumante().equals("Não"))
        {
            rbSfumante.setSelected(false);
            rbNfumante.setSelected(true);
        }
        if(!ana.getAlimentacaoBalanceada().equals(""))
        {
            rbSalimentacaoBalanceada.setSelected(true);
            rbNalimentacaoBalanceada.setSelected(false);
        }else if(ana.getAlimentacaoBalanceada().equals("Não"))
        {
            rbSalimentacaoBalanceada.setSelected(false);
            rbNalimentacaoBalanceada.setSelected(true);
        }
        if(ana.getGestante() == true)
        {
            rbSgestante.setSelected(true);
            rbNgestante.setSelected(false);
        }else if(ana.getGestante() == false)
        {
            rbSgestante.setSelected(false);
            rbNgestante.setSelected(true);
        }
        if(ana.getFilhos()==0)
        {
            rbSfilhos.setSelected(true);
            rbNfilhos.setSelected(false);    
        }else
        {
            rbSfilhos.setSelected(false);
            rbNfilhos.setSelected(true);
        }
        if(!ana.getProblemaOrtopedico().equals(""))
        {
            rbSproblemaOrtopedico.setSelected(true);
            rbNproblemaOrtopedico.setSelected(false);
        }else if(ana.getProblemaOrtopedico().equals("Não"))
        {
            rbSproblemaOrtopedico.setSelected(false);
            rbNproblemaOrtopedico.setSelected(true);
        }
        if(!ana.getTratamentoMedico().equals(""))
        {
            rbStratamentoMedico.setSelected(true);
            rbNtratamentoMedico.setSelected(false);
        }else if(ana.getTratamentoMedico().equals("Não"))
        {
            rbStratamentoMedico.setSelected(false);
            rbNtratamentoMedico.setSelected(true);
        }
        if(!ana.getAcidosPele().equals(""))
        {
            rbSacidoPele.setSelected(true);
            rbNacidoPele.setSelected(false);
        }else if(ana.getAcidosPele().equals("Não"))
        {
            rbSacidoPele.setSelected(false);
            rbNacidoPele.setSelected(true);
        }
        if(!ana.getTratamentoOrtomolecular().equals(""))
        {
            rbStratamentoOrtomolecular.setSelected(true);
            rbNtratamentoOrtomolecular.setSelected(false);
        }else if (ana.getTratamentoOrtomolecular().equals("Não"))
        {
            rbStratamentoOrtomolecular.setSelected(false);
            rbNtratamentoOrtomolecular.setSelected(true);
        }
        if(!ana.getMarcoPasso().equals(""))
        {
            rbSmarcapasso.setSelected(true);
            rbNmarcapasso.setSelected(false);
        }else if(ana.getMarcoPasso().equals("Não"))
        {
            rbSmarcapasso.setSelected(false);
            rbNmarcapasso.setSelected(true);
        }
        if(!ana.getMetaisCorpo().equals(""))
        {
            rbSpresencaoMetais.setSelected(true);
            rbNpresencaMetais.setSelected(false);
        }else if(ana.getMetaisCorpo().equals("Não"))
        {
            rbSpresencaoMetais.setSelected(false);
            rbNpresencaMetais.setSelected(true);
        }
        if(!ana.getAntecedentesOncologicos().equals(""))
        {
            rbSanteOncologico.setSelected(true);
            rbNantiOncologico.setSelected(false);
        }else if(ana.getAntecedentesOncologicos().equals("Não"))
        {
            rbSanteOncologico.setSelected(false);
            rbNantiOncologico.setSelected(true);
        }
        if(!ana.getCicloMenstrual().equals(""))
        {
            rbScicloMenstrual.setSelected(true);
            rbNciclomenstrual.setSelected(false);
        }
        else if (ana.getCicloMenstrual().equals("Não"))
        {
            rbScicloMenstrual.setSelected(false);
            rbNciclomenstrual.setSelected(true);
        }
        if(!ana.getMetodoAnticoncepcional().equals("")) 
        {
            rbSanticoncepcional.setSelected(true);
            rbNanticoncepcional.setSelected(false);
        }else if (ana.getMetodoAnticoncepcional().equals("Não"))
        {
            rbSanticoncepcional.setSelected(false);
            rbNanticoncepcional.setSelected(true);
        }
        if(!ana.getVarizes().equals(""))
        {
            rbSvarizes.setSelected(true);
            rbNvarizes.setSelected(false);
        }else if(ana.getVarizes().equals("Não"))
        {
            rbSvarizes.setSelected(false);
            rbNvarizes.setSelected(true);
        }
        if(!ana.getLesoes().equals(""))
        {
            rbSlesoes.setSelected(true);
            rbNlesoes.setSelected(false);
        }else if(ana.getLesoes().equals("Não"))
        {
            rbSlesoes.setSelected(false);
            rbNlesoes.setSelected(true);
        }
        if(ana.getHipertensao().equals("Não"))
        {
            rbShipertensao.setSelected(true);
            rbNhipertensao.setSelected(false);
        }else
        {
            rbShipertensao.setSelected(false);
            rbNhipertensao.setSelected(true);
        }
        if(ana.getHipotensao().equals("Não"))
        {
            rbShipotesao.setSelected(true);
            rbNhipotensao.setSelected(false);
        }else
        {
            rbShipotesao.setSelected(false);
            rbNhipotensao.setSelected(true);
        }
        if(ana.getEpilepsia().equals("Não"))
        {
            rbSepilipsia.setSelected(true);
            rbNelipsia.setSelected(false);          
        }else
        {
            rbSepilipsia.setSelected(false);
            rbNelipsia.setSelected(true);
        }
        if(ana.getDiabetes().equals("Não")) 
        {
            rbSdiabetes.setSelected(true);
            rbNdiabetes.setSelected(false);
        }else{
            rbSdiabetes.setSelected(false);
            rbNdiabetes.setSelected(true);
        }
    }
    
    public anamnese(Paciente paciente) {
        initComponents();
        anaDao = new AnamneseJpaController(Persistence.createEntityManagerFactory("NutriMaisPU"));
        this.paciente = paciente;
        lblId.setText(String.valueOf(this.paciente.getIdPaciente()));
        lblNome.setText(this.paciente.getNome());
        Anamnese ana = anaDao.findAnamnese(this.paciente.getIdPaciente());
        try{
            preencherCampos(ana);    
        }catch(Exception e)
        {
            //JOptionPane.showMessageDialog(this, e.toString());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblId = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        rbStempoSentado = new javax.swing.JRadioButton();
        rbNtempoSentado = new javax.swing.JRadioButton();
        rbNatividadeFisica = new javax.swing.JRadioButton();
        rbSatividadeFisica = new javax.swing.JRadioButton();
        rbSfumante = new javax.swing.JRadioButton();
        rbNfumante = new javax.swing.JRadioButton();
        rbNalimentacaoBalanceada = new javax.swing.JRadioButton();
        rbSalimentacaoBalanceada = new javax.swing.JRadioButton();
        rbNfuncIntestinalReg = new javax.swing.JRadioButton();
        rbSfuncIntestinalReg = new javax.swing.JRadioButton();
        rbNingereLiquidos = new javax.swing.JRadioButton();
        rbSingereliquidos = new javax.swing.JRadioButton();
        rbNgestante = new javax.swing.JRadioButton();
        rbSgestante = new javax.swing.JRadioButton();
        rbNfilhos = new javax.swing.JRadioButton();
        rbSfilhos = new javax.swing.JRadioButton();
        txtFilhos = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtFumante = new javax.swing.JTextField();
        txtAlimentcaoBalanceada = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtAtividadeFisica = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtTempoSentado = new javax.swing.JTextField();
        txtFuncionamentoIntestinal = new javax.swing.JTextField();
        txtIngereLiquidos = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        rbNanteCirurgico = new javax.swing.JRadioButton();
        rbSanteCirurgico = new javax.swing.JRadioButton();
        jLabel21 = new javax.swing.JLabel();
        txtAntecedentesCirurgicos = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtTramentamentoEstetico = new javax.swing.JTextField();
        rbNtratamentoEstetico = new javax.swing.JRadioButton();
        rbStratamentoEstetico = new javax.swing.JRadioButton();
        jLabel23 = new javax.swing.JLabel();
        txtAntecendenteAlergicos = new javax.swing.JTextField();
        rbNanteAlergico = new javax.swing.JRadioButton();
        rbSanteAlergico = new javax.swing.JRadioButton();
        jLabel24 = new javax.swing.JLabel();
        txtAntecendentesOncologicos = new javax.swing.JTextField();
        rbNantiOncologico = new javax.swing.JRadioButton();
        rbSanteOncologico = new javax.swing.JRadioButton();
        txtAcidosPele = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        rbNacidoPele = new javax.swing.JRadioButton();
        rbSacidoPele = new javax.swing.JRadioButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        rbSproblemaOrtopedico = new javax.swing.JRadioButton();
        rbNproblemaOrtopedico = new javax.swing.JRadioButton();
        jLabel31 = new javax.swing.JLabel();
        txtProblemaOrtopedico = new javax.swing.JTextField();
        rbStratamentoMedico = new javax.swing.JRadioButton();
        rbNtratamentoMedico = new javax.swing.JRadioButton();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtTratamentoMedico = new javax.swing.JTextField();
        rbStratamentoOrtomolecular = new javax.swing.JRadioButton();
        rbNtratamentoOrtomolecular = new javax.swing.JRadioButton();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtTratamentoOrtomolecular = new javax.swing.JTextField();
        rbSmarcapasso = new javax.swing.JRadioButton();
        rbNmarcapasso = new javax.swing.JRadioButton();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        txtMarcapasso = new javax.swing.JTextField();
        rbSanticoncepcional = new javax.swing.JRadioButton();
        rbNanticoncepcional = new javax.swing.JRadioButton();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        txtAnticocepicional = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        rbSpresencaoMetais = new javax.swing.JRadioButton();
        rbNpresencaMetais = new javax.swing.JRadioButton();
        jLabel41 = new javax.swing.JLabel();
        txtPresencaMetais = new javax.swing.JTextField();
        txtCicloMesntrual = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        rbScicloMenstrual = new javax.swing.JRadioButton();
        rbNciclomenstrual = new javax.swing.JRadioButton();
        jLabel43 = new javax.swing.JLabel();
        rbSvarizes = new javax.swing.JRadioButton();
        jLabel44 = new javax.swing.JLabel();
        txtVarizes = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        rbNvarizes = new javax.swing.JRadioButton();
        rbNlesoes = new javax.swing.JRadioButton();
        jLabel46 = new javax.swing.JLabel();
        txtLesoes = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        rbSlesoes = new javax.swing.JRadioButton();
        jLabel48 = new javax.swing.JLabel();
        rbNhipertensao = new javax.swing.JRadioButton();
        rbShipertensao = new javax.swing.JRadioButton();
        rbShipotesao = new javax.swing.JRadioButton();
        jLabel49 = new javax.swing.JLabel();
        rbNhipotensao = new javax.swing.JRadioButton();
        rbNelipsia = new javax.swing.JRadioButton();
        jLabel50 = new javax.swing.JLabel();
        rbSepilipsia = new javax.swing.JRadioButton();
        rbNdiabetes = new javax.swing.JRadioButton();
        rbSdiabetes = new javax.swing.JRadioButton();
        jLabel51 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(184, 225, 206));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("ID");

        lblId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblId.setText("????");

        jLabel6.setText("Campus Capivari.");

        jLabel5.setText("Instituto Federal de São Paulo");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Anamnese:");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jLabel8.setText("Costuma permanecer muito tempo sentado(a)?");

        jLabel9.setText("Pratica atividades fisicas?");

        jLabel10.setText("É fumante?");

        jLabel11.setText("Alimentação Balanceada?");

        jLabel12.setText("Funcionamento intestinal regular?");

        jLabel13.setText("Ingere liquidos com frequência?");

        jLabel14.setText("É gestante?");

        jLabel15.setText("Filhos?");

        jLabel16.setText("Quantos?");

        rbStempoSentado.setText("Sim");

        rbNtempoSentado.setText("Não");

        rbNatividadeFisica.setText("Não");

        rbSatividadeFisica.setText("Sim");

        rbSfumante.setText("Sim");

        rbNfumante.setText("Não");

        rbNalimentacaoBalanceada.setText("Não");

        rbSalimentacaoBalanceada.setText("Sim");

        rbNfuncIntestinalReg.setText("Não");

        rbSfuncIntestinalReg.setText("Sim");

        rbNingereLiquidos.setText("Não");

        rbSingereliquidos.setText("Sim");

        rbNgestante.setText("Não");

        rbSgestante.setText("Sim");

        rbNfilhos.setText("Não");

        rbSfilhos.setText("Sim");

        jLabel17.setText("Obs:");

        jLabel18.setText("Obs:");

        jLabel19.setText("Qual:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbSatividadeFisica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbNatividadeFisica))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbStempoSentado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbNtempoSentado))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbSfuncIntestinalReg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbNfuncIntestinalReg))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbSingereliquidos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbNingereLiquidos)
                        .addGap(65, 65, 65)
                        .addComponent(txtIngereLiquidos))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbSgestante)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbNgestante)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbSfumante)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbNfumante))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbSalimentacaoBalanceada)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbNalimentacaoBalanceada)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTempoSentado)
                                    .addComponent(txtAtividadeFisica)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(txtFuncionamentoIntestinal))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAlimentcaoBalanceada))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbSfilhos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbNfilhos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFilhos, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 35, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFumante)))))
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(rbStempoSentado)
                    .addComponent(rbNtempoSentado)
                    .addComponent(txtTempoSentado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(rbSatividadeFisica)
                    .addComponent(rbNatividadeFisica)
                    .addComponent(jLabel19)
                    .addComponent(txtAtividadeFisica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(rbSfumante)
                    .addComponent(rbNfumante)
                    .addComponent(jLabel17)
                    .addComponent(txtFumante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(rbSalimentacaoBalanceada)
                    .addComponent(rbNalimentacaoBalanceada)
                    .addComponent(jLabel18)
                    .addComponent(txtAlimentcaoBalanceada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(rbSfuncIntestinalReg)
                    .addComponent(rbNfuncIntestinalReg)
                    .addComponent(txtFuncionamentoIntestinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(rbSingereliquidos)
                    .addComponent(rbNingereLiquidos)
                    .addComponent(txtIngereLiquidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(rbSgestante)
                    .addComponent(rbNgestante)
                    .addComponent(rbSfilhos)
                    .addComponent(rbNfilhos)
                    .addComponent(jLabel16)
                    .addComponent(txtFilhos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jTabbedPane6.addTab("Hábitos de Vida", jPanel1);

        jLabel20.setText("Antecedentes Cirurgicos?");

        rbNanteCirurgico.setText("Não");

        rbSanteCirurgico.setText("Sim");

        jLabel21.setText("Qual:");

        jLabel22.setText("Qual:");

        rbNtratamentoEstetico.setText("Não");

        rbStratamentoEstetico.setText("Sim");

        jLabel23.setText("Qual:");

        rbNanteAlergico.setText("Não");

        rbSanteAlergico.setText("Sim");

        jLabel24.setText("Qual:");

        rbNantiOncologico.setText("Não");

        rbSanteOncologico.setText("Sim");

        jLabel25.setText("Qual:");

        rbNacidoPele.setText("Não");

        rbSacidoPele.setText("Sim");

        jLabel26.setText("Trat. estético anterior?");

        jLabel27.setText("Antecedentes alérgicos?");

        jLabel28.setText("Antecedentes oncológicos?");

        jLabel29.setText("Usa/usou ácidos na pele?");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27)
                    .addComponent(jLabel29)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rbSacidoPele)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbNacidoPele)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rbStratamentoEstetico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbNtratamentoEstetico)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(rbSanteAlergico)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbNanteAlergico))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(rbSanteCirurgico)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbNanteCirurgico))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(rbSanteOncologico)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbNantiOncologico)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel25)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtAcidosPele))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel23)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtAntecendenteAlergicos))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTramentamentoEstetico))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtAntecedentesCirurgicos, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel24)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtAntecendentesOncologicos)))))
                        .addGap(171, 171, 171))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(rbSanteCirurgico)
                    .addComponent(rbNanteCirurgico)
                    .addComponent(jLabel21)
                    .addComponent(txtAntecedentesCirurgicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbStratamentoEstetico)
                    .addComponent(rbNtratamentoEstetico)
                    .addComponent(jLabel22)
                    .addComponent(txtTramentamentoEstetico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbSanteAlergico)
                    .addComponent(rbNanteAlergico)
                    .addComponent(jLabel23)
                    .addComponent(txtAntecendenteAlergicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbSanteOncologico)
                    .addComponent(rbNantiOncologico)
                    .addComponent(jLabel24)
                    .addComponent(txtAntecendentesOncologicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbSacidoPele)
                    .addComponent(rbNacidoPele)
                    .addComponent(jLabel25)
                    .addComponent(txtAcidosPele, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addContainerGap(114, Short.MAX_VALUE))
        );

        jTabbedPane6.addTab("Antecedentes", jPanel2);

        jLabel30.setText("Tem algum problema ortopédico?");

        rbSproblemaOrtopedico.setText("Sim");

        rbNproblemaOrtopedico.setText("Não");

        jLabel31.setText("Qual:");

        rbStratamentoMedico.setText("Sim");

        rbNtratamentoMedico.setText("Não");

        jLabel32.setText("Faz algum tratamento médico?");

        jLabel33.setText("Qual:");

        rbStratamentoOrtomolecular.setText("Sim");

        rbNtratamentoOrtomolecular.setText("Não");

        jLabel34.setText("já fez algum tratamento ortomolecular?");

        jLabel35.setText("Qual:");

        rbSmarcapasso.setText("Sim");

        rbNmarcapasso.setText("Não");

        jLabel36.setText("Portador de marcapasso?");

        jLabel37.setText("Qual:");

        rbSanticoncepcional.setText("Sim");

        rbNanticoncepcional.setText("Não");

        jLabel38.setText("Usa método anticoncepcional?");

        jLabel39.setText("Qual:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbSanticoncepcional)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbNanticoncepcional)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAnticocepicional, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbSmarcapasso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbNmarcapasso)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMarcapasso, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbStratamentoOrtomolecular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbNtratamentoOrtomolecular)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTratamentoOrtomolecular, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbStratamentoMedico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbNtratamentoMedico)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTratamentoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbSproblemaOrtopedico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbNproblemaOrtopedico)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProblemaOrtopedico, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(rbSproblemaOrtopedico)
                    .addComponent(rbNproblemaOrtopedico)
                    .addComponent(jLabel31)
                    .addComponent(txtProblemaOrtopedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(rbStratamentoMedico)
                    .addComponent(rbNtratamentoMedico)
                    .addComponent(jLabel33)
                    .addComponent(txtTratamentoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(rbStratamentoOrtomolecular)
                    .addComponent(rbNtratamentoOrtomolecular)
                    .addComponent(jLabel35)
                    .addComponent(txtTratamentoOrtomolecular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(rbSmarcapasso)
                    .addComponent(rbNmarcapasso)
                    .addComponent(jLabel37)
                    .addComponent(txtMarcapasso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(rbSanticoncepcional)
                    .addComponent(rbNanticoncepcional)
                    .addComponent(jLabel39)
                    .addComponent(txtAnticocepicional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        jTabbedPane6.addTab("Patologia", jPanel3);

        jLabel40.setText("Presença de metais?");

        rbSpresencaoMetais.setText("Sim");

        rbNpresencaMetais.setText("Não");

        jLabel41.setText("Local?");

        txtPresencaMetais.setToolTipText("");

        txtCicloMesntrual.setToolTipText("");

        jLabel42.setText("Obs:");

        rbScicloMenstrual.setText("Sim");

        rbNciclomenstrual.setText("Não");

        jLabel43.setText("Ciclo menstrual regular?");

        rbSvarizes.setText("Sim");

        jLabel44.setText("Grau:");

        txtVarizes.setToolTipText("");

        jLabel45.setText("Varizes?");

        rbNvarizes.setText("Não");

        rbNlesoes.setText("Não");

        jLabel46.setText("Lesões?");

        txtLesoes.setToolTipText("");

        jLabel47.setText("Quais:");

        rbSlesoes.setText("Sim");

        jLabel48.setText("Hipertensão?");

        rbNhipertensao.setText("Não");

        rbShipertensao.setText("Sim");

        rbShipotesao.setText("Sim");

        jLabel49.setText("Hipotensão?");

        rbNhipotensao.setText("Não");

        rbNelipsia.setText("Não");

        jLabel50.setText("Epilepsia?");

        rbSepilipsia.setText("Sim");

        rbNdiabetes.setText("Não");

        rbSdiabetes.setText("Sim");

        jLabel51.setText("Diabetes?");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbSvarizes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbNvarizes)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVarizes, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbScicloMenstrual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbNciclomenstrual)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCicloMesntrual, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbSpresencaoMetais)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbNpresencaMetais)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPresencaMetais, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel46)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbSlesoes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbNlesoes)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel47)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel48)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rbShipertensao)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rbNhipertensao))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel49)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rbShipotesao)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rbNhipotensao))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel51)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(rbSdiabetes)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(rbNdiabetes))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel50)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(rbSepilipsia)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(rbNelipsia)))
                                        .addGap(1, 1, 1)))
                                .addGap(53, 53, 53)))
                        .addComponent(txtLesoes, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(183, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(rbSpresencaoMetais)
                    .addComponent(rbNpresencaMetais)
                    .addComponent(jLabel41)
                    .addComponent(txtPresencaMetais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(rbScicloMenstrual)
                    .addComponent(rbNciclomenstrual)
                    .addComponent(jLabel42)
                    .addComponent(txtCicloMesntrual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(rbSvarizes)
                    .addComponent(rbNvarizes)
                    .addComponent(jLabel44)
                    .addComponent(txtVarizes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(rbSlesoes)
                    .addComponent(rbNlesoes)
                    .addComponent(jLabel47)
                    .addComponent(txtLesoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(rbShipertensao)
                    .addComponent(rbNhipertensao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(rbShipotesao)
                    .addComponent(rbNhipotensao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(rbSepilipsia)
                    .addComponent(rbNelipsia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(rbSdiabetes)
                    .addComponent(rbNdiabetes))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jTabbedPane6.addTab("Patologia", jPanel4);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Nome");

        lblNome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNome.setText("????");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addComponent(lblId)
                .addGap(371, 371, 371)
                .addComponent(jLabel4)
                .addGap(6, 6, 6)
                .addComponent(lblNome))
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel7))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(307, 307, 307)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar))
            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(313, 313, 313)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel6))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lblId)
                    .addComponent(jLabel4)
                    .addComponent(lblNome))
                .addGap(19, 19, 19)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(1, 1, 1)
                .addComponent(jTabbedPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(6, 6, 6)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        Anamnese ana = new Anamnese();
        
            ana.setIdAna(this.paciente.getIdPaciente());
            ana.setMotivo("0");
            if(rbStempoSentado.isSelected())
            {   ana.setTempoSentada(txtTempoSentado.getText());}
            if(rbNtempoSentado.isSelected())
            {   ana.setTempoSentada("Não");}
            if(rbSanteCirurgico.isSelected())
            {   ana.setAntecendentesCirurgicos(txtAntecedentesCirurgicos.getText());}
            if(rbNanteCirurgico.isSelected())
            {   ana.setAntecendentesCirurgicos("Não");}
            if(rbStratamentoEstetico.isSelected())
            {   ana.setTratamentoEstetico(txtTramentamentoEstetico.getText());}
            if(rbNtratamentoEstetico.isSelected())
            {   ana.setTratamentoEstetico("Não");}
            if(rbSanteAlergico.isSelected())
            {   ana.setAntecedentesAlergicos(txtAntecendenteAlergicos.getText());}
            if(rbNanteAlergico.isSelected())
            {   ana.setAntecedentesAlergicos("Não");}
            if(rbSfuncIntestinalReg.isSelected())
            {   ana.setFuncionamentoIntestinalReg(txtFuncionamentoIntestinal.getText());}
            if(rbNfuncIntestinalReg.isSelected())
            {   ana.setFuncionamentoIntestinalReg("Não");}
            if(rbSatividadeFisica.isSelected())
            {   ana.setAtividadeFisica(txtAtividadeFisica.getText());}
            if(rbNatividadeFisica.isSelected())
            {   ana.setAtividadeFisica("Não");}
            if(rbSfumante.isSelected())
            {   ana.setFumante(txtFumante.getText());}
            if(rbNfumante.isSelected())
            {   ana.setFumante("Não"); }
            if(rbSalimentacaoBalanceada.isSelected())
            {   ana.setAlimentacaoBalanceada(txtAlimentcaoBalanceada.getText());}
            if(rbNalimentacaoBalanceada.isSelected())
            {   ana.setAlimentacaoBalanceada("Não");}
            // liquidos
            ana.setIngestaoLiquidos(txtIngereLiquidos.getText());
            if(rbSgestante.isSelected())
            {   ana.setGestante(true);}
            if(rbNgestante.isSelected())
            {    ana.setGestante(false);}
            if(rbSfilhos.isSelected())
            {   ana.setFilhos(Integer.valueOf(txtFilhos.getText()));}
            if(rbNfilhos.isSelected())
            {   ana.setFilhos(0); }
            if(rbSproblemaOrtopedico.isSelected())
            {   ana.setProblemaOrtopedico(txtProblemaOrtopedico.getText());}
            if(rbNproblemaOrtopedico.isSelected())
            {   ana.setProblemaOrtopedico("Não");}
            if(rbStratamentoMedico.isSelected())
            {   ana.setTratamentoMedico(txtTratamentoMedico.getText()) ;}
            if(rbNtratamentoMedico.isSelected())
            {   ana.setTratamentoMedico("Não") ;}
            if(rbSacidoPele.isSelected())
            {   ana.setAcidosPele(txtAcidosPele.getText());}
            if(rbNacidoPele.isSelected())
            {   ana.setAcidosPele("Não");}
            if(rbStratamentoOrtomolecular.isSelected())
            {   ana.setTratamentoOrtomolecular(txtTratamentoOrtomolecular.getText());}
            if(rbNtratamentoOrtomolecular.isSelected())
            {   ana.setTratamentoOrtomolecular("Não");}
            if(rbSmarcapasso.isSelected())
            {   ana.setMarcoPasso(txtMarcapasso.getText());}
            if(rbNmarcapasso.isSelected())
            {   ana.setMarcoPasso("Não");}
            if(rbSpresencaoMetais.isSelected())
            {   ana.setMetaisCorpo(txtPresencaMetais.getText());}
            if(rbNpresencaMetais.isSelected())
            {   ana.setMetaisCorpo("Não");}
            if(rbSanteOncologico.isSelected())
            {   ana.setAntecedentesOncologicos(txtAntecendentesOncologicos.getText());}
            if(rbNantiOncologico.isSelected())
            {   ana.setAntecedentesOncologicos("Não");}
            if(rbScicloMenstrual.isSelected())
            {   ana.setCicloMenstrual(txtCicloMesntrual.getText());}
            if(rbNciclomenstrual.isSelected())
            {   ana.setCicloMenstrual("Não");}
            if(rbSanticoncepcional.isSelected())
            {   ana.setMetodoAnticoncepcional(txtAnticocepicional.getText());}
            if(rbNanticoncepcional.isSelected())
            {   ana.setMetodoAnticoncepcional("Não");}
            if(rbSvarizes.isSelected())
            {   ana.setVarizes(txtVarizes.getText());}
            if(rbNvarizes.isSelected())
            {   ana.setVarizes("Não");}
            if(rbSlesoes.isSelected())
            {   ana.setLesoes(txtLesoes.getText());}
            if(rbNlesoes.isSelected())
            {   ana.setLesoes("Não");}
            if(rbShipertensao.isSelected())
            {   ana.setHipertensao(true);}
            if(rbNhipertensao.isSelected())
            {   ana.setHipertensao(false);}
            if(rbShipotesao.isSelected())
            {   ana.setHipotensao(true);}
            if(rbNhipotensao.isSelected())
            {   ana.setHipotensao(false);}
            if(rbSepilipsia.isSelected())
            {   ana.setEpilepsia(true);}
            if(rbNelipsia.isSelected())
            {   ana.setEpilepsia(false);}
            if(rbSdiabetes.isSelected())
            {   ana.setDiabetes(true);}
            if(rbNdiabetes.isSelected())
            {   ana.setDiabetes(false);}
            //observacao
            ana.setObservacoes("0");
            // paciente
            ana.setPaciente(this.paciente);
            
        if (estado == 1)
        {          
            try
            {
                anaDao.create(ana);
                JOptionPane.showMessageDialog(this, "anamneses Inserida com sucesso!");
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
        if (estado == 2)
        {
             try
            {
                anaDao.edit(ana);
                JOptionPane.showMessageDialog(this, "anamneses Atualizada com sucesso!");
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }


    }//GEN-LAST:event_btnSalvarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(anamnese.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(anamnese.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(anamnese.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(anamnese.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                Paciente p = new Paciente();
                new anamnese(p).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNome;
    private javax.swing.JRadioButton rbNacidoPele;
    private javax.swing.JRadioButton rbNalimentacaoBalanceada;
    private javax.swing.JRadioButton rbNanteAlergico;
    private javax.swing.JRadioButton rbNanteCirurgico;
    private javax.swing.JRadioButton rbNantiOncologico;
    private javax.swing.JRadioButton rbNanticoncepcional;
    private javax.swing.JRadioButton rbNatividadeFisica;
    private javax.swing.JRadioButton rbNciclomenstrual;
    private javax.swing.JRadioButton rbNdiabetes;
    private javax.swing.JRadioButton rbNelipsia;
    private javax.swing.JRadioButton rbNfilhos;
    private javax.swing.JRadioButton rbNfumante;
    private javax.swing.JRadioButton rbNfuncIntestinalReg;
    private javax.swing.JRadioButton rbNgestante;
    private javax.swing.JRadioButton rbNhipertensao;
    private javax.swing.JRadioButton rbNhipotensao;
    private javax.swing.JRadioButton rbNingereLiquidos;
    private javax.swing.JRadioButton rbNlesoes;
    private javax.swing.JRadioButton rbNmarcapasso;
    private javax.swing.JRadioButton rbNpresencaMetais;
    private javax.swing.JRadioButton rbNproblemaOrtopedico;
    private javax.swing.JRadioButton rbNtempoSentado;
    private javax.swing.JRadioButton rbNtratamentoEstetico;
    private javax.swing.JRadioButton rbNtratamentoMedico;
    private javax.swing.JRadioButton rbNtratamentoOrtomolecular;
    private javax.swing.JRadioButton rbNvarizes;
    private javax.swing.JRadioButton rbSacidoPele;
    private javax.swing.JRadioButton rbSalimentacaoBalanceada;
    private javax.swing.JRadioButton rbSanteAlergico;
    private javax.swing.JRadioButton rbSanteCirurgico;
    private javax.swing.JRadioButton rbSanteOncologico;
    private javax.swing.JRadioButton rbSanticoncepcional;
    private javax.swing.JRadioButton rbSatividadeFisica;
    private javax.swing.JRadioButton rbScicloMenstrual;
    private javax.swing.JRadioButton rbSdiabetes;
    private javax.swing.JRadioButton rbSepilipsia;
    private javax.swing.JRadioButton rbSfilhos;
    private javax.swing.JRadioButton rbSfumante;
    private javax.swing.JRadioButton rbSfuncIntestinalReg;
    private javax.swing.JRadioButton rbSgestante;
    private javax.swing.JRadioButton rbShipertensao;
    private javax.swing.JRadioButton rbShipotesao;
    private javax.swing.JRadioButton rbSingereliquidos;
    private javax.swing.JRadioButton rbSlesoes;
    private javax.swing.JRadioButton rbSmarcapasso;
    private javax.swing.JRadioButton rbSpresencaoMetais;
    private javax.swing.JRadioButton rbSproblemaOrtopedico;
    private javax.swing.JRadioButton rbStempoSentado;
    private javax.swing.JRadioButton rbStratamentoEstetico;
    private javax.swing.JRadioButton rbStratamentoMedico;
    private javax.swing.JRadioButton rbStratamentoOrtomolecular;
    private javax.swing.JRadioButton rbSvarizes;
    private javax.swing.JTextField txtAcidosPele;
    private javax.swing.JTextField txtAlimentcaoBalanceada;
    private javax.swing.JTextField txtAntecedentesCirurgicos;
    private javax.swing.JTextField txtAntecendenteAlergicos;
    private javax.swing.JTextField txtAntecendentesOncologicos;
    private javax.swing.JTextField txtAnticocepicional;
    private javax.swing.JTextField txtAtividadeFisica;
    private javax.swing.JTextField txtCicloMesntrual;
    private javax.swing.JTextField txtFilhos;
    private javax.swing.JTextField txtFumante;
    private javax.swing.JTextField txtFuncionamentoIntestinal;
    private javax.swing.JTextField txtIngereLiquidos;
    private javax.swing.JTextField txtLesoes;
    private javax.swing.JTextField txtMarcapasso;
    private javax.swing.JTextField txtPresencaMetais;
    private javax.swing.JTextField txtProblemaOrtopedico;
    private javax.swing.JTextField txtTempoSentado;
    private javax.swing.JTextField txtTramentamentoEstetico;
    private javax.swing.JTextField txtTratamentoMedico;
    private javax.swing.JTextField txtTratamentoOrtomolecular;
    private javax.swing.JTextField txtVarizes;
    // End of variables declaration//GEN-END:variables
}
