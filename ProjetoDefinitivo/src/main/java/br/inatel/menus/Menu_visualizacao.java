package br.inatel.menus;

import br.inatel.futebol.campeonatos.Campeonato;
import br.inatel.futebol.pessoa_fisica.Arbitro;
import br.inatel.futebol.pessoa_fisica.Jogador;
import br.inatel.futebol.pessoa_fisica.Tecnico;
import br.inatel.futebol.pessoa_juridica.Equipe;
import br.inatel.futebol.pessoa_juridica.Federacao;
import br.inatel.futebol.pessoa_juridica.Patrocinador;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu_visualizacao {

    public void menu_visualizacao(){

        System.out.println("\nMenu de visualização");
        int select1 = 0, select2;

        Scanner entrada1 = new Scanner(System.in);
        Scanner entrada2 = new Scanner(System.in);

        do {
            System.out.println("\n1: Ver os árbitros");
            System.out.println("2: Ver os campeonatos");
            System.out.println("3: Ver as equipes");
            System.out.println("4: Ver as federações");
            System.out.println("5: Ver os jogadores");
            System.out.println("6: Ver os técnicos");
            System.out.println("7: Ver os patrocinadores");
            System.out.println("Qualquer outro valor: Sair do menu");

            try {
                select1 = entrada1.nextInt();
            } catch (InputMismatchException e) {
                continue;
            }

            switch (select1){

                case 1:
                    System.out.println("Digite o código do árbitro para ver mais informações");
                    for (int i = 0; i < Arbitro.getListaArbitros().size(); i++) {
                        System.out.println(i + ": " + Arbitro.getListaArbitros().get(i).getNome());
                    }
                    try {
                        select2 = entrada2.nextInt();
                        Arbitro.getListaArbitros().get(select2).mostrarInformacoes();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Não existe árbitro com este código!");
                        continue;
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida!");
                        continue;
                    }
                    break;
                case 2:
                    System.out.println("Digite o código do campeonato para ver mais informações");
                    for (int i = 0; i < Campeonato.getListaCampeonato().size(); i++) {
                        System.out.println(i + ": " + Campeonato.getListaCampeonato().get(i).getNome());
                    }
                    try {
                        select2 = entrada2.nextInt();
                        Campeonato.getListaCampeonato().get(select2).mostrarInformacoes();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Não existe campeonato com este código!");
                        continue;
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida!");
                        continue;
                    }
                    break;
                case 3:
                    System.out.println("Digite código da equipe para ver mais informações");
                    for (int i = 0; i < Equipe.getListaEquipes().size(); i++) {
                        System.out.println(i + ": " + Equipe.getListaEquipes().get(i).getNome());
                    }
                    try {
                        select2 = entrada2.nextInt();
                        Equipe.getListaEquipes().get(select2).mostrarInformacoes();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Não existe equipe com este código!");
                        continue;
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida!");
                        continue;
                    }
                    break;
                case 4:
                    System.out.println("Digite o código da federação para ver mais informações");
                    for (int i = 0; i < Federacao.getListaFederacao().size(); i++) {
                        System.out.println(i + ": " + Federacao.getListaFederacao().get(i).getNome());
                    }
                    try {
                        select2 = entrada2.nextInt();
                        Federacao.getListaFederacao().get(select2).mostrarInformacoes();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Não existe federação com este código!");
                        continue;
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida!");
                        continue;
                    }
                    break;
                case 5:
                    System.out.println("Digite o código do jogador para ver mais informações");
                    for (int i = 0; i < Jogador.getListaJogadores().size(); i++) {
                        System.out.println(i + ": " + Jogador.getListaJogadores().get(i).getNome());
                    }
                    try {
                        select2 = entrada2.nextInt();
                        Jogador.getListaJogadores().get(select2).mostrarInformacoes();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Não existe jogador com este código!");
                        continue;
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida!");
                        continue;
                    }
                    break;
                case 6:
                    System.out.println("Digite o código do técnico para ver mais informações");
                    for (int i = 0; i < Tecnico.getListaTecnicos().size(); i++) {
                        System.out.println(i + ": " + Tecnico.getListaTecnicos().get(i).getNome());
                    }
                    try {
                        select2 = entrada2.nextInt();
                        Tecnico.getListaTecnicos().get(select2).mostrarInformacoes();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Não existe técnico com este código!");
                        continue;
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida!");
                        continue;
                    }
                    break;
                case 7:
                    System.out.println("Digite o código do patrocinador para ver mais informações");
                    for (int i = 0; i < Patrocinador.getListaPatrocinador().size(); i++) {
                        System.out.println(i + ": " + Patrocinador.getListaPatrocinador().get(i).getNome());
                    }
                    try {
                        select2 = entrada2.nextInt();
                        Patrocinador.getListaPatrocinador().get(select2).mostrarInformacoes();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Não existe patrocinador com este código!");
                        continue;
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida!");
                        continue;
                    }
                    break;
            }

        } while (select1 > 0 && select1 <= 7);
    }
}
