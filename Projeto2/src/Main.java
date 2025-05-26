import futebol.campeonatos.Campeonato;
import futebol.pessoa_fisica.Arbitro;
import futebol.pessoa_fisica.Jogador;
import futebol.pessoa_fisica.Tecnico;
import futebol.pessoa_juridica.Equipe;
import futebol.pessoa_juridica.Federacao;
import futebol.pessoa_juridica.Patrocinador;

public class Main {
    public static void main(String[] args) {

        // inserindo técnicos
        Tecnico tecnico1 = new Tecnico("Mourinho",62,111111,"Português");
        Tecnico tecnico2 = new Tecnico("Guardiola",54,222222,"Espanhol");
        Tecnico tecnico3 = new Tecnico("Ancelotti",65,333333,"Italiano");
        Tecnico tecnico4 = new Tecnico("Xabi Alonso",43,444444,"Espanhol");
        Tecnico tecnico5 = new Tecnico("Filipe Luís",39,555555,"Brasileiro");

        // inserindo equipes
        Equipe equipe1 = new Equipe("Fenerbahce",11111,1907,"Turquia");
        tecnico1.contratar(equipe1);
        Equipe equipe2 = new Equipe("Manchester City",22222,1894,"Inglaterra");
        tecnico2.contratar(equipe2);
        Equipe equipe3 = new Equipe("Real Madrid",33333,1902,"Espanha");
        tecnico3.contratar(equipe3);
        Equipe equipe4 = new Equipe("Bayer Leverkusen",44444,1904,"Alemanha");
        tecnico4.contratar(equipe4);
        Equipe equipe5 = new Equipe("Flamengo",55555,1895,"Brasil");
        tecnico5.contratar(equipe5);

        // inserindo jogadores
        // fenerbahce
        Jogador jogador01 = new Jogador("Talisca",31,100000,"Brasileiro","Atacante");
        jogador01.contratar(equipe1);
        Jogador jogador02 = new Jogador("Skriniar",30,150000,"Eslovaco","Defensor");
        jogador02.contratar(equipe1);
        Jogador jogador03 = new Jogador("Dzeko",39,180000,"Bósnio","Atacante");
        jogador03.contratar(equipe1);

        // manchester city
        Jogador jogador04 = new Jogador("De Bruyne",33,200000,"Belga","Meia");
        jogador04.contratar(equipe2);
        Jogador jogador05 = new Jogador("Doku",22,250000,"Belga","Atacante");
        jogador05.contratar(equipe2);
        Jogador jogador06 = new Jogador("Ederson",31,280000,"Brasileiro","Goleiro");
        jogador06.contratar(equipe2);

        // real madrid
        Jogador jogador07 = new Jogador("Vinícius Júnior",24,300000,"Brasileiro","Atacante");
        jogador07.contratar(equipe3);
        Jogador jogador08 = new Jogador("Modric",39,350000,"Croata","Meia");
        jogador08.contratar(equipe3);
        Jogador jogador09 = new Jogador("Courtois",32,380000,"Belga","Goleiro");
        jogador09.contratar(equipe3);

        // bayer leverkusen
        Jogador jogador10 = new Jogador("Frimpong",24,400000,"Holandês","Defensor");
        jogador10.contratar(equipe4);
        Jogador jogador11 = new Jogador("Wirtz",22,450000,"Alemão","Meia");
        jogador11.contratar(equipe4);
        Jogador jogador12 = new Jogador("Tah",29,480000,"Alemão","Defensor");
        jogador12.contratar(equipe4);

        // flamengo
        Jogador jogador13 = new Jogador("Rossi",29,500000,"Argentino","Goleiro");
        jogador13.contratar(equipe5);
        Jogador jogador14 = new Jogador("Arrascaeta",30,550000,"Uruguaio","Meia");
        jogador14.contratar(equipe5);
        Jogador jogador15 = new Jogador("Pedro",27,580000,"Brasileiro","Atacante");
        jogador15.contratar(equipe5);

        // inserindo patrocinadores
        Patrocinador patrocinador1 = new Patrocinador("Puma",10000);
        Patrocinador patrocinador2 = new Patrocinador("Etihad Airways",20000);
        Patrocinador patrocinador3 = new Patrocinador("Fly Emirates",30000);
        Patrocinador patrocinador4 = new Patrocinador("Bayer",40000);
        Patrocinador patrocinador5 = new Patrocinador("PixBet",50000);

        // inserindo patrocínios às equipes
        patrocinador1.contratar(equipe1,30000000);
        patrocinador1.contratar(equipe2, 65000000);
        patrocinador2.contratar(equipe2, 400000000);
        patrocinador3.contratar(equipe3, 70000000);
        patrocinador4.contratar(equipe4, 30000000);
        patrocinador5.contratar(equipe5,23000000);

        // inserindo Federações
        Federacao federacao1 = new Federacao("TFF", 111);
        Federacao federacao2 = new Federacao("EFA", 222);
        Federacao federacao3 = new Federacao("RFEF", 333);
        Federacao federacao4 = new Federacao("DFB", 444);
        Federacao federacao5 = new Federacao("CBF", 555);
        Federacao federacao6 = new Federacao("FIFA", 666);
        Federacao federacao7 = new Federacao("UEFA", 777);
        Federacao federacao8 = new Federacao("CONMEBOL", 888);

        // inserindo arbitros
        Arbitro arbitro1 = new Arbitro("Bitigen",42,910000);
        arbitro1.contratar(federacao1);
        Arbitro arbitro2 = new Arbitro("Oliver",40,920000);
        arbitro2.contratar(federacao2);
        Arbitro arbitro3 = new Arbitro("Bengoetxa",39,930000);
        arbitro3.contratar(federacao3);
        Arbitro arbitro4 = new Arbitro("Brych",49,940000);
        arbitro4.contratar(federacao4);
        Arbitro arbitro5 = new Arbitro("Daronco",44,950000);
        arbitro5.contratar(federacao5);
        Arbitro arbitro6 = new Arbitro("Marciniak",41,960000);
        arbitro6.contratar(federacao6);
        Arbitro arbitro7 = new Arbitro("Turpin",42,970000);
        arbitro7.contratar(federacao7);
        Arbitro arbitro8 = new Arbitro("Roldán",45,980000);
        arbitro8.contratar(federacao8);

        // inserindo campeonatos
        Campeonato campeonato1 = new Campeonato("SuperLig","Turquia",25000000);
        campeonato1.adicionarFederacao(federacao1);
        Campeonato campeonato2 = new Campeonato("Turkiye Kupasi","Turquia",10000000);
        campeonato2.adicionarFederacao(federacao1);
        Campeonato campeonato3 = new Campeonato("Premier League","Inglaterra",175000000);
        campeonato3.adicionarFederacao(federacao2);
        Campeonato campeonato4 = new Campeonato("FA Cup","Inglaterra",2000000);
        campeonato4.adicionarFederacao(federacao2);
        Campeonato campeonato5 = new Campeonato("Carabao Cup","Inglaterra",1000000);
        campeonato5.adicionarFederacao(federacao2);
        Campeonato campeonato6 = new Campeonato("LaLiga","Espanha",143000000);
        campeonato6.adicionarFederacao(federacao3);
        Campeonato campeonato7 = new Campeonato("Copa Del Rey","Espanha",2000000);
        campeonato7.adicionarFederacao(federacao3);
        Campeonato campeonato8 = new Campeonato("Bundesliga","Alemanha",76000000);
        campeonato8.adicionarFederacao(federacao4);
        Campeonato campeonato9 = new Campeonato("DFB Pokal","Alemanha",1000000);
        campeonato9.adicionarFederacao(federacao4);
        Campeonato campeonato10 = new Campeonato("Brasileirão","Brasil",9000000);
        campeonato10.adicionarFederacao(federacao5);
        Campeonato campeonato11 = new Campeonato("Copa do Brasil","Brasil",20000000);
        campeonato11.adicionarFederacao(federacao5);
        Campeonato campeonato12 = new Campeonato("Mundial de Clubes","Estados Unidos",125000000);
        campeonato12.adicionarFederacao(federacao6);
        Campeonato campeonato13 = new Campeonato("Champions League","Europa",127000000);
        campeonato13.adicionarFederacao(federacao7);
        Campeonato campeonato14 = new Campeonato("Europa League","Europa",14000000);
        campeonato14.adicionarFederacao(federacao7);
        Campeonato campeonato15 = new Campeonato("Libertadores","América do Sul",24000000);
        campeonato15.adicionarFederacao(federacao8);
        Campeonato campeonato16 = new Campeonato("Sulamericana","América do Sul",5000000);
        campeonato16.adicionarFederacao(federacao8);

        // inserindo equipes nos campeonatos
        // Fenerbahce
        equipe1.adicionarCampeonato(campeonato1);
        equipe1.adicionarCampeonato(campeonato2);
        equipe1.adicionarCampeonato(campeonato14);

        // Manchester City
        equipe2.adicionarCampeonato(campeonato3);
        equipe2.adicionarCampeonato(campeonato4);
        equipe2.adicionarCampeonato(campeonato5);
        equipe2.adicionarCampeonato(campeonato12);
        equipe2.adicionarCampeonato(campeonato13);

        // Real Madrid
        equipe3.adicionarCampeonato(campeonato6);
        equipe3.adicionarCampeonato(campeonato7);
        equipe3.adicionarCampeonato(campeonato12);
        equipe3.adicionarCampeonato(campeonato13);

        // Bayer Leverkusen
        equipe4.adicionarCampeonato(campeonato8);
        equipe4.adicionarCampeonato(campeonato9);
        equipe4.adicionarCampeonato(campeonato13);

        // Flamengo
        equipe5.adicionarCampeonato(campeonato10);
        equipe5.adicionarCampeonato(campeonato11);
        equipe5.adicionarCampeonato(campeonato12);
        equipe5.adicionarCampeonato(campeonato15);

        // teste da silva
        equipe1.mostrarInfo();
        equipe2.mostrarInfo();
        equipe3.mostrarInfo();
        equipe4.mostrarInfo();
        equipe5.mostrarInfo();


    }
}