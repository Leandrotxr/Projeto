package futebol.pessoa_juridica;

public abstract class Empresa {

    protected String nome;
    protected int cnpj;

    public Empresa(String nome, int cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public int getCnpj() {
        return cnpj;
    }
}
