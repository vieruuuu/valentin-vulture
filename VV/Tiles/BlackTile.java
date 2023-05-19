package VV.Tiles;

import VV.Graphics.Assets;

public class BlackTile extends Tile {
  public BlackTile(int id) {
    super(Assets.black, id);
  }

  @Override
  public boolean isSolid() {
    return true;
  }

}
