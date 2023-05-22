package vv.Tiles;

import vv.Graphics.Assets;

public class WaterBurningTile extends Tile {
  public WaterBurningTile(int id) {
    super(Assets.waterBurning, id);
  }

  @Override
  public boolean isWater() {
    return true;
  }
}
