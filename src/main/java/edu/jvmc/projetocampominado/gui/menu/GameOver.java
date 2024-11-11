package edu.jvmc.projetocampominado.gui.menu;

import edu.jvmc.projetocampominado.Principal;
import edu.jvmc.projetocampominado.connection.Conexao;
import edu.jvmc.projetocampominado.model.Partida;
import java.sql.SQLException;

public class GameOver extends javax.swing.JPanel {

    private final Partida partida ;
    private final Principal framePai;
    Conexao conn = new Conexao();
    
    public GameOver(Principal framePai, Partida partida) throws SQLException {
        initComponents();
        this.framePai = framePai;
        this.partida = partida;
        txInfoNome.setText(partida.getNome());
        txInfoTempo.setText(Integer.toString(partida.getTempo())+" segundos");
        lbSitu.setText(lbSitu.getText() + partida.getSituacao()+ "!");
        conn.escreverDB(this.partida);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbSitu = new javax.swing.JLabel();
        btVoltar = new javax.swing.JButton();
        txInfoTempo = new javax.swing.JLabel();
        txInfoNome = new javax.swing.JLabel();
        lbImagem = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 204));
        setLayout(null);

        lbSitu.setBackground(new java.awt.Color(255, 255, 255));
        lbSitu.setFont(new java.awt.Font("Berlin Sans FB", 1, 28)); // NOI18N
        lbSitu.setForeground(new java.awt.Color(102, 0, 102));
        lbSitu.setText("VOCÊ ");
        add(lbSitu);
        lbSitu.setBounds(290, 200, 399, 52);

        btVoltar.setBackground(new java.awt.Color(102, 0, 102));
        btVoltar.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        btVoltar.setForeground(new java.awt.Color(255, 255, 255));
        btVoltar.setText("VOLTAR AO MENU PRINCIPAL");
        btVoltar.setBorder(null);
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });
        add(btVoltar);
        btVoltar.setBounds(290, 380, 230, 40);

        txInfoTempo.setBackground(new java.awt.Color(255, 255, 255));
        txInfoTempo.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        txInfoTempo.setForeground(new java.awt.Color(255, 255, 255));
        txInfoTempo.setText("Tempo");
        add(txInfoTempo);
        txInfoTempo.setBounds(360, 320, 190, 40);

        txInfoNome.setBackground(new java.awt.Color(255, 255, 255));
        txInfoNome.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        txInfoNome.setForeground(new java.awt.Color(255, 255, 255));
        txInfoNome.setText("Nome");
        add(txInfoNome);
        txInfoNome.setBounds(360, 280, 190, 40);

        lbImagem.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lbImagem.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\edu\\jvmc\\projetocampominado\\gui\\menu\\img\\game_over_sem.png"));
        add(lbImagem);
        lbImagem.setBounds(0, 0, 800, 500);
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        this.framePai.trocarPainel(new MenuInicial(this.framePai));
    }//GEN-LAST:event_btVoltarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel lbImagem;
    private javax.swing.JLabel lbSitu;
    private javax.swing.JLabel txInfoNome;
    private javax.swing.JLabel txInfoTempo;
    // End of variables declaration//GEN-END:variables
}
