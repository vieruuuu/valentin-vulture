package vv.Database;

import java.util.concurrent.ConcurrentMap;

import org.mapdb.*;

public class Database {
  private static DB db;

  private static ConcurrentMap<String, String> map;

  private static void openDB() {
    db = DBMaker.fileDB("text.db").make();

    map = db.hashMap("map")
        .keySerializer(Serializer.STRING)
        .valueSerializer(Serializer.STRING)
        .createOrOpen();

  }

  private static void closeDB() {
    db.close();
  }

  public static void put(String key, String value) {
    openDB();

    map.put(key, value);

    closeDB();
  }

  public static String get(String key) {
    openDB();

    var val = map.get(key);

    closeDB();

    return val;
  }
}
