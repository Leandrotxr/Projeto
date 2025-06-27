package br.inatel.menus;

import br.inatel.DAO.EquipeDao;
import br.inatel.DAO.JogadorDao;
import br.inatel.exception.CodigoInvalidoException;
import br.inatel.exception.EntradaInvalidaException;
import br.inatel.futebol.pessoa_fisica.Jogador;
import br.inatel.futebol.pessoa_fisica.Tecnico;
import br.inatel.futebol.pessoa_juridica.Equipe;

import java.util.Scanner;

public class MenuNegociacao {

    public void menu_transferencia() {

        System.out.println("\nMenu de negociação");

        int select1 = 0, select2, select3;

        Scanner entrada1 = new Scanner(System.in);
        Scanner entrada2 = new Scanner(System.in);

        do {
            System.out.println("\n1: Transferir jogador");
            System.out.println("2: Transferir técnico");
            System.out.println("3: Contratar técnico");
            System.out.println("4: Aposentar jogador");
            System.out.println("5: Aposentar técnico");
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
                    System.out.println("Digite o código do jogador que será transferido:");
                    for (int i = 0; i < Jogador.getListaJogadores().size(); i++) {
                        System.out.println(i + ": " + Jogador.getListaJogadores().get(i).getNome());
                    }

                    try {
                        if (!entrada2.hasNextInt()) throw new EntradaInvalidaException();
                        select2 = entrada2.nextInt();

                        if (select2 < 0 || select2 >= Jogador.getListaJogadores().size())
                            throw new CodigoInvalidoException("jogador");

                    } catch (EntradaInvalidaException | CodigoInvalidoException e) {
                        System.out.println(e.getMessage());
                        entrada2.nextLine();
                        continue;
                    }

                    System.out.println("Digite o código da equipe que irá receber o jogador:");
                    for (int i = 0; i < Equipe.getListaEquipes().size(); i++) {
                        System.out.println(i + ": " + Equipe.getListaEquipes().get(i).getNome());
                    }

                    try {
                        if (!entrada2.hasNextInt()) throw new EntradaInvalidaException();
                        select3 = entrada2.nextInt();

                        if (select3 < 0 || select3 >= Equipe.getListaEquipes().size())
                            throw new CodigoInvalidoException("equipe");

                        Jogador.getListaJogadores().get(select2).getEquipe().transferirJogador(Jogador.getListaJogadores().get(select2), Equipe.getListaEquipes().get(select3));
                        JogadorDao jogadortransferido = new JogadorDao();
                        jogadortransferido.updateJogador(Jogador.getListaJogadores().get(select2).getCpf(), Jogador.getListaJogadores().get(select2));
                        System.out.println("Transferência realizada com sucesso!");

                    } catch (EntradaInvalidaException | CodigoInvalidoException e) {
                        System.out.println(e.getMessage());
                        entrada2.nextLine();
                        continue;
                    }
                    break;

                case 2:
                    System.out.println("Digite o código do técnico que será transferido:");
                    for (int i = 0; i < Tecnico.getListaTecnicos().size(); i++) {
                        System.out.println(i + ": " + Tecnico.getListaTecnicos().get(i).getNome());
                    }

                    try {
                        if (!entrada2.hasNextInt()) throw new EntradaInvalidaException();
                        select2 = entrada2.nextInt();

                        if (select2 < 0 || select2 >= Tecnico.getListaTecnicos().size())
                            throw new CodigoInvalidoException("técnico");

                    } catch (EntradaInvalidaException | CodigoInvalidoException e) {
                        System.out.println(e.getMessage());
                        entrada2.nextLine();
                        continue;
                    }

                    System.out.println("Digite o código da equipe que irá receber o técnico:");
                    for (int i = 0; i < Equipe.getListaEquipes().size(); i++) {
                        System.out.println(i + ": " + Equipe.getListaEquipes().get(i).getNome());
                    }

                    try {
                        if (!entrada2.hasNextInt()) throw new EntradaInvalidaException();
                        select3 = entrada2.nextInt();

                        if (select3 < 0 || select3 >= Equipe.getListaEquipes().size())
                            throw new CodigoInvalidoException("equipe");

                        try {
                            Tecnico.getListaTecnicos().get(select2).getEquipe().transferirTecnico(Tecnico.getListaTecnicos().get(select2), Equipe.getListaEquipes().get(select3));
                            EquipeDao equipe = new EquipeDao();
                            equipe.updateEquipe(Equipe.getListaEquipes().get(select3).getCnpj(), Equipe.getListaEquipes().get(select3));
                            System.out.println("Transferência realizada com sucesso!");
                        } catch (NullPointerException e) {
                            System.out.println("Operação inválida");
                        }

                    } catch (EntradaInvalidaException | CodigoInvalidoException e) {
                        System.out.println(e.getMessage());
                        entrada2.nextLine();
                        continue;
                    }
                    break;

                case 3:
                    System.out.println("Digite o código do técnico livre que será contratado:");
                    for (int i = 0; i < Tecnico.getListaTecnicos().size(); i++) {
                        if (Tecnico.getListaTecnicos().get(i).getEquipe() == null) {
                            System.out.println(i + ": " + Tecnico.getListaTecnicos().get(i).getNome());
                        }
                    }

                    try {
                        if (!entrada2.hasNextInt()) throw new EntradaInvalidaException();
                        select2 = entrada2.nextInt();

                        if (select2 < 0 || select2 >= Tecnico.getListaTecnicos().size())
                            throw new CodigoInvalidoException("técnico");

                    } catch (EntradaInvalidaException | CodigoInvalidoException e) {
                        System.out.println(e.getMessage());
                        entrada2.nextLine();
                        continue;
                    }

                    System.out.println("Digite o código da equipe que irá contratar o técnico:");
                    for (int i = 0; i < Equipe.getListaEquipes().size(); i++) {
                        if (Equipe.getListaEquipes().get(i).getTecnico() == null) {
                            System.out.println(i + ": " + Equipe.getListaEquipes().get(i).getNome());
                        }
                    }

                    try {
                        if (!entrada2.hasNextInt()) throw new EntradaInvalidaException();
                        select3 = entrada2.nextInt();

                        if (select3 < 0 || select3 >= Equipe.getListaEquipes().size())
                            throw new CodigoInvalidoException("equipe");

                        Tecnico.getListaTecnicos().get(select2).contratar(Equipe.getListaEquipes().get(select3));
                        EquipeDao equipe = new EquipeDao();
                        equipe.updateEquipe(Equipe.getListaEquipes().get(select3).getCnpj(), Equipe.getListaEquipes().get(select3));

                    } catch (EntradaInvalidaException | CodigoInvalidoException e) {
                        System.out.println(e.getMessage());
                        entrada2.nextLine();
                        continue;
                    }

                    break;

                case 4:
                    System.out.println("Digite o código do jogador que irá aposentar:");
                    for (int i = 0; i < Jogador.getListaJogadores().size(); i++) {
                        System.out.println(i + ": " + Jogador.getListaJogadores().get(i).getNome());
                    }

                    try {
                        if (!entrada2.hasNextInt()) throw new EntradaInvalidaException();
                        select2 = entrada2.nextInt();

                        if (select2 < 0 || select2 >= Jogador.getListaJogadores().size())
                            throw new CodigoInvalidoException("jogador");

                    } catch (EntradaInvalidaException | CodigoInvalidoException e) {
                        System.out.println(e.getMessage());
                        entrada2.nextLine();
                        continue;
                    }

                    Jogador.getListaJogadores().get(select2).aposentarjogador();

                    break;

                case 5:
                    System.out.println("Digite o código do técnico que irá aposentar:");
                    for (int i = 0; i < Tecnico.getListaTecnicos().size(); i++) {
                        System.out.println(i + ": " + Tecnico.getListaTecnicos().get(i).getNome());
                    }

                    try {
                        if (!entrada2.hasNextInt()) throw new EntradaInvalidaException();
                        select2 = entrada2.nextInt();

                        if (select2 < 0 || select2 >= Tecnico.getListaTecnicos().size())
                            throw new CodigoInvalidoException("técnico");

                    } catch (EntradaInvalidaException | CodigoInvalidoException e) {
                        System.out.println(e.getMessage());
                        entrada2.nextLine();
                        continue;
                    }

                    Tecnico.getListaTecnicos().get(select2).aposentarTecnico();

                    break;

            }
        } while (select1 > 0 && select1 <= 3);
    }
}
