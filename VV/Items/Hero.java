package VV.Items;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

import VV.Game;
import VV.Graphics.Assets;
import VV.Input.KeyManager;
import VV.Maps.Floor;
import VV.Maps.Map;
import VV.States.PlayState;

public class Hero extends Character {
  private BufferedImage image; /* !< Referinta catre imaginea curenta a eroului. */

  private boolean isDemon = false;
  public boolean isVisible = true;

  public boolean isInvincible = false;
  public long invincibleFrameStart = 0;

  public Hero(float x, float y) {
    super(x, y, 100, 100);
    image = Assets.humanLeft;
    normalBounds.x = 100 / 4;
    normalBounds.y = 100 / 2;
    normalBounds.width = 50;
    normalBounds.height = 50;

    attackBounds.x = 10;
    attackBounds.y = 10;
    attackBounds.width = 38;
    attackBounds.height = 1000;
  }

  public void takeDamage() {
    life -= 1;

    System.out.println("Player took dmg " + life);

    isInvincible = true;
    invincibleFrameStart = System.nanoTime();
  }

  @Override
  public void Update() {
    var km = KeyManager.getInstance();
    var gi = Game.getInstance();
    var mi = Map.getInstance();
    var time = System.nanoTime();

    if (life == 0) {
      gi.deadCount++;

      gi.state = new PlayState();

      mi.floor = new Floor();

      var rnd = new Random().nextInt(4);

      if (rnd == 0) {
        gi.notify("what happened ?");
      } else if (rnd == 1) {
        gi.notify("where am I ?");
      } else if (rnd == 2) {
        gi.notify("back from the start");
      } else {
        gi.notify("why????");
      }
    }

    // daca a trecut mai mult de o seconda de cand si a luat dmg
    if (isInvincible) {
      var timeDif = time - invincibleFrameStart;

      if (timeDif > 1000000000) {
        isVisible = true;
        isInvincible = false;
      } else if (timeDif > 900000000) {
        isVisible = false;
      } else if (timeDif > 800000000) {
        isVisible = true;
      } else if (timeDif > 700000000) {
        isVisible = false;
      } else if (timeDif > 600000000) {
        isVisible = true;
      } else if (timeDif > 500000000) {
        isVisible = false;
      } else if (timeDif > 400000000) {
        isVisible = true;
      } else if (timeDif > 300000000) {
        isVisible = false;
      } else if (timeDif > 200000000) {
        isVisible = true;
      } else {
        isVisible = false;
      }
    }

    isDemon = life == 1;

    GetInput();

    var nextX = x + xMove;
    var nextY = y + yMove;

    // cancel x movement
    if (nextX < 356 || nextX > gi.GetWidth() - 70) {
      xMove = 0;
    }

    // cancel y movement
    if (nextY < -50 || nextY > 730) {
      yMove = 0;
    }

    if (mi.floor.room.getTile((int) nextX, (int) y).isSolid()) {
      xMove = 0;
    }

    if (mi.floor.room.getTile((int) x, (int) nextY).isSolid()) {
      yMove = 0;
    }

    if (mi.floor.room.getTile((int) nextX, (int) nextY).isWater()) {
      gi.shoesSoaked = true;

      if (!gi.showNotify) {
        var rnd = new Random().nextInt(4);

        if (rnd == 0) {
          gi.notify("now im wet");
        } else if (rnd == 1) {
          gi.notify("my shoes are soaked");
        } else if (rnd == 2) {
          gi.notify("splash.. not my jordans..");
        } else {
          gi.notify("I feel water on my socks");
        }
      }
    }

    if (mi.floor.room.getTile((int) nextX, (int) nextY).isDoor()) {
      xMove = 0;
      yMove = 0;

      mi.floor.room.useDoor((int) nextX, (int) nextY);
    } else if (mi.floor.room.getTile((int) nextX, (int) nextY).isBed()) {
      gi.bedsCount += 1;

      var rnd = new Random().nextInt(4);

      if (rnd == 0) {
        gi.notify("finally some rest");
      } else if (rnd == 1) {
        gi.notify("such comfort");
      } else if (rnd == 2) {
        gi.notify("I miss my bed");
      } else {
        gi.notify("ZzzzZzz");
      }

      life = 5;

      mi.floor.room.setTile((int) nextX, (int) nextY, 3 * mi.floor.room.theme);
    } else if (!isInvincible && mi.floor.room.getTile((int) nextX, (int) nextY).isDangerous()) {
      var rnd = new Random().nextInt(4);

      if (rnd == 0) {
        gi.notify("my feet are bleeding");
      } else if (rnd == 1) {
        gi.notify("I should be more careful");
      } else if (rnd == 2) {
        gi.notify("spiky");
      } else {
        gi.notify("that's sharp");
      }

      takeDamage();

      if (life == 0) {
        gi.deathBySpikes = true;
      }

    }

    Move();

    if (isVisible) {
      image = isDemon ? Assets.demonLeft : Assets.humanLeft;

      if (km.right) {
        image = isDemon ? Assets.demonRight : Assets.humanRight;
      }
    } else {
      image = Assets.invisible;
    }

    float waterSpeed = mi.floor.room.getTile((int) x, (int) y).isWater() ? 0.5F : 1.0F;

    if (isDemon) {
      speed = DEFAULT_SPEED * 2 * waterSpeed;
    } else {
      speed = DEFAULT_SPEED * waterSpeed;
    }

  }

  private void GetInput() {
    xMove = 0;
    yMove = 0;

    var km = KeyManager.getInstance();

    if (km.up) {
      yMove = -speed;
    }

    if (km.down) {
      yMove = speed;
    }

    if (km.left) {
      xMove = -speed;
    }

    if (km.right) {
      xMove = speed;
    }
  }

  @Override
  public void Draw(Graphics g) {
    g.drawImage(image, (int) x, (int) y, width, height, null);

    /// doar pentru debug daca se doreste vizualizarea dreptunghiului de coliziune
    /// altfel se vor comenta urmatoarele doua linii
    // g.setColor(Color.blue);
    // g.fillRect((int) (x + bounds.x), (int) (y + bounds.y), bounds.width,
    // bounds.height);
  }
}
