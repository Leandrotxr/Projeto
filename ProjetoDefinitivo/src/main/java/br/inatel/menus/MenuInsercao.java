package br.inatel.menus;

import br.inatel.DAO.*;
import br.inatel.exception.EntradaInvalidaException;
import br.inatel.futebol.campeonatos.Campeonato;
import br.inatel.futebol.pessoa_fisica.Arbitro;
import br.inatel.futebol.pessoa_fisica.Jogador;
import br.inatel.futebol.pessoa_fisica.Tecnico;
import br.inatel.futebol.pessoa_fisica.Torcedor;
import br.inatel.futebol.pessoa_juridica.Equipe;
import br.inatel.futebol.pessoa_juridica.Federacao;
import br.inatel.futebol.pessoa_juridica.Patrocinador;

import java.util.Scanner;

public class MenuInsercao {

    public void default_insercao(){
        // inserindo técnicos
        TecnicoDao tecnicoDao = new TecnicoDao();

        Tecnico tecnico1 = new Tecnico("Mourinho",62,"111111","Português");
        tecnicoDao.insertTecnico(tecnico1);
        Tecnico tecnico2 = new Tecnico("Guardiola",54,"222222","Espanhol");
        tecnicoDao.insertTecnico(tecnico2);
        Tecnico tecnico3 = new Tecnico("Ancelotti",65,"333333","Italiano");
        tecnicoDao.insertTecnico(tecnico3);
        Tecnico tecnico4 = new Tecnico("Xabi Alonso",43,"444444","Espanhol");
        tecnicoDao.insertTecnico(tecnico4);
        Tecnico tecnico5 = new Tecnico("Filipe Luís",39,"555555","Brasileiro");
        tecnicoDao.insertTecnico(tecnico5);

        // inserindo equipes
        EquipeDao equipeDao = new EquipeDao();

        Equipe equipe1 = new Equipe("Fenerbahce","11111",1907,"Turquia");
        tecnico1.contratar(equipe1);
        equipeDao.insertEquipe(equipe1);

        Equipe equipe2 = new Equipe("Manchester City","22222",1894,"Inglaterra");
        tecnico2.contratar(equipe2);
        equipeDao.insertEquipe(equipe2);

        Equipe equipe3 = new Equipe("Real Madrid","33333",1902,"Espanha");
        tecnico3.contratar(equipe3);
        equipeDao.insertEquipe(equipe3);

        Equipe equipe4 = new Equipe("Bayer Leverkusen","44444",1904,"Alemanha");
        tecnico4.contratar(equipe4);
        equipeDao.insertEquipe(equipe4);

        Equipe equipe5 = new Equipe("Flamengo","55555",1895,"Brasil");
        tecnico5.contratar(equipe5);
        equipeDao.insertEquipe(equipe5);

        // inserindo jogadores
        JogadorDao jogadorDao = new JogadorDao();

        // fenerbahce
        Jogador jogador01 = new Jogador("Talisca",31,"100000","Brasileiro","Atacante");
        jogador01.contratar(equipe1);
        jogadorDao.insertJogador(jogador01);
        Jogador jogador02 = new Jogador("Skriniar",30,"150000","Eslovaco","Defensor");
        jogador02.contratar(equipe1);
        jogadorDao.insertJogador(jogador02);
        Jogador jogador03 = new Jogador("Dzeko",39,"180000","Bósnio","Atacante");
        jogador03.contratar(equipe1);
        jogadorDao.insertJogador(jogador03);

        // manchester city
        Jogador jogador04 = new Jogador("De Bruyne",33,"200000","Belga","Meia");
        jogador04.contratar(equipe2);
        jogadorDao.insertJogador(jogador04);
        Jogador jogador05 = new Jogador("Doku",22,"250000","Belga","Atacante");
        jogador05.contratar(equipe2);
        jogadorDao.insertJogador(jogador05);
        Jogador jogador06 = new Jogador("Ederson",31,"280000","Brasileiro","Goleiro");
        jogador06.contratar(equipe2);
        jogadorDao.insertJogador(jogador06);

        // real madrid
        Jogador jogador07 = new Jogador("Vinícius Júnior",24,"300000","Brasileiro","Atacante");
        jogador07.contratar(equipe3);
        jogadorDao.insertJogador(jogador07);
        Jogador jogador08 = new Jogador("Modric",39,"350000","Croata","Meia");
        jogador08.contratar(equipe3);
        jogadorDao.insertJogador(jogador08);
        Jogador jogador09 = new Jogador("Courtois",32,"380000","Belga","Goleiro");
        jogador09.contratar(equipe3);
        jogadorDao.insertJogador(jogador09);

        // bayer leverkusen
        Jogador jogador10 = new Jogador("Frimpong",24,"400000","Holandês","Defensor");
        jogador10.contratar(equipe4);
        jogadorDao.insertJogador(jogador10);
        Jogador jogador11 = new Jogador("Wirtz",22,"450000","Alemão","Meia");
        jogador11.contratar(equipe4);
        jogadorDao.insertJogador(jogador11);
        Jogador jogador12 = new Jogador("Tah",29,"480000","Alemão","Defensor");
        jogador12.contratar(equipe4);
        jogadorDao.insertJogador(jogador12);

        // flamengo
        Jogador jogador13 = new Jogador("Rossi",29,"500000","Argentino","Goleiro");
        jogador13.contratar(equipe5);
        jogadorDao.insertJogador(jogador13);
        Jogador jogador14 = new Jogador("Arrascaeta",30,"550000","Uruguaio","Meia");
        jogador14.contratar(equipe5);
        jogadorDao.insertJogador(jogador14);
        Jogador jogador15 = new Jogador("Pedro",27,"580000","Brasileiro","Atacante");
        jogador15.contratar(equipe5);
        jogadorDao.insertJogador(jogador15);

        // inserindo patrocinadores
        br.inatel.DAO.PatrocinadorDao patrocinadorDao = new PatrocinadorDao();

        Patrocinador patrocinador1 = new Patrocinador("Puma","10000");
        patrocinadorDao.insertPatrocinador(patrocinador1);
        Patrocinador patrocinador2 = new Patrocinador("Etihad Airways","20000");
        patrocinadorDao.insertPatrocinador(patrocinador2);
        Patrocinador patrocinador3 = new Patrocinador("Fly Emirates","30000");
        patrocinadorDao.insertPatrocinador(patrocinador3);
        Patrocinador patrocinador4 = new Patrocinador("Bayer","40000");
        patrocinadorDao.insertPatrocinador(patrocinador4);
        Patrocinador patrocinador5 = new Patrocinador("PixBet","50000");
        patrocinadorDao.insertPatrocinador(patrocinador5);

        // inserindo patrocínios às equipes
        Equipe_has_PatrocinadorDao equipe_has_patrocinadorDao = new Equipe_has_PatrocinadorDao();

        patrocinador1.contratar(equipe1,30000000);
        equipe_has_patrocinadorDao.insertEquipe_has_Patrocinador(patrocinador1, equipe1, 30000000);
        patrocinador1.contratar(equipe2, 65000000);
        equipe_has_patrocinadorDao.insertEquipe_has_Patrocinador(patrocinador1, equipe2, 65000000);
        patrocinador2.contratar(equipe2, 400000000);
        equipe_has_patrocinadorDao.insertEquipe_has_Patrocinador(patrocinador2, equipe2, 65000000);
        patrocinador3.contratar(equipe3, 70000000);
        equipe_has_patrocinadorDao.insertEquipe_has_Patrocinador(patrocinador3, equipe3, 70000000);
        patrocinador4.contratar(equipe4, 30000000);
        equipe_has_patrocinadorDao.insertEquipe_has_Patrocinador(patrocinador4, equipe4, 70000000);
        patrocinador5.contratar(equipe5,23000000);
        equipe_has_patrocinadorDao.insertEquipe_has_Patrocinador(patrocinador5, equipe5, 23000000);

        // inserindo Federações

        FederacaoDao federacaoDao = new FederacaoDao();

        Federacao federacao1 = new Federacao("TFF", "111");
        federacaoDao.insertFederacao(federacao1);
        Federacao federacao2 = new Federacao("EFA", "222");
        federacaoDao.insertFederacao(federacao2);
        Federacao federacao3 = new Federacao("RFEF", "333");
        federacaoDao.insertFederacao(federacao3);
        Federacao federacao4 = new Federacao("DFB", "444");
        federacaoDao.insertFederacao(federacao4);
        Federacao federacao5 = new Federacao("CBF", "555");
        federacaoDao.insertFederacao(federacao5);
        Federacao federacao6 = new Federacao("FIFA", "666");
        federacaoDao.insertFederacao(federacao6);
        Federacao federacao7 = new Federacao("UEFA", "777");
        federacaoDao.insertFederacao(federacao7);
        Federacao federacao8 = new Federacao("CONMEBOL", "888");
        federacaoDao.insertFederacao(federacao8);

        // inserindo arbitros
        ArbitroDao arbitroDao = new ArbitroDao();

        Arbitro arbitro1 = new Arbitro("Bitigen",42,"910000");
        arbitro1.contratar(federacao1);
        arbitroDao.insertArbitro(arbitro1);
        Arbitro arbitro2 = new Arbitro("Oliver",40,"920000");
        arbitro2.contratar(federacao2);
        arbitroDao.insertArbitro(arbitro2);
        Arbitro arbitro3 = new Arbitro("Bengoetxa",39,"930000");
        arbitro3.contratar(federacao3);
        arbitroDao.insertArbitro(arbitro3);
        Arbitro arbitro4 = new Arbitro("Brych",49,"940000");
        arbitro4.contratar(federacao4);
        arbitroDao.insertArbitro(arbitro4);
        Arbitro arbitro5 = new Arbitro("Daronco",44,"950000");
        arbitro5.contratar(federacao5);
        arbitroDao.insertArbitro(arbitro5);
        Arbitro arbitro6 = new Arbitro("Marciniak",41,"960000");
        arbitro6.contratar(federacao6);
        arbitroDao.insertArbitro(arbitro6);
        Arbitro arbitro7 = new Arbitro("Turpin",42,"970000");
        arbitro7.contratar(federacao7);
        arbitroDao.insertArbitro(arbitro7);
        Arbitro arbitro8 = new Arbitro("Roldán",45,"980000");
        arbitro8.contratar(federacao8);
        arbitroDao.insertArbitro(arbitro8);

        CampeonatoDao campeonatoDao = new CampeonatoDao();

        // inserindo campeonatos
        Campeonato campeonato1 = new Campeonato("SuperLig","Turquia",25000000,1);
        campeonato1.adicionarFederacao(federacao1);
        campeonatoDao.insertCampeonato(campeonato1);

        Campeonato campeonato2 = new Campeonato("Turkiye Kupasi","Turquia",10000000,2);
        campeonato2.adicionarFederacao(federacao1);
        campeonatoDao.insertCampeonato(campeonato2);

        Campeonato campeonato3 = new Campeonato("Premier League","Inglaterra",175000000,3);
        campeonato3.adicionarFederacao(federacao2);
        campeonatoDao.insertCampeonato(campeonato3);

        Campeonato campeonato4 = new Campeonato("FA Cup","Inglaterra",2000000,4);
        campeonato4.adicionarFederacao(federacao2);
        campeonatoDao.insertCampeonato(campeonato4);

        Campeonato campeonato5 = new Campeonato("Carabao Cup","Inglaterra",1000000,5);
        campeonato5.adicionarFederacao(federacao2);
        campeonatoDao.insertCampeonato(campeonato5);

        Campeonato campeonato6 = new Campeonato("LaLiga","Espanha",143000000,6);
        campeonato6.adicionarFederacao(federacao3);
        campeonatoDao.insertCampeonato(campeonato6);

        Campeonato campeonato7 = new Campeonato("Copa Del Rey","Espanha",2000000,7);
        campeonato7.adicionarFederacao(federacao3);
        campeonatoDao.insertCampeonato(campeonato7);

        Campeonato campeonato8 = new Campeonato("Bundesliga","Alemanha",76000000,8);
        campeonato8.adicionarFederacao(federacao4);
        campeonatoDao.insertCampeonato(campeonato8);

        Campeonato campeonato9 = new Campeonato("DFB Pokal","Alemanha",1000000,9);
        campeonato9.adicionarFederacao(federacao4);
        campeonatoDao.insertCampeonato(campeonato9);

        Campeonato campeonato10 = new Campeonato("Brasileirão","Brasil",9000000,10);
        campeonato10.adicionarFederacao(federacao5);
        campeonatoDao.insertCampeonato(campeonato10);

        Campeonato campeonato11 = new Campeonato("Copa do Brasil","Brasil",20000000,11);
        campeonato11.adicionarFederacao(federacao5);
        campeonatoDao.insertCampeonato(campeonato11);

        Campeonato campeonato12 = new Campeonato("Mundial de Clubes","Estados Unidos",125000000,12);
        campeonato12.adicionarFederacao(federacao6);
        campeonatoDao.insertCampeonato(campeonato12);

        Campeonato campeonato13 = new Campeonato("Champions League","Europa",127000000,13);
        campeonato13.adicionarFederacao(federacao7);
        campeonatoDao.insertCampeonato(campeonato13);

        Campeonato campeonato14 = new Campeonato("Europa League","Europa",14000000,14);
        campeonato14.adicionarFederacao(federacao7);
        campeonatoDao.insertCampeonato(campeonato14);

        Campeonato campeonato15 = new Campeonato("Libertadores","América do Sul",24000000,15);
        campeonato15.adicionarFederacao(federacao8);
        campeonatoDao.insertCampeonato(campeonato15);

        Campeonato campeonato16 = new Campeonato("Sulamericana","América do Sul",5000000,16);
        campeonato16.adicionarFederacao(federacao8);
        campeonatoDao.insertCampeonato(campeonato16);

        // inserindo equipes nos campeonatos

        Equipe_has_CampeonatoDao equipe_has_campeonatoDao = new Equipe_has_CampeonatoDao();

        // Fenerbahce
        equipe1.adicionarCampeonato(campeonato1);
        equipe_has_campeonatoDao.insertEquipe_has_Campeonato(campeonato1, equipe1);
        equipe1.adicionarCampeonato(campeonato2);
        equipe_has_campeonatoDao.insertEquipe_has_Campeonato(campeonato2, equipe1);
        equipe1.adicionarCampeonato(campeonato14);
        equipe_has_campeonatoDao.insertEquipe_has_Campeonato(campeonato14, equipe1);

        // Manchester City
        equipe2.adicionarCampeonato(campeonato3);
        equipe_has_campeonatoDao.insertEquipe_has_Campeonato(campeonato3, equipe2);
        equipe2.adicionarCampeonato(campeonato4);
        equipe_has_campeonatoDao.insertEquipe_has_Campeonato(campeonato4, equipe2);
        equipe2.adicionarCampeonato(campeonato5);
        equipe_has_campeonatoDao.insertEquipe_has_Campeonato(campeonato5, equipe2);
        equipe2.adicionarCampeonato(campeonato12);
        equipe_has_campeonatoDao.insertEquipe_has_Campeonato(campeonato12, equipe2);
        equipe2.adicionarCampeonato(campeonato13);
        equipe_has_campeonatoDao.insertEquipe_has_Campeonato(campeonato13, equipe2);

        // Real Madrid
        equipe3.adicionarCampeonato(campeonato6);
        equipe_has_campeonatoDao.insertEquipe_has_Campeonato(campeonato6, equipe3);
        equipe3.adicionarCampeonato(campeonato7);
        equipe_has_campeonatoDao.insertEquipe_has_Campeonato(campeonato7, equipe3);
        equipe3.adicionarCampeonato(campeonato12);
        equipe_has_campeonatoDao.insertEquipe_has_Campeonato(campeonato12, equipe3);
        equipe3.adicionarCampeonato(campeonato13);
        equipe_has_campeonatoDao.insertEquipe_has_Campeonato(campeonato13, equipe3);

        // Bayer Leverkusen
        equipe4.adicionarCampeonato(campeonato8);
        equipe_has_campeonatoDao.insertEquipe_has_Campeonato(campeonato8, equipe4);
        equipe4.adicionarCampeonato(campeonato9);
        equipe_has_campeonatoDao.insertEquipe_has_Campeonato(campeonato9, equipe4);
        equipe4.adicionarCampeonato(campeonato13);
        equipe_has_campeonatoDao.insertEquipe_has_Campeonato(campeonato13, equipe4);

        // Flamengo
        equipe5.adicionarCampeonato(campeonato10);
        equipe_has_campeonatoDao.insertEquipe_has_Campeonato(campeonato10, equipe5);
        equipe5.adicionarCampeonato(campeonato11);
        equipe_has_campeonatoDao.insertEquipe_has_Campeonato(campeonato11, equipe5);
        equipe5.adicionarCampeonato(campeonato12);
        equipe_has_campeonatoDao.insertEquipe_has_Campeonato(campeonato12, equipe5);
        equipe5.adicionarCampeonato(campeonato15);
        equipe_has_campeonatoDao.insertEquipe_has_Campeonato(campeonato15, equipe5);

        //inserindo torcedores
        Torcedor torcedor1 = new Torcedor("Enzo", 6, "2019", equipe5);
        Torcedor torcedor2 = new Torcedor("Zico", 44, "1981", equipe5);

    }

