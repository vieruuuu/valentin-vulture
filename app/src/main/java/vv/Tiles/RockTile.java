package vv.Tiles;

import vv.Graphics.Assets;

/**
 * The RockTile class extends the Tile class and creates a solid tile with a
 * rock image.
 */
public class RockTile extends Tile {
  public RockTile(int id) {
    super(Assets.rock, id);
  }

  @Override
  public boolean isSolid() {
    return true;
  }
}
