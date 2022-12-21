import data.GameData;
import services.auxiliary.Show;
import services.fill.Fill;
import services.game.Game;

public class Main {
    public static void main(String[] args) {

        GameData gd = new GameData();
        Fill.getData(gd);

        Game.start(gd);
    }
}
