package futebol.pessoa_fisica;

public abstract class Pessoa {

    protected String nome;
    protected int idade;
    protected int cpf;

    public Pessoa(String nome, int idade, int cpf) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
}
