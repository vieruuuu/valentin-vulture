package VV.Tiles;

import VV.Graphics.Assets;

public class FloorTile extends Tile {
  public FloorTile(int id) {
    super(Assets.floor, id);
  }

  @Override
  public boolean IsSolid() {
    return false;
  }
}
