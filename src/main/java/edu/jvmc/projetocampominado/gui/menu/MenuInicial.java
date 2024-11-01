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

        jLabel1 = new javax.swing.JLabel();
        btJogar = new javax.swing.JButton();
        btPontuacao = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(0, 153, 51));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setOpaque(false);
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 36)); // NOI18N
        jLabel1.setText("CAMPO MINADO");
        add(jLabel1);
        jLabel1.setBounds(220, 100, 390, 70);

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
        add(btJogar);
        btJogar.setBounds(300, 270, 180, 27);

        btPontuacao.setText("PONTUAÇÕES");
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
        btPontuacao.setBounds(300, 330, 180, 27);

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(jPanel2);
        jPanel2.setBounds(190, 80, 410, 100);

        jPanel1.setBackground(new java.awt.Color(0, 153, 0));
        jPanel1.setLayout(null);
        add(jPanel1);
        jPanel1.setBounds(0, 0, 800, 510);
    }// </editor-fold>//GEN-END:initComponents

    private void btJogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btJogarActionPerformed
        this.framePai.trocarPainel(new SelecaoDificuldade(framePai));
    }//GEN-LAST:event_btJogarActionPerformed

    private void btJogarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btJogarFocusGained
        
    }//GEN-LAST:event_btJogarFocusGained

    private void btJogarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btJogarMouseEntered
        btJogar.setText("💣"+btJogar.getText()+"💣");
    }//GEN-LAST:event_btJogarMouseEntered

    private void btJogarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btJogarMouseExited
       btJogar.setText("JOGAR");
    }//GEN-LAST:event_btJogarMouseExited

    private void btPontuacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPontuacaoActionPerformed
        btPontuacao.setText("💥"+btPontuacao.getText()+"💥");
    }//GEN-LAST:event_btPontuacaoActionPerformed

    private void btPontuacaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btPontuacaoMouseEntered
        btPontuacao.setText("💣"+btPontuacao.getText()+"💣");
    }//GEN-LAST:event_btPontuacaoMouseEntered

    private void btPontuacaoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btPontuacaoMouseExited
       btPontuacao.setText("PONTUAÇÃO");
        try {
            this.framePai.trocarPainel(new Pontuacao());
        } catch (SQLException ex) {
            System.out.println("Erro SQL:"+ ex);
        }
    }//GEN-LAST:event_btPontuacaoMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btJogar;
    private javax.swing.JButton btPontuacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
