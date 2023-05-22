package vv.States;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import vv.Game;
import vv.Graphics.Button;
import vv.Maps.Floor;
import vv.Maps.Map;

public class MenuState implements State {
  private Button playBtn = new Button("keep dreaming", 0, 300, () -> playBtnAction());
  private Button memoriesBtn = new Button("memories", 0, 360, () -> memoriesBtnAction());
  private Button optionsBtn = new Button("alter this world", 0, 420, () -> optionsBtnAction());
  private Button quitBtn = new Button("give up", 0, 480, () -> quitBtnAction());

  private static MenuState instance;

  private void playBtnAction() {
    Game.getInstance().state = PlayState.getInstance();
  }

  private void memoriesBtnAction() {
    Game.getInstance().state = MemoriesState.getInstance();
  }

  private void optionsBtnAction() {
    Game.getInstance().state = new PlayState();
    Map.getInstance().floor = new Floor();
  }

  private void quitBtnAction() {
    System.exit(0);
  }

  public MenuState() {
    instance = this;
  }

  static public MenuState getInstance() {
    if (instance == null) {
      instance = new MenuState();
    }

    return instance;
  }

  public void Update() {

    playBtn.Update();
    memoriesBtn.Update();
    optionsBtn.Update();
    quitBtn.Update();
  }

  public void Draw(Graphics g) {
    g.setColor(Color.black);

    g.fillRect(0, 0, Game.getInstance().GetWidth(), Game.getInstance().GetHeight());

    g.setColor(Color.white);
    g.setFont(new Font("Arial", Font.BOLD, 40));
    g.drawString("VALENTIN VULTURE", 20, 220 + 30);

    playBtn.Draw(g);
    memoriesBtn.Draw(g);
    optionsBtn.Draw(g);
    quitBtn.Draw(g);

  }
}
