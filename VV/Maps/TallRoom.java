package VV.Maps;

import java.awt.Point;

public class TallRoom extends Room {
  public String type() {
    return "tall";
  }

  protected Point doorLeft() {
    return new Point(2, height / 2);
  }

  protected Point doorRight() {
    return new Point(10, height / 2);
  }

  public TallRoom(Floor floorRef, Point pos) {
    super(floorRef, pos);
  }

  protected void generateBed() {
    if (rand.nextInt(3) == 0) {
      var x = rand.nextInt(10 - 2) + 2;
      var y = rand.nextInt(13);

      if (x < 2 || x > 10) {
        x = 3;
      }

      if (y == 0 || y == 12) {
        y = 3;
      }

      tiles[x][y] = 13 * theme;
    }
  }

  protected void generateTiles() {
    for (int i = 0; i < width; ++i) {
      for (int j = 0; j < height; ++j) {
        if (i < 2 || i > 10) {
          tiles[i][j] = 113;
          continue;
        }

        if (i == 2 || j == 0 || i == 10 || j == height - 1) {
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
