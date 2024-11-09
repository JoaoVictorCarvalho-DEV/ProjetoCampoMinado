package edu.jvmc.projetocampominado.gui.jogo;

import edu.jvmc.projetocampominado.gui.menu.GameOver;
import edu.jvmc.projetocampominado.Principal;
import edu.jvmc.projetocampominado.model.Partida;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jarvis 3.0
 */
public final class PainelJogo extends javax.swing.JPanel {
    Principal framePai;
    private boolean minaEncontrada;
    private int tijolosRevelados = 0;
    private final int tamanhoQuadrado = 70;
    private final int numLinhas = 8;
    private final int numColunas = numLinhas;
    private int qtdMinas;
    private final Partida partida;
    private Timer tm;
    private int contador = 0;
    TijolinhoMina[][] tabuleiro = new TijolinhoMina[numLinhas][numColunas];
    ArrayList<TijolinhoMina> listMina;

    public PainelJogo(Principal framePai,Partida partida){
        initComponents();
        this.framePai = framePai;
        this.partida = partida;
        setQtdMinas();
        mostrarInfo();
        criarTijolo(this);
        iniciarTimer();
    }
    
    public void iniciarTimer(){
        tm = new Timer();
        
        tm.scheduleAtFixedRate(new TimerTask(){
            
            @Override
            public void run(){
                contador++;
                lbTempo.setText(""+contador);
            }
        }, 1000, 1000);
    }
    
    public void mostrarInfo(){
        lbNick.setText(lbNick.getText()+ this.partida.getNome());
        lbDificuldade.setText(lbDificuldade.getText() + this.partida.getDificuldade());
    }
    
