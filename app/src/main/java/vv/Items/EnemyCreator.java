package vv.Items;

import java.util.Random;

/**
 * The EnemyCreator is a factory class that creates a random enemy object based
 * on the given parameters.
 */
public class EnemyCreator {
  public static Enemy CreateRandomEnemy(int x, int y, int roomTheme) {
    var rnd = new Random().nextInt(7);

    switch (rnd) {
      case 1:
        if (roomTheme == 3) {
          return new EnemyFlame(x, y);
        }

        return new EnemyShadow(x, y);
      case 2:
      case 3:
        if (roomTheme == 2) {
          return new EnemyWraith(x, y);
        }

        return new EnemyShadow(x, y);
      case 4:
        return new EnemyBomber(x, y);

      default:
        return new EnemyShadow(x, y);
    }
  }
}
