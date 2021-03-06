package com.quzhi1.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StripePhone {

  static class RecordComparator implements Comparator<Map<String, Integer>> {

    enum DIRECTION {
      ASC, DESC
    }

    private final String key;
    private final DIRECTION direction;

    public RecordComparator(String key, String direction) {
      this.key = key;
      this.direction = direction.equals("asc") ? DIRECTION.ASC : DIRECTION.DESC;
    }

    public int compare(Map<String, Integer> left, Map<String, Integer> right) {
      int leftVal = left.getOrDefault(key, 0);
      int rightVal = right.getOrDefault(key, 0);
      return direction == DIRECTION.ASC ? leftVal - rightVal : rightVal - leftVal;
    }
  }

//  static class RecordComparatorExtended implements Comparator<Map<String, Integer>> {
//
//    enum DIRECTION {
//      ASC, DESC
//    }
//
//    private LinkedHashMap<String, DIRECTION> directions;
//
//    public RecordComparator(LinkedHashMap<String, String> directions) {
//      directions = new LinkedHashMap<>();
//      for (Map.Entry<String, String> direction : directions.entrySet()) {
//        DIRECTION directionEach = direction.getValue().equals("asc") ? DIRECTION.ASC : DIRECTION.DESC;
//        this.directions.put(direction.getKey(), directionEach);
//      }
//    }
//
//    public int compare(Map<String, Integer> left, Map<String, Integer> right) {
//      for ()
//      int leftVal = left.getOrDefault(key, 0);
//      int rightVal = right.getOrDefault(key, 0);
//      return direction == DIRECTION.ASC ? leftVal - rightVal : rightVal - leftVal;
//    }
//  }

  public static Map<String, Integer> firstByKey(String key, String direction, List<Map<String, Integer>> records) {
    if (records == null || records.isEmpty()) {
      return Collections.emptyMap();
    }

    RecordComparator comparator = new RecordComparator(key, direction);
    Map<String, Integer> thresholdRecord = records.get(0);
    for (Map<String, Integer> record : records) {
      if (comparator.compare(thresholdRecord, record) > 0) {
        thresholdRecord = record;
      }
    }
    return thresholdRecord;
  }

  public static Map<String, Integer> minByKey(String key, List<Map<String, Integer>> records) {
    return firstByKey(key, "asc", records);
  }

  public static void main(String[] args) {
    testMinByKey();
    testFirstByKey();
    testRecordComparator();
  }

  public static <T> void assertEqual(T expected, T actual) {
    if (expected == null && actual == null || actual != null && actual.equals(expected)) {
      System.out.println("PASSED");
    } else {
      throw new AssertionError("Expected:\n  " + expected + "\nActual:\n  " + actual + "\n");
    }
  }

  public static void testRecordComparator() {
    RecordComparator cmp = new RecordComparator("a", "asc");
    Map<String, Integer> a1 = Maps.of("a", 1);
    Map<String, Integer> a2 = Maps.of("a", 2);
    System.out.println("RecordComparator");
    assertEqual(-1, cmp.compare(a1, a2));
    assertEqual(1, cmp.compare(a2, a1));
    assertEqual(0, cmp.compare(a1, a1));
  }

  public static void testFirstByKey() {
    List<Map<String, Integer>> example1 = Arrays.asList(Maps.of("a", 1));
    List<Map<String, Integer>> example2 = Arrays.asList(
        Maps.of("b", 1),
        Maps.of("b", -2),
        Maps.of("a", 10)
    );
    List<Map<String, Integer>> example3 = Arrays.asList(
        Maps.of(),
        Maps.of("a", 10, "b", -10),
        Maps.of(),
        Maps.of("a", 3, "c", 3)
    );

    System.out.println("firstByKey");
    assertEqual(example1.get(0), firstByKey("a", "asc", example1));
    assertEqual(example2.get(0), firstByKey("a", "asc", example2));  // example2.get(1) ok too
    assertEqual(example2.get(2), firstByKey("a", "desc", example2));
    assertEqual(example2.get(1), firstByKey("b", "asc", example2));
    assertEqual(example2.get(0), firstByKey("b", "desc", example2));
    assertEqual(example3.get(1), firstByKey("a", "desc", example3));
  }

  public static void testMinByKey() {
    List<Map<String, Integer>> example1 = Arrays.asList(
        Maps.of("a", 1, "b", 2),
        Maps.of("a", 2)
    );
    List<Map<String, Integer>> example2 = Arrays.asList(example1.get(1), example1.get(0));
    List<Map<String, Integer>> example3 = Arrays.asList(Maps.of());
    List<Map<String, Integer>> example4 = Arrays.asList(
        Maps.of("a", -1),
        Maps.of("b", -1)
    );

    System.out.println("minByKey");
    assertEqual(example1.get(0), minByKey("a", example1));
    assertEqual(example2.get(1), minByKey("a", example2));
    assertEqual(example1.get(1), minByKey("b", example1));
    assertEqual(example3.get(0), minByKey("a", example3));
    assertEqual(example4.get(1), minByKey("b", example4));
  }
}

/*
 * Helpers to quickly create and populate new Maps.
 *
 * Inspired by ImmutableMap.of in guava.
 */
class Maps {

  public static <K, V> Map<K, V> of() {
    return new HashMap<K, V>();
  }

  public static <K, V> Map<K, V> of(K k1, V v1) {
    Map<K, V> map = new HashMap<K, V>();
    map.put(k1, v1);
    return map;
  }

  public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2) {
    Map<K, V> map = new HashMap<K, V>();
    map.put(k1, v1);
    map.put(k2, v2);
    return map;
  }

  public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3) {
    Map<K, V> map = new HashMap<K, V>();
    map.put(k1, v1);
    map.put(k2, v2);
    map.put(k3, v3);
    return map;
  }

  public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
    Map<K, V> map = new HashMap<K, V>();
    map.put(k1, v1);
    map.put(k2, v2);
    map.put(k3, v3);
    map.put(k4, v4);
    return map;
  }

  public static <K, V> Map<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
    Map<K, V> map = new HashMap<K, V>();
    map.put(k1, v1);
    map.put(k2, v2);
    map.put(k3, v3);
    map.put(k4, v4);
    map.put(k5, v5);
    return map;
  }

  public static <K, V> LinkedHashMap<K, V> ordered(K k1, V v1) {
    LinkedHashMap<K, V> map = new LinkedHashMap<K, V>();
    map.put(k1, v1);
    return map;
  }

  public static <K, V> LinkedHashMap<K, V> ordered(K k1, V v1, K k2, V v2) {
    LinkedHashMap<K, V> map = new LinkedHashMap<K, V>();
    map.put(k1, v1);
    map.put(k2, v2);
    return map;
  }

  public static <K, V> LinkedHashMap<K, V> ordered(K k1, V v1, K k2, V v2, K k3, V v3) {
    LinkedHashMap<K, V> map = new LinkedHashMap<K, V>();
    map.put(k1, v1);
    map.put(k2, v2);
    map.put(k3, v3);
    return map;
  }

}
