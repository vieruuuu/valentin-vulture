package VV.Tiles;

import VV.Graphics.Assets;

/**
 * The DoorTile class extends the Tile class and represents a non-solid tile
 * that acts as a door.
 */
public class DoorBurningTile extends Tile {
  public DoorBurningTile(int id) {
    super(Assets.doorBurning, id);
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
