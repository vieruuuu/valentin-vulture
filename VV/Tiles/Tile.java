package VV.Tiles;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class Tile {
  private static final int NO_TILES = 32;
  public static Tile[] tiles = new Tile[NO_TILES];

  public static Tile floorTile = new FloorTile(0);
  public static Tile wallTile = new WallTile(1);
  public static Tile waterTile = new WaterTile(2);
  public static Tile doorTile = new DoorTile(3);
  public static Tile bedTile = new BedTile(4);
  public static Tile rockTile = new RockTile(5);

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

  public boolean IsSolid() {
    return false;
  }

  public boolean isDoor() {
    return false;
  }

  public int GetId() {
    return id;
  }
}
