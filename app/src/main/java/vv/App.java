package vv;

/**
 * The Main class starts the game by calling the StartGame method of the Game
 * singleton instance.
 */
public class App {
  public static void main(String[] args) {
    Game.getInstance().StartGame();
  }
}
