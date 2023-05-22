package vv.Maps;

import java.awt.Point;
import java.util.Random;

import vv.Game;
import vv.Items.Enemy;
import vv.Items.EnemyBomber;
import vv.Items.EnemyFlame;
import vv.Items.EnemyShadow;
import vv.Items.EnemyWraith;
import vv.States.PlayState;
import vv.Tiles.Tile;

/**
 * The Room class generates and manages the tiles and doors of a room in a game.
 */
public class Room {
  protected int width = 13;
  protected int height = 13;

  public int[][] tiles = new int[width][height];

  protected Random rand = new Random();

  protected Floor floorRef;
  public Point pos;

  public int theme = rand.nextInt(3) + 1; // 1 sau 2 momentan

  public Enemy[] enemies = new Enemy[5];

  public String type() {
    return "normal";
  }

  protected Point doorTop() {
    return new Point(width / 2, 0);
  }

  protected Point doorBottom() {
    return new Point(width / 2, height - 1);
  }

  protected Point doorLeft() {
    return new Point(0, height / 2);
  }

  protected Point doorRight() {
    return new Point(width - 1, height / 2);
  }

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

    generateTiles();
    generateDoors();

    // generate bed
    generateBed();

    generateEnemies();
  }

  protected Enemy randomEnemy(int x, int y) {
    var rnd = rand.nextInt(5);

    switch (rnd) {
      case 1:
        return new EnemyFlame(x, y);
      case 2:
        return new EnemyWraith(x, y);
      case 3:
        return new EnemyBomber(x, y);

      default:
        return new EnemyShadow(x, y);
    }
  }

  protected void generateEnemies() {
    for (int i = 0; i < enemies.length; i++) {
      var posX = 0;
      var posY = 0;

      do {
        posX = rand.nextInt(1060 - 460) + 460;
        posY = rand.nextInt(650 - 80) + 80;
      } while (getTileUnsafe(posX, posY) == null);

      enemies[i] = randomEnemy(posX, posY);
    }
  }

  protected void generateBed() {
    if (rand.nextInt(3) == 0) {
      var x = rand.nextInt(13);
      var y = rand.nextInt(13);

      if (x == 0 || x == 12) {
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
        if (i == 0 || j == 0 || i == width - 1 || j == height - 1) {
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

  /**
   * The function generates doors in a room based on the existence of neighboring
   * rooms.
   */
  protected void generateDoors() {
    var dt = doorTop();
    var db = doorBottom();
    var dl = doorLeft();
    var dr = doorRight();

    // top door
    if (floorRef.roomExists(pos.x - 1, pos.y)) {
      tiles[dt.x][dt.y] = 17 * theme;
      tiles[dt.x][dt.y + 1] = 3 * theme;
    }

    // bottom door
    if (floorRef.roomExists(pos.x + 1, pos.y)) {
      tiles[db.x][db.y] = 17 * theme;
      tiles[db.x][db.y - 1] = 3 * theme;
    }

    // left door
    if (floorRef.roomExists(pos.x, pos.y - 1)) {
      tiles[dl.x][dl.y] = 17 * theme;
      tiles[dl.x + 1][dl.y] = 3 * theme;
    }

    // right door
    if (floorRef.roomExists(pos.x, pos.y + 1)) {
      tiles[dr.x][dr.y] = 17 * theme;
      tiles[dr.x - 1][dr.y] = 3 * theme;
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

  public Tile getTileUnsafe(int x, int y) {
    var tileX = (x - 270) / Tile.TILE_HEIGHT - 1;
    var tileY = (y + 90) / Tile.TILE_HEIGHT;

    if (tileX < 0 || tileY < 0 || tileX >= width || tileY >= height) {
      return null;
    }

    return Tile.tiles[tiles[tileX][tileY]];
  }

  public Tile getTile(int x, int y) {
    var t = getTileUnsafe(x, y);

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
    var p = new Point(tileX, tileY);

    if (tileX < 0 || tileY < 0 || tileX >= width || tileY >= height) {
      return;
    }

    var hi = PlayState.getInstance().hero;
    var gi = Game.getInstance();

    gi.roomsVisitedCount++;

    // top door
    if (doorTop().equals(p)) {
      floorRef.setRoom(pos.x - 1, pos.y);
      switch (floorRef.room.type()) {
        case "wide":
          hi.SetY(522);
          break;

        default:
          hi.SetY(650);
          break;
      }
    }

    // bottom door
    if (doorBottom().equals(p)) {
      floorRef.setRoom(pos.x + 1, pos.y);

      switch (floorRef.room.type()) {
        case "wide":
          hi.SetY(148);
          break;

        default:
          hi.SetY(20);
          break;
      }
    }

    // left door
    if (doorLeft().equals(p)) {
      floorRef.setRoom(pos.x, pos.y - 1);

      switch (floorRef.room.type()) {
        case "tall":
          hi.SetX(936);
          break;
        default:
          hi.SetX(1064);
          break;
      }
    }

    // right door
    if (doorRight().equals(p)) {
      floorRef.setRoom(pos.x, pos.y + 1);

      switch (floorRef.room.type()) {
        case "tall":
          hi.SetX(578);
          break;
        default:
          hi.SetX(450);
          break;
      }
    }

  }
}
