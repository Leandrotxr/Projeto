package br.inatel.DAO;

import br.inatel.futebol.campeonatos.Campeonato;
import br.inatel.futebol.pessoa_juridica.Equipe;

import java.sql.SQLException;

public class Equipe_has_CampeonatoDao extends ConnectionDao{

    public void testConnection(){
        connectdToDb();
    }

    // insert
    public boolean insertEquipe_has_Campeonato(Campeonato campeonato, Equipe equipe){
        connectdToDb();

        boolean sucesso;
        String sql = "insert into Equipe_has_Campeonato (Campeonato_idCampeonato, Equipe_cnpj) values (?,?)";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1,String.valueOf(campeonato.getIdCampeonato()));
            pst.setString(2,equipe.getCnpj());
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
}