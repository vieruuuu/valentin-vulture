
import VV.Game;

/**
 * The Main class starts the game by calling the StartGame method of the Game
 * singleton instance.
 */
public class Main {
  public static void main(String[] args) {
    Game.getInstance().StartGame();
  }
}
