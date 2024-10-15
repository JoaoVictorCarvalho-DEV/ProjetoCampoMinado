/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package edu.jvmc.projetocampominado.gui.jogo;

import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
 
/**
 *
 * @author Jarvis 3.0
 */
public final class PainelJogo extends javax.swing.JPanel {
    int minasEncontradas = 0;
    public PainelJogo(){
        initComponents();
        criarTijolo(this);
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
                         if (e.getButton() == MouseEvent.BUTTON1){
                            if (tijolo.getText()==""){//Ou seja, só pode clicar se tiver vazio
                                if(listMina.contains(tijolo)){
                                    revelarMinas();
                                }else{
                                    checarMina(tijolo.linha,tijolo.coluna);
                                }
                            }
                         }
                         if(e.getButton()==MouseEvent.BUTTON3 && tijolo.isEnabled()){
                             if (tijolo.getText()==""){//Ou seja, só pode clicar se tiver vazio
                                tijolo.setText("🚩");
                            }else if(tijolo.getText()=="🚩"){
                                 tijolo.setText("");
                             }
                         }
                        } 
                    });
                    
                    campoPainel.add(tijolo);
                }
            }
            addMinas();
        }
    
    //adição das minas
    void addMinas(){
        listMina = new ArrayList<TijolinhoMina>();
        
        listMina.add(tabuleiro[3][2]);
        listMina.add(tabuleiro[5][3]);
        listMina.add(tabuleiro[5][6]);
        listMina.add(tabuleiro[7][4]);
        listMina.add(tabuleiro[1][4]);
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
        
        int minaEncontrada = 0;
        
        //verificando se há bombas
        //em cima
        minaEncontrada +=contarMina(linha-1,coluna-1);//topo e esquerda
        minaEncontrada +=contarMina(linha-1,coluna);  //topo
        minaEncontrada +=contarMina(linha-1,coluna+1);//topo e direita e por aí vai
        
        //lados
        minaEncontrada +=contarMina(linha, coluna-1);
        minaEncontrada +=contarMina(linha,coluna+1);
        
        //em baixo
        minaEncontrada +=contarMina(linha+1,coluna-1);
        minaEncontrada +=contarMina(linha+1,coluna);
        minaEncontrada +=contarMina(linha+1,coluna+1);
        
        if (minaEncontrada>0){
            tijolo.setText(Integer.toString(minaEncontrada));
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
    
    int tamanhoQuadrado = 70;
    int numLinhas = 8;
    int numColunas = numLinhas;
    int larguraTela = tamanhoQuadrado * numColunas;
    int alturaTela = tamanhoQuadrado * numLinhas;
    
    TijolinhoMina[][] tabuleiro = new TijolinhoMina[numLinhas][numColunas];
    ArrayList<TijolinhoMina> listMina;
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        campoPainel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(800, 500));
        setLayout(new java.awt.BorderLayout());

        txPanel.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Campo Minado");
        jLabel1.setOpaque(true);
        txPanel.add(jLabel1, java.awt.BorderLayout.NORTH);

        add(txPanel, java.awt.BorderLayout.NORTH);

        campoPainel.setBackground(new java.awt.Color(255, 255, 255));
        campoPainel.setLayout(new java.awt.GridLayout(this.numLinhas, this.numColunas));
        add(campoPainel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel campoPainel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel txPanel;
    // End of variables declaration//GEN-END:variables
}
