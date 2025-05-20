package mundobruxo.personagens;

public abstract class Personagem {

    protected String nome;
    protected int idade;
    protected String sexo;

    public Personagem(String nome, int idade, String sexo) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }
}
