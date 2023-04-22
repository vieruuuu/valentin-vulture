package VV.Maps;

import java.awt.Point;
import java.util.Random;

import VV.Game;
import VV.Tiles.Tile;

/**
 * The Room class generates and manages the tiles and doors of a room in a game.
 */
public class Room {
  private int width = 13;
  private int height = 13;

  public int[][] tiles = new int[width][height];

  private Random rand = new Random();

  private Floor floorRef;
  public Point pos;

  /**
   * This is the constructor method for the Room class. It takes in a Floor object
   * reference and a Point object representing the position of the room on the
   * floor. It initializes the instance variables floorRef and pos with the passed
   * in values. It then generates the tiles for the room by setting the values of
   * the 2D array tiles based on certain conditions. It also generates doors for
   * the room by calling the generateDoors() method. Finally, it randomly
   * generates a bed in the room by setting a tile to the value 4.
   */
  public Room(Floor floorRef, Point pos) {
    this.floorRef = floorRef;
    this.pos = pos;

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

    generateDoors();

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

  /**
   * The function generates doors in a room based on the existence of neighboring
   * rooms.
   */
  private void generateDoors() {
    // top door
    if (floorRef.roomExists(pos.x - 1, pos.y)) {
      tiles[width / 2][0] = 3;
      tiles[width / 2][1] = 0;
    }

    // bottom door
    if (floorRef.roomExists(pos.x + 1, pos.y)) {
      tiles[width / 2][height - 1] = 3;
      tiles[width / 2][height - 2] = 0;
    }

    // left door
    if (floorRef.roomExists(pos.x, pos.y - 1)) {
      tiles[0][height / 2] = 3;
      tiles[1][height / 2] = 0;
    }

    // right door
    if (floorRef.roomExists(pos.x, pos.y + 1)) {
      tiles[width - 1][height / 2] = 3;
      tiles[width - 2][height / 2] = 0;
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

  public void setTile(int x, int y, int tileId) {
    var tileX = (x - 270) / Tile.TILE_HEIGHT - 1;
    var tileY = (y + 90) / Tile.TILE_HEIGHT;

    if (tileX < 0 || tileY < 0 || tileX >= width || tileY >= height) {
      return;
    }

    tiles[tileX][tileY] = tileId;
  }

  public Tile getTile(int x, int y) {
    var tileX = (x - 270) / Tile.TILE_HEIGHT - 1;
    var tileY = (y + 90) / Tile.TILE_HEIGHT;

    if (tileX < 0 || tileY < 0 || tileX >= width || tileY >= height) {
      return Tile.floorTile;
    }

    var t = Tile.tiles[tiles[tileX][tileY]];

    if (t == null) {
      return Tile.floorTile;
    }

    return t;
  }

  /**
   * The function useDoor() updates the position of the hero and sets the room
   * based on which door they
   * entered.
   * 
   * @param x The x-coordinate of the point where the door is being used.
   * @param y The y parameter represents the vertical position of the point where
   *          the door is being used,
   *          measured in pixels.
   */
  public void useDoor(int x, int y) {
    var tileX = (x - 270) / Tile.TILE_HEIGHT - 1;
    var tileY = (y + 90) / Tile.TILE_HEIGHT;

    if (tileX < 0 || tileY < 0 || tileX >= width || tileY >= height) {
      return;
    }

    var hi = Game.getInstance().state.hero;

    // top door
    if (tileX == width / 2 && tileY == 0) {
      floorRef.setRoom(pos.x - 1, pos.y);

      hi.SetY(650);
      ;
    }

    // bottom door
    if (tileX == width / 2 && tileY == height - 1) {
      floorRef.setRoom(pos.x + 1, pos.y);

      hi.SetY(20);
    }

    // left door
    if (tileX == 0 && tileY == height / 2) {
      floorRef.setRoom(pos.x, pos.y - 1);

      hi.SetX(1064);
    }

    // right door
    if (tileX == width - 1 && tileY == height / 2) {
      floorRef.setRoom(pos.x, pos.y + 1);

      hi.SetX(450);
    }
  }
}
