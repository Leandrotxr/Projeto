package br.inatel.DAO;

import br.inatel.futebol.pessoa_fisica.Arbitro;

import java.sql.SQLException;
import java.util.ArrayList;

public class ArbitroDao extends ConnectionDao{

    public void testConnection(){
        connectdToDb();
    }

    // insert
    public boolean insertArbitro(Arbitro arbitro){
        connectdToDb();

        boolean sucesso;
        String sql = "insert into Arbitro (nome, idade, cpf, Federacao_cnpj) values (?,?,?,?)";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1,arbitro.getNome());
            pst.setString(2,String.valueOf(arbitro.getIdade()));
            pst.setString(3,arbitro.getCpf());
            pst.setString(4,arbitro.getFederacao().getCnpj());
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
    public boolean updateArbitro(String cpf, Arbitro arbitro){
        connectdToDb();

        boolean sucesso;
        String sql = "update Arbitro set nome = ?,idade = ?, cpf = ?, Federacao_cnpj = ?  where cpf = ?";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1,arbitro.getNome());
            pst.setString(2,String.valueOf(arbitro.getIdade()));
            pst.setString(3,arbitro.getCpf());
            pst.setString(4,arbitro.getFederacao().getCnpj());
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
    public boolean deleteArbitro(String cpf){
        connectdToDb();

        boolean sucesso;
        String sql = "delete from Arbitro where cpf = ?";
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

    public ArrayList<Arbitro> selectArbitro(){
        connectdToDb();

        ArrayList<Arbitro> arbitros = new ArrayList<>();
        String sql = "select * from Arbitro";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de arbitros: ");
            while(rs.next()){
                Arbitro arbitroAux = new Arbitro(rs.getString("nome"), rs.getInt("idade"), rs.getString("cpf"));
                System.out.println("Nome: " + arbitroAux.getNome() + " CPF: " + arbitroAux.getCpf());
                System.out.println("-----------------------------------------");
                arbitros.add(arbitroAux);
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
        return arbitros;
    }
}