package VV.Tiles;

import VV.Graphics.Assets;

public class FloorWinterTile extends Tile {
  public FloorWinterTile(int id) {
    super(Assets.floorWinter, id);
  }

  @Override
  public boolean isSolid() {
    return false;
  }
}
