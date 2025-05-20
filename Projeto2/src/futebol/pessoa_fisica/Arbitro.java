package futebol.pessoa_fisica;

import futebol.interfaces.Contratavel;
import futebol.pessoa_juridica.Federacao;

public class Arbitro extends Pessoa implements Contratavel {

    public Arbitro(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public void contratar(Federacao federacao){
        federacao.adicionarArbitro(this);
        System.out.println("Arbitrado com sucesso!");
    }
}
