package VV.Tiles;

import VV.Graphics.Assets;

public class WaterWinterTile extends Tile {
  public WaterWinterTile(int id) {
    super(Assets.waterWinter, id);
  }

  @Override
  public boolean isSolid() {
    return true;
  }
}
