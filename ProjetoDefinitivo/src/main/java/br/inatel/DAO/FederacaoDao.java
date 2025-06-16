package br.inatel.DAO;

import br.inatel.futebol.pessoa_juridica.Federacao;

import java.sql.SQLException;
import java.util.ArrayList;

public class FederacaoDao extends ConnectionDao{

    public void testConnection(){
        connectdToDb();
    }

    // insert
    public boolean insertFederacao(Federacao federacao){
        connectdToDb();

        boolean sucesso;
        String sql = "insert into Federacao (nome, cnpj) values (?,?)";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1,federacao.getNome());
            pst.setString(2,federacao.getCnpj());
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
    public boolean updateFederacao(String cnpj, Federacao federacao){
        connectdToDb();

        boolean sucesso;
        String sql = "update Federacao set nome = ?, cnpj = ? where cnpj = ?";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1,federacao.getNome());
            pst.setString(2,federacao.getCnpj());
            pst.setString(3,String.valueOf(cnpj));
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
    public boolean deleteFederacao(String cnpj){
        connectdToDb();

        boolean sucesso;
        String sql = "delete from Federacao where cnpj = ?";
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

    public ArrayList<Federacao> selectFederacao(){
        connectdToDb();

        ArrayList<Federacao> federacoes = new ArrayList<>();
        String sql = "select * from Federacao";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de federacões: ");
            while(rs.next()){
                Federacao federacaoaux = new Federacao(rs.getString("nome"),rs.getString("cnpj"));
                System.out.println("Nome: " + federacaoaux.getNome() + " CNPJ: " + federacaoaux.getCnpj());
                System.out.println("-----------------------------------------");
                federacoes.add(federacaoaux);
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
        return federacoes;
    }
}
