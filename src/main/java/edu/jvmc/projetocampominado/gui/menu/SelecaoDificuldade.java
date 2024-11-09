/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package edu.jvmc.projetocampominado.gui.menu;

import edu.jvmc.projetocampominado.Principal;
import edu.jvmc.projetocampominado.gui.jogo.PainelJogo;
import edu.jvmc.projetocampominado.model.Partida;

/**
 *
 * @author Jarvis 3.0
 */
public class SelecaoDificuldade extends javax.swing.JPanel {

    Principal framePai;
    Partida partida = new Partida();
    public SelecaoDificuldade(Principal framePai) {
        initComponents();
        //this.setSize(800,500);
        this.framePai = framePai;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoDificuldades = new javax.swing.ButtonGroup();
        jRBFacil = new javax.swing.JRadioButton();
        jRBMedia = new javax.swing.JRadioButton();
        jRBDificil = new javax.swing.JRadioButton();
        btIniciar = new javax.swing.JButton();
        tfNick = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 102, 102));
        setName(""); // NOI18N
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(null);

        grupoDificuldades.add(jRBFacil);
        jRBFacil.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jRBFacilFocusLost(evt);
            }
        });
        jRBFacil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBFacilActionPerformed(evt);
            }
        });
        add(jRBFacil);
        jRBFacil.setBounds(50, 320, 110, 20);

        grupoDificuldades.add(jRBMedia);
        jRBMedia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jRBMediaFocusLost(evt);
            }
        });
        jRBMedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBMediaActionPerformed(evt);
            }
        });
        add(jRBMedia);
        jRBMedia.setBounds(50, 360, 100, 20);

        grupoDificuldades.add(jRBDificil);
        jRBDificil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBDificilActionPerformed(evt);
            }
        });
        add(jRBDificil);
        jRBDificil.setBounds(50, 400, 100, 20);

        btIniciar.setBackground(new java.awt.Color(255, 255, 255));
        btIniciar.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        btIniciar.setForeground(new java.awt.Color(51, 51, 51));
        btIniciar.setText("INICIAR");
        btIniciar.setEnabled(false);
        btIniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btIniciarMouseEntered(evt);
            }
        });
        btIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIniciarActionPerformed(evt);
            }
        });
        add(btIniciar);
        btIniciar.setBounds(40, 430, 90, 40);

        tfNick.setBackground(new java.awt.Color(255, 255, 255));
        tfNick.setColumns(1);
        tfNick.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        tfNick.setForeground(new java.awt.Color(51, 51, 51));
        tfNick.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfNickFocusLost(evt);
            }
        });
        tfNick.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                tfNickInputMethodTextChanged(evt);
            }
        });
        tfNick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNickActionPerformed(evt);
            }
        });
        tfNick.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfNickKeyReleased(evt);
            }
        });
        add(tfNick);
        tfNick.setBounds(40, 200, 270, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\edu\\jvmc\\projetocampominado\\gui\\menu\\img\\sem_1.png"));
        add(jLabel4);
        jLabel4.setBounds(0, 0, 800, 500);
    }// </editor-fold>//GEN-END:initComponents

    private void jRBMediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBMediaActionPerformed
        partida.setDificuldade("MÉDIA");
        if(!"".equals(tfNick.getText())&&(jRBMedia.isSelected()||jRBDificil.isSelected()||jRBFacil.isSelected())){
            btIniciar.setEnabled(true);
        }
    }//GEN-LAST:event_jRBMediaActionPerformed

    private void tfNickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNickActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNickActionPerformed

    private void tfNickFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfNickFocusLost
        if(!"".equals(tfNick.getText())&&(jRBMedia.isSelected()||jRBDificil.isSelected()||jRBFacil.isSelected())){
            btIniciar.setEnabled(true);
        }
    }//GEN-LAST:event_tfNickFocusLost

    private void btIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIniciarActionPerformed
        partida.setNome(tfNick.getText());
        this.framePai.trocarPainel(new PainelJogo(this.framePai,this.partida));
    }//GEN-LAST:event_btIniciarActionPerformed

    private void jRBDificilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBDificilActionPerformed
        partida.setDificuldade("DIFÍCIL");
        if(!"".equals(tfNick.getText())&&(jRBMedia.isSelected()||jRBDificil.isSelected()||jRBFacil.isSelected())){
            btIniciar.setEnabled(true);
        }
    }//GEN-LAST:event_jRBDificilActionPerformed

    private void jRBMediaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jRBMediaFocusLost
        
    }//GEN-LAST:event_jRBMediaFocusLost

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
        if(!"".equals(tfNick.getText())&&(jRBMedia.isSelected()||jRBDificil.isSelected()||jRBFacil.isSelected())){
            btIniciar.setEnabled(true);
        }
    }//GEN-LAST:event_formFocusLost

    private void tfNickInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tfNickInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNickInputMethodTextChanged

    private void tfNickKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNickKeyReleased
        if(!"".equals(tfNick.getText())&&(jRBMedia.isSelected()||jRBDificil.isSelected()||jRBFacil.isSelected())){
            btIniciar.setEnabled(true);
        }
    }//GEN-LAST:event_tfNickKeyReleased

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        if(!"".equals(tfNick.getText())&&(jRBMedia.isSelected()||jRBDificil.isSelected()||jRBFacil.isSelected())){
            btIniciar.setEnabled(true);
        }
    }//GEN-LAST:event_formFocusGained

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        
    }//GEN-LAST:event_formMouseClicked

    private void jRBFacilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBFacilActionPerformed
        partida.setDificuldade("FÁCIL");
        if(!"".equals(tfNick.getText())&&(jRBMedia.isSelected()||jRBDificil.isSelected()||jRBFacil.isSelected())){
            btIniciar.setEnabled(true);
        }
    }//GEN-LAST:event_jRBFacilActionPerformed

    private void jRBFacilFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jRBFacilFocusLost

    }//GEN-LAST:event_jRBFacilFocusLost

    private void btIniciarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btIniciarMouseEntered
        if("".equals(tfNick.getText())){
            btIniciar.setEnabled(false);
        }
    }//GEN-LAST:event_btIniciarMouseEntered

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btIniciar;
    private javax.swing.ButtonGroup grupoDificuldades;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton jRBDificil;
    private javax.swing.JRadioButton jRBFacil;
    private javax.swing.JRadioButton jRBMedia;
    private javax.swing.JTextField tfNick;
    // End of variables declaration//GEN-END:variables
}
