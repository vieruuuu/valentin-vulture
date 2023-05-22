package vv.Tiles;

import vv.Graphics.Assets;

/**
 * The FloorTile class extends the Tile class and represents a non-solid floor
 * tile.
 */
public class FloorTile extends Tile {
  public FloorTile(int id) {
    super(Assets.floor, id);
  }

  @Override
  public boolean isSolid() {
    return false;
  }
}
