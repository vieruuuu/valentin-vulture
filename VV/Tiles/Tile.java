package VV.Tiles;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

/**
 * The Tile class defines different types of tiles with their respective images
 * and properties for a game.
 */
public class Tile {
  private static final int NO_TILES = 128;
  public static Tile[] tiles = new Tile[NO_TILES];

  public static Tile floorTile = new FloorTile(3);
  public static Tile wallTile = new WallTile(5);
  public static Tile waterTile = new WaterTile(7);
  public static Tile rockTile = new RockTile(11);
  public static Tile bedTile = new BedTile(13);
  public static Tile doorTile = new DoorTile(17);
  public static Tile spikesTile = new SpikesTile(19);

  public static Tile floorWinterTile = new FloorWinterTile(3 * 2);
  public static Tile wallWinterTile = new WallWinterTile(5 * 2);
  public static Tile waterWinterTile = new WaterWinterTile(7 * 2);
  public static Tile rockWinterTile = new RockWinterTile(11 * 2);
  public static Tile bedWinterTile = new BedWinterTile(13 * 2);
  public static Tile doorWinterTile = new DoorWinterTile(17 * 2);
  public static Tile spikesWinterTile = new SpikesWinterTile(19 * 2);

  public static Tile floorBurningTile = new FloorBurningTile(3 * 3);
  public static Tile wallBurningTile = new WallBurningTile(5 * 3);
  public static Tile waterBurningTile = new WaterBurningTile(7 * 3);
  public static Tile rockBurningTile = new RockBurningTile(11 * 3);
  public static Tile bedBurningTile = new BedBurningTile(13 * 3);
  public static Tile doorBurningTile = new DoorBurningTile(17 * 3);
  public static Tile spikesBurningTile = new SpikesBurningTile(19 * 3);

  public static Tile blackTile = new BlackTile(113);

  public static final int TILE_WIDTH = 64;
  public static final int TILE_HEIGHT = 64;

  protected BufferedImage img;
  protected final int id;

  public Tile(BufferedImage image, int idd) {
    img = image;
    id = idd;

    tiles[id] = this;
  }

  public void Update() {

  }

  public void Draw(Graphics g, int x, int y) {

    g.drawImage(img, x, y, TILE_WIDTH, TILE_HEIGHT, null);
  }

  public void rotate() {
    AffineTransform tx = new AffineTransform();
    tx.rotate(0.5, img.getWidth() / 2, img.getHeight() / 2);

    AffineTransformOp op = new AffineTransformOp(tx,
        AffineTransformOp.TYPE_BILINEAR);

    img = op.filter(img, null);

  }

  public boolean isSolid() {
    return false;
  }

  public boolean isBed() {
    return false;
  }

  public boolean isDoor() {
    return false;
  }

  public boolean isDangerous() {
    return false;
  }

  public boolean isWater() {
    return false;
  }

  public int GetId() {
    return id;
  }
}
