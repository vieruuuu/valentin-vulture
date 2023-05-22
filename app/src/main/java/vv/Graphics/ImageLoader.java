package vv.Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageLoader {
  public static BufferedImage LoadImage(String path) {

    try {
      return ImageIO.read(ClassLoader.getSystemResource(path));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
