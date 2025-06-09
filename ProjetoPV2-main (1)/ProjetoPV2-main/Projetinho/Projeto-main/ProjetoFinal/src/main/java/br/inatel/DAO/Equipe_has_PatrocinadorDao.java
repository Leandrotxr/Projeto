package br.inatel.DAO;

import br.inatel.futebol.campeonatos.Campeonato;
import br.inatel.futebol.pessoa_juridica.Equipe;
import br.inatel.futebol.pessoa_juridica.Patrocinador;

import java.sql.SQLException;

public class Equipe_has_PatrocinadorDao extends connectionDao{

    public void testConnection(){
        connectdToDb();
    }

    // insert
    public boolean insertEquipe_has_Patrocinador(Patrocinador patrocinador, Equipe equipe, int valor){
        connectdToDb();

        boolean sucesso;
        String sql = "insert into Equipe_has_Patrocinador (Patrocinador_cnpj, Equipe_cnpj, valor) values (?,?,?)";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1,patrocinador.getCnpj());
            pst.setString(2,equipe.getCnpj());
            pst.setInt(3, valor);
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
