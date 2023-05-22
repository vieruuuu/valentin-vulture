package vv.States;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import vv.Game;
import vv.Database.Database;
import vv.Graphics.Button;

public class MemoriesState implements State {
  private static MemoriesState instance;
  private Button menuBtn = new Button("stop thinking about that", 0, 480, () -> gotoMenu());

  public void gotoMenu() {
    Game.getInstance().state = MenuState.getInstance();
  }

  public MemoriesState() {
    instance = this;
  }

  static public MemoriesState getInstance() {
    if (instance == null) {
      instance = new MemoriesState();
    }

    return instance;
  }

  public void Update() {
    menuBtn.Update();
  }

  private void DrawAchievement(Graphics g, String text, boolean achieved, int posX, int posY) {
    g.setColor(achieved ? Color.green : Color.gray);
    g.drawString((achieved ? "[x] " : "[  ] ") + text, posX, posY);
  }

  public void Draw(Graphics g) {
    var gi = Game.getInstance();

    var bedsCount = Database.mapInt.get("bedsCount");
    var deadCount = Database.mapInt.get("deadCount");
    var roomsVisitedCount = Database.mapInt.get("roomsVisitedCount");
    var deathBySpikes = Database.mapBool.get("deathBySpikes");
    var shoesSoaked = Database.mapBool.get("shoesSoaked");

    g.setColor(Color.black);

    g.fillRect(0, 0, gi.GetWidth(), gi.GetHeight());

    menuBtn.Draw(g);
    g.setFont(new Font("Arial", Font.BOLD, 25));

    DrawAchievement(g, "die stepping on spikes", deathBySpikes, 20, 270);
    DrawAchievement(g, "soak your shoes in water", shoesSoaked, 20, 330);
    // DrawAchievement(g, "die stepping on spikes", deathBySpikes, 20, 390);
    // DrawAchievement(g, "die stepping on spikes", deathBySpikes, 20, 450);

    DrawAchievement(g, "die 5 times " + deadCount + "/5", deadCount >= 5, 400, 270);
    DrawAchievement(g, "visit 100 rooms " + roomsVisitedCount + "/100", roomsVisitedCount >= 100, 400, 330);
    // DrawAchievement(g, "die stepping on spikes", deathBySpikes, 400, 390);
    // DrawAchievement(g, "die stepping on spikes", deathBySpikes, 400, 450);

    DrawAchievement(g, "rest on 5 beds " + bedsCount + "/5", bedsCount >= 5, 780, 270);
    // DrawAchievement(g, "die stepping on spikes", deathBySpikes, 780, 330);
    // DrawAchievement(g, "die stepping on spikes", deathBySpikes, 780, 390);
    // DrawAchievement(g, "die stepping on spikes", deathBySpikes, 780, 450);

  }
}
