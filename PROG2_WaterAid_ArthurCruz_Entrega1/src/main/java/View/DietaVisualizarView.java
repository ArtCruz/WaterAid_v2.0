/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.*;
import Model.Pessoa;
import java.awt.Color;
import java.awt.event.ActionListener;

/**
 *
 * @author Usuário
 */
public class DietaVisualizarView extends javax.swing.JFrame {

    /**
     * Creates new form DietaVisualizarView
     */
    public DietaVisualizarView() {
        initComponents();
        Color backGroundColor=  new Color(221,221,221);
        this.getContentPane().setBackground(backGroundColor);
    }
    
    public void exibirTela(){
        setVisible(true);
    }
    
    public void limparTodosTextArea(){
        taLitAguaImpac.setText("");
        taLitDif.setText("");
        taBanhos.setText("");
        taReais.setText("");
    }
    
    public Object getSelectedPessoa(){
        return cmbPesDietVis.getSelectedItem();
    }
    
    public void preencherTALitAgua(String txt){
        taLitAguaImpac.append(txt);
    }
    
    public void preencherTADifAgua(String txt){
        taLitDif.append(txt);
    }
    
    public void preencherTABanhos(String txt){
        taBanhos.append(txt);
    }
    
    public void preencherTAReais(String txt){
        taReais.append(txt);
    }
    
    public void adicionarAcaoCMBPessoas(ActionListener acao){
        cmbPesDietVis.addActionListener(acao);
    }
    
    public void listarCMBPessoas(Pessoa p){
        cmbPesDietVis.addItem(p);
    }  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jLabel7 = new javax.swing.JLabel();
        cmbPesDietVis = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taLitDif = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        taLitAguaImpac = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        taBanhos = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        taReais = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jMenuBar3 = new javax.swing.JMenuBar();
        mnCadastro7 = new javax.swing.JMenu();
        btnCadastroPessoa4 = new javax.swing.JMenuItem();
        btnCadastroComida7 = new javax.swing.JMenuItem();
        btnRefeicao7 = new javax.swing.JMenu();
        miRefNovaView2 = new javax.swing.JMenuItem();
        btnRefeicaoHistoricoView2 = new javax.swing.JMenuItem();
        btnRelatório7 = new javax.swing.JMenu();
        btnRelatorioPessoasView2 = new javax.swing.JMenuItem();
        btnRelatorioComidaView2 = new javax.swing.JMenuItem();
        miCalcularImpacto2 = new javax.swing.JMenu();
        miCalcImpacView2 = new javax.swing.JMenuItem();
        miVisualizarImpactoView2 = new javax.swing.JMenuItem();
        miCalcularDieta5 = new javax.swing.JMenu();
        miCalcularDietaView2 = new javax.swing.JMenuItem();
        miVisualizarDietaView2 = new javax.swing.JMenuItem();
        miRankingGeral5 = new javax.swing.JMenu();
        miRankingGeralView2 = new javax.swing.JMenuItem();
        mnRemPesView1 = new javax.swing.JMenu();
        miRemPesView1 = new javax.swing.JMenuItem();
        miRemRefeicaoView2 = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar2.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Visualizar Dieta");

        cmbPesDietVis.setBackground(new java.awt.Color(37, 201, 228));
        cmbPesDietVis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPesDietVisActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Pessoa:");

        taLitDif.setColumns(20);
        taLitDif.setRows(5);
        jScrollPane1.setViewportView(taLitDif);

        taLitAguaImpac.setColumns(20);
        taLitAguaImpac.setRows(5);
        jScrollPane6.setViewportView(taLitAguaImpac);

        taBanhos.setColumns(20);
        taBanhos.setRows(5);
        jScrollPane7.setViewportView(taBanhos);

