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

  protected void generateTiles() {
    for (int i = 0; i < width; ++i) {
      for (int j = 0; j < height; ++j) {
        if (i < 2 || i > 10) {
          tiles[i][j] = 30;
          continue;
        }

        if (i == 2 || j == 0 || i == 10 || j == height - 1) {
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
