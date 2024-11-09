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
        txInfo.setText(this.partida.toString());
        lbSitu.setText(lbSitu.getText() + partida.getSituacao()+ "!");
        conn.escreverDB(this.partida);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbSitu = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btVoltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txInfo = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(204, 255, 204));

        lbSitu.setFont(new java.awt.Font("Arial Black", 3, 36)); // NOI18N
        lbSitu.setForeground(new java.awt.Color(0, 0, 0));
        lbSitu.setText("VOCÊ ");

        jLabel2.setFont(new java.awt.Font("Arial Black", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("GAME OVER");

        btVoltar.setText("VOLTAR AO MENU PRINCIPAL");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        txInfo.setColumns(20);
        txInfo.setRows(5);
        txInfo.setFocusable(false);
        jScrollPane1.setViewportView(txInfo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbSitu, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(157, 157, 157))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(269, 269, 269))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(293, 293, 293))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(282, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(259, 259, 259)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(lbSitu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(112, 112, 112)
                    .addComponent(jLabel2)
                    .addContainerGap(336, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        this.framePai.trocarPainel(new MenuInicial(this.framePai));
    }//GEN-LAST:event_btVoltarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbSitu;
    private javax.swing.JTextArea txInfo;
    // End of variables declaration//GEN-END:variables
}
