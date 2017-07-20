import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

/**
 * Created by filipebraida on 31/05/16 and adapted by Mariana Mendes and Thalia Ferreira.
 */
public class Engine {
    public static void main(String[] args) throws IOException {
        Book book = Engine.createBook();
        File file = book.openFileChoices();

        book.showHistoryBook();

        Scanner in = new Scanner(System.in);
        
        do {
        	System.out.println(book.showHistory(file));
        	
            System.out.println("Escolha:  ");

            for(Choice choice:book.nextEvents()) {
                System.out.println(choice.getDescription());
            }

            int i;

            do {
                i = in.nextInt();
            } while(!book.nextEvent(i));
        } while(!book.isTheEnd());

        System.out.println(book.showHistory(file));
    }

    public static Book createBook() {
    	Player player = new Player(30, -50);
    	Enemy enemy = new Enemy(10, -10);
    	Enemy theodor = new Enemy(50, -10);
    	
    	Event eventoFinal = new BlankEvent("Game over", new ArrayList<Choice>());
    	Event eventoSaqueadores = new BlankEvent("7:", new ArrayList<Choice>());
    	Event eventoEcarino = new BlankEvent("10B:", new ArrayList<Choice>());
    	Event eventoEcarino2 = new BlankEvent("11B:", new ArrayList<Choice>());
    	Event gameOver = new BlankEvent("FINAL:", new ArrayList<Choice>());
    	
    	Collection choices = new ArrayList<Choice>();
    	
    	
    	choices = new ArrayList<Choice>();	
        Choice escolhaCont8 = new BlankChoice("Continuar", gameOver);
        choices.add(escolhaCont8);
    	Event eventLutaTheodor = new BlankEvent("17B:", choices);
    	
    	choices = new ArrayList<Choice>();	
        Choice escolhaCont7 = new BattleChoice("Continuar", eventLutaTheodor, theodor, player);
        choices.add(escolhaCont7);
    	Event eventStatusLutaSemElixir2 = new BlankEvent("Vida de Vania: "+player.getLife()+"\n"+"Vida de Theodor: "+theodor.getLife(), choices);
    	
    	choices = new ArrayList<Choice>();	
        Choice escolhaCont6 = new BattleChoice("Continuar", eventStatusLutaSemElixir2, theodor, player);
        choices.add(escolhaCont6);
    	Event eventStatusLutaSemElixir = new BlankEvent("Vida de Vania: "+player.getLife()+"\n"+"Vida de Theodor: "+theodor.getLife(), choices);
    	
    	choices = new ArrayList<Choice>();	
        Choice escolhaCont3 = new BlankChoice("Continuar", gameOver);
        choices.add(escolhaCont3);
    	Event eventoVenceTheodor = new BlankEvent("16B:", choices);
    	
    	choices = new ArrayList<Choice>();	
        Choice escolhaCont5 = new BattleChoice("Acabar com isso", eventoVenceTheodor, theodor, player);
        choices.add(escolhaCont5);
    	Event eventStatusLutaElixir3 = new BlankEvent("Vida de Vania: "+player.getLife()+"\n"+"Vida de Theodor: "+theodor.getLife(), choices);
    	
    	choices = new ArrayList<Choice>();	
        Choice escolhaCont4 = new BattleChoice("Continuar", eventStatusLutaElixir3, theodor, player);
        choices.add(escolhaCont4);
    	Event eventStatusLutaElixir2 = new BlankEvent("Vida de Vania: "+player.getLife()+"\n"+"Vida de Theodor: "+theodor.getLife(), choices);
    	
    	choices = new ArrayList<Choice>();	
        Choice escolhaCont2 = new BattleChoice("Continuar", eventStatusLutaElixir2, theodor, player);
        choices.add(escolhaCont2);
    	Event eventStatusLutaElixir = new BlankEvent("Vida de Vania: "+player.getLife()+"\n"+"Vida de Theodor: "+theodor.getLife(), choices);
    	
    	
    	choices = new ArrayList<Choice>();	
        Choice escolhaElixirCastelo = new BlankChoice("Toma Elixir", eventStatusLutaElixir);
        Choice escolhaLutaCastelo = new BlankChoice("Luta", eventStatusLutaSemElixir);
        choices.add(escolhaElixirCastelo);
        choices.add(escolhaLutaCastelo);
    	Event eventCastelo = new BlankEvent("15B:", choices);
    	
    	choices = new ArrayList<Choice>();	
        Choice escolhaContinuar4 = new BlankChoice("Continuar", eventCastelo);
        choices.add(escolhaContinuar4);
    	Event eventElixirMorganaFim = new BlankEvent("14B.2:", choices);
    	
    	choices = new ArrayList<Choice>();	
        Choice escolhaContinuar3 = new BattleChoice("Continuar", eventElixirMorganaFim, enemy, player);
        choices.add(escolhaContinuar3);
    	Event eventElixirMorgana = new BlankEvent("14B:", choices);
    	
    	choices = new ArrayList<Choice>();	
        Choice escolhaContinuar2 = new BlankChoice("Continuar", eventoFinal);
        choices.add(escolhaContinuar2);
    	Event eventFimParte1 = new BlankEvent("8B:", choices);
    	
    	choices = new ArrayList<Choice>();	
        Choice escolhaContinuar = new BlankChoice("Continuar", eventFimParte1);
        choices.add(escolhaContinuar);
    	Event eventElixir = new BlankEvent("8:", choices);
    	
    	choices = new ArrayList<Choice>();	
        Choice escolhaLuta3 = new BlankChoice("Luta", eventoEcarino);
        Choice escolhaElixir3 = new BlankChoice("Toma Elixir", eventElixirMorgana);
        choices.add(escolhaLuta3);
        choices.add(escolhaElixir3);
    	Event eventAjuda = new BlankEvent("6:", choices);
    	
    	choices = new ArrayList<Choice>();	
        Choice escolhaLuta2 = new BlankChoice("Luta", eventoEcarino);
        Choice escolhaElixir2 = new BlankChoice("Foge", eventoEcarino2);
        choices.add(escolhaLuta2);
        choices.add(escolhaElixir2);
    	Event eventFoge = new BlankEvent("5:", choices);
    
        
    	choices = new ArrayList<Choice>();	
        Choice escolhaContinua = new BlankChoice("Continua", eventoSaqueadores);
        Choice escolhaElixir = new BlankChoice("Toma Elixir", eventElixir);
        choices.add(escolhaContinua);
        choices.add(escolhaElixir);
    	Event eventLuta = new BlankEvent("4:", choices);
    	
    	
    	choices = new ArrayList<Choice>();	
        Choice escolhaFogeGio = new BlankChoice("Foge", eventFoge);
        Choice escolhaAjuda = new BlankChoice("Ajuda", eventAjuda);
        choices.add(escolhaAjuda);
        choices.add(escolhaFogeGio);
    	Event eventGiovanni = new BlankEvent("3:", choices);
    	
    	choices = new ArrayList<Choice>();	
        Choice escolhaLuta = new BlankChoice("Luta", eventLuta);
        Choice escolhaFoge = new BlankChoice("Foge", eventFoge);
        choices.add(escolhaLuta);
        choices.add(escolhaFoge);
    	Event peloPorto = new BlankEvent("2:", choices);
    	
    	 choices = new ArrayList<Choice>();
         Choice escolhaTrilha = new BlankChoice("Pela trilha", peloPorto);
         Choice escolhaFloresta = new BlankChoice("Pela Floresta", eventGiovanni);
         choices.add(escolhaTrilha);
         choices.add(escolhaFloresta);
         
    	Event eventoInicial = new BlankEvent("1:", choices);
    	
    	Book book = new Book("Night Hunter", eventoInicial, player);

        return book;
    }
}