package edu.jvmc.projetocampominado.gui.jogo;

import javax.swing.JButton;

public class TijolinhoMina extends JButton {
        int linha;
        int coluna;
        
        public TijolinhoMina(int linha, int coluna){
            this.linha = linha;
            this.coluna = coluna;
        }
}
