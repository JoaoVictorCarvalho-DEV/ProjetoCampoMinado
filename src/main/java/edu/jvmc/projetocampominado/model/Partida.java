/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.jvmc.projetocampominado.model;

/**
 *
 * @author Jarvis 3.0
 */
public class Partida {
    private String nome;
    private String situacao = "Perdeu";
    private String dificuldade;
    private int tempo;

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }
    
    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    @Override
    public String toString(){
        String infos = "Nickname: " + this.nome + "\n" +
                       "Dificuldade: " + this.dificuldade + "\n" +
                        "Tempo: " + this.tempo + " segundos";
        return infos;
    }
    
}
