package vv.Tiles;

import vv.Graphics.Assets;

/**
 * The DoorTile class extends the Tile class and represents a non-solid tile
 * that acts as a door.
 */
public class DoorWinterTile extends Tile {
  public DoorWinterTile(int id) {
    super(Assets.doorWinter, id);
  }

  @Override
  public boolean isSolid() {
    return false;
  }

  @Override
  public boolean isDoor() {
    return true;
  }
}
