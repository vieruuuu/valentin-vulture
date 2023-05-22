package vv.Items;

import vv.Graphics.Assets;

public class EnemyBomber extends Enemy {
  public EnemyBomber(float x, float y) {
    super(x, y);

    image = Assets.bomber;
  }
}
