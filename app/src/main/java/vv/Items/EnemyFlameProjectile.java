
package vv.Items;

import java.util.Random;

import vv.Graphics.Assets;
import vv.States.PlayState;

public class EnemyFlameProjectile extends Enemy {
  public EnemyFlameProjectile(float x, float y) {
    super(x, y);

    image = Assets.flameProjectile;

    life = 2;
  }

  @Override
  public void Update() {
    var hi = PlayState.getInstance().hero;

    if (Math.abs(x - hi.x) > 30 || Math.abs(y - hi.y) > 30) {
      var rndX = new Random().nextInt(3) + 2;
      var rndY = new Random().nextInt(3) + 2;

      xMove = (x > hi.x ? -1 : 1) * rndX;
      yMove = (y > hi.y ? -1 : 1) * rndY;

      Move();
    } else {
      life = 0;

      hi.takeDamage();
    }
  }
}
