package VV.Tiles;

import VV.Graphics.Assets;

public class WallBurningTile extends Tile {
  public WallBurningTile(int id) {
    super(Assets.wallBurning, id);
  }

  @Override
  public boolean isSolid() {
    return true;
  }
}
