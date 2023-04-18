package VV.Menus;

import VV.RefLinks;
import VV.Input.Mouse;

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

    if (onHover && Mouse.isButtonPressed(1)) {
      if (clickCount == 1) {
        clickCount = 2;
      } else if (clickCount == 0) {
        clickCount = 1;
      }
    } else {
      clickCount = 0;
    }

    if (clickCount == 1) {
      action.run();
    }
  }

  public void Draw(Graphics g) {
    g.setColor(onHover ? Color.CYAN : Color.WHITE);
    g.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 25));

    int hoverOffset = onHover ? 40 : 20;

    // g.fillRect(x, y, (int) width, (int) height);
    // g.setColor(Color.BLACK);
    g.drawString(text, x + hoverOffset, y + 30);

  }
}

public class MainMenu {
  private RefLinks refLink;

  private Button playBtn = new Button("keep dreaming", 0, 300, () -> playBtnAction());
  private Button memoriesBtn = new Button("memories", 0, 360, () -> memoriesBtnAction());
  private Button optionsBtn = new Button("alter this world", 0, 420, () -> optionsBtnAction());
  private Button quitBtn = new Button("give up", 0, 480, () -> quitBtnAction());

  public MainMenu(RefLinks refLink) {
    this.refLink = refLink;
  }

  private void playBtnAction() {
    System.out.println("playBtn");
  }

  private void memoriesBtnAction() {
    System.out.println("memoriesBtn");
  }

  private void optionsBtnAction() {
    System.out.println("optionsBtn");
  }

  private void quitBtnAction() {
    System.exit(0);
  }

  public void Update() {
    playBtn.Update();
    memoriesBtn.Update();
    optionsBtn.Update();
    quitBtn.Update();
  }

  public void Draw(Graphics g) {
    g.setColor(Color.black);

    g.fillRect(0, 0, 256 + 128, refLink.GetHeight());

    playBtn.Draw(g);
    memoriesBtn.Draw(g);
    optionsBtn.Draw(g);
    quitBtn.Draw(g);
  }
}
