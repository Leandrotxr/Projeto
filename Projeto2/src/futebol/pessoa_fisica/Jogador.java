package futebol.pessoa_fisica;

import futebol.interfaces.Contratavel;
import futebol.pessoa_juridica.Equipe;

public class Jogador extends Pessoa implements Contratavel {

    private String nacionalidade;
    private String posicao;

    public Jogador(String nome, int idade, int cpf, String nacionalidade, String posicao) {
        super(nome, idade, cpf);
        this.nacionalidade = nacionalidade;
        this.posicao = posicao;
    }

    @Override
    public void contratar(Equipe equipe){
        equipe.adcionaJogador(this);
        System.out.println(this.nome + " foi contratado com sucesso!");
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public void mostrarInfo(){

    }
}
