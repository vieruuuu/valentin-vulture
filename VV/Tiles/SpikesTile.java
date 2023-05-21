package VV.Tiles;

import VV.Graphics.Assets;

public class SpikesTile extends Tile {
  public SpikesTile(int id) {
    super(Assets.spikes, id);
  }

  @Override
  public boolean isDangerous() {
    return true;
  }
}
