package VV.Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageLoader {
  public static BufferedImage LoadImage(String path) {
    try {
      return ImageIO.read(ImageLoader.class.getResource("./../../assets/" + path));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
