import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by filipebraida on 31/05/16 and adapted by Mariana Mendes and Thalia Ferreira.
 */

public abstract class Event {
    public Event(String description, Collection<Choice> choices) {
        this.description = description;
        this.choices = new ArrayList<>();

        int i = 0;
        for(Choice choice:choices) {
            choice.defineNumber(i);
            this.choices.add(choice);
            i++;
        }

    }

    public String history(File file) throws IOException {
    	BufferedReader br = new BufferedReader (new FileReader(file));
		String line;

		while((line = br.readLine()) != null){
			if(line.contains(this.description)){
				return line.replaceAll(description, "");
			}
		}
		
		return this.description;
    }

    public boolean isEndEvent() {
        if(this.choices.isEmpty()) return true;

        return false;
    }

    public Collection<Choice> nextEvents() {
        return this.choices;
    }

    public Choice findChoice(int number) {
        for(Choice choice:this.choices) {
            if(choice.getNumber() == number) return choice;
        }

        return null;
    }

    public abstract void applyHistory(Character character);

    private String description;
    private Collection<Choice> choices;
}