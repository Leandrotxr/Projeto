package br.inatel.menus;

import br.inatel.exception.EntradaInvalidaException;

import java.util.Scanner;

public class MenuPrincipal {

    public void menu_principal() {

        MenuInsercao menuInsercao = new MenuInsercao();
        menuInsercao.default_insercao();

        System.out.println("Bem vindo ao SofaScore de pobre!");

        int select1 = 0;

        Scanner entrada1 = new Scanner(System.in);

        do {
            System.out.println("\n1: Menu de visualização");
            System.out.println("2: Menu de negociação");
            System.out.println("3: Menu de inserção");
            System.out.println("4: Menu de selects");
            System.out.println("Qualquer outro valor: Sair do menu");

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
                    MenuVisualizacao menuVisualizacao = new MenuVisualizacao();
                    menuVisualizacao.menu_visualizacao();
                    break;
                case 2:
                    MenuNegociacao menuNegociacao = new MenuNegociacao();
                    menuNegociacao.menu_transferencia();
                    break;
                case 3:
                    menuInsercao.menu_insercao();
                    break;
                case 4:
                    MenuSelect menuSelect = new MenuSelect();
                    menuSelect.menu_selecao();
                    break;
            }
        } while (select1 > 0 && select1 <= 4);
    }
}