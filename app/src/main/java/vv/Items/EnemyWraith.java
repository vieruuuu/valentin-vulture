package vv.Items;

import vv.Graphics.Assets;
import vv.States.PlayState;

public class EnemyWraith extends Enemy {
  public EnemyWraith(float x, float y) {
    super(x, y);

    image = Assets.wraith;
  }

  @Override
  public void Update() {
    var hi = PlayState.getInstance().hero;

    if (Math.abs(x - hi.x) > 10 || Math.abs(y - hi.y) > 10) {

      xMove = x > hi.x ? -1 : 1;
      yMove = y > hi.y ? -1 : 1;

      Move();
    } else {
      hi.takeDamage();
    }

  }
}
