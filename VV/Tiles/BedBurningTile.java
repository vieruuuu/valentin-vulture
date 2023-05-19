package VV.Tiles;

import VV.Graphics.Assets;

/**
 * The BedTile class extends the Tile class and represents a non-solid tile.
 */
public class BedBurningTile extends Tile {
  public BedBurningTile(int id) {
    super(Assets.bedBurning, id);
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
