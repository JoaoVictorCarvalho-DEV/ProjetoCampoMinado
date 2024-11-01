/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.jvmc.projetocampominado.connection;

import edu.jvmc.projetocampominado.model.Partida;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost/db_cm";
    private static final String USER = "root";
    private static final String PASS = "";
    private Connection conexao = null;
    
    public ArrayList lerDB() throws SQLException{
        ArrayList resultado = new ArrayList();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection(URL, USER, PASS);
            ResultSet rsCliente = conexao.createStatement().executeQuery("SELECT * FROM jogadas");
            
            while (rsCliente.next()){
                Partida partidaAtual = new Partida();
                partidaAtual.setNome(rsCliente.getString("nome"));
                partidaAtual.setSituacao(rsCliente.getString("situacao"));
                partidaAtual.setTempo(rsCliente.getInt("tempo"));
                partidaAtual.setDificuldade(rsCliente.getString("dificuldade"));
                resultado.add(partidaAtual);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver do banco de dados não localizado");
        }catch(SQLException ex){
            System.out.println("Ocorreu um erro ao acessar o banco: "+ ex.getMessage());
        }finally{
            if (conexao != null){
                conexao.close();
            }
        }
        return resultado;
    }
    
    public void escreverDB(Partida partida) throws SQLException{
        String nome = partida.getNome();
        String situacao = partida.getSituacao();
        int tempo = partida.getTempo();
        String dificuldade = partida.getDificuldade();
        
        String sql = "INSERT INTO jogadas (nome, situacao , tempo, dificuldade) VALUES (?, ?, ?, ?)";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            
            pstmt.setString(1, nome);
            pstmt.setString(2, situacao);
            pstmt.setInt(3, tempo);
            pstmt.setString(4,dificuldade);
            
            int linhasAfetadas = pstmt.executeUpdate();
            
            System.out.println("Insercao bem-sucedida! Linhas afetadas: " + linhasAfetadas);
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver do banco de dados não localizado");
        }catch(SQLException ex){
            System.out.println("Ocorreu um erro ao acessar o banco: "+ ex.getMessage());
        }finally{
            if (conexao != null){
                conexao.close();
            }
        }
    }
    
    
    
}
