package vv.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class KeyManager extends KeyAdapter {
  public boolean up = false;
  public boolean down = false;
  public boolean left = false;
  public boolean right = false;
  public boolean action = false;

  private static KeyManager instance;

  public static KeyManager getInstance() {
    if (instance == null) {
      instance = new KeyManager();
    }

    return instance;
  }

  public void Update() {
  }

  private void updateKey(KeyEvent e, boolean value) {
    var key = e.getKeyCode();

    switch (key) {
      case KeyEvent.VK_W:
        up = value;
        break;
      case KeyEvent.VK_S:
        down = value;
        break;
      case KeyEvent.VK_A:
        left = value;
        break;
      case KeyEvent.VK_D:
        right = value;
        break;
      case KeyEvent.VK_SPACE:
        action = value;
        break;
    }
  }

  @Override
  public void keyPressed(KeyEvent e) {
    updateKey(e, true);
  }

  @Override
  public void keyReleased(KeyEvent e) {
    updateKey(e, false);
  }
}
