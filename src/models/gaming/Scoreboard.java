package src.models.gaming;

import src.models.player.HumanPlayer;
import java.util.ArrayList;
import java.util.List;


public class Scoreboard {
    private static final List<HumanPlayer> players = new ArrayList<>();

    public static void addOrUpdatePlayer(HumanPlayer player) {
        for (HumanPlayer p : players) {
            if (p.getName().equals(player.getName())) {
                p.setVictories(p.getVictories() + 1);
                return;
            }
        }
        player.setVictories(1);
        players.add(player);
    }

    public static List<HumanPlayer> getPlayers() {
        return players;
    }

    public static void reset() {
        players.clear();
    }
}
