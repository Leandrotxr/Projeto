package br.inatel.DAO;

import br.inatel.futebol.pessoa_juridica.Patrocinador;

import java.sql.SQLException;
import java.util.ArrayList;

public class PatrocinadorDao extends ConnectionDao{

    public void testConnection(){
        connectdToDb();
    }

    // insert
    public boolean insertPatrocinador(Patrocinador patrocinador){
        connectdToDb();

        boolean sucesso;
        String sql = "insert into Patrocinador (nome, cnpj) values (?,?)";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1,patrocinador.getNome());
            pst.setString(2,patrocinador.getCnpj());
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
    public boolean updatePatrocinador(String cnpj, Patrocinador patrocinador){
        connectdToDb();

        boolean sucesso;
        String sql = "update Patrocinador set nome = ?, cnpj = ? where cnpj = ?";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1,patrocinador.getNome());
            pst.setString(2,patrocinador.getCnpj());
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
        String sql = "delete from Patrocinador where cnpj = ?";
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

    public ArrayList<Patrocinador> selectPatrocinador(){
        connectdToDb();

        ArrayList<Patrocinador> patrocinadores = new ArrayList<>();
        String sql = "select * from Patrocinador";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de patrocinadores: ");
            while(rs.next()){
                Patrocinador patrocinadoraux = new Patrocinador(rs.getString("nome"),rs.getString("cnpj"));
                System.out.println("Nome: " + patrocinadoraux.getNome());
                System.out.println("--------------------------------------------------------------------------------------");
                patrocinadores.add(patrocinadoraux);
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
        return patrocinadores;
    }
}
