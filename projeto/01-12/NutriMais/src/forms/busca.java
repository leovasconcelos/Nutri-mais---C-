/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import beans.Anamnese;
import beans.Paciente;
import beans.Usuario;
import controladores.AnamneseJpaController;
import controladores.PacienteJpaController;
import controladores.UsuarioJpaController;
import java.util.List;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lucas
 */
public class busca extends javax.swing.JFrame {
    
    private PacienteJpaController pacDAO;
    private AnamneseJpaController anaDao;
    private UsuarioJpaController usDao;
    
    private void preencherTabela(List<Paciente> lista)
    {
        if(lista.size()>0)
        {
            DefaultTableModel Tudo = (DefaultTableModel)tblTudo.getModel();
            Tudo.setNumRows(0);
            for(Paciente p : lista)
            {
                Object[] obj = new Object[]{
                  p.getIdPaciente(),
                  p.getNome()
                };
                Tudo.addRow(obj);
            }
        }
    }
        private void preencherTabelaUm(Paciente p)
    {

            DefaultTableModel tabelapac = (DefaultTableModel)tblTudo.getModel();
            tabelapac.setNumRows(0);

            Object[] obj = new Object[]{
                p.getIdPaciente(),
                p.getNome()
            };
            tabelapac.addRow(obj);
    }
    /**
     * Creates new form busca
     */
    public busca() {
        initComponents();
        pacDAO = new PacienteJpaController(Persistence.createEntityManagerFactory("NutriMaisPU"));
        anaDao = new AnamneseJpaController(Persistence.createEntityManagerFactory("NutriMaisPU"));
        usDao = new UsuarioJpaController(Persistence.createEntityManagerFactory("NutriMaisPU"));
        preencherTabela(pacDAO.findPacienteEntities());
        btnVisualizar.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTudo = new javax.swing.JTable();
        rbAnamnese = new javax.swing.JRadioButton();
        btnTodos = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnVisualizar = new javax.swing.JButton();
        rbUsuario = new javax.swing.JRadioButton();
        btnPesquisarr = new javax.swing.JButton();
        lblTelefone = new javax.swing.JLabel();
        rbDieta = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        rbAntropometria = new javax.swing.JRadioButton();
        btnNovo = new javax.swing.JButton();
        rbPacientes = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        btnDeletar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(184, 225, 206));

        jPanel2.setBackground(new java.awt.Color(184, 225, 206));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Nome:");

        lblNome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNome.setText("????");

