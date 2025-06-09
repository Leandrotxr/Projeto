package br.inatel.DAO;

import br.inatel.Model.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao extends connectionDao{

    public void testConnection(){
        connectdToDb();
    }

    // insert
    public boolean insertUser(User user){
        connectdToDb();

        boolean sucesso;
        String sql = "insert into usuario (nome, cpf) values(?,?)";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1,user.getNome());
            pst.setString(2,user.getCpf());
            pst.execute();
            sucesso = true;
        }catch (SQLException exc){
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try{
                con.close();
                pst.close();
            }catch (SQLException exc){
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    // update
    public boolean updateUser(int id, User user){
        connectdToDb();

        boolean sucesso;
        String sql = "update usuario set nome = ?, cpf = ? where id = ?";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1,user.getNome());
            pst.setString(2,user.getCpf());
            pst.setString(3,String.valueOf(id));
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            }catch (SQLException exc){
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    // delete
    public boolean deleteUser(int id){
        connectdToDb();

        boolean sucesso;
        String sql = "delete from usuario where id = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,id);
            pst.execute();
            sucesso = true;
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException exc){
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    // select

    public ArrayList<User> selectUser(){
        connectdToDb();

        ArrayList<User> users = new ArrayList<>();
        String sql = "select * from usuario";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de usuários: ");
            while(rs.next()){
                User userAux = new User(rs.getString("nome"), rs.getString("cpf"), rs.getString("id"));
                System.out.println("Nome: " + userAux.getNome() + " CPF: " + userAux.getCpf());
                System.out.println("-----------------------------------------");
                users.add(userAux);
            }
        } catch (SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
        } finally {
            try {
                con.close();
                st.close();
                rs.close();
            }catch (SQLException exc){
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return users;
    }
}
