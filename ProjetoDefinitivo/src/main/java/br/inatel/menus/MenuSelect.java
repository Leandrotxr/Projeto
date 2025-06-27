package br.inatel.menus;

import br.inatel.DAO.*;
import br.inatel.exception.EntradaInvalidaException;

import java.util.Scanner;

public class MenuSelect {

    public void menu_selecao() {

        System.out.println("\nMenu de seleção geral");
        int select1 = 0;

        Scanner entrada1 = new Scanner(System.in);

        do {
            System.out.println("\n1: Ver os árbitros");
            System.out.println("2: Ver os campeonatos");
            System.out.println("3: Ver as equipes");
            System.out.println("4: Ver as federações");
            System.out.println("5: Ver os jogadores");
            System.out.println("6: Ver os técnicos");
            System.out.println("7: Ver os patrocinadores");
            System.out.println("8: Ver equipes e tecnicos (JOIN)");
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
                    ArbitroDao arbitroDao = new ArbitroDao();
                    arbitroDao.selectArbitro();

                    break;

                case 2:
                    CampeonatoDao campeonatoDao = new CampeonatoDao();
                    campeonatoDao.selectCampeonato();

                    break;

                case 3:
                    EquipeDao equipeDao = new EquipeDao();
                    equipeDao.selectEquipe();

                    break;

                case 4:
                    FederacaoDao federacaoDao = new FederacaoDao();
                    federacaoDao.selectFederacao();

                    break;

                case 5:
                    JogadorDao jogadorDao = new JogadorDao();
                    jogadorDao.selectJogador();

                    break;

                case 6:
                    TecnicoDao tecnicoDao = new TecnicoDao();
                    tecnicoDao.selectTecnico();

                    break;

                case 7:
                    PatrocinadorDao patrocinadorDao = new PatrocinadorDao();
                    patrocinadorDao.selectPatrocinador();

                    break;

                case 8:
                    TecnicoDao tecnicoDao2 = new TecnicoDao();
                    tecnicoDao2.selectEquipesComTecnicos();
                    break;
            }

        } while (select1 > 0 && select1 <= 8);
    }
}
