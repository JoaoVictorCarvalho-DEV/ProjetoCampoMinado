/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package edu.jvmc.projetocampominado.gui.menu;

import edu.jvmc.projetocampominado.Principal;
import edu.jvmc.projetocampominado.gui.jogo.PainelJogo;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jarvis 3.0
 */
public class MenuInicial extends javax.swing.JPanel {

    /**
     * Creates new form MenuInicial
     */
    Principal framePai;
    public MenuInicial(Principal framePai) {
        initComponents();
        this.framePai = framePai;
        //this.setSize(800,500);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btPontuacao = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btJogar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 51));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setOpaque(false);
        setLayout(null);

        btPontuacao.setBackground(new java.awt.Color(255, 255, 255));
        btPontuacao.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        btPontuacao.setForeground(new java.awt.Color(51, 51, 51));
        btPontuacao.setText("PLACAR");
        btPontuacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btPontuacaoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btPontuacaoMouseExited(evt);
            }
        });
        btPontuacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPontuacaoActionPerformed(evt);
            }
        });
        add(btPontuacao);
        btPontuacao.setBounds(330, 330, 130, 60);

        jPanel1.setBackground(new java.awt.Color(50, 50, 50));
        jPanel1.setLayout(null);

        btJogar.setBackground(new java.awt.Color(255, 255, 255));
        btJogar.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        btJogar.setForeground(new java.awt.Color(51, 51, 51));
        btJogar.setText("JOGAR");
        btJogar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btJogarFocusGained(evt);
            }
        });
        btJogar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btJogarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btJogarMouseExited(evt);
            }
        });
        btJogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btJogarActionPerformed(evt);
            }
        });
        jPanel1.add(btJogar);
        btJogar.setBounds(120, 330, 130, 60);

        btSair.setBackground(new java.awt.Color(255, 255, 255));
        btSair.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        btSair.setForeground(new java.awt.Color(51, 51, 51));
        btSair.setText("SAIR");
        btSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSairMouseClicked(evt);
            }
        });
        jPanel1.add(btSair);
        btSair.setBounds(550, 330, 130, 60);

        jLabel2.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\edu\\jvmc\\projetocampominado\\gui\\menu\\img\\Tela_inicial_sem_botoes.png"));
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 800, 500);

        add(jPanel1);
        jPanel1.setBounds(0, 0, 800, 500);
    }// </editor-fold>//GEN-END:initComponents

    private void btJogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btJogarActionPerformed
        this.framePai.trocarPainel(new SelecaoDificuldade(framePai));
    }//GEN-LAST:event_btJogarActionPerformed

    private void btJogarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btJogarFocusGained
        
    }//GEN-LAST:event_btJogarFocusGained

    private void btJogarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btJogarMouseEntered
        btJogar.setBackground(new java.awt.Color(150, 150, 150));
    }//GEN-LAST:event_btJogarMouseEntered

    private void btJogarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btJogarMouseExited
       btJogar.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_btJogarMouseExited
    private void btPontuacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPontuacaoActionPerformed
        try {
            this.framePai.trocarPainel(new Pontuacao(this.framePai));
        } catch (SQLException ex) {
            System.out.println("Erro SQL:"+ ex);
        }
    }//GEN-LAST:event_btPontuacaoActionPerformed

    private void btPontuacaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btPontuacaoMouseEntered
        btPontuacao.setBackground(new java.awt.Color(150, 150, 150));
    }//GEN-LAST:event_btPontuacaoMouseEntered

    private void btPontuacaoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btPontuacaoMouseExited
        btPontuacao.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_btPontuacaoMouseExited

    private void btSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSairMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btSairMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btJogar;
    private javax.swing.JButton btPontuacao;
    private javax.swing.JButton btSair;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
