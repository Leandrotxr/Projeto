package br.inatel.DAO;

import br.inatel.futebol.pessoa_fisica.Tecnico;

import java.sql.SQLException;
import java.util.ArrayList;

public class TecnicoDao extends ConnectionDao{

    public void testConnection(){
        connectdToDb();
    }

    // insert
    public boolean insertTecnico(Tecnico tecnico){
        connectdToDb();

        boolean sucesso;
        String sql = "insert into Tecnico (nome, idade, cpf, nacionalidade) values (?,?,?,?)";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1,tecnico.getNome());
            pst.setString(2,String.valueOf(tecnico.getIdade()));
            pst.setString(3,tecnico.getCpf());
            pst.setString(4,tecnico.getNacionalidade());
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
    public boolean updateTecnico(String cpf, Tecnico tecnico){
        connectdToDb();

        boolean sucesso;
        String sql = "update Tecnico set nome = ?,idade = ?, cpf = ?, nacionalidade = ? where cpf = ?";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1,tecnico.getNome());
            pst.setString(2,String.valueOf(tecnico.getIdade()));
            pst.setString(3,tecnico.getCpf());
            pst.setString(4,tecnico.getNacionalidade());
            pst.setString(5,String.valueOf(cpf));
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
    public boolean deleteTecnico(String cpf){
        connectdToDb();

        boolean sucesso;
        String sql = "delete from Tecnico where cpf = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1,cpf);
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

    public ArrayList<Tecnico> selectTecnico(){
        connectdToDb();

        ArrayList<Tecnico> tecnicos = new ArrayList<>();
        String sql = "select * from Tecnico";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de tecnicos: ");
            while(rs.next()){
                Tecnico tecnicoaux = new Tecnico(rs.getString("nome"), rs.getInt("idade"), rs.getString("cpf"),rs.getString("nacionalidade"));
                System.out.println("Nome: " + tecnicoaux.getNome() + " | Idade: " + tecnicoaux.getIdade() + " | Nacionalidade: " + tecnicoaux.getNacionalidade());
                System.out.println("------------------------------------------------------------------------");
                tecnicos.add(tecnicoaux);
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
        return tecnicos;
    }

    public void selectEquipesComTecnicos() {
        connectdToDb();

        String sql = "SELECT Equipe.nome AS nomeEquipe, Tecnico.nome AS nomeTecnico " +
                "FROM Equipe " +
                "JOIN Tecnico ON Equipe.Tecnico_cpf = Tecnico.cpf";

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                String nomeEquipe = rs.getString("nomeEquipe");
                String nomeTecnico = rs.getString("nomeTecnico");

                System.out.println("Equipe: " + nomeEquipe + " | Técnico: " + nomeTecnico);
            }

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }

}

