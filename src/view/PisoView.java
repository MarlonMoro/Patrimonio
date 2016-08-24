/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.BlocoDAO;
import dao.PisoDAO;
import dao.UnidadeDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.BlocoM;
import model.PisoM;
import model.UnidadeM;
import util.LimiteDigitos;

/**
 * UNIVERSIDADE DO ESTADO DE MINAS GERAIS - Unidade Frutal
 * @author NUPSI - Núcle de Práticas em Sistemas de Informação
 * Equipe: Gustavo Pinoti,Leopoldo Ferreira, Marlon Moro, Murillo Cuervo
 */
public class PisoView extends javax.swing.JInternalFrame {

    PisoM piso;
    PisoDAO pisoDAO;
    List<PisoM> listaPiso;
    List<BlocoM> listaBloco;
    BlocoDAO blocoDAO;
    List<UnidadeM> listaUnidade;
    UnidadeDAO unidadeDAO;

    /**
     * Creates new form PisoView
     */
    public PisoView() {
        pisoDAO = new PisoDAO();
        listaPiso = new ArrayList<>();
        listaBloco = new ArrayList<>();
        blocoDAO = new BlocoDAO();
        listaUnidade = new ArrayList<>();
        unidadeDAO = new UnidadeDAO();
        initComponents();
        this.setVisible(true);
        atualizaTabelaPiso();
        atualizaBoxUnidade();
        btnAlterarPiso.setEnabled(false);
        btnExcluirPiso.setEnabled(false);
        tfdDescricaoPiso.setDocument(new LimiteDigitos(45));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbePiso = new javax.swing.JTable();
        lblSelecUnidade1 = new javax.swing.JLabel();
        lblSelecBloco1 = new javax.swing.JLabel();
        cbxUnidade1 = new javax.swing.JComboBox<>();
        cbxBloco1 = new javax.swing.JComboBox<>();
        lblIDPiso = new javax.swing.JLabel();
        tfdIDPiso = new javax.swing.JTextField();
        lblDescricaoPiso = new javax.swing.JLabel();
        tfdDescricaoPiso = new javax.swing.JTextField();
        btnSalvarPiso = new javax.swing.JButton();
        btnExcluirPiso = new javax.swing.JButton();
        btnAlterarPiso = new javax.swing.JButton();
        btnNovoPiso = new javax.swing.JButton();
        btnCancelarPiso = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastrar Piso");

        tbePiso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Descrição", "Unidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbePiso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbePisoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbePiso);

        lblSelecUnidade1.setText("Selecione a unidade:");

        lblSelecBloco1.setText("Selecione o bloco:");

