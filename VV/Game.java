package VV;

import VV.GameWindow.GameWindow;
import VV.Graphics.Assets;
import VV.Input.KeyManager;
import VV.Input.Mouse;
import VV.States.*;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * The Game class is a Java implementation of a game loop with methods for
 * initializing, starting,
 * stopping, updating, and drawing the game.
 */
public class Game implements Runnable {
  private static Game gameInstance;

  private GameWindow wnd;
  private boolean runState;
  private Thread gameThread;
  private BufferStrategy bs;

  private Graphics g;

  public PlayState state;

  public int bedCount = 0;

  private Game(String title, int width, int height) {
    wnd = new GameWindow(title, width, height);
    runState = false;

  }

  /**
   * This function returns an instance of the Game class, creating it if it
   * doesn't already exist.
   * 
   * @return The method `getInstance()` returns an instance of the `Game` class.
   */
  public static Game getInstance() {
    if (gameInstance == null) {
      gameInstance = new Game("Valentin Vulture", 832 + 256 + 128, 832);
    }

    return gameInstance;
  }

  /**
   * The function initializes the game by building the game window, adding a key
   * listener, initializing
   * assets, creating a play state, setting the canvas for the mouse, and adding a
   * mouse listener.
   */
  private void InitGame() {
    wnd.BuildGameWindow();
    wnd.GetWndFrame().addKeyListener(KeyManager.getInstance());

    Assets.Init();

    state = new PlayState();

    Mouse.canvas = wnd.GetCanvas();

    Mouse.addMouseListener();
  }

  /**
   * This function runs a game loop that updates and draws the game at a specified
   * frame rate.
   */
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

  /**
   * This function starts a game thread if the run state is false.
   */
  public synchronized void StartGame() {
    if (runState == false) {
      runState = true;
      gameThread = new Thread(this);
      gameThread.start();
    } else {

      return;
    }
  }

  /**
   * This Java function stops the game thread if it is currently running.
   */
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

  /**
   * This function updates the key manager and the state.
   */
  private void Update() {
    KeyManager.getInstance().Update();

    state.Update();
  }

  /**
   * This function draws the current state of the game onto a canvas using a
   * buffer strategy.
   */
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

  /**
   * This function returns the width of a window.
   * 
   * @return The method `GetWidth()` is returning an integer value which is the
   *         width of the window
   *         obtained from the `GetWndWidth()` method of the `wnd` object.
   */
  public int GetWidth() {
    return wnd.GetWndWidth();
  }

  /**
   * The function returns the height of a window.
   * 
   * @return The method `GetHeight()` is returning an integer value which is the
   *         height of the window
   *         obtained from the `GetWndHeight()` method.
   */
  public int GetHeight() {
    return wnd.GetWndHeight();
  }

}
