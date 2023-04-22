package VV.Tiles;

import VV.Graphics.Assets;

/**
 * The BedTile class extends the Tile class and represents a non-solid tile.
 */
public class BedTile extends Tile {
  public BedTile(int id) {
    super(Assets.bed, id);
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
