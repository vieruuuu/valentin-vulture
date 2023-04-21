package VV.Maps;

import VV.Game;
import VV.Tiles.Tile;

import java.awt.*;
import java.util.Random;

public class Map {
  private int width;
  private int height;
  private int[][] tiles;

  private static Map instance;

  public static Map getInstance() {
    if (instance == null) {
      instance = new Map();
    }

    return instance;
  }

  private Map() {
    LoadWorld();
  }

  public void Update() {

  }

  public void setTile(int x, int y, int tileId) {
    var testX = (x - 270) / Tile.TILE_HEIGHT - 1;
    // System.out.println(x + " " + testX);

    var testY = (y + 90) / Tile.TILE_HEIGHT;
    // System.out.println(y + " " + testY);

    tiles[testX][testY] = tileId;
  }

  public Tile getTile(int x, int y) {
    var testX = (x - 270) / Tile.TILE_HEIGHT - 1;
    // System.out.println(x + " " + testX);

    var testY = (y + 90) / Tile.TILE_HEIGHT;
    // System.out.println(y + " " + testY);

    return Tile.tiles[tiles[testX][testY]];
  }

  public void Draw(Graphics g) {
    /// Se parcurge matricea de dale (codurile aferente) si se deseneaza harta
    /// respectiva
    for (int y = 0; y < Game.getInstance().GetHeight() / Tile.TILE_HEIGHT; y++) {
      for (int x = 0; x < (Game.getInstance().GetWidth() / Tile.TILE_WIDTH); x++) {
        GetTile(x, y).Draw(g, 256 + 128 + (int) x * Tile.TILE_HEIGHT, (int) y * Tile.TILE_WIDTH);
      }
    }
  }

  public Tile GetTile(int x, int y) {
    if (x < 0 || y < 0 || x >= width || y >= height) {
      return Tile.floorTile;
    }
    Tile t = Tile.tiles[tiles[x][y]];
    if (t == null) {
      return Tile.floorTile;
    }
    return t;
  }

  public void LoadWorld() {
    /// Se stabileste latimea hartii in numar de dale.
    width = 13;
    /// Se stabileste inaltimea hartii in numar de dale
    height = 13;
    /// Se construieste matricea de coduri de dale
    tiles = new int[width][height];
    Random rand = new Random();

    for (int i = 0; i < width; ++i) {
      for (int j = 0; j < height; ++j) {
        if (i == 0 || j == 0 || i == width - 1 || j == height - 1) {
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

    // generate doors

    var oneDoor = false;

    if (rand.nextInt(3) == 0) {
      oneDoor = true;
      tiles[width / 2][0] = 3;
    }
    if (rand.nextInt(3) == 0) {
      oneDoor = true;
      tiles[width / 2][height - 1] = 3;
    }
    if (rand.nextInt(3) == 0) {
      oneDoor = true;
      tiles[0][height / 2] = 3;
    }

    if (rand.nextInt(3) == 0 || !oneDoor) {
      tiles[width - 1][height / 2] = 3;
    }

    // generate bed
    if (rand.nextInt(3) == 0) {
      var x = rand.nextInt(13);
      var y = rand.nextInt(13);

      if (x == 0 || x == 12) {
        x = 3;
      }

      if (y == 0 || y == 12) {
        y = 3;
      }

      tiles[x][y] = 4;
    }
  }
}
