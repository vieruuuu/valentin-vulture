package vv.Tiles;

import vv.Graphics.Assets;

/**
 * The BedTile class extends the Tile class and represents a non-solid tile.
 */
public class BedWinterTile extends Tile {
  public BedWinterTile(int id) {
    super(Assets.bedWinter, id);
  }

  @Override
  public boolean isSolid() {
    return false;
  }

  @Override
  public boolean isBed() {
    return true;
  }

}
