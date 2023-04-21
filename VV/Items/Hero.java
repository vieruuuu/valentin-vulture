package VV.Items;

import java.awt.*;
import java.awt.image.BufferedImage;

import VV.Game;
import VV.Graphics.Assets;
import VV.Input.KeyManager;
import VV.Maps.Map;

public class Hero extends Character {
  private BufferedImage image; /* !< Referinta catre imaginea curenta a eroului. */

  private boolean isDemon = false;

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

  @Override
  public void Update() {
    var km = KeyManager.getInstance();
    var gi = Game.getInstance();
    var mi = Map.getInstance();

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

    if (mi.getTile((int) nextX, (int) y).isSolid()) {
      xMove = 0;
    }

    if (mi.getTile((int) x, (int) nextY).isSolid()) {
      yMove = 0;
    }

    if (mi.getTile((int) nextX, (int) nextY).isDoor()) {
      xMove = 0;
      yMove = 0;

      x = gi.GetWidth() / 2 + 140;
      y = gi.GetHeight() / 2 - 80;

      mi.LoadWorld();
    } else if (mi.getTile((int) nextX, (int) nextY).isBed()) {
      gi.bedCount++;

      mi.setTile((int) nextX, (int) nextY, 0);
    }

    Move();

    if (km.left) {
      image = isDemon ? Assets.demonLeft : Assets.humanLeft;
    }
    if (km.right) {
      image = isDemon ? Assets.demonRight : Assets.humanRight;
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
