package VV.Tiles;

import VV.Graphics.Assets;

public class RockBurningTile extends Tile {
  public RockBurningTile(int id) {
    super(Assets.rockBurning, id);
  }

  @Override
  public boolean isSolid() {
    return true;
  }

}
