package br.inatel.futebol.pessoa_fisica;

import br.inatel.futebol.interfaces.Contratavel;
import br.inatel.futebol.interfaces.Transferivel;
import br.inatel.futebol.pessoa_juridica.Equipe;

import java.util.ArrayList;
import java.util.List;

public class Tecnico extends Pessoa implements Contratavel, Transferivel {

    private final String nacionalidade;
    private Equipe equipe;
    private static List<Tecnico> lista_tecnicos = new ArrayList<Tecnico>();

    public Tecnico(String nome, int idade, String cpf, String nacionalidade) {
        super(nome, idade, cpf);
        this.nacionalidade = nacionalidade;
        lista_tecnicos.add(this);
    }

    @Override
    public void mostrarInformacoes(){
        System.out.println("\nNome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Nacionalidade: " + nacionalidade);
        try {
            System.out.println("Equipe: " + equipe.getNome());
        } catch (NullPointerException e) {
            System.out.println("O técnico está livre no mercado!");
        }
    }

    @Override
    public void contratar(Equipe equipe) {
        this.equipe = equipe;
        equipe.adcionaTecnico(this);
    }

    @Override
    public void transferir(Equipe equipe_destino) {
        this.equipe = equipe_destino;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public static List<Tecnico> getListaTecnicos() {
        return lista_tecnicos;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
}