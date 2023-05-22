package vv.States;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import vv.Game;
import vv.Items.Enemy;
import vv.Items.Hero;
import vv.Maps.Map;
import vv.Graphics.Button;

/**
 * The PlayState class initializes a hero and a main menu, updates and draws
 * them based on whether the game has started or not.
 */
public class PlayState implements State {
  public Hero hero;

  private Button menuBtn = new Button("close your eyes", 0, 480, () -> gotoMenu());

  private static PlayState instance;

  public PlayState() {
    instance = this;

    var gi = Game.getInstance();

    hero = new Hero(gi.GetWidth() / 2 + 140, gi.GetHeight() / 2 - 80);
  }

  public void gotoMenu() {
    Game.getInstance().state = MenuState.getInstance();
  }

  static public PlayState getInstance() {
    if (instance == null) {
      instance = new PlayState();
    }

    return instance;
  }

  public void Update() {
    menuBtn.Update();

    Map.getInstance().Update();
    hero.Update();
  }

  public void Draw(Graphics g) {
    g.setColor(Color.black);

    g.fillRect(0, 0, Game.getInstance().GetWidth(), Game.getInstance().GetHeight());

    var gi = Game.getInstance();

    g.setColor(Color.red);
    g.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 25));

    g.drawString("you died " + gi.deadCount + " times", 20, 450);
    g.setColor(Color.white);

    menuBtn.Draw(g);

    Map.getInstance().Draw(g);
    hero.Draw(g);
  }
}
