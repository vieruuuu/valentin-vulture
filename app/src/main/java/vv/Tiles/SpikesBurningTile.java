package vv.Tiles;

import vv.Graphics.Assets;

public class SpikesBurningTile extends Tile {
  public SpikesBurningTile(int id) {
    super(Assets.spikesBurning, id);
  }

  @Override
  public boolean isDangerous() {
    return true;
  }
}
