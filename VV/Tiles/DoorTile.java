package VV.Tiles;

import VV.Graphics.Assets;

public class DoorTile extends Tile {
  public DoorTile(int id) {
    super(Assets.door, id);
  }

  @Override
  public boolean IsSolid() {
    return false;
  }

  @Override
  public boolean isDoor() {
    return true;
  }
}
