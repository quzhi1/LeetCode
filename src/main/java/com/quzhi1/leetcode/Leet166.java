package com.quzhi1.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leet166 {

  public static String fractionToDecimal(int numerator, int denominator) {
    // This is to prevent Integer.MIN_VALUE
    return fractionToDecimal((long) numerator, (long) denominator);
  }

  private static String fractionToDecimal(long up, long down) {
    // edge cases
    if (up == 0) {
      return "0";
    } else if (up < 0 && down < 0) {
      return fractionToDecimal(-up, -down);
    } else if (up < 0 && down > 0) {
      return "-" + fractionToDecimal(-up, down);
    } else if (up > 0 && down < 0) {
      return "-" + fractionToDecimal(up, -down);
    }

    // Up to now, up and down are all positive
    Map<Long, Integer> reminderToLoc = new HashMap<>();
    long reminder = up % down;
    int loc = 0;
    long startingPoint = -1;
    if (reminder == 0) {
      return String.valueOf(up / down);
    }
    StringBuilder sb = new StringBuilder(up / down + ".");
    while (reminder != 0) {
      if (reminderToLoc.containsKey(reminder)) {
        startingPoint = reminderToLoc.get(reminder);
        sb.append(reminder * 10 / down);
        break;
      } else {
        reminderToLoc.put(reminder, loc++);
        reminder *= 10;
        sb.append(reminder / down);
        reminder %= down;
      }
    }
    if (startingPoint != -1) {
      String rawResult = sb.toString();
      int realStartingPoint = rawResult.indexOf('.') + (int) startingPoint + 1;
      return rawResult.substring(0, realStartingPoint) + "(" +
          rawResult.substring(realStartingPoint, rawResult.length() - 1) + ")";
    } else {
      return sb.toString();
    }
  }

  public static void main(String[] args) {
//    System.out.println(fractionToDecimal(1, 3));
//    System.out.println(fractionToDecimal(1, 7));
//    System.out.println(fractionToDecimal(1, 30));
//    System.out.println(fractionToDecimal(1, -30));
//    System.out.println(fractionToDecimal(1, 125));
    System.out.println(fractionToDecimal(2, 1));
  }

}
