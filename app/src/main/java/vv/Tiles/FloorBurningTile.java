package vv.Tiles;

import vv.Graphics.Assets;

public class FloorBurningTile extends Tile {
  public FloorBurningTile(int id) {
    super(Assets.floorBurning, id);
  }

  @Override
  public boolean isSolid() {
    return false;
  }
}
