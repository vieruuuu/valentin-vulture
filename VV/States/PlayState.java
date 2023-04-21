package VV.States;

import VV.Game;
import VV.Items.Hero;
import VV.Maps.Map;
import VV.Menus.MainMenu;

import java.awt.*;

public class PlayState extends State {
  private Hero hero;
  private Map map;
  private MainMenu menu;

  public PlayState() {
    super();

    map = Map.getInstance();

    var gi = Game.getInstance();

    hero = new Hero(gi.GetWidth() / 2 + 140, gi.GetHeight() / 2 - 80);

    menu = new MainMenu();
  }

  @Override
  public void Update() {
    menu.Update();
    map.Update();
    hero.Update();
  }

  @Override
  public void Draw(Graphics g) {
    map.Draw(g);
    menu.Draw(g);
    hero.Draw(g);
  }
}
