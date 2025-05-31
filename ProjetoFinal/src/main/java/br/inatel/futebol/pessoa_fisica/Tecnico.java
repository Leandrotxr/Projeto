package br.inatel.futebol.pessoa_fisica;

import br.inatel.futebol.interfaces.Contratavel;
import br.inatel.futebol.pessoa_juridica.Equipe;

public class Tecnico extends Pessoa implements Contratavel {

    private String nacionalidade;

    public Tecnico(String nome, int idade, String cpf, String nacionalidade) {
        super(nome, idade, cpf);
        this.nacionalidade = nacionalidade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    @Override
    public void contratar(Equipe equipe) {
        equipe.adcionaTecnico(this);
    }
}