        cbxUnidade1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "UEMG", "Cadastrar Unidade" }));
        cbxUnidade1.setEnabled(false);
        cbxUnidade1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxUnidade1ItemStateChanged(evt);
            }
        });
        cbxUnidade1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbxUnidade1FocusLost(evt);
            }
        });
        cbxUnidade1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
                cbxUnidade1PopupMenuCanceled(evt);
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cbxUnidade1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxUnidade1ActionPerformed(evt);
            }
        });
        cbxUnidade1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cbxUnidade1PropertyChange(evt);
            }
        });
        cbxUnidade1.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                cbxUnidade1VetoableChange(evt);
            }
        });

        cbxBloco1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bloco A", "Cadastrar Bloco" }));
        cbxBloco1.setEnabled(false);
        cbxBloco1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxBloco1ActionPerformed(evt);
            }
        });

        lblIDPiso.setText("ID");

        tfdIDPiso.setEditable(false);
        tfdIDPiso.setEnabled(false);

        lblDescricaoPiso.setText("Descrição");

        tfdDescricaoPiso.setEnabled(false);

        btnSalvarPiso.setText("Salvar");
        btnSalvarPiso.setEnabled(false);
        btnSalvarPiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarPisoActionPerformed(evt);
            }
        });

        btnExcluirPiso.setText("Excluir");
        btnExcluirPiso.setEnabled(false);
        btnExcluirPiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirPisoActionPerformed(evt);
            }
        });

        btnAlterarPiso.setText("Alterar");
        btnAlterarPiso.setEnabled(false);
        btnAlterarPiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarPisoActionPerformed(evt);
            }
        });

        btnNovoPiso.setText("Novo");
        btnNovoPiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoPisoActionPerformed(evt);
            }
        });

        btnCancelarPiso.setText("Cancelar");
        btnCancelarPiso.setEnabled(false);
        btnCancelarPiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPisoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbxUnidade1, 0, 1, Short.MAX_VALUE)
                                .addGap(24, 24, 24))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSelecUnidade1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxBloco1, 0, 1, Short.MAX_VALUE)
                            .addComponent(lblSelecBloco1)))
                    .addComponent(tfdDescricaoPiso)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfdIDPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIDPiso)
                            .addComponent(lblDescricaoPiso)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNovoPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSalvarPiso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelarPiso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAlterarPiso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluirPiso)))
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSelecBloco1)
                    .addComponent(lblSelecUnidade1))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxUnidade1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxBloco1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblIDPiso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfdIDPiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDescricaoPiso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfdDescricaoPiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterarPiso)
                    .addComponent(btnNovoPiso)
                    .addComponent(btnSalvarPiso)
                    .addComponent(btnCancelarPiso)
                    .addComponent(btnExcluirPiso))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void atualizaTabelaPiso() {
        try {
            listaPiso = pisoDAO.listaTodos();
        } catch (SQLException ex) {
            Logger.getLogger(EntidadeView.class.getName()).log(Level.SEVERE, null, ex);
        }
        String dados[][] = new String[listaPiso.size()][4];
        int i = 0;
        for (PisoM pis : listaPiso) {
            dados[i][0] = String.valueOf(pis.getId());
            dados[i][1] = pis.getDescricao();
            dados[i][2] = pis.getBloco().getDescricao();
            dados[i][3] = pis.getBloco().getUnidadeM().getNome();
            i++;
        }
        String tituloColuna[] = {"ID", "Nome", "Bloco Pertencente", "Unidade Pertencente"};
        DefaultTableModel tabelaCliente = new DefaultTableModel();
        tabelaCliente.setDataVector(dados, tituloColuna);
        tbePiso.setModel(new DefaultTableModel(dados, tituloColuna) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tbePiso.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbePiso.getColumnModel().getColumn(1).setPreferredWidth(300);
        tbePiso.getColumnModel().getColumn(2).setPreferredWidth(300);
        tbePiso.getColumnModel().getColumn(3).setPreferredWidth(300);
        
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        tbePiso.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        tbePiso.setRowHeight(25);
        tbePiso.updateUI();
    }

    public void atualizaBoxUnidade() {
        cbxUnidade1.removeAllItems();
        cbxUnidade1.addItem("--Selecione--");
        try {
            listaUnidade = unidadeDAO.listaTodos();
        } catch (SQLException ex) {
            Logger.getLogger(EntidadeView.class.getName()).log(Level.SEVERE, null, ex);
        }
        String dados[][] = new String[listaUnidade.size()][5];
        int i = 0;
        for (UnidadeM uni : listaUnidade) {
            cbxUnidade1.addItem(uni.getNome());
        }

    }


    private void cbxUnidade1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxUnidade1ActionPerformed
        if (cbxUnidade1.getSelectedIndex() < 1) {
            cbxBloco1.removeAllItems();
            cbxBloco1.addItem("--Selecione--");

        } else {
            cbxBloco1.removeAllItems();
            cbxBloco1.addItem("--Selecione--");
            UnidadeM unid = new UnidadeM();
            try {
                unid = unidadeDAO.buscaNome(cbxUnidade1.getSelectedItem().toString());
                listaBloco = blocoDAO.buscaUni(unid.getId());
                for (BlocoM bloc : listaBloco) {
                    cbxBloco1.addItem(bloc.getDescricao());
                }
            } catch (SQLException ex) {
                Logger.getLogger(PisoView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_cbxUnidade1ActionPerformed

    private void cbxBloco1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxBloco1ActionPerformed
        
    }//GEN-LAST:event_cbxBloco1ActionPerformed

    private void btnNovoPisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoPisoActionPerformed
        limpaCamposPiso();
        ativaCampos();
        preparaNovo();
        cbxUnidade1.requestFocusInWindow();
    }//GEN-LAST:event_btnNovoPisoActionPerformed

    private void btnSalvarPisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarPisoActionPerformed
        if (tfdDescricaoPiso.getText().isEmpty() || cbxUnidade1.getSelectedIndex() == 0 || cbxBloco1.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Prencha todos os campos.", "Erro", JOptionPane.WARNING_MESSAGE);
            tfdDescricaoPiso.requestFocusInWindow();
        } else if (tfdIDPiso.getText().isEmpty()){
            piso = new PisoM();
            piso.setDescricao(tfdDescricaoPiso.getText());
            piso.setBloco(pegaBloco());
            try {
                pisoDAO.salvar(piso);
                JOptionPane.showMessageDialog(null, "Gravado com Sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                Logger.getLogger(EntidadeView.class.getName()).log(Level.SEVERE, null, ex);
            }
        preparaSalvareCancelar();
        desativaCampos();
        atualizaTabelaPiso();
        limpaCamposPiso();
        } else{

            piso = new PisoM();
            piso.setDescricao(tfdDescricaoPiso.getText());      
            piso.setId(Integer.parseInt(tfdIDPiso.getText()));
            try {
                pisoDAO.alterar(piso);
                JOptionPane.showMessageDialog(null, "Alterado com Sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                Logger.getLogger(EntidadeView.class.getName()).log(Level.SEVERE, null, ex);
            }
        preparaSalvareCancelar();
        desativaCampos();
        atualizaTabelaPiso();
        limpaCamposPiso();
        }
        
                
    }//GEN-LAST:event_btnSalvarPisoActionPerformed

    private void btnExcluirPisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirPisoActionPerformed
        if (tfdIDPiso.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um Piso.", "Erro", JOptionPane.WARNING_MESSAGE);
        } else {
            piso = new PisoM();
            piso.setId(Integer.parseInt(tfdIDPiso.getText()));
            int confirma = JOptionPane.showConfirmDialog(null, "Deseja Excluir: " + tfdDescricaoPiso.getText() + " ?");
            if (confirma == 0) {
                try {
                    pisoDAO.excluir(piso);
                    atualizaTabelaPiso();
                    limpaCamposPiso();
                    preparaExcluir();
                } catch (SQLException ex) {
                    Logger.getLogger(EntidadeView.class.getName()).log(Level.SEVERE, null, ex);
                    if (ex.getErrorCode() == 1451) {
                        JOptionPane.showMessageDialog(null, "Impossível excluir esse Piso, ele já possui Salas cadastradas!", "Erro", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
                    }
                }

            }
        }
        limpaCamposPiso();
        atualizaTabelaPiso();
        preparaExcluir();
        desativaCampos();
    }//GEN-LAST:event_btnExcluirPisoActionPerformed

    private void tbePisoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbePisoMouseClicked
          //falta preencher os combobox!!  //falta preencher os combobox!!
            //falta preencher os combobox!!   //falta preencher os combobox!!
        
        tfdIDPiso.setText(tbePiso.getValueAt(tbePiso.getSelectedRow(), 0).toString());
        tfdDescricaoPiso.setText(tbePiso.getValueAt(tbePiso.getSelectedRow(), 1).toString());
        cbxBloco1.setEnabled(false);
        cbxUnidade1.setEnabled(false);
        cbxUnidade1.setSelectedItem(tbePiso.getValueAt(tbePiso.getSelectedRow(), 3).toString());
        cbxBloco1.setSelectedItem(tbePiso.getValueAt(tbePiso.getSelectedRow(), 2).toString());
        preparaSelecaoTabelaPiso();
    }//GEN-LAST:event_tbePisoMouseClicked

    private void btnAlterarPisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarPisoActionPerformed
        preparaAlterar();
        ativaCampos();
        /* if (tfdIDPiso.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um Piso", "Erro", JOptionPane.WARNING_MESSAGE);
        } else {
            piso = new PisoM();
            piso.setId(Integer.parseInt(tfdIDPiso.getText()));
            piso.setDescricao(tfdDescricaoPiso.getText());
            try {
                pisoDAO.alterar(piso);
                JOptionPane.showMessageDialog(null, "Piso atualizado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                atualizaTabelaPiso();
                limpaCamposPiso();
                btnAlterarPiso.setEnabled(false);
                btnSalvarPiso.setEnabled(true);
                btnExcluirPiso.setEnabled(false);
            } catch (SQLException ex) {
                Logger.getLogger(EntidadeView.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
            }

        }*/
    }//GEN-LAST:event_btnAlterarPisoActionPerformed

    private void cbxUnidade1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxUnidade1ItemStateChanged

    }//GEN-LAST:event_cbxUnidade1ItemStateChanged

    private void cbxUnidade1PopupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbxUnidade1PopupMenuCanceled

    }//GEN-LAST:event_cbxUnidade1PopupMenuCanceled

    private void cbxUnidade1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbxUnidade1FocusLost

    }//GEN-LAST:event_cbxUnidade1FocusLost

    private void cbxUnidade1VetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_cbxUnidade1VetoableChange

    }//GEN-LAST:event_cbxUnidade1VetoableChange

    private void cbxUnidade1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbxUnidade1PropertyChange

    }//GEN-LAST:event_cbxUnidade1PropertyChange

    private void btnCancelarPisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPisoActionPerformed
        // TODO add your handling code here:
        limpaCamposPiso();
        preparaSalvareCancelar();
        desativaCampos();
    }//GEN-LAST:event_btnCancelarPisoActionPerformed

    public BlocoM pegaBloco() {
        try {
            return blocoDAO.buscaNome(cbxBloco1.getSelectedItem().toString());
        } catch (SQLException ex) {
            Logger.getLogger(BlocoView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     // INÍCIO MÉTODOS DE CONTROLE DE BOTÕES 
    
    public void limpaCamposPiso() {
        tfdDescricaoPiso.setText("");
        tfdIDPiso.setText("");
        cbxUnidade1.setSelectedIndex(0);
        cbxBloco1.setSelectedIndex(0);
        
    }
    
    public void preparaNovo() {
        btnNovoPiso.setEnabled(false);
        btnSalvarPiso.setEnabled(true);
        btnCancelarPiso.setEnabled(true);
        btnAlterarPiso.setEnabled(false);
        btnExcluirPiso.setEnabled(false);
        cbxBloco1.setEnabled(true);
        cbxUnidade1.setEnabled(true);
        tbePiso.setEnabled(false);
        tbePiso.clearSelection();
    }
    public void preparaSalvareCancelar() {
        btnNovoPiso.setEnabled(true);
        btnSalvarPiso.setEnabled(false);
        btnCancelarPiso.setEnabled(false);
        cbxUnidade1.setEnabled(false);
        cbxBloco1.setEnabled(false);
        tbePiso.setEnabled(true);
    }
    
    public void ativaCampos() {
        tfdIDPiso.setEnabled(true);
        tfdDescricaoPiso.setEnabled(true);
    }
    
    public void desativaCampos(){
       cbxUnidade1.setSelectedIndex(0);
       cbxUnidade1.setEnabled(false);
       cbxBloco1.setSelectedIndex(0);
       cbxBloco1.setEnabled(false);
       tfdIDPiso.setText("");
       tfdIDPiso.setEnabled(false);
       tfdDescricaoPiso.setEnabled(false);
       btnSalvarPiso.setEnabled(false);
       btnCancelarPiso.setEnabled(false);
       btnAlterarPiso.setEnabled(false);
       btnExcluirPiso.setEnabled(false);
    } 
     public void preparaAlterar() {
        btnNovoPiso.setEnabled(false);
        btnExcluirPiso.setEnabled(false);
        btnAlterarPiso.setEnabled(false);
        btnSalvarPiso.setEnabled(true);
        btnCancelarPiso.setEnabled(true);
        tbePiso.setEnabled(false);
        tbePiso.clearSelection();
     }
     public void preparaExcluir() {
        btnExcluirPiso.setEnabled(false);
        btnAlterarPiso.setEnabled(false);
    }
     
    public void preparaSelecaoTabelaPiso(){
        btnNovoPiso.setEnabled(true);
        btnExcluirPiso.setEnabled(true);
        btnAlterarPiso.setEnabled(true);
    }
    
     // FIM MÉTODOS DE CONTROLE DE BOTÕES 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarPiso;
    private javax.swing.JButton btnCancelarPiso;
    private javax.swing.JButton btnExcluirPiso;
    private javax.swing.JButton btnNovoPiso;
    private javax.swing.JButton btnSalvarPiso;
    private javax.swing.JComboBox<String> cbxBloco1;
    private javax.swing.JComboBox<String> cbxUnidade1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescricaoPiso;
    private javax.swing.JLabel lblIDPiso;
    private javax.swing.JLabel lblSelecBloco1;
    private javax.swing.JLabel lblSelecUnidade1;
    private javax.swing.JTable tbePiso;
    private javax.swing.JTextField tfdDescricaoPiso;
    private javax.swing.JTextField tfdIDPiso;
    // End of variables declaration//GEN-END:variables
}
