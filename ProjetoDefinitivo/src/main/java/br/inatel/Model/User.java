package br.inatel.Model;

public class User {

    String nome;
    String cpf;
    String id;

    public User(String id, String cpf, String nome) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}
