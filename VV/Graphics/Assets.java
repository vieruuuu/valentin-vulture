package VV.Graphics;

import java.awt.image.BufferedImage;

/*! \class public class Assets
    \brief Clasa incarca fiecare element grafic necesar jocului.

    Game assets include tot ce este folosit intr-un joc: imagini, sunete, harti etc.
 */
public class Assets {
  /// Referinte catre elementele grafice (dale) utilizate in joc.
  public static BufferedImage humanLeft;
  public static BufferedImage humanRight;

  public static BufferedImage demonLeft;
  public static BufferedImage demonRight;

  public static BufferedImage wall;
  public static BufferedImage water;
  public static BufferedImage floor;
  public static BufferedImage door;
  public static BufferedImage bed;
  public static BufferedImage rock;

  /*
   * ! \fn public static void Init()
   * \brief Functia initializaza referintele catre elementele grafice utilizate.
   * 
   * Aceasta functie poate fi rescrisa astfel incat elementele grafice
   * incarcate/utilizate
   * sa fie parametrizate. Din acest motiv referintele nu sunt finale.
   */
  public static void Init() {
    floor = ImageLoader.LoadImage("room/floor.png");
    wall = ImageLoader.LoadImage("room/wall.png");
    water = ImageLoader.LoadImage("room/water.png");
    door = ImageLoader.LoadImage("room/door.png");
    bed = ImageLoader.LoadImage("room/bed.png");
    rock = ImageLoader.LoadImage("room/rock.png");

    humanLeft = ImageLoader.LoadImage("player/human_left.png");
    humanRight = ImageLoader.LoadImage("player/human_right.png");

    demonLeft = ImageLoader.LoadImage("player/demon_left.png");
    demonRight = ImageLoader.LoadImage("player/demon_right.png");

  }
}
