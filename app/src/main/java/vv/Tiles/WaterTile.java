package vv.Tiles;

import vv.Graphics.Assets;

/**
 * The WaterTile class extends the Tile class and sets the tile image to water
 * while also making it solid.
 */
public class WaterTile extends Tile {

  public WaterTile(int id) {
    super(Assets.water, id);
  }

  @Override
  public boolean isWater() {
    return true;
  }
}
