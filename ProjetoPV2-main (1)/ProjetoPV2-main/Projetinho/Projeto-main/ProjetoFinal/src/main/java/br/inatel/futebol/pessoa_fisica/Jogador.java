package br.inatel.futebol.pessoa_fisica;

import br.inatel.futebol.interfaces.Contratavel;
import br.inatel.futebol.pessoa_juridica.Equipe;

public class Jogador extends Pessoa implements Contratavel {

    private String nacionalidade;
    private String posicao;
    private Equipe equipe;

    public Jogador(String nome, int idade, String cpf, String nacionalidade, String posicao) {
        super(nome, idade, cpf);
        this.nacionalidade = nacionalidade;
        this.posicao = posicao;
    }

    @Override
    public void contratar(Equipe equipe){
        equipe.adcionaJogador(this);
        this.equipe = equipe;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public String getPosicao() {
        return posicao;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public void mostrarInfo(){

    }
}
