/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.HistoricoAcaoDAO;
import dao.OrgaoDAO;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.HistoricoAcaoM;
import model.OrgaoM;
import model.UsuarioM;
import util.LimiteDigitos;

/**
 * UNIVERSIDADE DO ESTADO DE MINAS GERAIS - Unidade Frutal
 * @author NUPSI - Núcle de Práticas em Sistemas de Informação
 * Equipe: Gustavo Pinoti,Leopoldo Ferreira, Marlon Moro, Murillo Cuervo
 */
public class OrgaoView extends javax.swing.JInternalFrame {

    /**
     * Creates new form Orgão
     */
    private UsuarioM usuarioAtivo;
    
    public OrgaoView(UsuarioM usuarioAtivo) {
        orgaoDAO = new OrgaoDAO();
        listaOrgao = new ArrayList<>();
        
        initComponents();  
        this.setVisible(true);
        atualizaTabelaOrgao();
        tfdCnpj.setDocument(new LimiteDigitos(45));
        tfdContato.setDocument(new LimiteDigitos(45));
        tfdNome.setDocument(new LimiteDigitos(45));
        this.usuarioAtivo = usuarioAtivo;

    }

    OrgaoM orgao;
    OrgaoDAO orgaoDAO;
    
    String acao;
    int idHistorico;
    String descricaoHistorico;
    List<OrgaoM> listaOrgao;

