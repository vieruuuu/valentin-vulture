package VV.Tiles;

import VV.Graphics.Assets;

public class BedTile extends Tile {
  public BedTile(int id) {
    super(Assets.bed, id);
  }

  @Override
  public boolean IsSolid() {
    return false;
  }
}
