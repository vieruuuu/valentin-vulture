package vv.Items;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

import vv.Game;
import vv.Graphics.Assets;
import vv.Input.KeyManager;
import vv.Maps.Floor;
import vv.Maps.Map;
import vv.States.PlayState;

public class Enemy extends Character {
  protected BufferedImage image;

  private boolean isDemon = false;
  public boolean isVisible = true;

  public boolean isInvincible = false;
  public long invincibleFrameStart = 0;

  public Enemy(float x, float y) {
    super(x, y, 100, 100);
    image = Assets.bomber;
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
  }

  @Override
  public void Draw(Graphics g) {
    g.drawImage(image, (int) x, (int) y, width, height, null);
  }
}
