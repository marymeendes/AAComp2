/**
 * Created by filipebraida on 31/05/16 and adapted by Mariana Mendes and Thalia Ferreira.
 */
public class BattleChoice extends Choice {
    public BattleChoice(String description, Event event, Enemy enemy, Player player) {
        super(description, event);

        this.enemy = enemy;
        this.executeChoice(player);
    }

    @Override
    public void executeChoice(Character character) {
        character.battle(this.enemy);
    }

    private Enemy enemy;
}