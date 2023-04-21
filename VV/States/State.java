package VV.States;

import java.awt.*;

public abstract class State {
  private static State previousState = null;
  private static State currentState = null;

  public State() {
  }

  public static void SetState(State state) {
    previousState = currentState;
    currentState = state;
  }

  public static State GetState() {
    return currentState;
  }

  /// Metoda abstracta destinata actualizarii starii curente
  public abstract void Update();

  /// Metoda abstracta destinata desenarii starii curente
  public abstract void Draw(Graphics g);
}
