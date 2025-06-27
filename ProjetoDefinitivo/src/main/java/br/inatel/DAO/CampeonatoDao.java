package br.inatel.DAO;

import br.inatel.futebol.campeonatos.Campeonato;

import java.sql.SQLException;
import java.util.ArrayList;

public class CampeonatoDao extends ConnectionDao{

    public void testConnection(){
        connectdToDb();
    }

    // insert
    public boolean insertCampeonato(Campeonato campeonato){
        connectdToDb();

        boolean sucesso;
        String sql = "insert into Campeonato (idCampeonato, nome, premiacao, localizacao, Federacao_cnpj) values (?,?,?,?,?)";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1,String.valueOf(campeonato.getIdCampeonato()));
            pst.setString(2,campeonato.getNome());
            pst.setString(3,String.valueOf(campeonato.getPremio()));
            pst.setString(4,campeonato.getLocal());
            pst.setString(5,campeonato.getFederacao().getCnpj());
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
    public boolean updateCampeonato(int idCampeonato, Campeonato campeonato){
        connectdToDb();

        boolean sucesso;
        String sql = "update Patrocinador set nome = ?, premiacao = ?, localizacao = ? where idCampeonato = ?";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1,campeonato.getNome());
            pst.setString(2,String.valueOf(campeonato.getPremio()));
            pst.setString(3,campeonato.getLocal());
            pst.setInt(4,idCampeonato);
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
    public boolean deleteCampeonato(int idCampeonato){
        connectdToDb();

        boolean sucesso;
        String sql = "delete from Campeonato where idCampeonato = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, String.valueOf(idCampeonato));
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

    public ArrayList<Campeonato> selectCampeonato(){
        connectdToDb();

        ArrayList<Campeonato> campeonatos = new ArrayList<>();
        String sql = "select * from Campeonato";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de campeonatos: ");
            while(rs.next()){
                Campeonato campeonatoraux = new Campeonato(rs.getString("nome"),rs.getString("localizacao"), rs.getInt("premiacao"), rs.getInt("idCampeonato"));
                System.out.println("Nome: " + campeonatoraux.getNome() + " | Prêmio: " + campeonatoraux.getPremio() + " | Localização: " + campeonatoraux.getLocal());
                System.out.println("--------------------------------------------------------------------");
                campeonatos.add(campeonatoraux);
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
        return campeonatos;
    }
}