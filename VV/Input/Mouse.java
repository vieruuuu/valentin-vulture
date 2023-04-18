package VV.Input;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class Mouse extends MouseAdapter {
  // <https://stackoverflow.com/a/69120392>
  public static Canvas canvas;
  private static final Map<Integer, Boolean> pressedButtons = new HashMap<>();

  public static void addMouseListener() {
    canvas.addMouseListener(new Mouse());
  }

  @Override
  public void mousePressed(MouseEvent e) {
    synchronized (Mouse.class) {
      pressedButtons.put(e.getButton(), true);
    }
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    synchronized (Mouse.class) {
      pressedButtons.put(e.getButton(), false);
    }
  }

  public static boolean isButtonPressed(int button) {
    return pressedButtons.getOrDefault(button, false);
  }

  public static Point getPosition() {
    return canvas.getMousePosition();
  }
}