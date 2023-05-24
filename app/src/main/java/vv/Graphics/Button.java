package vv.Graphics;

import vv.Input.Mouse;
import java.awt.*;

class ButtonError extends RuntimeException {
  ButtonError() {
    super("PUNE TEXT PT BUTON!!");
  }
}

public class Button {
  int x, y;

  int width = 256 + 128;
  int height = 50;

  String text;

  boolean onHover = false;

  // 0 1 sau 2
  int clickCount = 0;

  Runnable action;

  public Button(String text, int x, int y, Runnable action) {
    if (text.length() < 1) {
      throw new ButtonError();
    }

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