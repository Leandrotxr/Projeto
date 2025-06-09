package br.inatel.futebol.pessoa_juridica;

import br.inatel.futebol.campeonatos.Campeonato;
import br.inatel.futebol.pessoa_fisica.Arbitro;

import java.util.ArrayList;
import java.util.List;

public class Federacao extends Empresa{

    List<Arbitro> lista_arbitro = new ArrayList<>();
    List<Campeonato> lista_campeonato = new ArrayList<>();

    public Federacao(String nome, String cnpj) {
        super(nome,cnpj);
    }

    public void adicionarArbitro(Arbitro arbitro) {
        lista_arbitro.add(arbitro);
    }

    public void adicionarCampeonato(Campeonato campeonato) {
        lista_campeonato.add(campeonato);
    }

    public void mostrarInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Lista de arbitros: ");
        for (Arbitro arbitro : lista_arbitro) {
            System.out.println("Nome: " + arbitro.getNome());
        }
        System.out.println("Lista de campeonatos: ");
        for(Campeonato campeonato : lista_campeonato){
            System.out.println("Nome: " + campeonato.getNome());
        }
    }


}
