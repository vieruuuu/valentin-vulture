package vv.Maps;

import java.awt.Point;
import java.util.Random;

import vv.Game;
import vv.Items.Enemy;
import vv.Tiles.Tile;

public class WideRoom extends Room {
  public String type() {
    return "wide";
  }

  protected Point doorTop() {
    return new Point(width / 2, 2);
  }

  protected Point doorBottom() {
    return new Point(width / 2, 10);
  }

  public WideRoom(Floor floorRef, Point pos) {
    super(floorRef, pos);
  }

  protected void generateEnemies() {
    for (int i = 0; i < enemies.length; i++) {
      var posX = 0;
      var posY = 0;

      do {
        posX = rand.nextInt(1060 - 460) + 460;
        posY = rand.nextInt(560 - 210) + 210;
      } while (getTileUnsafe(posX, posY) == null);

      enemies[i] = randomEnemy(posX, posY);
    }
  }

  protected void generateBed() {
    if (rand.nextInt(3) == 0) {
      var x = rand.nextInt(13);
      var y = rand.nextInt(10 - 2) + 2;

      if (x == 0 || x == 12) {
        x = 3;
      }

      if (y < 2 || y > 10) {
        y = 3;
      }

      tiles[x][y] = 13 * theme;
    }
  }

  protected void generateTiles() {
    for (int i = 0; i < width; ++i) {
      for (int j = 0; j < height; ++j) {
        if (j < 2 || j > 10) {
          tiles[i][j] = 113;
          continue;
        }

        if (i == 0 || j == 2 || i == width - 1 || j == 10) {
          tiles[i][j] = 5 * theme;
          continue;
        }

        if (i == width / 2 && j == height / 2) {
          tiles[i][j] = 3 * theme;
          continue;
        }

        var rnd = rand.nextInt(30);

        if (rnd == 0 || rnd == 1) {
          tiles[i][j] = 11 * theme; // rock
        } else if (rnd == 2) {
          tiles[i][j] = 7 * theme; // water
        } else if (rnd == 4) {
          tiles[i][j] = 19 * theme; // spikes
        } else {
          tiles[i][j] = 3 * theme; // floor
        }

      }
    }

  }
}
