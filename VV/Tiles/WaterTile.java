package VV.Tiles;

import VV.Graphics.Assets;

public class WaterTile extends Tile {

  public WaterTile(int id) {
    super(Assets.water, id);
  }

  @Override
  public boolean IsSolid() {
    return true;
  }
}
