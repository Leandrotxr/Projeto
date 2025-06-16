package br.inatel.menus;

import br.inatel.exception.CodigoInvalidoException;
import br.inatel.exception.EntradaInvalidaException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu_principal {

    public void menu_principal() {

        Menu_insercao menuInsercao = new Menu_insercao();
        menuInsercao.default_insercao();

        System.out.println("Bem vindo ao SofaScore de pobre!");

        int select1 = 0;

        Scanner entrada1 = new Scanner(System.in);

        do {
            System.out.println("\n1: Menu de visualização");
            System.out.println("2: Menu de transferência");
            System.out.println("3: Menu de inserção");
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
                    Menu_visualizacao menuVisualizacao = new Menu_visualizacao();
                    menuVisualizacao.menu_visualizacao();
                    break;
                case 2:
                    Menu_transferencia menuTransferencia = new Menu_transferencia();
                    menuTransferencia.menu_transferencia();
                    break;
                case 3:
                    menuInsercao.menu_insercao();
                    break;
            }
        } while (select1 > 0 && select1 <= 3);
    }
}
