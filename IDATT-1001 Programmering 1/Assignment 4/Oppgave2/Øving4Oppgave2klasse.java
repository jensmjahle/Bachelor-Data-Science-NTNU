import java.util.*;

class Player {
    int sumPoeng;
    String playerName;
    Random terning = new Random();

    public Player(int sumPoeng, String playerName) {
        this.sumPoeng = sumPoeng;
        this.playerName = playerName;
    }

    public int getSumPoeng() {
        return sumPoeng;

    }

    public int kastTerning(int score) {
        int terningkast = terning.nextInt(6);
        terningkast++;
        if (terningkast == 1) {
            score = 0;
        }
        if (score > 100) {
            score = score - terningkast;
        } else {
            score = score + terningkast;
        }
        return score;

    }

    public String getPlayerName() {
        return playerName;
    }
}
