package futebol.campeonatos;

import futebol.pessoa_juridica.Equipe;
import futebol.pessoa_juridica.Federacao;

import java.util.ArrayList;
import java.util.List;

public class Campeonato {

    private String nome;
    private int premio;
    private String local;
    private Federacao federacao;
    private List<Equipe> lista_equipes = new ArrayList<Equipe>();

    public Campeonato(String nome, String local, int premio) {
        this.nome = nome;
        this.local = local;
        this.premio = premio;
    }

    public void adicionarFederacao(Federacao federacao) {
        this.federacao = federacao;
    }

    public void adicionarEquipe(Equipe equipe) {
        lista_equipes.add(equipe);
        System.out.println("Equipe adicionado com sucesso!");
    }

    public void mostrarInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Premio: " + premio);
        System.out.println("Local: " + local);
        System.out.println("Federacao: " + federacao);
        System.out.println("Lista equipes: ");
        for(Equipe equipe : lista_equipes) {
            System.out.println("Equipe " + equipe.getNome());
        }
    }

    public String getNome() {
        return nome;
    }
}
