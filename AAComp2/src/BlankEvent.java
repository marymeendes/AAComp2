import java.util.Collection;

/**
 * Created by filipebraida on 31/05/16 and adapted by Mariana Mendes and Thalia Ferreira.
 */
public class BlankEvent extends Event{
    public BlankEvent(String description, Collection<Choice> choices) {
        super(description, choices);
    }

    @Override
    public void applyHistory(Character character) {

    }
}