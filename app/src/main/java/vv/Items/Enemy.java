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

  public boolean isHit = false;

  public boolean isTargeted = false;

  private long hitStart = 0;

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
    var hi = PlayState.getInstance().hero;

    life -= hi.isDemon ? 3 : 1;
    hitStart = System.nanoTime();
  }

  @Override
  public void Update() {
  }

  @Override
  public void Draw(Graphics g) {
    if ((System.nanoTime() - hitStart) / 100000000 < 1) {
      // Get the image's pixel data
      int[] pixels = new int[image.getWidth() * image.getHeight()];
      image.getRGB(0, 0, image.getWidth(), image.getHeight(), pixels, 0, image.getWidth());

      // Apply red filter to the image pixels
      for (int i = 0; i < pixels.length; i++) {
        int pixel = pixels[i];
        int alpha = (pixel >> 24) & 0xFF;
        int red = (pixel >> 16) & 0xFF;
        int green = (pixel >> 8) & 0xFF;
        int blue = pixel & 0xFF;

        // Increase the red component to create a red-filtered effect
        red = Math.min(red + 100, 255);

        // Create the filtered pixel value
        int filteredPixel = (alpha << 24) | (red << 16) | (green << 8) | blue;

        // Update the pixel in the pixel array
        pixels[i] = filteredPixel;
      }

      // Create a new image with the filtered pixels
      Image filteredImage = Toolkit.getDefaultToolkit().createImage(
          new java.awt.image.MemoryImageSource(image.getWidth(), image.getHeight(), pixels, 0, image.getWidth()));

      // Draw the filtered image
      g.drawImage(filteredImage, (int) x, (int) y, width, height, null);
    } else {
      g.drawImage(image, (int) x, (int) y, width, height, null);
    }

    if (isTargeted) {
      g.drawImage(Assets.crosshair, (int) x, (int) y, width, height, null);
    }
  }
}
