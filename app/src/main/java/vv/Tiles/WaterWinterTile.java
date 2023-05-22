package vv.Tiles;

import vv.Graphics.Assets;

public class WaterWinterTile extends Tile {
  public WaterWinterTile(int id) {
    super(Assets.waterWinter, id);
  }

  @Override
  public boolean isWater() {
    return true;
  }
}
