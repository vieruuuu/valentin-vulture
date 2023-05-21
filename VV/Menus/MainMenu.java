package VV.Menus;

import VV.Game;
import VV.Input.Mouse;
import VV.Maps.Floor;
import VV.Maps.Map;

import java.awt.*;

class Button {
  int x, y;

  int width = 256 + 128;
  int height = 50;

  String text;

  boolean onHover = false;

  // 0 1 sau 2
  int clickCount = 0;

  Runnable action;

  public Button(String text, int x, int y, Runnable action) {
    this.text = text;

    this.x = x;
    this.y = y;

    this.action = action;
  }

  public void Update() {
    var mousePos = Mouse.getPosition();

    if (mousePos != null) {
      var mX = mousePos.getX();
      var mY = mousePos.getY();

      onHover = mX >= x && mX <= x + width && mY >= y && mY <= y + height;
    }

    if (onHover && Mouse.isButtonClicked(1)) {
      action.run();
    }
  }

  public void Draw(Graphics g) {
    g.setColor(onHover ? Color.RED : Color.WHITE);
    g.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 25));

    int hoverOffset = onHover ? 40 : 20;

    // g.fillRect(x, y, (int) width, (int) height);
    // g.setColor(Color.BLACK);
    g.drawString(text, x + hoverOffset, y + 30);
  }
}

/**
 * The MainMenu class contains buttons for starting a game, accessing memories
 * and options, and
 * quitting the game, as well as a button for returning to the main menu during
 * gameplay.
 */
public class MainMenu {
  private Button playBtn = new Button("keep dreaming", 0, 300, () -> startedGame = true);
  private Button memoriesBtn = new Button("memories", 0, 360, () -> memoriesBtnAction());
  private Button optionsBtn = new Button("alter this world", 0, 420, () -> optionsBtnAction());
  private Button quitBtn = new Button("give up", 0, 480, () -> quitBtnAction());

  private Button menuBtn = new Button("close your eyes", 0, 480, () -> startedGame = false);

  public boolean startedGame = false;

  private void memoriesBtnAction() {
    System.out.println("memoriesBtn");
  }

  private void optionsBtnAction() {
    Map.getInstance().floor = new Floor();
  }

  private void quitBtnAction() {
    System.exit(0);
  }

  public void Update() {
    if (startedGame) {
      menuBtn.Update();
    } else {
      playBtn.Update();
      memoriesBtn.Update();
      optionsBtn.Update();
      quitBtn.Update();
    }
  }

  public void Draw(Graphics g) {

    g.setColor(Color.black);

    g.fillRect(0, 0, Game.getInstance().GetWidth(), Game.getInstance().GetHeight());

    if (startedGame) {
      var gi = Game.getInstance();

      g.setColor(Color.WHITE);
      g.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 25));

      g.drawString("you died " + gi.deadCount + " times", 20, 460);

      menuBtn.Draw(g);
    } else {
      g.setColor(Color.white);
      g.setFont(new Font("Arial", Font.BOLD, 40));
      g.drawString("VALENTIN VULTURE", 20, 220 + 30);

      playBtn.Draw(g);
      memoriesBtn.Draw(g);
      optionsBtn.Draw(g);
      quitBtn.Draw(g);
    }
  }
}
