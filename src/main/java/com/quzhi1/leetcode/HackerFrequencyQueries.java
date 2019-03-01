package com.quzhi1.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;

public class HackerFrequencyQueries {

  static List<Integer> freqQuery(List<int[]> queries) {
    Map<Integer, Integer> freqMap = new HashMap<>();
    Map<Integer, Integer> inverseMap = new HashMap<>();
    List<Integer> results = new ArrayList<>();
    for (int[] query : queries) {
      switch (query[0]) {
        case 1:
          // insert one
          // Update freqMap
          int oldFreq = freqMap.getOrDefault(query[1], 0);
          freqMap.merge(query[1], 1, (i1, i2) -> i1 + 1);

          // Update inverseMap
          // Update new freq
          inverseMap.merge(oldFreq + 1, 1, (i1, i2) -> i1 + 1);

          // Update old freq
          int numAtOldFreq = inverseMap.getOrDefault(oldFreq, 0);
          // If this value is not the only one has freq 1
          if (numAtOldFreq != 1) {
            inverseMap.put(oldFreq, numAtOldFreq - 1);
          } else {
            inverseMap.remove(oldFreq);
          }
          break;
        case 2:
          // delete one
          // Update freqMap
          if (freqMap.containsKey(query[1])) {
            int valueToDelete = freqMap.get(query[1]);
            if (valueToDelete == 1) {
              freqMap.remove(query[1]);
              int inverseVal = inverseMap.getOrDefault(1, 0);
              if (inverseVal == 1) {
                inverseMap.remove(1);
              } else {
                inverseMap.put(1, inverseVal - 1);
              }
            } else {
              freqMap.put(query[1], valueToDelete - 1);
              int inverseVal = inverseMap.getOrDefault(valueToDelete, 0);
              if (inverseVal == 1) {
                inverseMap.remove(valueToDelete);
              } else {
                inverseMap.put(valueToDelete, inverseVal - 1);
              }
              inverseMap.put(valueToDelete - 1, inverseMap.getOrDefault(valueToDelete - 1, 0) + 1);
            }
          }
          break;
        case 3:
          // check
          if (inverseMap.containsKey(query[1]) && inverseMap.get(query[1]) == 0) {
            throw new RuntimeException("Found 0 in inverseMap, case 3");
          }
          int result = inverseMap.containsKey(query[1]) ? 1 : 0;
          results.add(result);
          break;
        default:
          throw new UnsupportedOperationException();
      }
    }
    return results;
  }

  public static void main(String[] args) {
    List<int[]> queries1 = Arrays.asList(
        new int[]{1, 5},
        new int[]{1, 6},
        new int[]{3, 2},
        new int[]{1, 10},
        new int[]{1, 10},
        new int[]{1, 6},
        new int[]{2, 5},
        new int[]{3, 2}
    );
    Assert.assertEquals(Arrays.asList(0, 1), freqQuery(queries1));
  }

//  public static void main(String[] args) throws IOException {
//    try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
//      int q = Integer.parseInt(bufferedReader.readLine().trim());
//      List<int[]> queries = new ArrayList<>(q);
//      Pattern p  = Pattern.compile("^(\\d+)\\s+(\\d+)\\s*$");
//      for (int i = 0; i < q; i++) {
//        int[] query = new int[2];
//        Matcher m = p.matcher(bufferedReader.readLine());
//        if (m.matches()) {
//          query[0] = Integer.parseInt(m.group(1));
//          query[1] = Integer.parseInt(m.group(2));
//          queries.add(query);
//        }
//      }
//      List<Integer> ans = freqQuery(queries);
//      ans.forEach(System.out::println);
////      try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {
////        bufferedWriter.write(
////            ans.stream()
////                .map(Object::toString)
////                .collect(joining("\n"))
////                + "\n");
////      }
//    }
//  }

}
