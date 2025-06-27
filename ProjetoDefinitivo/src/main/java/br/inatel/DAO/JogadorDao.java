package br.inatel.DAO;

import br.inatel.futebol.pessoa_fisica.Jogador;

import java.sql.SQLException;
import java.util.ArrayList;

public class JogadorDao extends ConnectionDao{

    public void testConnection(){
        connectdToDb();
    }

    // insert
    public boolean insertJogador(Jogador jogador){
        connectdToDb();

        boolean sucesso;
        String sql = "insert into Jogador (nome, idade, cpf, nacionalidade, posicao, Equipe_cnpj) values (?,?,?,?,?,?)";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1,jogador.getNome());
            pst.setString(2,String.valueOf(jogador.getIdade()));
            pst.setString(3,jogador.getCpf());
            pst.setString(4,jogador.getNacionalidade());
            pst.setString(5,jogador.getPosicao());
            pst.setString(6,jogador.getEquipe().getCnpj());
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
    public boolean updateJogador(String cpf, Jogador jogador){
        connectdToDb();

        boolean sucesso;
        String sql = "update Jogador set nome = ?,idade = ?, cpf = ?, nacionalidade = ?, posicao = ?, Equipe_cnpj = ? where cpf = ?";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1,jogador.getNome());
            pst.setString(2,String.valueOf(jogador.getIdade()));
            pst.setString(3,jogador.getCpf());
            pst.setString(4,jogador.getNacionalidade());
            pst.setString(5,jogador.getPosicao());
            pst.setString(6,jogador.getEquipe().getCnpj());
            pst.setString(7,String.valueOf(cpf));
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
    public boolean deleteJogador(String cpf){
        connectdToDb();

        boolean sucesso;
        String sql = "delete from Jogador where cpf = ?";
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

    public ArrayList<Jogador> selectJogador(){
        connectdToDb();

        ArrayList<Jogador> jogadores = new ArrayList<>();
        String sql = "select * from Jogador";
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("Lista de jogadores: ");
            while(rs.next()){
                Jogador jogadorAux = new Jogador(rs.getString("nome"), rs.getInt("idade"), rs.getString("cpf"),rs.getString("nacionalidade"), rs.getString("posicao"));
                System.out.println("Nome: " + jogadorAux.getNome() + " | Idade: " + jogadorAux.getIdade() + " | Nacionalidade: " + jogadorAux.getNacionalidade() + " | Posição: " + jogadorAux.getPosicao());
                System.out.println("----------------------------------------------------------------------------------");
                jogadores.add(jogadorAux);
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
        return jogadores;
    }
}
