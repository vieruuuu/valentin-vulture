package VV.Tiles;

import VV.Graphics.Assets;

public class SpikesWinterTile extends Tile {
  public SpikesWinterTile(int id) {
    super(Assets.spikesWinter, id);
  }

  @Override
  public boolean isDangerous() {
    return true;
  }
}
