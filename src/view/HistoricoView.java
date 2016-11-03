/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.HistoricoAcaoDAO;
import dao.UsuarioDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.HistoricoAcaoM;
import model.UsuarioM;

/**
 *
 * @author Leopo
 */
public class HistoricoView extends javax.swing.JInternalFrame {
    

    /**
     * Creates new form HistoricoView
     */
    HistoricoAcaoM hist;
    HistoricoAcaoDAO historicoAcaoDAO;
    List<HistoricoAcaoM> listaHistorico;
    UsuarioDAO usuarioDAO;
    List<UsuarioM> listaUsuario;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
    Date dataIni = null;
    Date dataF = null;
    
    public HistoricoView() {
        
        initComponents();
        this.setVisible(true);
        historicoAcaoDAO = new HistoricoAcaoDAO();
        listaHistorico = new ArrayList<>();
        usuarioDAO = new UsuarioDAO();
        listaUsuario = new ArrayList<>();
        sdf.setLenient(false);
        
        //inicia a tela já com todos os logs
        /*try {
            listaHistorico = historicoAcaoDAO.listaTodos();
        } catch (SQLException ex) {
            
            Logger.getLogger(OrgaoView.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        preencheComboUsuario();
        preencheComboAcoes();
        //atualizaTabelaHistorico();
    } 
    
    public void atualizaTabelaHistorico() {
       
        String dados[][] = new String[listaHistorico.size()][4];
        int i = 0;
        for (HistoricoAcaoM hist : listaHistorico) {
            
            dados[i][0] = hist.getDataAcao().toString();
            dados[i][1] = hist.getTipoObjeto();
            dados[i][2] = hist.getAcao();
            dados[i][3] = hist.getUsuario().getNome();
            
            i++;
        }
        String tituloColuna[] = {"Data", "Objeto", "Ação", "Usuário"};
        DefaultTableModel tabelaCliente = new DefaultTableModel();
        tabelaCliente.setDataVector(dados, tituloColuna);
        tbeHistorico.setModel(new DefaultTableModel(dados, tituloColuna) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tbeHistorico.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbeHistorico.getColumnModel().getColumn(1).setPreferredWidth(200);
        tbeHistorico.getColumnModel().getColumn(2).setPreferredWidth(150);
        tbeHistorico.getColumnModel().getColumn(3).setPreferredWidth(300);
        

        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        tbeHistorico.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        tbeHistorico.setRowHeight(25);
        tbeHistorico.updateUI();
    }
    
    public void preencheComboUsuario(){
        cbxUsuario.removeAllItems();
        cbxUsuario.addItem("--Selecione--");
        
        try {
            listaUsuario = usuarioDAO.listaTodos();
        } catch (SQLException ex) {
            Logger.getLogger(HistoricoView.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (UsuarioM user : listaUsuario){
            if (!user.getUsuario().equals("root"))
            {
                cbxUsuario.addItem(user.getNome());
            }   
        }        
        
    }
    
    public void preencheComboAcoes(){
        cbxAcoes.removeAllItems();
        cbxAcoes.addItem("--Selecione--");
        
        cbxAcoes.addItem("Adicionar");
        cbxAcoes.addItem("Alterar");
        cbxAcoes.addItem("Deletar");
        cbxAcoes.addItem("Baixar");
    }
    
    public void definePeriodo(){
        
        String dataInicio = tfdPeriodoInicio.getText();
        String dataFim = tfdPeriodoFim.getText();
       
       
        try {
            dataIni = new Date(sdf.parse(dataInicio).getTime());
            dataF = new Date(sdf.parse(dataFim).getTime());
        } catch (ParseException ex) {
            Logger.getLogger(HistoricoView.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbeHistorico = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbxUsuario = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        tfdPeriodoInicio = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfdPeriodoFim = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        cbxAcoes = new javax.swing.JComboBox<>();
        tfdNavegacao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblQuantPaginas = new javax.swing.JLabel();
        btnProximo = new javax.swing.JButton();
        btnAnterior1 = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        tbeHistorico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", null, "", null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Data", "Título 2", "Patrimonio", "Usuario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbeHistorico.setSelectionForeground(new java.awt.Color(153, 0, 255));
        tbeHistorico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbeHistoricoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbeHistorico);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));
        jPanel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnBuscar.setText("Buscar");
        btnBuscar.setPreferredSize(new java.awt.Dimension(65, 26));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel1.setText("Usuário:");

        jLabel2.setText("Período da ação");

        try {
            tfdPeriodoInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setText("Início:");

        jLabel5.setText("Fim:");

        try {
            tfdPeriodoFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel6.setText("Ação:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbxUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jLabel2)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tfdPeriodoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tfdPeriodoFim, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxAcoes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfdPeriodoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(tfdPeriodoFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbxAcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tfdNavegacao.setPreferredSize(new java.awt.Dimension(6, 23));
        tfdNavegacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfdNavegacaoKeyPressed(evt);
            }
        });

        jLabel3.setText("Ir para:");

        lblQuantPaginas.setText("quant de paginas");

        btnProximo.setText(">>");
        btnProximo.setEnabled(false);
        btnProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximoActionPerformed(evt);
            }
        });

        btnAnterior1.setText("<<");
        btnAnterior1.setEnabled(false);
        btnAnterior1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnterior1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAnterior1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQuantPaginas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProximo)
                .addGap(233, 233, 233)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfdNavegacao, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantPaginas)
                    .addComponent(btnProximo)
                    .addComponent(jLabel3)
                    .addComponent(tfdNavegacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnterior1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbeHistoricoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbeHistoricoMouseClicked
    }//GEN-LAST:event_tbeHistoricoMouseClicked

    private void tfdNavegacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdNavegacaoKeyPressed
        
    }//GEN-LAST:event_tfdNavegacaoKeyPressed

    private void btnProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximoActionPerformed
        
    }//GEN-LAST:event_btnProximoActionPerformed

    private void btnAnterior1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnterior1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAnterior1ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        /*UsuarioM usuario = null;
        try {
            usuario = usuarioDAO.buscaNome(cbxUsuario.getSelectedItem().toString());
        } catch (SQLException ex) {
            Logger.getLogger(HistoricoView.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
       /* definePeriodo();

        try {
            
            hist = new HistoricoAcaoM(dataIni, dataF);
            
            listaHistorico = historicoAcaoDAO.busca(hist, 1, 3);
        } catch (SQLException ex) {
            Logger.getLogger(HistoricoView.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*try {
            hist = new HistoricoAcaoM(usuario);
            listaHistorico = historicoAcaoDAO.busca(hist, 1, 5);
        } catch (SQLException ex) {
            Logger.getLogger(HistoricoView.class.getName()).log(Level.SEVERE, null, ex);
        }*/
       
        /*hist = new HistoricoAcaoM(cbxAcoes.getSelectedItem().toString());
        try {
            listaHistorico = historicoAcaoDAO.busca(hist, 1, 7);
        } catch (SQLException ex) {
            Logger.getLogger(HistoricoView.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        atualizaTabelaHistorico();
    }//GEN-LAST:event_btnBuscarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior1;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnProximo;
    private javax.swing.JComboBox<String> cbxAcoes;
    private javax.swing.JComboBox<String> cbxUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblQuantPaginas;
    private javax.swing.JTable tbeHistorico;
    private javax.swing.JTextField tfdNavegacao;
    private javax.swing.JFormattedTextField tfdPeriodoFim;
    private javax.swing.JFormattedTextField tfdPeriodoInicio;
    // End of variables declaration//GEN-END:variables
}