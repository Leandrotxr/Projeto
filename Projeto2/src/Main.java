import futebol.campeonatos.Campeonato;
import futebol.pessoa_fisica.Arbitro;
import futebol.pessoa_fisica.Jogador;
import futebol.pessoa_fisica.Tecnico;
import futebol.pessoa_juridica.Equipe;
import futebol.pessoa_juridica.Federacao;
import futebol.pessoa_juridica.Patrocinador;

public class Main {
    public static void main(String[] args) {

        Jogador jogador1 = new Jogador("Vinicius",23,789987,"brasileiro","ponta esquerdo");
        Equipe equipe1 = new Equipe("Real Madrid",11111,1900,"Espanha");
        Tecnico tecnico1 = new Tecnico("Ancelloti",60,756489,"italiano");
        Patrocinador patrocinador1 = new Patrocinador("aaa",22222);
        Arbitro arbitro1 = new Arbitro("Junior",46,77777);
        Federacao federacao1 = new Federacao("FIFA",44444);
        Campeonato campeonato1 = new Campeonato("Mundial","Mundo",1000000);

        equipe1.adicionarCampeonato(campeonato1);
        federacao1.adicionarCampeonato(campeonato1);
        arbitro1.contratar(federacao1);
        patrocinador1.contratar(equipe1,1000);
        tecnico1.contratar(equipe1);
        jogador1.contratar(equipe1);
        equipe1.mostrarInfo();




        /*Bruxo bruxo1 = new Bruxo("Harry Potter",20,"masculino");
        Varinha varinha1 = new Varinha("Varinha de azevinho");
        Varinha varinha2 = new Varinha("Varinha das Varinhas ");
        bruxo1.adicionaVarinha(varinha1);
        bruxo1.adicionaVarinha(varinha2);
        bruxo1.mostrarInfos();*/
    }
}