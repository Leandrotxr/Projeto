package futebol.pessoa_fisica;

import futebol.interfaces.Contratavel;
import futebol.pessoa_juridica.Federacao;

public class Arbitro extends Pessoa implements Contratavel {

    private Federacao federacao;

    public Arbitro(String nome, int idade, int cpf) {
        super(nome, idade, cpf);
    }

    @Override
    public void contratar(Federacao federacao){
        this.federacao = federacao;
        federacao.adicionarArbitro(this);
        System.out.println("Arbitrado com sucesso!");
    }

    public void mostrarInformacoes(){
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("CPF: " + cpf);
        System.out.println("Federacao: " + federacao);
    }
}
