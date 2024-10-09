
package edu.jvmc.projetocampominado.gui.jogo;

import javax.swing.JButton;

/**
 *
 * @author Jarvis 3.0
 */
public class modeloCampoMinado{
    private class TijolinhoMina extends JButton{
        int linha;
        int coluna;
        
        public TijolinhoMina(int linha, int coluna){
            this.linha = linha;
            this.coluna = coluna;
        }
    }
    
    
}
