package com.quzhi1.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Leet56 {

  public static List<Interval> merge(List<Interval> intervals) {
    if (intervals == null || intervals.size() == 0) {
      return Collections.emptyList();
    } else if (intervals.size() == 1) {
      return intervals;
    } else {
      intervals.sort(Comparator.comparingInt(i -> i.start));
      List<Interval> result = new ArrayList<>();
      result.add(intervals.get(0));
      for (int i = 0; i < intervals.size() - 1; i++) {
        result.add(intervals.get(i + 1));
        Interval lastResult = result.get(result.size() - 1);
        Interval secondLastResult = result.get(result.size() - 2);
        if (secondLastResult.end >= lastResult.start) {
          // Overlap
          int start = Math.min(lastResult.start, secondLastResult.start);
          int end = Math.max(lastResult.end, secondLastResult.end);
          result.remove(lastResult);
          result.remove(secondLastResult);
          result.add(new Interval(start, end));
        }
      }
      return result;
    }
  }

  static public class Interval {

    int start;
    int end;

    Interval() {
      start = 0;
      end = 0;
    }

    Interval(int s, int e) {
      start = s;
      end = e;
    }
  }

  public static void main(String[] main) {
    List<Interval> input1 = Arrays.asList(new Interval(1, 3),
        new Interval(2, 6),
        new Interval(8, 10),
        new Interval(15, 18)
    );
    System.out.println("Input:");
    input1
        .forEach(interval -> System.out.print("[" + interval.start + ", " + interval.end + "], "));
    System.out.println();
    System.out.println("Output:");
    merge(input1)
        .forEach(interval -> System.out.print("[" + interval.start + ", " + interval.end + "], "));
    System.out.println();

//    List<Interval> input2 = Arrays.asList(new Interval(1, 3),
//        new Interval(2, 3),
//        new Interval(4, 5),
//        new Interval(6, 7),
//        new Interval(8, 9),
//        new Interval(1, 10)
//    );
//    System.out.println("Input:");
//    input2
//        .forEach(interval -> System.out.print("[" + interval.start + ", " + interval.end + "], "));
//    System.out.println();
//    System.out.println("Output:");
//    merge(input2)
//        .forEach(interval -> System.out.print("[" + interval.start + ", " + interval.end + "], "));
//    System.out.println();
  }
}
