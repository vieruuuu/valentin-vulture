package vv.Tiles;

import vv.Graphics.Assets;

public class RockWinterTile extends Tile {
  public RockWinterTile(int id) {
    super(Assets.rockWinter, id);
  }

  @Override
  public boolean isSolid() {
    return true;
  }

}
