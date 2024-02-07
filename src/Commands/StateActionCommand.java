package Commands;

import Model.Player;

public class StateActionCommand extends Command {

    private Player player;

    private int roll;

    public StateActionCommand(Player player, int roll) {
        this.player = player;
        this.roll = roll;
    }
    /**
     *
     */
    @Override
    public void execute() {
        player.getState().action(roll);
    }
}
