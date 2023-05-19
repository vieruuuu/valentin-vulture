package VV.Maps;

import java.awt.Point;
import java.util.Random;

import VV.Game;
import VV.Tiles.Tile;

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

  protected void generateTiles() {
    for (int i = 0; i < width; ++i) {
      for (int j = 0; j < height; ++j) {
        if (j < 2 || j > 10) {
          tiles[i][j] = 30;
          continue;
        }

        if (i == 0 || j == 2 || i == width - 1 || j == 10) {
          tiles[i][j] = 1;
          continue;
        }

        if (i == width / 2 && j == height / 2) {
          tiles[i][j] = 0;
          continue;
        }

        var rnd = rand.nextInt(10);

        if (rnd == 0) {
          tiles[i][j] = 5;
        } else if (rnd == 1) {
          tiles[i][j] = 2;
        } else {
          tiles[i][j] = 0;
        }

      }
    }

  }
}
