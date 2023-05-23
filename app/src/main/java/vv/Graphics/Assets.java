package vv.Graphics;

import java.awt.image.BufferedImage;

/*! \class public class Assets
    \brief Clasa incarca fiecare element grafic necesar jocului.

    Game assets include tot ce este folosit intr-un joc: imagini, sunete, harti etc.
 */
public class Assets {
  /// Referinte catre elementele grafice (dale) utilizate in joc.
  public static BufferedImage bomber;
  public static BufferedImage flame;
  public static BufferedImage flameProjectile;
  public static BufferedImage shadow;
  public static BufferedImage wraith;

  public static BufferedImage humanLeft;
  public static BufferedImage humanRight;

  public static BufferedImage invisible;
  public static BufferedImage crosshair;

  public static BufferedImage demonLeft;
  public static BufferedImage demonRight;

  public static BufferedImage wall;
  public static BufferedImage water;
  public static BufferedImage floor;
  public static BufferedImage rock;
  public static BufferedImage spikes;

  public static BufferedImage wallWinter;
  public static BufferedImage waterWinter;
  public static BufferedImage floorWinter;
  public static BufferedImage rockWinter;
  public static BufferedImage spikesWinter;

  public static BufferedImage wallBurning;
  public static BufferedImage waterBurning;
  public static BufferedImage floorBurning;
  public static BufferedImage rockBurning;
  public static BufferedImage spikesBurning;

  public static BufferedImage bed;
  public static BufferedImage bedWinter;
  public static BufferedImage bedBurning;

  public static BufferedImage door;
  public static BufferedImage doorWinter;
  public static BufferedImage doorBurning;

  public static BufferedImage black;

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
    rock = ImageLoader.LoadImage("room/rock.png");
    spikes = ImageLoader.LoadImage("room/spikes.png");

    floorWinter = ImageLoader.LoadImage("room/floorWinter.png");
    wallWinter = ImageLoader.LoadImage("room/wallWinter.png");
    waterWinter = ImageLoader.LoadImage("room/waterWinter.png");
    rockWinter = ImageLoader.LoadImage("room/rockWinter.png");
    spikesWinter = ImageLoader.LoadImage("room/spikesWinter.png");

    floorBurning = ImageLoader.LoadImage("room/floorBurning.png");
    wallBurning = ImageLoader.LoadImage("room/wallBurning.png");
    waterBurning = ImageLoader.LoadImage("room/waterBurning.png");
    rockBurning = ImageLoader.LoadImage("room/rockBurning.png");
    spikesBurning = ImageLoader.LoadImage("room/spikesBurning.png");

    door = ImageLoader.LoadImage("room/door.png");
    bed = ImageLoader.LoadImage("room/bed.png");
    black = ImageLoader.LoadImage("room/black.png");

    doorWinter = ImageLoader.LoadImage("room/doorWinter.png");
    bedWinter = ImageLoader.LoadImage("room/bedWinter.png");

    doorBurning = ImageLoader.LoadImage("room/doorBurning.png");
    bedBurning = ImageLoader.LoadImage("room/bedBurning.png");

    invisible = ImageLoader.LoadImage("player/invisible.png");

    humanLeft = ImageLoader.LoadImage("player/human_left.png");
    humanRight = ImageLoader.LoadImage("player/human_right.png");

    demonLeft = ImageLoader.LoadImage("player/demon_left.png");
    demonRight = ImageLoader.LoadImage("player/demon_right.png");

    bomber = ImageLoader.LoadImage("enemies/bomber.png");
    flame = ImageLoader.LoadImage("enemies/flame.png");
    flameProjectile = ImageLoader.LoadImage("enemies/flameProjectile.png");
    shadow = ImageLoader.LoadImage("enemies/shadow.png");
    wraith = ImageLoader.LoadImage("enemies/wraith.png");

    crosshair = ImageLoader.LoadImage("enemies/crosshair.png");
  }
}
