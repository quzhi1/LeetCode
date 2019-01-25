package com.quzhi1.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class AmazonOa1 {

  public static List<List<Integer>> ClosestXdestinations(int numDestinations,
      List<List<Integer>> allLocations,
      int numDeliveries) {
    if (numDeliveries <= 0 || numDestinations <= 0 || allLocations == null || allLocations.size() == 0) {
      return Collections.emptyList();
    }
    PriorityQueue<List<Integer>> queue = new PriorityQueue<>(numDeliveries, (e1, e2) ->
        e2.get(0) * e2.get(0) + e2.get(1) * e2.get(1) - e1.get(0) * e1.get(0) - e1.get(1) * e1.get(1)
    );
    for (List<Integer> loc : allLocations) {
      queue.add(loc);
      if (queue.size() > numDeliveries) {
        queue.poll();
      }
    }
    return new ArrayList<>(queue);
  }

  public static void main(String[] args) {
//    List<List<Integer>> allLocations = Arrays.asList(Arrays.asList(1, -3),
//        Arrays.asList(1, 2),
//        Arrays.asList(3, 4));
//    ClosestXdestinations(3, allLocations, 2).forEach(dest -> {
//          dest.forEach(axis -> System.out.print(axis + ","));
//          System.out.println();
//        }
//    );
//    ClosestXdestinations(3, Collections.emptyList(), 2).forEach(dest -> {
//          dest.forEach(axis -> System.out.print(axis + ","));
//          System.out.println();
//        }
//    );
    ClosestXdestinations(3, Collections.emptyList(), -1).forEach(dest -> {
          dest.forEach(axis -> System.out.print(axis + ","));
          System.out.println();
        }
    );
  }

}
