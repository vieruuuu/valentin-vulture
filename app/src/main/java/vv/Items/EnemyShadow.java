package vv.Items;

import vv.Graphics.Assets;
import vv.States.PlayState;

public class EnemyShadow extends Enemy {
  public EnemyShadow(float x, float y) {
    super(x, y);

    image = Assets.shadow;
  }

  @Override
  public void Update() {
    var hi = PlayState.getInstance().hero;

    if (x != hi.x || y != hi.y) {
      xMove = x > hi.x ? -1 : 1;
      yMove = y > hi.y ? -1 : 1;

      Move();
    }
  }
}
