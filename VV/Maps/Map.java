package VV.Maps;

import VV.RefLinks;
import VV.Tiles.Tile;

import java.awt.*;
import java.util.Random;

/*! \class public class Map
    \brief Implementeaza notiunea de harta a jocului.
 */
public class Map {
  private RefLinks refLink; /*
                             * !< O referinte catre un obiect "shortcut", obiect ce contine o serie de
                             * referinte utile in program.
                             */
  private int width; /* !< Latimea hartii in numar de dale. */
  private int height; /* !< Inaltimea hartii in numar de dale. */
  private int[][] tiles; /* !< Referinta catre o matrice cu codurile dalelor ce vor construi harta. */

  /*
   * ! \fn public Map(RefLinks refLink)
   * \brief Constructorul de initializare al clasei.
   * 
   * \param refLink O referinte catre un obiect "shortcut", obiect ce contine o
   * serie de referinte utile in program.
   */
  public Map(RefLinks refLink) {
    /// Retine referinta "shortcut".
    this.refLink = refLink;
    /// incarca harta de start. Functia poate primi ca argument id-ul hartii ce
    /// poate fi incarcat.
    LoadWorld();
  }

  /*
   * ! \fn public void Update()
   * \brief Actualizarea hartii in functie de evenimente (un copac a fost taiat)
   */
  public void Update() {

  }

  /*
   * ! \fn public void Draw(Graphics g)
   * \brief Functia de desenare a hartii.
   * 
   * \param g Contextl grafi in care se realizeaza desenarea.
   */
  public void Draw(Graphics g) {
    /// Se parcurge matricea de dale (codurile aferente) si se deseneaza harta
    /// respectiva
    for (int y = 0; y < refLink.GetGame().GetHeight() / Tile.TILE_HEIGHT; y++) {
      for (int x = 0; x < (refLink.GetGame().GetWidth() / Tile.TILE_WIDTH); x++) {
        GetTile(x, y).Draw(g, 256 + 128 + (int) x * Tile.TILE_HEIGHT, (int) y * Tile.TILE_WIDTH);
      }
    }
  }

  /*
   * ! \fn public Tile GetTile(int x, int y)
   * \brief Intoarce o referinta catre dala aferenta codului din matrice de dale.
   * 
   * In situatia in care dala nu este gasita datorita unei erori ce tine de cod
   * dala, coordonate gresite etc se
   * intoarce o dala predefinita (ex. grassTile, mountainTile)
   */
  public Tile GetTile(int x, int y) {
    if (x < 0 || y < 0 || x >= width || y >= height) {
      return Tile.floorTile;
    }
    Tile t = Tile.tiles[tiles[x][y]];
    if (t == null) {
      return Tile.floorTile;
    }
    return t;
  }

  /*
   * ! \fn private void LoadWorld()
   * \brief Functie de incarcare a hartii jocului.
   * Aici se poate genera sau incarca din fisier harta. Momentan este incarcata
   * static.
   */
  private void LoadWorld() {
    // atentie latimea si inaltimea trebuiesc corelate cu dimensiunile ferestrei sau
    // se poate implementa notiunea de camera/cadru de vizualizare al hartii
    /// Se stabileste latimea hartii in numar de dale.
    width = 13;
    /// Se stabileste inaltimea hartii in numar de dale
    height = 13;
    /// Se construieste matricea de coduri de dale
    tiles = new int[width][height];
    Random rand = new Random();

    for (int i = 0; i < width; ++i) {
      for (int j = 0; j < height; ++j) {
        tiles[i][j] = rand.nextInt(3);
      }
    }
  }

}