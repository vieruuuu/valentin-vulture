package vv.Tiles;

import vv.Graphics.Assets;

public class WallWinterTile extends Tile {
  public WallWinterTile(int id) {
    super(Assets.wallWinter, id);
  }

  @Override
  public boolean isSolid() {
    return true;
  }
}