        tblTudo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblTudo);

        rbAnamnese.setText("Anamnese");

        btnTodos.setText("Todos");
        btnTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodosActionPerformed(evt);
            }
        });

        jLabel2.setText("Pesquisar");

        btnVisualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forms/1480536330_seo-social-web-network-internet_232.png"))); // NOI18N
        btnVisualizar.setText("Visualizar");
        btnVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarActionPerformed(evt);
            }
        });

        rbUsuario.setText("usuario");
        rbUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbUsuarioActionPerformed(evt);
            }
        });

        btnPesquisarr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forms/1480208325_BT_search.png"))); // NOI18N
        btnPesquisarr.setText("Pesquisar");
        btnPesquisarr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarrActionPerformed(evt);
            }
        });

        lblTelefone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTelefone.setText("????");

        rbDieta.setText("Dieta Paciente");
        rbDieta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDietaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("ID:");

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forms/1480536547_pen-checkbox.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        rbAntropometria.setText("Antropometria");

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forms/add-32.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        rbPacientes.setText("Pacientes");
        rbPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPacientesActionPerformed(evt);
            }
        });

        jLabel5.setText("Instituto Federal de São Paulo");

        btnDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forms/recycle.png"))); // NOI18N
        btnDeletar.setText("Excluir");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        jLabel6.setText("Campus Capivari.");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forms/nutrimaisReduzidoReduzido.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(rbPacientes)
                                .addGap(9, 9, 9)
                                .addComponent(rbAnamnese)
                                .addGap(15, 15, 15)
                                .addComponent(rbAntropometria))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(14, 14, 14)
                                .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnPesquisarr)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTodos))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(rbUsuario)
                                .addGap(18, 18, 18)
                                .addComponent(rbDieta))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel1)
                        .addGap(10, 10, 10)
                        .addComponent(lblNome)
                        .addGap(331, 331, 331)
                        .addComponent(jLabel4)
                        .addGap(6, 6, 6)
                        .addComponent(lblTelefone))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addComponent(jLabel6))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 737, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeletar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVisualizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lblNome)
                    .addComponent(jLabel4)
                    .addComponent(lblTelefone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbPacientes)
                            .addComponent(rbAnamnese)
                            .addComponent(rbAntropometria))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbUsuario)
                            .addComponent(rbDieta))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPesquisarr)
                            .addComponent(btnTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeletar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovo)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel5)
                .addGap(6, 6, 6)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 727, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
        //int verificaAna = anaDao.getAnamneseCountDoUsuario();
        int linhaSelecionada  = tblTudo.getSelectedRow();
        Paciente p = pacDAO.findPaciente(Integer.parseInt(tblTudo.getValueAt(linhaSelecionada, 0).toString()));
        if(rbAnamnese.isSelected())
        {
            Anamnese a = new Anamnese();
            try{
                a = anaDao.findAnamnese(Integer.parseInt(tblTudo.getValueAt(linhaSelecionada, 0).toString()));
            }catch(Exception e){
                
            }           
            if( a == null )
            {

                anamnese an = new anamnese(p);
                an.estado = 1;            
                an.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Ja existe uma Anamnese para esse paciente");
            }
        }
        if(rbAntropometria.isSelected())
        {

            antropometria a = new antropometria(p);            
            a.setVisible(true);
        }
        if(rbUsuario.isSelected())
        {
            Usuario u = new Usuario();
            try{u = usDao.findUsuario(p.getIdPaciente());}
            catch(Exception e)
            {}
            if(u == null)
            {                
                cadastrarUsuario cu = new cadastrarUsuario(p);
                cu.status = 1;
                cu.setVisible(true);                    
            }            
            else
            {
                JOptionPane.showMessageDialog(this, "Não existe um usuario para esse paciente");
            }
            
        }
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        int linhaSelecionada  = tblTudo.getSelectedRow();
        Paciente p = pacDAO.findPaciente(Integer.parseInt(tblTudo.getValueAt(linhaSelecionada, 0).toString()));
        if(rbAnamnese.isSelected())
        {
            Anamnese a = new Anamnese();
            try{a = anaDao.findAnamnese(Integer.parseInt(tblTudo.getValueAt(linhaSelecionada, 0).toString()));}
            catch(Exception e){}           
            if( a != null )
            {

                anamnese an = new anamnese(p);
                an.estado = 2;
                an.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Não existe uma Anamnese para esse paciente");
            }
        }        
        if(rbUsuario.isSelected())
        {
            Usuario u = new Usuario();
            try{u = usDao.findUsuario(p.getIdPaciente());}
            catch(Exception e)
            {}
            if(u != null)
            {                
                cadastrarUsuario cu = new cadastrarUsuario(p);
                cu.status = 2;
                cu.setVisible(true);                    
            }            
            else
            {
                JOptionPane.showMessageDialog(this, "Não existe um usuario para esse paciente");
            }

            
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void rbPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPacientesActionPerformed
        // TODO add your handling code here:
        preencherTabela(pacDAO.findPacienteEntities());
    }//GEN-LAST:event_rbPacientesActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        // TODO add your handling code here:
        if(rbAnamnese.isSelected())
        {
            int linhaSelecionada  = tblTudo.getSelectedRow();
            if(linhaSelecionada != -1)
            {
                int confirma = JOptionPane.showConfirmDialog(this, "deseja realmente excluir");

                if(confirma == 0)
                {           
                    try{
                        int id = Integer.parseInt(tblTudo.getValueAt(linhaSelecionada, 0).toString());
                        anaDao.destroy(id);
                        JOptionPane.showMessageDialog(this, "Anamnese excluido com sucesso");
                        preencherTabela(pacDAO.findPacienteEntities()); 
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(this, "Erro ao excluir: "+e.getMessage());
                    } 
                }
            }
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnPesquisarrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarrActionPerformed
        // TODO add your handling code here:
        try
        {
            String texto = txtPesquisa.getText();
            if (Character.isDigit(texto.charAt(0))==true)
            {
                Paciente p = pacDAO.findPaciente(Integer.parseInt(texto));
                preencherTabelaUm(p);
            }else{
                List<Paciente> lista = pacDAO.findByNomelike(texto);
                preencherTabela(lista);
            }   
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Erro ao buscar: "+e.getMessage());
        }

    }//GEN-LAST:event_btnPesquisarrActionPerformed

    private void btnTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodosActionPerformed
        // TODO add your handling code here:
        preencherTabela(pacDAO.findPacienteEntities());
    }//GEN-LAST:event_btnTodosActionPerformed

    private void btnVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarActionPerformed
        // TODO add your handling code here:
        int linhaSelecionada  = tblTudo.getSelectedRow();
        Paciente p = pacDAO.findPaciente(Integer.parseInt(tblTudo.getValueAt(linhaSelecionada, 0).toString()));
        new dietaSemanal(p).setVisible(true); 
    }//GEN-LAST:event_btnVisualizarActionPerformed

    private void rbDietaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDietaActionPerformed
        // TODO add your handling code here:
        if(rbDieta.isSelected())
        {
            btnVisualizar.setEnabled(true); 
        }
        else
        {
           btnVisualizar.setEnabled(false); 
        }
    }//GEN-LAST:event_rbDietaActionPerformed

    private void rbUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbUsuarioActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_rbUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(busca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(busca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(busca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(busca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new busca().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisarr;
    private javax.swing.JButton btnTodos;
    private javax.swing.JButton btnVisualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JRadioButton rbAnamnese;
    private javax.swing.JRadioButton rbAntropometria;
    private javax.swing.JRadioButton rbDieta;
    private javax.swing.JRadioButton rbPacientes;
    private javax.swing.JRadioButton rbUsuario;
    private javax.swing.JTable tblTudo;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
