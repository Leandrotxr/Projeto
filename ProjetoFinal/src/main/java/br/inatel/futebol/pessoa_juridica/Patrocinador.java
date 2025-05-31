package br.inatel.futebol.pessoa_juridica;

import br.inatel.futebol.interfaces.Contratavel;

import java.util.ArrayList;
import java.util.List;

public class Patrocinador extends Empresa implements Contratavel {

    private List<Equipe> lista_Equipe = new ArrayList<>();

    @Override
    public void contratar(Equipe equipe, int valor) {
        equipe.adicionarPatrocinador(this, valor);
    }

    public Patrocinador(String nome, String cnpj) {
        super(nome,cnpj);
    }

    public void adicionarEquipe(Equipe equipe) {
        lista_Equipe.add(equipe);
    }

    public void setLista_Equipe(List<Equipe> lista_Equipe) {
        this.lista_Equipe = lista_Equipe;
    }
}
