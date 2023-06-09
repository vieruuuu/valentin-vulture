package vv.Items;

import java.util.Random;

import vv.Graphics.Assets;
import vv.States.PlayState;

public class EnemyWraith extends Enemy {
  public EnemyWraith(float x, float y) {
    super(x, y);

    image = Assets.wraith;

    life = 3;
  }

  @Override
  public void Update() {
    var hi = PlayState.getInstance().hero;

    if (Math.abs(x - hi.x) > 30 || Math.abs(y - hi.y) > 30) {
      var rndX = new Random().nextInt(5);
      var rndY = new Random().nextInt(5);

      xMove = (x > hi.x ? -1 : 1) * rndX;
      yMove = (y > hi.y ? -1 : 1) * rndY;

      Move();
    } else {
      hi.takeDamage();
    }

  }
}
