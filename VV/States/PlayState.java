package VV.States;

import VV.Game;
import VV.Items.Hero;
import VV.Maps.Map;
import VV.Menus.MainMenu;

import java.awt.*;

public class PlayState {
  private Hero hero;
  private MainMenu menu;

  public PlayState() {
    var gi = Game.getInstance();

    hero = new Hero(gi.GetWidth() / 2 + 140, gi.GetHeight() / 2 - 80);

    menu = new MainMenu();
  }

  public void Update() {
    menu.Update();

    if (menu.startedGame) {
      Map.getInstance().Update();
      hero.Update();
    }
  }

  public void Draw(Graphics g) {
    menu.Draw(g);

    if (menu.startedGame) {
      Map.getInstance().Draw(g);
      hero.Draw(g);
    }
  }
}
