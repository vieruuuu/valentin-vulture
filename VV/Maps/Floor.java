package VV.Maps;

import java.awt.Point;
import java.util.Random;

/**
 * The `Floor` class generates a floor plan with randomly placed rooms and sets
 * a random room with
 * neighboring rooms as the current room.
 */
public class Floor {
  private final int floorSize = 10;

  private boolean[][] roomsMap = new boolean[floorSize][floorSize];
  private Room[][] rooms = new Room[floorSize][floorSize];

  Random rand = new Random();

  public Room room;

  /**
   * This is the constructor for the `Floor` class. It initializes the `roomsMap`
   * boolean array with
   * random values (either `true` or `false`) for each coordinate. It then creates
   * a `Room` object for
   * each coordinate where `roomsMap` is `true`, and sets the `room` variable to a
   * random `Room` object
   * that has neighboring rooms.
   */
  public Floor() {
    for (int i = 0; i < floorSize; i++) {
      for (int j = 0; j < floorSize; j++) {
        var r = rand.nextInt(2);

        if (r == 0) {
          roomsMap[i][j] = true;
        }
      }
    }

    for (int i = 0; i < floorSize; i++) {
      for (int j = 0; j < floorSize; j++) {
        if (roomExists(i, j)) {
          rooms[i][j] = new Room(this, new Point(i, j));
        }

      }
    }

    setRandomRoom();
  }

  /**
   * This function prints out a floor plan with a highlighted room.
   */
  public void printFloor() {
    System.out.println("------------------------------------------------------------------");
    for (int i = 0; i < floorSize; i++) {
      for (int j = 0; j < floorSize; j++) {
        if (room.pos.x == i && room.pos.y == j) {
          System.out.print("HERE \t");
        } else {
          System.out.print(roomsMap[i][j] + "\t ");
        }
      }

      System.out.println();
    }
    System.out.println("------------------------------------------------------------------");
  }

  /**
   * The function sets a random room on a floor grid, ensuring that the room
   * exists and has neighboring
   * rooms.
   */
  private void setRandomRoom() {
    var x = rand.nextInt(floorSize);
    var y = rand.nextInt(floorSize);

    if (!roomExists(x, y) || !roomHasNeighbors(x, y)) {
      setRandomRoom();
      return;
    }

    room = rooms[x][y];
  }

  /**
   * The function checks if a room has neighboring rooms in the specified
   * coordinates.
   * 
   * @param x The x-coordinate of the room being checked for neighbors.
   * @param y The y parameter represents the vertical position or row number of a
   *          room in a grid or
   *          matrix.
   * @return The method `roomHasNeighbors` is returning a boolean value. It
   *         returns `true` if there is at
   *         least one neighboring room (roomExists) in any of the four directions
   *         (right, left, up, down) from
   *         the given coordinates (x, y), and `false` otherwise.
   */
  public boolean roomHasNeighbors(int x, int y) {
    return roomExists(x + 1, y) || roomExists(x - 1, y) || roomExists(x, y + 1) || roomExists(x, y - 1);
  }

  /**
   * This function sets the current room to the specified coordinates if it
   * exists.
   * 
   * @param x The x-coordinate of the room that needs to be set.
   * @param y The parameter "y" is an integer representing the vertical coordinate
   *          of a room in a
   *          two-dimensional array of rooms.
   */
  public void setRoom(int x, int y) {
    if (roomExists(x, y)) {
      room = rooms[x][y];
    }
  }

  /**
   * This function checks if a room exists at the given coordinates on a floor
   * map.
   * 
   * @param x The x-coordinate of the room being checked for existence.
   * @param y The parameter "y" represents the vertical coordinate of a room on a
   *          floor map.
   * @return The method is returning a boolean value. It returns `false` if the
   *         given coordinates (x, y)
   *         are outside the bounds of the floor (i.e., x or y is less than 0 or
   *         greater than or equal to
   *         `floorSize`). Otherwise, it returns the value of the `roomsMap` at
   *         the given coordinates, which is
   *         also a boolean value.
   */
  public boolean roomExists(int x, int y) {
    if (x < 0 || y < 0 || x >= floorSize || y >= floorSize) {
      return false;
    }

    return roomsMap[x][y];
  }
}