    public void criarTijolo(PainelJogo painel){
            for (int l = 0; l< painel.numLinhas; l++){
                for (int c = 0; c< painel.numColunas; c++){
                    TijolinhoMina tijolo = new TijolinhoMina(l, c);
                    tabuleiro[l][c] = tijolo;
                    
                    tijolo.setFocusable(false);
                    tijolo.setMargin(new Insets(0,0,0,0));
                    tijolo.setFont(new Font("Arial Unicode MS", Font.PLAIN, 45));

                    tijolo.addMouseListener(new MouseAdapter(){
                        
                     @Override
                     public void mousePressed(MouseEvent e){
                         TijolinhoMina tijolo = (TijolinhoMina) e.getSource();
                         
                         //botao esquerdo
                         if (e.getButton() == MouseEvent.BUTTON1 && minaEncontrada==false){
                            if (tijolo.getText()==""){//Ou seja, só pode clicar se tiver vazio
                                if(listMina.contains(tijolo)){
                                    minaEncontrada = true;
                                    revelarMinas();
                                    try {
                                        checarFinal();
                                    } catch (SQLException ex) {
                                        Logger.getLogger(PainelJogo.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }else{
                                    checarMina(tijolo.linha,tijolo.coluna);
                                    try {
                                        checarFinal();
                                    } catch (SQLException ex) {
                                        Logger.getLogger(PainelJogo.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            }
                        }
                         if(e.getButton()==MouseEvent.BUTTON3 && tijolo.isEnabled()){
                             if ("".equals(tijolo.getText())){//Ou seja, só pode clicar se tiver vazio
                                tijolo.setText("🚩");
                            }else if("🚩".equals(tijolo.getText())){
                                 tijolo.setText("");
                             }
                        }
                        } 
                    });
                    campoPainel.add(tijolo);
                }
            }
            addMinas(qtdMinas);
        }
    
    //adição das minas
    void addMinas(int qtdDesejadaMinas){
        listMina = new ArrayList<TijolinhoMina>();
        Random randomizador = new Random();
        int minasPosicionadas = 0;
        while(minasPosicionadas<qtdDesejadaMinas){
            int coluna = randomizador.nextInt(numLinhas);
            int linha = randomizador.nextInt(numColunas);
            if (!listMina.contains(tabuleiro[coluna][linha])){
                listMina.add(tabuleiro[coluna][linha]);
                minasPosicionadas++;
            }
            
        }
    }
    
    public void setQtdMinas() {
        String dificuldade = this.partida.getDificuldade();
        switch (dificuldade) {
            case "FÁCIL":
                qtdMinas = 5;
                break;
            case "MÉDIA":
                qtdMinas = 8;
                break;
            case "DIFÍCIL":
                qtdMinas = 14;
                break;
        }
    }
    
    void revelarMinas(){
        for (int i = 0; i<listMina.size(); i++){
            TijolinhoMina tijolo = listMina.get(i);
            tijolo.setText("💣");
        }
    }
    
    void checarMina(int linha, int coluna){
        //CASO BASE 1
        if (linha <0 || linha>=numLinhas || coluna < 0 || coluna >=numColunas){//primeiro caso base
            return;
        }
        TijolinhoMina tijolo = tabuleiro[linha][coluna];
        //CASO BASE 2
        if(!tijolo.isEnabled()){
            return;
        }
        tijolo.setEnabled(false);
        
        int minaEncontradas = 0;
        tijolosRevelados++;
        //verificando se há bombas
        //topo
        minaEncontradas +=contarMina(linha-1,coluna-1);//topo e esquerda
        minaEncontradas +=contarMina(linha-1,coluna);  //topo
        minaEncontradas +=contarMina(linha-1,coluna+1);//topo e direita e por aí vai
        
        //lados
        minaEncontradas +=contarMina(linha, coluna-1);
        minaEncontradas +=contarMina(linha,coluna+1);
        
        //baixo
        minaEncontradas +=contarMina(linha+1,coluna-1);
        minaEncontradas +=contarMina(linha+1,coluna);
        minaEncontradas +=contarMina(linha+1,coluna+1);
        
        if (minaEncontradas>0){
            tijolo.setText(Integer.toString(minaEncontradas));
        }else{
            tijolo.setText(" ");
            //
            //usar a recursão aqui, verificando se as minas vizinhas tem minas e suas seguintes
            //
            
            //topo
            checarMina(linha-1, coluna-1);
            checarMina(linha-1, coluna);
            checarMina(linha-1, coluna+1);
            //lados
            checarMina(linha, coluna-1);
            checarMina(linha, coluna+1);
            //baixo
            checarMina(linha+1,coluna-1);
            checarMina(linha+1, coluna);
            checarMina(linha+1, coluna+1);
        }
        
    }
    int contarMina(int linha, int coluna){
        if (linha <0 || linha>=numLinhas || coluna < 0 || coluna >=numColunas){
            return 0;
        }
        if(listMina.contains(tabuleiro[linha][coluna])){
            return 1;
        }
        return 0;
    }
    
    public void finalizarJogo() throws SQLException{
        this.partida.setTempo(contador);
        this.framePai.trocarPainel(new GameOver(this.framePai, this.partida));
        tm.cancel();
    }
    
    public void  checarFinal() throws SQLException{
        if(tijolosRevelados==(numColunas*numLinhas)-qtdMinas){
            this.partida.setSituacao("VENCEU");
            finalizarJogo();
        }else{
            this.partida.setSituacao("PERDEU");
        }
    }
 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbDificuldade = new javax.swing.JLabel();
        lbNick = new javax.swing.JLabel();
        lbTempo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        campoPainel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(800, 500));
        setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Campo Minado");
        jLabel1.setOpaque(true);

        lbDificuldade.setText("Dificuldade: ");

        lbNick.setText("Nome: ");

        lbTempo.setText("0");

        jLabel2.setText("Tempo de jogo: ");

        jButton1.setText("TERMINAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout txPanelLayout = new javax.swing.GroupLayout(txPanel);
        txPanel.setLayout(txPanelLayout);
        txPanelLayout.setHorizontalGroup(
            txPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txPanelLayout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(186, Short.MAX_VALUE))
            .addGroup(txPanelLayout.createSequentialGroup()
                .addGroup(txPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNick, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDificuldade, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(140, 140, 140)
                .addComponent(jLabel2)
                .addGap(8, 8, 8)
                .addComponent(lbTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1))
        );
        txPanelLayout.setVerticalGroup(
            txPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txPanelLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(txPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txPanelLayout.createSequentialGroup()
                        .addComponent(lbNick)
                        .addGap(0, 0, 0)
                        .addComponent(lbDificuldade))
                    .addGroup(txPanelLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(txPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbTempo)
                            .addComponent(jButton1)))
                    .addGroup(txPanelLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel2))))
        );

        add(txPanel, java.awt.BorderLayout.NORTH);

        campoPainel.setBackground(new java.awt.Color(255, 255, 255));
        campoPainel.setLayout(new java.awt.GridLayout(this.numLinhas, this.numColunas));
        add(campoPainel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            checarFinal();
        } catch (SQLException ex) {
            Logger.getLogger(PainelJogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel campoPainel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbDificuldade;
    private javax.swing.JLabel lbNick;
    private javax.swing.JLabel lbTempo;
    private javax.swing.JPanel txPanel;
    // End of variables declaration//GEN-END:variables
}
