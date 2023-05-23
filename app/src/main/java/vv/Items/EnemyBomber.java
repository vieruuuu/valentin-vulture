package vv.Items;

import java.util.Random;

import vv.Graphics.Assets;
import vv.Maps.Map;
import vv.States.PlayState;

public class EnemyBomber extends Enemy {
  public EnemyBomber(float x, float y) {
    super(x, y);

    image = Assets.bomber;

    life = 10;
  }

  @Override
  public void Update() {
    var hi = PlayState.getInstance().hero;
    var ri = Map.getInstance().floor.room;

    if (Math.abs(x - hi.x) > 30 || Math.abs(y - hi.y) > 30) {
      var rndX = new Random().nextInt(1) + 1;
      var rndY = new Random().nextInt(1) + 1;

      xMove = (x > hi.x ? -1 : 1) * rndX;
      yMove = (y > hi.y ? -1 : 1) * rndY;

      Move();

      ri.setTile((int) x, (int) y, 19 * ri.theme);
    } else {
      hi.takeDamage();
    }

  }
}
