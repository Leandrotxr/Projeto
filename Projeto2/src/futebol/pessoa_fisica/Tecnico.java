package futebol.pessoa_fisica;

import futebol.interfaces.Contratavel;
import futebol.pessoa_juridica.Equipe;

public class Tecnico extends Pessoa implements Contratavel {

    private String nacionalidade;

    public Tecnico(String nome, int idade, int cpf, String nacionalidade) {
        super(nome, idade, cpf);
        this.nacionalidade = nacionalidade;
    }

    @Override
    public void contratar(Equipe equipe) {
        equipe.adcionaTecnico(this);
        System.out.println(this.nome + " foi contratado com sucesso!");
    }
}
