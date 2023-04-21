package VV;

import VV.GameWindow.GameWindow;
import VV.Graphics.Assets;
import VV.Input.KeyManager;
import VV.Input.Mouse;
import VV.States.*;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {
  private static Game gameInstance;

  private GameWindow wnd;
  private boolean runState;
  private Thread gameThread;
  private BufferStrategy bs;

  private Graphics g;

  private PlayState state;

  public int bedCount = 0;

  private Game(String title, int width, int height) {
    wnd = new GameWindow(title, width, height);
    runState = false;

  }

  public static Game getInstance() {
    if (gameInstance == null) {
      gameInstance = new Game("Valentin Vulture", 832 + 256 + 128, 832);
    }

    return gameInstance;
  }

  private void InitGame() {
    wnd.BuildGameWindow();
    wnd.GetWndFrame().addKeyListener(KeyManager.getInstance());

    Assets.Init();

    state = new PlayState();

    Mouse.canvas = wnd.GetCanvas();

    Mouse.addMouseListener();
  }

  public void run() {
    InitGame();

    long oldTime = System.nanoTime();
    long currentTime;

    final int framesPerSecond = 60;
    final double timeFrame = 1000000000 / framesPerSecond;

    while (runState == true) {
      currentTime = System.nanoTime();

      if ((currentTime - oldTime) > timeFrame) {
        Update();
        Draw();

        oldTime = currentTime;
      }
    }

  }

  public synchronized void StartGame() {
    if (runState == false) {
      runState = true;
      gameThread = new Thread(this);
      gameThread.start();
    } else {

      return;
    }
  }

  public synchronized void StopGame() {
    if (runState == true) {
      runState = false;

      try {
        gameThread.join();
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }
    } else {
      /// Thread-ul este oprit deja.
      return;
    }
  }

  private void Update() {
    KeyManager.getInstance().Update();

    state.Update();
  }

  private void Draw() {
    bs = wnd.GetCanvas().getBufferStrategy();
    if (bs == null) {
      try {
        wnd.GetCanvas().createBufferStrategy(3);
        return;
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    g = bs.getDrawGraphics();

    g.clearRect(0, 0, wnd.GetWndWidth(), wnd.GetWndHeight());

    state.Draw(g);

    bs.show();

    g.dispose();
  }

  public int GetWidth() {
    return wnd.GetWndWidth();
  }

  public int GetHeight() {
    return wnd.GetWndHeight();
  }

}
