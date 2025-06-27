package br.inatel.menus;

import br.inatel.exception.CodigoInvalidoException;
import br.inatel.exception.EntradaInvalidaException;
import br.inatel.futebol.campeonatos.Campeonato;
import br.inatel.futebol.pessoa_fisica.Arbitro;
import br.inatel.futebol.pessoa_fisica.Jogador;
import br.inatel.futebol.pessoa_fisica.Tecnico;
import br.inatel.futebol.pessoa_juridica.Equipe;
import br.inatel.futebol.pessoa_juridica.Federacao;
import br.inatel.futebol.pessoa_juridica.Patrocinador;

import java.util.Scanner;

public class MenuVisualizacao {

    public void menu_visualizacao() {

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
            System.out.println("Qualquer outro valor: Retornar ao início");

            try {
                if (!entrada1.hasNextInt()) throw new EntradaInvalidaException();
                select1 = entrada1.nextInt();
            } catch (EntradaInvalidaException e) {
                System.out.println(e.getMessage());
                entrada1.nextLine();
                continue;
            }

            switch (select1) {
                case 1:
                    System.out.println("Digite o código do árbitro para ver mais informações:");
                    for (int i = 0; i < Arbitro.getListaArbitros().size(); i++) {
                        System.out.println(i + ": " + Arbitro.getListaArbitros().get(i).getNome());
                    }
                    try {
                        if (!entrada2.hasNextInt()) throw new EntradaInvalidaException();
                        select2 = entrada2.nextInt();
                        if (select2 < 0 || select2 >= Arbitro.getListaArbitros().size())
                            throw new CodigoInvalidoException("árbitro");

                        Arbitro.getListaArbitros().get(select2).mostrarInformacoes();
                    } catch (EntradaInvalidaException | CodigoInvalidoException e) {
                        System.out.println(e.getMessage());
                        entrada2.nextLine();
                    }
                    break;

                case 2:
                    System.out.println("Digite o código do campeonato para ver mais informações:");
                    for (int i = 0; i < Campeonato.getListaCampeonato().size(); i++) {
                        System.out.println(i + ": " + Campeonato.getListaCampeonato().get(i).getNome());
                    }
                    try {
                        if (!entrada2.hasNextInt()) throw new EntradaInvalidaException();
                        select2 = entrada2.nextInt();
                        if (select2 < 0 || select2 >= Campeonato.getListaCampeonato().size())
                            throw new CodigoInvalidoException("campeonato");

                        Campeonato.getListaCampeonato().get(select2).mostrarInformacoes();
                    } catch (EntradaInvalidaException | CodigoInvalidoException e) {
                        System.out.println(e.getMessage());
                        entrada2.nextLine();
                    }
                    break;

                case 3:
                    System.out.println("Digite o código da equipe para ver mais informações:");
                    for (int i = 0; i < Equipe.getListaEquipes().size(); i++) {
                        System.out.println(i + ": " + Equipe.getListaEquipes().get(i).getNome());
                    }
                    try {
                        if (!entrada2.hasNextInt()) throw new EntradaInvalidaException();
                        select2 = entrada2.nextInt();
                        if (select2 < 0 || select2 >= Equipe.getListaEquipes().size())
                            throw new CodigoInvalidoException("equipe");

                        Equipe.getListaEquipes().get(select2).mostrarInformacoes();
                    } catch (EntradaInvalidaException | CodigoInvalidoException e) {
                        System.out.println(e.getMessage());
                        entrada2.nextLine();
                    }
                    break;

                case 4:
                    System.out.println("Digite o código da federação para ver mais informações:");
                    for (int i = 0; i < Federacao.getListaFederacao().size(); i++) {
                        System.out.println(i + ": " + Federacao.getListaFederacao().get(i).getNome());
                    }
                    try {
                        if (!entrada2.hasNextInt()) throw new EntradaInvalidaException();
                        select2 = entrada2.nextInt();
                        if (select2 < 0 || select2 >= Federacao.getListaFederacao().size())
                            throw new CodigoInvalidoException("federação");

                        Federacao.getListaFederacao().get(select2).mostrarInformacoes();
                    } catch (EntradaInvalidaException | CodigoInvalidoException e) {
                        System.out.println(e.getMessage());
                        entrada2.nextLine();
                    }
                    break;

                case 5:
                    System.out.println("Digite o código do jogador para ver mais informações:");
                    for (int i = 0; i < Jogador.getListaJogadores().size(); i++) {
                        System.out.println(i + ": " + Jogador.getListaJogadores().get(i).getNome());
                    }
                    try {
                        if (!entrada2.hasNextInt()) throw new EntradaInvalidaException();
                        select2 = entrada2.nextInt();
                        if (select2 < 0 || select2 >= Jogador.getListaJogadores().size())
                            throw new CodigoInvalidoException("jogador");

                        Jogador.getListaJogadores().get(select2).mostrarInformacoes();
                    } catch (EntradaInvalidaException | CodigoInvalidoException e) {
                        System.out.println(e.getMessage());
                        entrada2.nextLine();
                    }
                    break;

                case 6:
                    System.out.println("Digite o código do técnico para ver mais informações:");
                    for (int i = 0; i < Tecnico.getListaTecnicos().size(); i++) {
                        System.out.println(i + ": " + Tecnico.getListaTecnicos().get(i).getNome());
                    }
                    try {
                        if (!entrada2.hasNextInt()) throw new EntradaInvalidaException();
                        select2 = entrada2.nextInt();
                        if (select2 < 0 || select2 >= Tecnico.getListaTecnicos().size())
                            throw new CodigoInvalidoException("técnico");

                        Tecnico.getListaTecnicos().get(select2).mostrarInformacoes();
                    } catch (EntradaInvalidaException | CodigoInvalidoException e) {
                        System.out.println(e.getMessage());
                        entrada2.nextLine();
                    }
                    break;

                case 7:
                    System.out.println("Digite o código do patrocinador para ver mais informações:");
                    for (int i = 0; i < Patrocinador.getListaPatrocinador().size(); i++) {
                        System.out.println(i + ": " + Patrocinador.getListaPatrocinador().get(i).getNome());
                    }
                    try {
                        if (!entrada2.hasNextInt()) throw new EntradaInvalidaException();
                        select2 = entrada2.nextInt();
                        if (select2 < 0 || select2 >= Patrocinador.getListaPatrocinador().size())
                            throw new CodigoInvalidoException("patrocinador");

                        Patrocinador.getListaPatrocinador().get(select2).mostrarInformacoes();
                    } catch (EntradaInvalidaException | CodigoInvalidoException e) {
                        System.out.println(e.getMessage());
                        entrada2.nextLine();
                    }
                    break;
            }

        } while (select1 >= 1 && select1 <= 7);
    }
}
