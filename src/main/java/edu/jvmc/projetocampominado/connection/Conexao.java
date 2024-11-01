/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.jvmc.projetocampominado.connection;

import edu.jvmc.projetocampominado.model.Partida;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class Conexao {
    
    public ArrayList lerDB() throws SQLException{
        Connection conexao = null;
        ArrayList resultado = new ArrayList();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/db_cm", "root", "");
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
    
}
