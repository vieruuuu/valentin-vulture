package VV.Tiles;

import VV.Graphics.Assets;

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