    public void atualizaTabelaOrgao() {

        try {
            listaOrgao = orgaoDAO.listaTodos();
        } catch (SQLException ex) {
            Logger.getLogger(OrgaoView.class.getName()).log(Level.SEVERE, null, ex);
        }
        String dados[][] = new String[listaOrgao.size()][4];
        int i = 0;
        for (OrgaoM orgao1 : listaOrgao) {
            dados[i][0] = String.valueOf(orgao1.getId());
            dados[i][1] = orgao1.getNome();
            dados[i][2] = orgao1.getCnpj();
            dados[i][3] = orgao1.getContato();
            i++;
        }
        String tituloColuna[] = {"ID", "Nome", "CNPJ", "Contato"};
        DefaultTableModel tabelaCliente = new DefaultTableModel();
        tabelaCliente.setDataVector(dados, tituloColuna);
        tbeOrgao.setModel(new DefaultTableModel(dados, tituloColuna) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tbeOrgao.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbeOrgao.getColumnModel().getColumn(1).setPreferredWidth(250);
        tbeOrgao.getColumnModel().getColumn(2).setPreferredWidth(250);
        tbeOrgao.getColumnModel().getColumn(3).setPreferredWidth(250);

        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        tbeOrgao.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        tbeOrgao.setRowHeight(25);
        tbeOrgao.updateUI();

    }
    
    public void salvaHistorico() throws SQLException{
        HistoricoAcaoM historico = new HistoricoAcaoM();
        historico.setIdObjeto(idHistorico);
        historico.setTipoObjeto(descricaoHistorico);
        historico.setAcao(acao);
        historico.setDataAcao(new Date(System.currentTimeMillis()));
        historico.setUsuario(usuarioAtivo);
        
        HistoricoAcaoDAO.salvar(historico);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlOrgao = new javax.swing.JPanel();
        btnAlterar = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();
        tfdID = new javax.swing.JTextField();
        lblCnpj = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        tfdNome = new javax.swing.JTextField();
        lblTelefone = new javax.swing.JLabel();
        tfdCnpj = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        tfdContato = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbeOrgao = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Orgão");
        setToolTipText("");
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.setEnabled(false);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        btnAlterar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAlterarKeyPressed(evt);
            }
        });

        lblNome.setText("ID");

        tfdID.setEditable(false);
        tfdID.setEnabled(false);
        tfdID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdIDActionPerformed(evt);
            }
        });

        lblCnpj.setText("Nome");

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        btnNovo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnNovoKeyPressed(evt);
            }
        });

        tfdNome.setEnabled(false);
        tfdNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfdNomeKeyPressed(evt);
            }
        });

        lblTelefone.setText("CNPJ");

        tfdCnpj.setEnabled(false);
        tfdCnpj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfdCnpjKeyPressed(evt);
            }
        });

        lblEmail.setText("Contato");

        tfdContato.setEnabled(false);
        tfdContato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfdContatoKeyPressed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        btnSalvar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSalvarKeyPressed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        btnCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCancelarKeyPressed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        btnExcluir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnExcluirKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pnlOrgaoLayout = new javax.swing.GroupLayout(pnlOrgao);
        pnlOrgao.setLayout(pnlOrgaoLayout);
        pnlOrgaoLayout.setHorizontalGroup(
            pnlOrgaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnlOrgaoLayout.createSequentialGroup()
                .addGroup(pnlOrgaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlOrgaoLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir))
                    .addGroup(pnlOrgaoLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(pnlOrgaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfdNome, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfdContato, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfdCnpj)
                            .addGroup(pnlOrgaoLayout.createSequentialGroup()
                                .addGroup(pnlOrgaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTelefone)
                                    .addComponent(lblEmail)
                                    .addComponent(lblCnpj)
                                    .addComponent(lblNome)
                                    .addComponent(tfdID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        pnlOrgaoLayout.setVerticalGroup(
            pnlOrgaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOrgaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfdID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCnpj)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfdNome, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTelefone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfdCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfdContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlOrgaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterar)
                    .addComponent(btnNovo)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar)
                    .addComponent(btnExcluir))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        tbeOrgao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "CNPJ", "Contato"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbeOrgao.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbeOrgao.getTableHeader().setReorderingAllowed(false);
        tbeOrgao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbeOrgaoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbeOrgao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlOrgao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(pnlOrgao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfdIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdIDActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (tfdNome.getText().isEmpty() || tfdCnpj.getText().isEmpty() || tfdContato.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Prencha todos os campos.", "Erro", JOptionPane.WARNING_MESSAGE);
            tfdNome.requestFocusInWindow();
        } else if (tfdID.getText().isEmpty()){
            orgao = new OrgaoM();
            orgao.setNome(tfdNome.getText());
            orgao.setCnpj(tfdCnpj.getText());
            orgao.setContato(tfdContato.getText());
            try {
                idHistorico = orgaoDAO.salvar(orgao);
                acao = "Novo Orgão";
                descricaoHistorico = orgao.getNome();
                salvaHistorico();
                JOptionPane.showMessageDialog(null, "Gravado com Sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                atualizaTabelaOrgao();
                limpaCamposOrgao();
                preparaSalvareCancelar();
                desativaCampos();
                atualizaTabelaOrgao();

            } catch (SQLException ex) {
                Logger.getLogger(OrgaoView.class.getName()).log(Level.SEVERE, null, ex);
                if (ex.getErrorCode() == 1062) {
                    JOptionPane.showMessageDialog(null, "Orgao com nome já existente.", "Erro", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
            

        } 
        else {
            if (tfdID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um Orgao.", "Erro", JOptionPane.WARNING_MESSAGE);
            } else {
                orgao = new OrgaoM();
                orgao.setId(Integer.parseInt(tfdID.getText()));
                orgao.setNome(tfdNome.getText());
                orgao.setCnpj(tfdCnpj.getText());
                orgao.setContato(tfdContato.getText());
                acao = "Alterar Orgão";
                idHistorico = orgao.getId();
                descricaoHistorico = orgao.getNome();
                try {
                    salvaHistorico();
                    orgaoDAO.alterar(orgao);
                    JOptionPane.showMessageDialog(null, "Alterado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    preparaSalvareCancelar();
                    desativaCampos();
                    atualizaTabelaOrgao();
                } catch (SQLException ex) {
                    if (ex.getErrorCode() == 1062) {
                    JOptionPane.showMessageDialog(null, "Orgao com nome já existente.", "Erro", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                }
            }
       
        }
            
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (tfdID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione uma Orgao.", "Erro", JOptionPane.WARNING_MESSAGE);
        } else {
            orgao = new OrgaoM();
            orgao.setId(Integer.parseInt(tfdID.getText()));
            orgao.setNome(tfdNome.getText());
            int confirma = JOptionPane.showConfirmDialog(null, "Deseja Excluir: " + tfdNome.getText() + " ?");
            if (confirma == 0) {
                try {
                    acao = "Excluir Orgão";
                    idHistorico = orgao.getId();
                    descricaoHistorico = orgao.getNome();
                    salvaHistorico();
                    orgaoDAO.excluir(orgao);
                    atualizaTabelaOrgao();
                    limpaCamposOrgao();

                } catch (SQLException ex) {
                    Logger.getLogger(OrgaoView.class.getName()).log(Level.SEVERE, null, ex);
                    if (ex.getErrorCode() == 1451) {
                        JOptionPane.showMessageDialog(null, "Impossível excluir essa Orgao, ela já possui patrimônios cadastrados!", "Erro", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
                    }
                }

            }
        }
        limpaCamposOrgao();
        atualizaTabelaOrgao();
        preparaExcluir();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        limpaCamposOrgao();
        preparaNovo();
        ativaCampos();
        tfdNome.requestFocusInWindow();
      
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed

        preparaAlterar();
        ativaCampos();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void tbeOrgaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbeOrgaoMouseClicked
        // TODO add your handling code here:
        tfdID.setText(tbeOrgao.getValueAt(tbeOrgao.getSelectedRow(), 0).toString());
        tfdNome.setText(tbeOrgao.getValueAt(tbeOrgao.getSelectedRow(), 1).toString());
        tfdCnpj.setText(tbeOrgao.getValueAt(tbeOrgao.getSelectedRow(), 2).toString());
        tfdContato.setText(tbeOrgao.getValueAt(tbeOrgao.getSelectedRow(), 3).toString());
        preparaSelecaoTabela();
    }//GEN-LAST:event_tbeOrgaoMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        limpaCamposOrgao();
        preparaSalvareCancelar();
        desativaCampos();
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed

    }//GEN-LAST:event_formInternalFrameClosed

    private void tfdNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdNomeKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            tfdCnpj.requestFocusInWindow();
        }
    }//GEN-LAST:event_tfdNomeKeyPressed

    private void tfdCnpjKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdCnpjKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            tfdContato.requestFocusInWindow();
        }
    }//GEN-LAST:event_tfdCnpjKeyPressed

    private void tfdContatoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdContatoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnSalvar.requestFocusInWindow();
        }
    }//GEN-LAST:event_tfdContatoKeyPressed

    private void btnSalvarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalvarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            
            if (tfdNome.getText().isEmpty() || tfdCnpj.getText().isEmpty() || tfdContato.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Prencha todos os campos.", "Erro", JOptionPane.WARNING_MESSAGE);
            tfdNome.requestFocusInWindow();
            } else if (tfdID.getText().isEmpty()){
                orgao = new OrgaoM();
                orgao.setNome(tfdNome.getText());
                orgao.setCnpj(tfdCnpj.getText());
                orgao.setContato(tfdContato.getText());
                try {
                    idHistorico = orgaoDAO.salvar(orgao);
                    acao = "Novo Orgão";
                    descricaoHistorico = orgao.getNome();
                    salvaHistorico();
                    JOptionPane.showMessageDialog(null, "Gravado com Sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    atualizaTabelaOrgao();
                    limpaCamposOrgao();
                    preparaSalvareCancelar();
                    desativaCampos();
                    atualizaTabelaOrgao();

                } catch (SQLException ex) {
                    Logger.getLogger(OrgaoView.class.getName()).log(Level.SEVERE, null, ex);
                    if (ex.getErrorCode() == 1062) {
                        JOptionPane.showMessageDialog(null, "Orgao com nome já existente.", "Erro", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            

            } 
            else {
                if (tfdID.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Selecione um Orgao.", "Erro", JOptionPane.WARNING_MESSAGE);
                } else {
                    orgao = new OrgaoM();
                    orgao.setId(Integer.parseInt(tfdID.getText()));
                    orgao.setNome(tfdNome.getText());
                    orgao.setCnpj(tfdCnpj.getText());
                    orgao.setContato(tfdContato.getText());
                    acao = "Alterar Orgão";
                    idHistorico = orgao.getId();
                    descricaoHistorico = orgao.getNome();
                    try {
                        salvaHistorico();
                        orgaoDAO.alterar(orgao);
                        JOptionPane.showMessageDialog(null, "Alterado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                        preparaSalvareCancelar();
                        desativaCampos();
                        atualizaTabelaOrgao();
                    } catch (SQLException ex) {
                        if (ex.getErrorCode() == 1062) {
                            JOptionPane.showMessageDialog(null, "Orgao com nome já existente.", "Erro", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                    }
                }
            
             
            }
        }
    }//GEN-LAST:event_btnSalvarKeyPressed

    private void btnCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelarKeyPressed

         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
             limpaCamposOrgao();
            preparaSalvareCancelar();
            desativaCampos();
        }
    }//GEN-LAST:event_btnCancelarKeyPressed

    private void btnAlterarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAlterarKeyPressed

         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            preparaAlterar();
            ativaCampos();
        }
    }//GEN-LAST:event_btnAlterarKeyPressed

    private void btnExcluirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnExcluirKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (tfdID.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Selecione uma Orgao.", "Erro", JOptionPane.WARNING_MESSAGE);
            } else {
                orgao = new OrgaoM();
                orgao.setId(Integer.parseInt(tfdID.getText()));
                orgao.setNome(tfdNome.getText());
                int confirma = JOptionPane.showConfirmDialog(null, "Deseja Excluir: " + tfdNome.getText() + " ?");
                if (confirma == 0) {
                    try {
                        acao = "Excluir Orgão";
                        idHistorico = orgao.getId();
                        descricaoHistorico = orgao.getNome();
                        salvaHistorico();
                        orgaoDAO.excluir(orgao);
                        atualizaTabelaOrgao();
                        limpaCamposOrgao();

                    } catch (SQLException ex) {
                        Logger.getLogger(OrgaoView.class.getName()).log(Level.SEVERE, null, ex);
                        if (ex.getErrorCode() == 1451) {
                            JOptionPane.showMessageDialog(null, "Impossível excluir essa Orgao, ela já possui patrimônios cadastrados!", "Erro", JOptionPane.WARNING_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
                        }
                    }

                }
            }
            limpaCamposOrgao();
            atualizaTabelaOrgao();
            preparaExcluir();
        }
    }//GEN-LAST:event_btnExcluirKeyPressed

    private void btnNovoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnNovoKeyPressed

         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
             limpaCamposOrgao();
             preparaNovo();
             ativaCampos();
             tfdNome.requestFocusInWindow();
        }
    }//GEN-LAST:event_btnNovoKeyPressed

    // INÍCIO MÉTODOS DE CONTROLE DE BOTÕES
    
    public void preparaSalvareCancelar() {
        btnNovo.setEnabled(true);
        btnSalvar.setEnabled(false);
        btnCancelar.setEnabled(false);
        tbeOrgao.setEnabled(true);
    }
    
    public void limpaCamposOrgao() {
        
        tfdID.setText("");
        tfdNome.setText("");        
        tfdCnpj.setText("");       
        tfdContato.setText("");  

    }
    
    public void ativaCampos() {
        tfdNome.setEnabled(true);   
        tfdCnpj.setEnabled(true);    
        tfdContato.setEnabled(true);
       
    }
    
    public void desativaCampos(){
        tfdID.setText("");
        tfdID.setEnabled(false);
        tfdID.setEditable(false);
        tfdNome.setText("");
        tfdNome.setEnabled(false);
        tfdCnpj.setText("");
        tfdCnpj.setEnabled(false);
        tfdContato.setText("");
        tfdContato.setEnabled(false);
    } 
   
    public void preparaNovo() {
        btnNovo.setEnabled(false);
        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnAlterar.setEnabled(false);
        btnExcluir.setEnabled(false);
        tbeOrgao.setEnabled(false);
        tbeOrgao.clearSelection();
    }
    public void preparaAlterar() {
        btnNovo.setEnabled(false);
        btnExcluir.setEnabled(false);
        btnAlterar.setEnabled(false);
        btnSalvar.setEnabled(true);
        btnCancelar.setEnabled(true);
        tbeOrgao.setEnabled(false);
        tbeOrgao.clearSelection();
    }
    
    public void preparaExcluir() {
        btnExcluir.setEnabled(false);
        btnAlterar.setEnabled(false);
    }
    
    public void preparaSelecaoTabela(){
        btnNovo.setEnabled(true);
        btnExcluir.setEnabled(true);
        btnAlterar.setEnabled(true);
    }
    
    // FIM MÉTODOS DE CONTROLE DE BOTÕES

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCnpj;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JPanel pnlOrgao;
    private javax.swing.JTable tbeOrgao;
    private javax.swing.JTextField tfdCnpj;
    private javax.swing.JTextField tfdContato;
    private javax.swing.JTextField tfdID;
    private javax.swing.JTextField tfdNome;
    // End of variables declaration//GEN-END:variables
}
