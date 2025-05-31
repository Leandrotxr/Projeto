package br.inatel.futebol.pessoa_fisica;

import br.inatel.futebol.interfaces.Contratavel;
import br.inatel.futebol.pessoa_juridica.Federacao;

public class Arbitro extends Pessoa implements Contratavel {

    private Federacao federacao;

    public Arbitro(String nome, int idade, String cpf) {
        super(nome, idade, cpf);
    }

    public Federacao getFederacao() {
        return federacao;
    }

    @Override
    public void contratar(Federacao federacao){
        this.federacao = federacao;
        federacao.adicionarArbitro(this);
    }

    public void mostrarInformacoes(){
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("CPF: " + cpf);
        System.out.println("Federacao: " + federacao.getNome());
    }
}
