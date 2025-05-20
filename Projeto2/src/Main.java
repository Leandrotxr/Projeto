import futebol.pessoa_fisica.Jogador;
import futebol.pessoa_fisica.Tecnico;
import futebol.pessoa_juridica.Equipe;
import futebol.pessoa_juridica.Patrocinador;
import mundobruxo.itens.Varinha;
import mundobruxo.personagens.humanos.Bruxo;

public class Main {
    public static void main(String[] args) {

        Jogador jogador1 = new Jogador("Vinicius",23,"brasileiro","ponta esquerdo");
        Equipe equipe1 = new Equipe("Real Madrid",11111,1900,"Espanha");
        Tecnico tecnico1 = new Tecnico("Ancelloti",60,"italiano");
        Patrocinador patrocinador1 = new Patrocinador("aaa",22222);

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