        taReais.setColumns(20);
        taReais.setRows(5);
        jScrollPane8.setViewportView(taReais);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Dieta Litros de Água :");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Diferença Litros de Água:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Equivale a Tantos Banhos:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Equivale a Tantos Reais:");

        jMenuBar3.setBackground(new java.awt.Color(42, 187, 242));

        mnCadastro7.setText("Cadastro");
        mnCadastro7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCadastro7ActionPerformed(evt);
            }
        });

        btnCadastroPessoa4.setText("Cadastro Pessoa");
        btnCadastroPessoa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroPessoa4ActionPerformed(evt);
            }
        });
        mnCadastro7.add(btnCadastroPessoa4);

        btnCadastroComida7.setText("Cadastro Comida");
        btnCadastroComida7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroComida7ActionPerformed(evt);
            }
        });
        mnCadastro7.add(btnCadastroComida7);

        jMenuBar3.add(mnCadastro7);

        btnRefeicao7.setText("Refeição");
        btnRefeicao7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefeicao7ActionPerformed(evt);
            }
        });

        miRefNovaView2.setText("Nova Refeição");
        miRefNovaView2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRefNovaView2ActionPerformed(evt);
            }
        });
        btnRefeicao7.add(miRefNovaView2);

        btnRefeicaoHistoricoView2.setText("Histórico Refeição");
        btnRefeicaoHistoricoView2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefeicaoHistoricoView2ActionPerformed(evt);
            }
        });
        btnRefeicao7.add(btnRefeicaoHistoricoView2);

        jMenuBar3.add(btnRefeicao7);

        btnRelatório7.setText("Relatório");

        btnRelatorioPessoasView2.setText("Pessoas");
        btnRelatorioPessoasView2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioPessoasView2ActionPerformed(evt);
            }
        });
        btnRelatório7.add(btnRelatorioPessoasView2);

        btnRelatorioComidaView2.setText("Comida");
        btnRelatorioComidaView2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioComidaView2ActionPerformed(evt);
            }
        });
        btnRelatório7.add(btnRelatorioComidaView2);

        jMenuBar3.add(btnRelatório7);

        miCalcularImpacto2.setText("Impacto");

        miCalcImpacView2.setText("Calcular Impacto");
        miCalcImpacView2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCalcImpacView2ActionPerformed(evt);
            }
        });
        miCalcularImpacto2.add(miCalcImpacView2);

        miVisualizarImpactoView2.setText("Visualizar Impacto");
        miVisualizarImpactoView2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miVisualizarImpactoView2ActionPerformed(evt);
            }
        });
        miCalcularImpacto2.add(miVisualizarImpactoView2);

        jMenuBar3.add(miCalcularImpacto2);

        miCalcularDieta5.setText("Dieta");
        miCalcularDieta5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCalcularDieta5ActionPerformed(evt);
            }
        });

        miCalcularDietaView2.setText("Calcular Dieta");
        miCalcularDietaView2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCalcularDietaView2ActionPerformed(evt);
            }
        });
        miCalcularDieta5.add(miCalcularDietaView2);

        miVisualizarDietaView2.setText("Visualizar Dieta");
        miVisualizarDietaView2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miVisualizarDietaView2ActionPerformed(evt);
            }
        });
        miCalcularDieta5.add(miVisualizarDietaView2);

        jMenuBar3.add(miCalcularDieta5);

        miRankingGeral5.setText("Ranking");

        miRankingGeralView2.setText("Ranking Geral");
        miRankingGeralView2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRankingGeralView2ActionPerformed(evt);
            }
        });
        miRankingGeral5.add(miRankingGeralView2);

        jMenuBar3.add(miRankingGeral5);

        mnRemPesView1.setText("Remover");

        miRemPesView1.setText("Remover Pessoa");
        miRemPesView1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRemPesView1ActionPerformed(evt);
            }
        });
        mnRemPesView1.add(miRemPesView1);

        miRemRefeicaoView2.setText("Remover Refeição");
        miRemRefeicaoView2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRemRefeicaoView2ActionPerformed(evt);
            }
        });
        mnRemPesView1.add(miRemRefeicaoView2);

        jMenuBar3.add(mnRemPesView1);

        setJMenuBar(jMenuBar3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(186, 186, 186))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbPesDietVis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(cmbPesDietVis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbPesDietVisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPesDietVisActionPerformed
        
    }//GEN-LAST:event_cmbPesDietVisActionPerformed

    private void btnCadastroPessoa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroPessoa4ActionPerformed
        CadastroPessoaController cadPessoaController = new CadastroPessoaController(new CadastroPessoaView());
        cadPessoaController.exibirTela();
        dispose();
    }//GEN-LAST:event_btnCadastroPessoa4ActionPerformed

    private void btnCadastroComida7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroComida7ActionPerformed
        CadastroComidaController cadComidaController = new CadastroComidaController(new CadastroComidaView());
        cadComidaController.exibirTela();
        dispose();
    }//GEN-LAST:event_btnCadastroComida7ActionPerformed

    private void mnCadastro7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCadastro7ActionPerformed
        //Nada
    }//GEN-LAST:event_mnCadastro7ActionPerformed

    private void miRefNovaView2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRefNovaView2ActionPerformed
        RefeicaoNovaController refNovaController = new RefeicaoNovaController(new RefeicaoNovaView());
        refNovaController.exibirTela();
        dispose();
    }//GEN-LAST:event_miRefNovaView2ActionPerformed

    private void btnRefeicaoHistoricoView2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefeicaoHistoricoView2ActionPerformed
        RefeicaoHistoricoController refHistController = new RefeicaoHistoricoController(new RefeicaoHistoricoView());
        refHistController.exibirTela();
        dispose();
    }//GEN-LAST:event_btnRefeicaoHistoricoView2ActionPerformed

    private void btnRefeicao7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefeicao7ActionPerformed
        //Nada
    }//GEN-LAST:event_btnRefeicao7ActionPerformed

    private void btnRelatorioPessoasView2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioPessoasView2ActionPerformed
        RelatorioPessoaController relComidaController = new RelatorioPessoaController(new RelatorioPessoaView());
        relComidaController.exibeTela();
        dispose();
    }//GEN-LAST:event_btnRelatorioPessoasView2ActionPerformed

    private void btnRelatorioComidaView2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioComidaView2ActionPerformed
        RelatorioComidaController relComidaController = new RelatorioComidaController(new RelatorioComidaView());
        relComidaController.exibirTela();
        dispose();
    }//GEN-LAST:event_btnRelatorioComidaView2ActionPerformed

    private void miCalcImpacView2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCalcImpacView2ActionPerformed
        ImpactoCalcularController impacCalcController = new ImpactoCalcularController(new ImpactoCalcularView());
        impacCalcController.exibirTela();
        dispose();
    }//GEN-LAST:event_miCalcImpacView2ActionPerformed

    private void miVisualizarImpactoView2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miVisualizarImpactoView2ActionPerformed
        ImpactoVisualizarController impacVisuController = new ImpactoVisualizarController(new ImpactoVisualizarView());
        impacVisuController.exibirTela();
        dispose();
    }//GEN-LAST:event_miVisualizarImpactoView2ActionPerformed

    private void miCalcularDietaView2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCalcularDietaView2ActionPerformed
        DietaCalcularController dietaCalcularController = new DietaCalcularController(new DietaCalcularView());
        dietaCalcularController.exibirTela();
        dispose();
    }//GEN-LAST:event_miCalcularDietaView2ActionPerformed

    private void miVisualizarDietaView2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miVisualizarDietaView2ActionPerformed
        DietaVisualizarController dietaVisualizarController = new DietaVisualizarController(new DietaVisualizarView());
        dietaVisualizarController.exibirTela();
        dispose();
    }//GEN-LAST:event_miVisualizarDietaView2ActionPerformed

    private void miCalcularDieta5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCalcularDieta5ActionPerformed
        //Nada
    }//GEN-LAST:event_miCalcularDieta5ActionPerformed

    private void miRankingGeralView2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRankingGeralView2ActionPerformed
        RankingGeralController rankingGeralController = new RankingGeralController(new RankingGeralView());
        rankingGeralController.exibirTela();
        dispose();
    }//GEN-LAST:event_miRankingGeralView2ActionPerformed

    private void miRemPesView1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRemPesView1ActionPerformed
        RemoverPessoaController removerPessoaController = new RemoverPessoaController(new RemoverPessoaView());
        removerPessoaController.exibirTela();
        dispose();
    }//GEN-LAST:event_miRemPesView1ActionPerformed

    private void miRemRefeicaoView2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRemRefeicaoView2ActionPerformed
        RefeicaoRemoverController refRemController = new RefeicaoRemoverController(new RefeicaoRemoverView());
        refRemController.exibirTela();
        dispose();
    }//GEN-LAST:event_miRemRefeicaoView2ActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnCadastroComida7;
    private javax.swing.JMenuItem btnCadastroPessoa4;
    private javax.swing.JMenu btnRefeicao7;
    private javax.swing.JMenuItem btnRefeicaoHistoricoView2;
    private javax.swing.JMenuItem btnRelatorioComidaView2;
    private javax.swing.JMenuItem btnRelatorioPessoasView2;
    private javax.swing.JMenu btnRelatório7;
    private javax.swing.JComboBox<Pessoa> cmbPesDietVis;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JMenuItem miCalcImpacView2;
    private javax.swing.JMenu miCalcularDieta5;
    private javax.swing.JMenuItem miCalcularDietaView2;
    private javax.swing.JMenu miCalcularImpacto2;
    private javax.swing.JMenu miRankingGeral5;
    private javax.swing.JMenuItem miRankingGeralView2;
    private javax.swing.JMenuItem miRefNovaView2;
    private javax.swing.JMenuItem miRemPesView1;
    private javax.swing.JMenuItem miRemRefeicaoView2;
    private javax.swing.JMenuItem miVisualizarDietaView2;
    private javax.swing.JMenuItem miVisualizarImpactoView2;
    private javax.swing.JMenu mnCadastro7;
    private javax.swing.JMenu mnRemPesView1;
    private javax.swing.JTextArea taBanhos;
    private javax.swing.JTextArea taLitAguaImpac;
    private javax.swing.JTextArea taLitDif;
    private javax.swing.JTextArea taReais;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JComboBox<Pessoa> cmbPesDietaVis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JMenu miDieta;
    private javax.swing.JMenuItem miDietaCalcular;
    private javax.swing.JMenuItem miDietaVisualizar;
    private javax.swing.JMenu mnRanking5;

    
     
}
