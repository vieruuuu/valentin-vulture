package VV.Items;

public abstract class Character extends Item {
  public static final int DEFAULT_LIFE = 5; /* !< Valoarea implicita a vietii unui caracter. */
  public static final float DEFAULT_SPEED = 3.0f; /* !< Viteza implicita a unu caracter. */
  public static final int DEFAULT_CREATURE_WIDTH = 64; /* !< Latimea implicita a imaginii caracterului. */
  public static final int DEFAULT_CREATURE_HEIGHT = 64; /* !< Inaltimea implicita a imaginii caracterului. */

  protected int life; /* !< Retine viata caracterului. */
  protected float speed; /* !< Retine viteza de deplasare caracterului. */
  protected float xMove; /* !< Retine noua pozitie a caracterului pe axa X. */
  protected float yMove; /* !< Retine noua pozitie a caracterului pe axa Y. */

  public Character(float x, float y, int width, int height) {
    /// Apel constructor la clasei de baza
    super(x, y, width, height);
    // Seteaza pe valorile implicite pentru viata, viteza si distantele de deplasare
    life = DEFAULT_LIFE;
    speed = DEFAULT_SPEED;
    xMove = 0;
    yMove = 0;
  }

  /*
   * ! \fn public void Move()
   * \brief Modifica pozitia caracterului
   */
  public void Move() {
    /// Modifica pozitia caracterului pe axa X.
    /// Modifica pozitia caracterului pe axa Y.
    x += xMove;
    y += yMove;
  }

  /*
   * ! \fn public int GetLife()
   * \brief Returneaza viata caracterului.
   */
  public int GetLife() {
    return life;
  }

  /*
   * ! \fn public int GetSpeed()
   * \brief Returneaza viteza caracterului.
   */
  public float GetSpeed() {
    return speed;
  }

  /*
   * ! \fn public void SetLife(int life)
   * \brief Seteaza viata caracterului.
   */
  public void SetLife(int life) {
    this.life = life;
  }

  /*
   * ! \fn public void SetSpeed(float speed)
   * \brief
   */
  public void SetSpeed(float speed) {
    this.speed = speed;
  }

  /*
   * ! \fn public float GetXMove()
   * \brief Returneaza distanta in pixeli pe axa X cu care este actualizata
   * pozitia caracterului.
   */
  public float GetXMove() {
    return xMove;
  }

  /*
   * ! \fn public float GetYMove()
   * \brief Returneaza distanta in pixeli pe axa Y cu care este actualizata
   * pozitia caracterului.
   */
  public float GetYMove() {
    return yMove;
  }

  /*
   * ! \fn public void SetXMove(float xMove)
   * \brief Seteaza distanta in pixeli pe axa X cu care va fi actualizata pozitia
   * caracterului.
   */
  public void SetXMove(float xMove) {
    this.xMove = xMove;
  }

  /*
   * ! \fn public void SetYMove(float yMove)
   * \brief Seteaza distanta in pixeli pe axa Y cu care va fi actualizata pozitia
   * caracterului.
   */
  public void SetYMove(float yMove) {
    this.yMove = yMove;
  }
}
