package mundobruxo.personagens.humanos;

import mundobruxo.itens.Varinha;

import java.util.ArrayList;
import java.util.List;

public class Bruxo extends Humano{

    List<Varinha> lista_varinhas = new ArrayList<>();

    public Bruxo(String nome, int idade, String sexo) {
        super(nome, idade, sexo);
    }

    public void adicionaVarinha(Varinha varinha) {
        lista_varinhas.add(varinha);
        System.out.println("Adicionando varinha: " + varinha.getNome() + " ao bruxo: " + this.nome);
    }

    public void mostrarInfos(){
        System.out.println("\nNome: " + this.nome);
        System.out.println("Idade: " + this.idade);
        System.out.println("Sexo: " + this.sexo);
        System.out.println("Lista varinhas:");
        for (Varinha varinha : lista_varinhas) {
            System.out.println(varinha.getNome());
        }
    }
}
