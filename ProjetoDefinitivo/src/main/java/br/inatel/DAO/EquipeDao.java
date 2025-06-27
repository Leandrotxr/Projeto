package br.inatel.DAO;

import br.inatel.futebol.pessoa_juridica.Equipe;

import java.sql.SQLException;
import java.util.ArrayList;

public class EquipeDao extends ConnectionDao{

    public void testConnection(){
        connectdToDb();
    }

    // insert
    public boolean insertEquipe(Equipe equipe){
        connectdToDb();

        boolean sucesso;
        String sql = "insert into Equipe (nome, fundacao, sede, cnpj, tecnico_cpf) values (?,?,?,?,?)";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1,equipe.getNome());
            pst.setString(2,String.valueOf(equipe.getFundacao()));
            pst.setString(3,equipe.getSede());
            pst.setString(4,equipe.getCnpj());
            pst.setString(5,equipe.getTecnico().getCpf());
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
    public boolean updateEquipe(String cnpj, Equipe equipe){
        connectdToDb();

        boolean sucesso;
        String sql = "update Equipe set nome = ?,fundacao = ?, sede = ?, cnpj = ?, tecnico_cpf = ? where cnpj = ?";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1,equipe.getNome());
            pst.setString(2,String.valueOf(equipe.getFundacao()));
            pst.setString(3,equipe.getSede());
            pst.setString(4, equipe.getCnpj());
            pst.setString(5,equipe.getTecnico().getCpf());
            pst.setString(6,String.valueOf(cnpj));
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

    public boolean updateEquipeSemTecnico(String cnpj, Equipe equipe){
        connectdToDb();

        boolean sucesso;
        String sql = "update Equipe set tecnico_cpf = null where cnpj = ?";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1,String.valueOf(cnpj));
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
    public boolean deleteEquipe(String cnpj){
        connectdToDb();

        boolean sucesso;
        String sql = "delete from Tecnico where cnpj = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1,cnpj);
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

    public ArrayList<Equipe> selectEquipe(){
        connectdToDb();

        ArrayList<Equipe> equipes = new ArrayList<>();
        String sql = "select * from Equipe";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de equipes: ");
            while(rs.next()){
                Equipe equipeaux = new Equipe(rs.getString("nome"),rs.getString("cnpj"), rs.getInt("fundacao"), rs.getString("sede"));
                System.out.println("Nome: " + equipeaux.getNome() + " | Fundação: " + equipeaux.getFundacao() + " | Sede: " + equipeaux.getSede());
                System.out.println("-------------------------------------------------------------------------------");
                equipes.add(equipeaux);
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
        return equipes;
    }
}
