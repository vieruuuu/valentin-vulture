
package vv.Items;

import vv.Graphics.Assets;
import vv.Maps.Map;

public class EnemyFlame extends Enemy {
  private long lastProjectileStart = 0;

  public EnemyFlame(float x, float y) {
    super(x, y);

    image = Assets.flame;
  }

  @Override
  public void Update() {
    var ri = Map.getInstance().floor.room;

    if ((System.nanoTime() - lastProjectileStart) / 1000000000 > 1) {
      lastProjectileStart = System.nanoTime();

      ri.enemies.add(new EnemyFlameProjectile(x, y));
    }
  }
}
