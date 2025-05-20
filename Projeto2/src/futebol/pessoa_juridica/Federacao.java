package futebol.pessoa_juridica;

import futebol.campeonatos.Campeonato;
import futebol.pessoa_fisica.Arbitro;

import java.util.ArrayList;
import java.util.List;

public class Federacao extends Empresa{

    List<Arbitro> lista_arbitro = new ArrayList<>();
    List<Campeonato> lista_campeonato = new ArrayList<>();

    public Federacao(String nome, int cnpj) {
        super(nome,cnpj);
    }

    public void adicionarArbitro(Arbitro arbitro) {
        lista_arbitro.add(arbitro);
        System.out.println("Adicionado arbitro: " + arbitro.getNome());
    }
}
