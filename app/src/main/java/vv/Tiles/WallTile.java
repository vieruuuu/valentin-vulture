package vv.Tiles;

import vv.Graphics.Assets;

/**
 * The WallTile class extends the Tile class and represents a solid wall tile.
 */
public class WallTile extends Tile {
  public WallTile(int id) {
    super(Assets.wall, id);
  }

  @Override
  public boolean isSolid() {
    return true;
  }
}
