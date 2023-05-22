package vv.Tiles;

import vv.Graphics.Assets;

/**
 * The DoorTile class extends the Tile class and represents a non-solid tile
 * that acts as a door.
 */
public class DoorTile extends Tile {
  public DoorTile(int id) {
    super(Assets.door, id);
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
