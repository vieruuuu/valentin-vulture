package vv.Database;

import java.util.concurrent.ConcurrentMap;

import org.mapdb.*;

public class Database {
  private static DB db;

  public static ConcurrentMap<String, String> mapString;
  public static ConcurrentMap<String, Integer> mapInt;
  public static ConcurrentMap<String, Boolean> mapBool;

  public static void openDB() {
    db = DBMaker.fileDB("save.db").make();

    mapString = db.hashMap("mapString")
        .keySerializer(Serializer.STRING)
        .valueSerializer(Serializer.STRING)
        .createOrOpen();

    mapInt = db.hashMap("mapInt")
        .keySerializer(Serializer.STRING)
        .valueSerializer(Serializer.INTEGER)
        .createOrOpen();

    mapBool = db.hashMap("mapBool")
        .keySerializer(Serializer.STRING)
        .valueSerializer(Serializer.BOOLEAN)
        .createOrOpen();

    initData();
  }

  private static void initData() {
    if (!mapInt.containsKey("bedsCount")) {
      mapInt.put("bedsCount", 0);
    }

    if (!mapInt.containsKey("deadCount")) {
      mapInt.put("deadCount", 0);
    }

    if (!mapInt.containsKey("roomsVisitedCount")) {
      mapInt.put("roomsVisitedCount", 0);
    }

    if (!mapBool.containsKey("deathBySpikes")) {
      mapBool.put("deathBySpikes", false);
    }

    if (!mapBool.containsKey("shoesSoaked")) {
      mapBool.put("shoesSoaked", false);
    }
  }

  public static void closeDB() {
    db.close();
  }
}
