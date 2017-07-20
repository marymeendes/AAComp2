import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by filipebraida on 31/05/16 and adapted by Mariana Mendes and Thalia Ferreira.
 */
public class Book {
	
	public Book(String description, Event eventInitial, Player player) {
	        this.eventInitial = eventInitial;
	        this.description = description;
	        this.player = player;

	        this.resetHistory();
	    }
    
    public File openFileChoices() throws IOException{
    	File file = new File("choices.txt");
		return file;
    }

    public void resetHistory() {
        this.eventActually = this.eventInitial;
    }

    public String showHistory(File file) throws IOException {
        return this.eventActually.history(file);
    }

    public boolean isTheEnd() {
        return this.eventActually.isEndEvent();
    }

    public void showHistoryBook() throws IOException{
        File file = new File("prologue.txt");
        BufferedReader br = new BufferedReader (new FileReader(file));
		String line;

		while((line = br.readLine()) != null){
			System.out.println(line);;
		}
        
    }

    public boolean nextEvent(int number) {
        Choice choice = this.selectChoice(number);

        if(choice != null) {
            choice.executeChoice(player);

            if(player.isAlive()) {
                this.eventActually = choice.getEvent();
                this.eventActually.applyHistory(player);
            }
            else {
                Event gameOver = new BlankEvent("Game Over", new ArrayList<Choice>());
                this.eventActually = gameOver;
            }

            return true;
        }

        return false;
    }

    public Choice selectChoice(int number) {
        return this.eventActually.findChoice(number);
    }

    public Collection<Choice> nextEvents() {
        return this.eventActually.nextEvents();
    }

    private Event eventActually;
    private Event eventInitial;
    private String description;
    private Player player;
}