    public void menu_insercao(){

        System.out.println("\nMenu de inserção");

        int select1 = 0;

        Scanner entrada1 = new Scanner(System.in);

        String nome, cpf, local, cnpj, nacionalidade, posicao;
        int premio, ano_fundacao, idade, codigo_equipe;

        do {
            System.out.println("\n1: Inserir árbitro");
            System.out.println("2: Inserir campeonato");
            System.out.println("3: Inserir equipe");
            System.out.println("4: Inserir federação");
            System.out.println("5: Inserir jogador");
            System.out.println("6: Inserir técnico");
            System.out.println("7: Inserir torcedor");
            System.out.println("8: Inserir patrocinador");
            System.out.println("Qualquer outro valor: Retornar ao inicio");

            try {
                if (!entrada1.hasNextInt()) throw new EntradaInvalidaException();
                select1 = entrada1.nextInt();
            } catch (EntradaInvalidaException e) {
                System.out.println(e.getMessage());
                entrada1.nextLine();
                continue;
            }

            switch (select1){

                case 1:
                    System.out.println("Digite o nome, idade e CPF do árbitro que deseja inserir");
                    System.out.print("Nome: ");
                    nome = entrada1.nextLine();
                    System.out.print("Idade: ");
                    idade = entrada1.nextInt();
                    cpf = entrada1.nextLine();
                    new Arbitro(nome, idade, cpf);
                    break;
                case 2:
                    System.out.println("Digite o nome, local e prêmio do campeonato que deseja inserir");
                    new Campeonato(entrada1.nextLine(), entrada1.nextLine(), entrada1.nextInt(), entrada1.nextInt());
                    break;
                case 3:
                    System.out.println("Digite o nome, CNPJ, o ano de fundação e o país da equipe que deseja inserir");
                    new Equipe(entrada1.nextLine(), entrada1.nextLine(), entrada1.nextInt(), entrada1.nextLine());
                    break;
                case 4:
                    System.out.println("Digite o nome e o CNPJ da federação que deseja inserir");
                    new Federacao(entrada1.nextLine(), entrada1.nextLine());
                    break;
                case 5:
                    System.out.println("Digite o nome, idade, CPF, nacionalidade e posição do jogador que deseja inserir");
                    new Jogador(entrada1.nextLine(), entrada1.nextInt(), entrada1.nextLine(), entrada1.nextLine(), entrada1.nextLine());
                    break;
                case 6:
                    System.out.println("Digite o nome, idade, CPF e nacionalidade do técnico que deseja inserir");
                    new Tecnico(entrada1.nextLine(), entrada1.nextInt(), entrada1.nextLine(), entrada1.nextLine());
                    break;
                case 7:
                    System.out.println("Digite o nome, idade, CPF e o código da equipe do coração do torcedor que deseja inserir");
                    for (int i = 0; i < Equipe.getListaEquipes().size(); i++) {
                        System.out.println(i + ": " + Equipe.getListaEquipes().get(i).getNome());
                    }
                    new Torcedor(entrada1.nextLine(), entrada1.nextInt(), entrada1.nextLine(), Equipe.getListaEquipes().get(entrada1.nextInt()));
                    break;
                case 8:
                    System.out.println("Digite o nome e CNPJ do patrocinador que deseja inserir");
                    new Patrocinador(entrada1.nextLine(), entrada1.nextLine());
                    break;
            }

        } while (select1 > 0 && select1 <= 8);

    }
}
