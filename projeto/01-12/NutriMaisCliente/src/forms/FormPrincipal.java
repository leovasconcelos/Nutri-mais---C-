/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import beans.PassaDados;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author IFSP
 */
public class FormPrincipal extends javax.swing.JFrame {

    private PassaDados pd = new PassaDados();
    private PassaDados pd2[] = new PassaDados[7];
    private void diaDaSemana()
    {
        Date d = new Date();
		Calendar c = new GregorianCalendar();
		c.setTime(d);
		
		int dia = c.get(c.DAY_OF_WEEK);
		switch(dia){
		  case Calendar.SUNDAY: radDomingo.setSelected(true);break;
		  case Calendar.MONDAY: radSegunda.setSelected(true);break;
		  case Calendar.TUESDAY: radTerca.setSelected(true);break;
		  case Calendar.WEDNESDAY: radQuarta.setSelected(true);break;
		  case Calendar.THURSDAY: radQuinta.setSelected(true);break;
		  case Calendar.FRIDAY: radSexta.setSelected(true);break;
		  case Calendar.SATURDAY: radSabado.setFocusable(true);break;
		}
		
    }
    
    private void preencherRefeicoes(String dia, String refeicao)
    {
        File file = new File("C:\\Users\\guilh\\Dropbox\\Nutrição\\19-11\\NutriMaisCliente\\test\\SabCM.txt");
        FileInputStream fis = null;
        String texto = "";

        try {
            fis = new FileInputStream(file);
            int content;
            while ((content = fis.read()) != -1) {
                texto += (char) content;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        txtDescricao.setText(texto);
        //textArea.setLineWrap(true); //quebra de linha automática
        //add(textArea);
    }
    
    private void preencherDietaSegunda()
    {
        if( lstRefeicoes.getSelectedValue().equals("Café da Manhã"))
        {
            txtDescricao.setText(this.pd2[0].getDado2());
        }
        if( lstRefeicoes.getSelectedValue().equals("Lanche da Manhã"))
        {
            txtDescricao.setText(this.pd2[0].getDado3());
        }
        if( lstRefeicoes.getSelectedValue().equals("Almoço"))
        {
            txtDescricao.setText(this.pd2[0].getDado4());
        }
        if( lstRefeicoes.getSelectedValue().equals("Lanche da Tarde"))
        {
            txtDescricao.setText(this.pd2[0].getDado5());
        }
        if( lstRefeicoes.getSelectedValue().equals("Jantar"))
        {
            txtDescricao.setText(this.pd2[0].getDado6());
        }
        if( lstRefeicoes.getSelectedValue().equals("Ceia"))
        {
            txtDescricao.setText(this.pd2[0].getDado7());
        }
    }
    private void preencherDietaTerça()
    {
        if( lstRefeicoes.getSelectedValue().equals("Café da Manhã"))
        {
            txtDescricao.setText(this.pd2[1].getDado1());
        }
        if( lstRefeicoes.getSelectedValue().equals("Lanche da Manhã"))
        {
            txtDescricao.setText(this.pd2[1].getDado2());
        }
        if( lstRefeicoes.getSelectedValue().equals("Almoço"))
        {
            txtDescricao.setText(this.pd2[1].getDado3());
        }
        if( lstRefeicoes.getSelectedValue().equals("Lanche da Tarde"))
        {
            txtDescricao.setText(this.pd2[1].getDado4());
        }
        if( lstRefeicoes.getSelectedValue().equals("Jantar"))
        {
            txtDescricao.setText(this.pd2[1].getDado5());
        }
        if( lstRefeicoes.getSelectedValue().equals("Ceia"))
        {
            txtDescricao.setText(this.pd2[1].getDado6());
        }
    }
    private void preencherDietaQuarta()
    {

    }
    private void preencherDietaQuinta()
    {

    }
    private void preencherDietaSexta()
    {
        
    }
    private void preencherDietaSabado()
    {

    }
    private void preencherDietaDomingo()
    {
       
    }
    
    /**
     * Creates new form FormPrincipal
     * @param pd
     */
    public FormPrincipal(PassaDados pd, PassaDados[] pd2) {
        initComponents();
        this.pd = pd;
        this.pd2 = pd2;
        diaDaSemana();
        //preencherRefeicoes();
        lstRefeicoes.setSelectedIndex(0);  
        lblNome.setText(String.valueOf(pd.getDado1()));
        lblObjetivo.setText(pd.getDado2());
        lblClassificaoPeso.setText(pd.getDado3());
        lblPorcentagem.setText(pd.getDado4());
        lblPesoGordura.setText(pd.getDado5());
        lblPesoMassaMagra.setText(pd.getDado6());
        lblPesoAtual.setText(pd.getDado7());;
        lblPesoIdeal.setText(pd.getDado8());    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton7 = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        radSexta = new javax.swing.JRadioButton();
        radSabado = new javax.swing.JRadioButton();
        radQuarta = new javax.swing.JRadioButton();
        radQuinta = new javax.swing.JRadioButton();
        radDomingo = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextPane();
        btnVisualiza = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstRefeicoes = new javax.swing.JList<>();
        jLabel8 = new javax.swing.JLabel();
        lblPesoGordura = new javax.swing.JLabel();
        lblClassificaoPeso4 = new javax.swing.JLabel();
        lblPesoMassaMagra = new javax.swing.JLabel();
        lblClassificaoPeso6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        radTerca = new javax.swing.JRadioButton();
        radSegunda = new javax.swing.JRadioButton();
        lblPorcentagem = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblObjetivo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblClassificaoPeso2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblPesoIdeal = new javax.swing.JLabel();
        lblPesoAtual = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblClassificaoPeso = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();

        jRadioButton7.setText("Segunda");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(184, 225, 206));

        radSexta.setText("Sexta");
        radSexta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                radSextaFocusGained(evt);
            }
        });

        radSabado.setText("Sábado");
        radSabado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                radSabadoFocusGained(evt);
            }
        });

        radQuarta.setText("Quarta");
        radQuarta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                radQuartaFocusGained(evt);
            }
        });

        radQuinta.setText("Quinta");
        radQuinta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                radQuintaFocusGained(evt);
            }
        });

        radDomingo.setText("Domingo");
        radDomingo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                radDomingoFocusGained(evt);
            }
        });

        jScrollPane1.setEnabled(false);

        txtDescricao.setToolTipText("Refeição a se Seguir");
        jScrollPane1.setViewportView(txtDescricao);

        btnVisualiza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forms/1480536330_seo-social-web-network-internet_232.png"))); // NOI18N
        btnVisualiza.setText("Visualizar");
        btnVisualiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizaActionPerformed(evt);
            }
        });

        lstRefeicoes.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Café da Manhã", "Lanche da Manhã", "Almoço", "Lanche da Tarde", "Jantar", "Ceia" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lstRefeicoes);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Refeições");

        lblPesoGordura.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPesoGordura.setText("????");

        lblClassificaoPeso4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblClassificaoPeso4.setText("Peso da Gordura(kg):");

        lblPesoMassaMagra.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPesoMassaMagra.setText("????");

        lblClassificaoPeso6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblClassificaoPeso6.setText("Peso da Massa Magra:(kg):");

        radTerca.setText("Terça");
        radTerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radTercaActionPerformed(evt);
            }
        });
        radTerca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                radTercaFocusGained(evt);
            }
        });

        radSegunda.setText("Segunda");
        radSegunda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radSegundaActionPerformed(evt);
            }
        });
        radSegunda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                radSegundaFocusGained(evt);
            }
        });

        lblPorcentagem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPorcentagem.setText("????");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Classificação do seu Peso:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Objetivo:");

        lblObjetivo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblObjetivo.setText("????");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Nome:");

        lblNome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNome.setText("????");

        lblClassificaoPeso2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblClassificaoPeso2.setText("Porcentagem de Gordura:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Peso Ideal:");

        lblPesoIdeal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPesoIdeal.setText("????");

        lblPesoAtual.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPesoAtual.setText("????");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Peso Atual:");

        lblClassificaoPeso.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblClassificaoPeso.setText("????");

        jLabel9.setText("Instituto Federal de São Paulo");

        jLabel10.setText("Campus Capivari.");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forms/nutrimaisReduzido.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radDomingo)
                            .addComponent(radSabado)
                            .addComponent(radSexta)
                            .addComponent(radSegunda)
                            .addComponent(radTerca)
                            .addComponent(radQuarta)
                            .addComponent(radQuinta))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVisualiza))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(jLabel8)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 41, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblClassificaoPeso6)
                                .addGap(13, 13, 13)
                                .addComponent(lblPesoMassaMagra))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblClassificaoPeso4)
                                .addGap(13, 13, 13)
                                .addComponent(lblPesoGordura))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblClassificaoPeso2)
                                .addGap(13, 13, 13)
                                .addComponent(lblPorcentagem)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblPesoIdeal))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblClassificaoPeso))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblPesoAtual)))
                        .addGap(22, 22, 22))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(141, 141, 141)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNome)
                                .addGap(95, 95, 95)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblObjetivo))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(65, 65, 65)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(34, 34, 34))
                                    .addComponent(jLabel9))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblNome)
                    .addComponent(jLabel3)
                    .addComponent(lblObjetivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lblClassificaoPeso))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lblPesoAtual)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPorcentagem)
                            .addComponent(lblClassificaoPeso2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPesoGordura)
                            .addComponent(lblClassificaoPeso4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPesoMassaMagra)
                    .addComponent(lblClassificaoPeso6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(lblPesoIdeal)))
                .addGap(34, 34, 34)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnVisualiza, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(radSegunda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radTerca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radQuarta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radQuinta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radSexta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radSabado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radDomingo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(334, 334, 334)
                .addComponent(jLabel4))
            .addComponent(jLabel6)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(428, 428, 428)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(434, 434, 434)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void radSegundaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_radSegundaFocusGained
        // TODO add your handling code here:
        radTerca.setSelected(false);
        radQuarta.setSelected(false);
        radQuinta.setSelected(false);
        radSexta.setSelected(false);
        radSabado.setSelected(false);
        radDomingo.setSelected(false);
    }//GEN-LAST:event_radSegundaFocusGained

    private void radTercaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_radTercaFocusGained
        // TODO add your handling code here:
        radSegunda.setSelected(false);
        radQuarta.setSelected(false);
        radQuinta.setSelected(false);
        radSexta.setSelected(false);
        radSabado.setSelected(false);
        radDomingo.setSelected(false);
    }//GEN-LAST:event_radTercaFocusGained

    private void radQuartaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_radQuartaFocusGained
        // TODO add your handling code here:
        radSegunda.setSelected(false);
        radTerca.setSelected(false);
        radQuinta.setSelected(false);
        radSexta.setSelected(false);
        radSabado.setSelected(false);
        radDomingo.setSelected(false);
    }//GEN-LAST:event_radQuartaFocusGained

    private void radQuintaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_radQuintaFocusGained
        // TODO add your handling code here:
        radSegunda.setSelected(false);
        radTerca.setSelected(false);
        radQuarta.setSelected(false);
        radSexta.setSelected(false);
        radSabado.setSelected(false);
        radDomingo.setSelected(false);
    }//GEN-LAST:event_radQuintaFocusGained

    private void radSextaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_radSextaFocusGained
        // TODO add your handling code here:
        radSegunda.setSelected(false);
        radTerca.setSelected(false);
        radQuarta.setSelected(false);
        radQuinta.setSelected(false);
        radSabado.setSelected(false);
        radDomingo.setSelected(false);
    }//GEN-LAST:event_radSextaFocusGained

    private void radSabadoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_radSabadoFocusGained
        // TODO add your handling code here:
        radSegunda.setSelected(false);
        radTerca.setSelected(false);
        radQuarta.setSelected(false);
        radQuinta.setSelected(false);
        radSexta.setSelected(false);
        radDomingo.setSelected(false);
    }//GEN-LAST:event_radSabadoFocusGained

    private void radDomingoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_radDomingoFocusGained
        // TODO add your handling code here:
        radSegunda.setSelected(false);
        radTerca.setSelected(false);
        radQuarta.setSelected(false);
        radQuinta.setSelected(false);
        radSexta.setSelected(false);
        radSabado.setSelected(false);
    }//GEN-LAST:event_radDomingoFocusGained

    private void radSegundaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radSegundaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radSegundaActionPerformed

    private void btnVisualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizaActionPerformed
        // TODO add your handling code here:
        if(radSegunda.isSelected() && lstRefeicoes.getSelectedValue().equals("Café da Manhã") )
        {
            txtDescricao.setText(pd2[0].getDado1()); 
        }
        if(radSegunda.isSelected() && lstRefeicoes.getSelectedValue().equals("Lanche da Manhã") )
        {
            txtDescricao.setText(pd2[0].getDado2()); 
        }
        if(radSegunda.isSelected() && lstRefeicoes.getSelectedValue().equals("Almoço") )
        {
            txtDescricao.setText(pd2[0].getDado3()); 
        }
        if(radSegunda.isSelected() && lstRefeicoes.getSelectedValue().equals("Lanche da Tarde") )
        {
            txtDescricao.setText(pd2[0].getDado4()); 
        }
        if(radSegunda.isSelected() && lstRefeicoes.getSelectedValue().equals("Jantar") )
        {
            txtDescricao.setText(pd2[0].getDado5()); 
        }
        if(radSegunda.isSelected() && lstRefeicoes.getSelectedValue().equals("Ceia") )
        {
            txtDescricao.setText(pd2[0].getDado6()); 
        }
        
        if(radTerca.isSelected() && lstRefeicoes.getSelectedValue().equals("Café da Manhã") )
        {
            txtDescricao.setText(pd2[1].getDado1()); 
        }
        if(radTerca.isSelected() && lstRefeicoes.getSelectedValue().equals("Lanche da Manhã") )
        {
            txtDescricao.setText(pd2[1].getDado2()); 
        }
        if(radTerca.isSelected() && lstRefeicoes.getSelectedValue().equals("Almoço") )
        {
            txtDescricao.setText(pd2[1].getDado3()); 
        }
        if(radTerca.isSelected() && lstRefeicoes.getSelectedValue().equals("Lanche da Tarde") )
        {
            txtDescricao.setText(pd2[1].getDado4()); 
        }
        if(radTerca.isSelected() && lstRefeicoes.getSelectedValue().equals("Jantar") )
        {
            txtDescricao.setText(pd2[1].getDado5()); 
        }
        if(radTerca.isSelected() && lstRefeicoes.getSelectedValue().equals("Ceia") )
        {
            txtDescricao.setText(pd2[1].getDado6()); 
        }
        
        if(radQuarta.isSelected() && lstRefeicoes.getSelectedValue().equals("Café da Manhã") )
        {
            txtDescricao.setText(pd2[2].getDado1()); 
        }
        if(radQuarta.isSelected() && lstRefeicoes.getSelectedValue().equals("Lanche da Manhã") )
        {
            txtDescricao.setText(pd2[2].getDado2()); 
        }
        if(radQuarta.isSelected() && lstRefeicoes.getSelectedValue().equals("Almoço") )
        {
            txtDescricao.setText(pd2[2].getDado3()); 
        }
        if(radQuarta.isSelected() && lstRefeicoes.getSelectedValue().equals("Lanche da Tarde") )
        {
            txtDescricao.setText(pd2[2].getDado4()); 
        }
        if(radQuarta.isSelected() && lstRefeicoes.getSelectedValue().equals("Jantar") )
        {
            txtDescricao.setText(pd2[2].getDado5()); 
        }
        if(radQuarta.isSelected() && lstRefeicoes.getSelectedValue().equals("Ceia") )
        {
            txtDescricao.setText(pd2[2].getDado6()); 
        }
        
        if(radQuinta.isSelected() && lstRefeicoes.getSelectedValue().equals("Café da Manhã") )
        {
            txtDescricao.setText(pd2[3].getDado1()); 
        }
        if(radQuinta.isSelected() && lstRefeicoes.getSelectedValue().equals("Lanche da Manhã") )
        {
            txtDescricao.setText(pd2[3].getDado2()); 
        }
        if(radQuinta.isSelected() && lstRefeicoes.getSelectedValue().equals("Almoço") )
        {
            txtDescricao.setText(pd2[3].getDado3()); 
        }
        if(radQuinta.isSelected() && lstRefeicoes.getSelectedValue().equals("Lanche da Tarde") )
        {
            txtDescricao.setText(pd2[3].getDado4()); 
        }
        if(radQuinta.isSelected() && lstRefeicoes.getSelectedValue().equals("Jantar") )
        {
            txtDescricao.setText(pd2[3].getDado5()); 
        }
        if(radQuinta.isSelected() && lstRefeicoes.getSelectedValue().equals("Ceia") )
        {
            txtDescricao.setText(pd2[3].getDado6()); 
        }
        
        if(radSexta.isSelected() && lstRefeicoes.getSelectedValue().equals("Café da Manhã") )
        {
            txtDescricao.setText(pd2[4].getDado1()); 
        }
        if(radSexta.isSelected() && lstRefeicoes.getSelectedValue().equals("Lanche da Manhã") )
        {
            txtDescricao.setText(pd2[4].getDado2()); 
        }
        if(radSexta.isSelected() && lstRefeicoes.getSelectedValue().equals("Almoço") )
        {
            txtDescricao.setText(pd2[4].getDado3()); 
        }
        if(radSexta.isSelected() && lstRefeicoes.getSelectedValue().equals("Lanche da Tarde") )
        {
            txtDescricao.setText(pd2[4].getDado4()); 
        }
        if(radSexta.isSelected() && lstRefeicoes.getSelectedValue().equals("Jantar") )
        {
            txtDescricao.setText(pd2[4].getDado5()); 
        }
        if(radSexta.isSelected() && lstRefeicoes.getSelectedValue().equals("Ceia") )
        {
            txtDescricao.setText(pd2[4].getDado6()); 
        }
        
        if(radSabado.isSelected() && lstRefeicoes.getSelectedValue().equals("Café da Manhã") )
        {
            txtDescricao.setText(pd2[5].getDado1()); 
        }
        if(radSabado.isSelected() && lstRefeicoes.getSelectedValue().equals("Lanche da Manhã") )
        {
            txtDescricao.setText(pd2[5].getDado2()); 
        }
        if(radSabado.isSelected() && lstRefeicoes.getSelectedValue().equals("Almoço") )
        {
            txtDescricao.setText(pd2[5].getDado3()); 
        }
        if(radSabado.isSelected() && lstRefeicoes.getSelectedValue().equals("Lanche da Tarde") )
        {
            txtDescricao.setText(pd2[5].getDado4()); 
        }
        if(radSabado.isSelected() && lstRefeicoes.getSelectedValue().equals("Jantar") )
        {
            txtDescricao.setText(pd2[5].getDado5()); 
        }
        if(radSabado.isSelected() && lstRefeicoes.getSelectedValue().equals("Ceia") )
        {
            txtDescricao.setText(pd2[5].getDado6()); 
        }
        
        if(radDomingo.isSelected() && lstRefeicoes.getSelectedValue().equals("Café da Manhã") )
        {
            txtDescricao.setText(pd2[6].getDado1()); 
        }
        if(radDomingo.isSelected() && lstRefeicoes.getSelectedValue().equals("Lanche da Manhã") )
        {
            txtDescricao.setText(pd2[6].getDado2()); 
        }
        if(radDomingo.isSelected() && lstRefeicoes.getSelectedValue().equals("Almoço") )
        {
            txtDescricao.setText(pd2[6].getDado3()); 
        }
        if(radDomingo.isSelected() && lstRefeicoes.getSelectedValue().equals("Lanche da Tarde") )
        {
            txtDescricao.setText(pd2[6].getDado4()); 
        }
        if(radDomingo.isSelected() && lstRefeicoes.getSelectedValue().equals("Jantar") )
        {
            txtDescricao.setText(pd2[6].getDado5()); 
        }
        if(radDomingo.isSelected() && lstRefeicoes.getSelectedValue().equals("Ceia") )
        {
            txtDescricao.setText(pd2[6].getDado6()); 
        } 
    }//GEN-LAST:event_btnVisualizaActionPerformed

    private void radTercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radTercaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radTercaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PassaDados pd = new PassaDados();
                PassaDados[] pd2 = new PassaDados[7];
                new FormPrincipal(pd,pd2).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVisualiza;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblClassificaoPeso;
    private javax.swing.JLabel lblClassificaoPeso2;
    private javax.swing.JLabel lblClassificaoPeso4;
    private javax.swing.JLabel lblClassificaoPeso6;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblObjetivo;
    private javax.swing.JLabel lblPesoAtual;
    private javax.swing.JLabel lblPesoGordura;
    private javax.swing.JLabel lblPesoIdeal;
    private javax.swing.JLabel lblPesoMassaMagra;
    private javax.swing.JLabel lblPorcentagem;
    private javax.swing.JList<String> lstRefeicoes;
    private javax.swing.JRadioButton radDomingo;
    private javax.swing.JRadioButton radQuarta;
    private javax.swing.JRadioButton radQuinta;
    private javax.swing.JRadioButton radSabado;
    private javax.swing.JRadioButton radSegunda;
    private javax.swing.JRadioButton radSexta;
    private javax.swing.JRadioButton radTerca;
    private javax.swing.JTextPane txtDescricao;
    // End of variables declaration//GEN-END:variables
}
