package br.inatel.DAO;

import java.sql.*;

public abstract class connectionDao {

    Connection con; //conexão
    PreparedStatement pst; //declaração (query) preparada - código em sql
    Statement st; //declaração (query) - código em sql
    ResultSet rs; //resposta do banco

    String database = "projeto";
    String user = "root";
    String password = "Le@ndroid3";
    String url = "jdbc:mysql://localhost:3306/" + database;

    public void connectdToDb() {
        try{
            con = DriverManager.getConnection(url, user, password);
            //System.out.println("Conectado com sucesso!");
        } catch(SQLException exc){
            System.out.println("Erro: " + exc.getMessage());
        }
    }
}
