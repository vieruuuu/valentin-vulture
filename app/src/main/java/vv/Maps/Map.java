package vv.Maps;

import vv.Game;
import vv.Items.Enemy;
import vv.Tiles.Tile;

import java.awt.*;

/**
 * The Map class is a singleton that contains a Floor object and methods for
 * updating and drawing the
 * tiles on the floor.
 */
public class Map {
  private static Map instance;

  /**
   * This function returns an instance of a Map object, creating it if it doesn't
   * already exist.
   * 
   * @return The method `getInstance()` returns an instance of the `Map` class.
   */
  public static Map getInstance() {
    if (instance == null) {
      instance = new Map();
    }

    return instance;
  }

  public Floor floor = new Floor();

  private Map() {

  }

  public void Update() {
    for (Enemy enemy : floor.room.enemies) {
      enemy.Update();
    }

  }

  /**
   * This function draws tiles on the screen using the Graphics object.
   * 
   * @param g The Graphics object used for drawing on the screen.
   */
  public void Draw(Graphics g) {
    for (int y = 0; y < Game.getInstance().GetHeight() / Tile.TILE_HEIGHT; y++) {
      for (int x = 0; x < (Game.getInstance().GetWidth() / Tile.TILE_WIDTH); x++) {
        floor.room.GetTile(x, y).Draw(g, 256 + 128 + (int) x * Tile.TILE_HEIGHT, (int) y * Tile.TILE_WIDTH);
      }
    }

    for (Enemy enemy : floor.room.enemies) {
      enemy.Draw(g);
    }
  }
}
