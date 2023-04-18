package VV.States;

import VV.Items.Hero;
import VV.RefLinks;
import VV.Maps.Map;
import VV.Menus.MainMenu;

import java.awt.*;

/*! \class public class PlayState extends State
    \brief Implementeaza/controleaza jocul.
 */
public class PlayState extends State {
  private Hero hero; /* !< Referinta catre obiectul animat erou (controlat de utilizator). */
  private Map map; /* !< Referinta catre harta curenta. */
  private MainMenu menu;

  /*
   * ! \fn public PlayState(RefLinks refLink)
   * \brief Constructorul de initializare al clasei
   * 
   * \param refLink O referinta catre un obiect "shortcut", obiect ce contine o
   * serie de referinte utile in program.
   */
  public PlayState(RefLinks refLink) {
    /// Apel al constructorului clasei de baza
    super(refLink);
    /// Construieste harta jocului
    map = new Map(refLink);
    /// Referinta catre harta construita este setata si in obiectul shortcut pentru
    /// a fi accesibila si in alte clase ale programului.
    refLink.SetMap(map);
    /// Construieste eroul
    hero = new Hero(refLink, 400, 400);

    menu = new MainMenu(refLink);
  }

  /*
   * ! \fn public void Update()
   * \brief Actualizeaza starea curenta a jocului.
   */
  @Override
  public void Update() {
    menu.Update();
    map.Update();
    hero.Update();
  }

  /*
   * ! \fn public void Draw(Graphics g)
   * \brief Deseneaza (randeaza) pe ecran starea curenta a jocului.
   * 
   * \param g Contextul grafic in care trebuie sa deseneze starea jocului pe
   * ecran.
   */
  @Override
  public void Draw(Graphics g) {
    map.Draw(g);
    menu.Draw(g);
    hero.Draw(g);
  }
}
