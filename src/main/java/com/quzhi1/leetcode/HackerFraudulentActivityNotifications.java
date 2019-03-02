package com.quzhi1.leetcode;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HackerFraudulentActivityNotifications {

  static int activityNotifications(int[] expenditure, int d) {
    if (d == 0) {
      return 0;
    }
    List<Integer> sortedList = new ArrayList<>();
    for (int i = 0; i < d; i++) {
      sortedList.add(expenditure[i]);
    }
    sortedList.sort(Comparator.comparingInt(Integer::intValue));
    int result = 0;
    for (int i = d; i < expenditure.length; i++) {
      int today = expenditure[i];
      double threshold = 2 * medianFromSorted(sortedList);
      if (today >= threshold) {
        result++;
//        System.out.println("Alert: " + today);
      }
      removeFromSorted(sortedList, expenditure[i - d]);
      insertIntoSorted(sortedList, expenditure[i]);
//      List<Integer> sortedEverytime = new ArrayList<>(sortedList);
//      sortedEverytime.sort(Comparator.comparingInt(Integer::intValue));
//      Assert.assertEquals(sortedEverytime, sortedList);
    }
    return result;
  }

  private static double medianFromSorted(final List<Integer> sortedList) {
    if (sortedList.size() % 2 == 1) {
      return sortedList.get(sortedList.size() / 2);
    } else {
      int midRight = sortedList.get(sortedList.size() / 2);
      int midLeft = sortedList.get(sortedList.size() / 2 - 1);
      return (midLeft + midRight) / 2.0;
    }
  }

  private static void insertIntoSorted(final List<Integer> sortedList, final int input) {
    if (sortedList.size() == 0) {
      sortedList.add(input);
    } else if (sortedList.size() == 1) {
      if (sortedList.get(0) > input) {
        sortedList.add(0, input);
      } else {
        sortedList.add(1, input);
      }
    } else {
      int midIndex = sortedList.size() / 2 - 1;
      int mid = sortedList.get(midIndex);
      if (input == mid) {
        sortedList.add(midIndex, input);
      } else if (input > mid && input < sortedList.get(midIndex + 1)) {
        sortedList.add(midIndex + 1, input);
      } else if (input >= sortedList.get(midIndex + 1)) {
        insertIntoSorted(sortedList.subList(midIndex + 1, sortedList.size()), input);
      } else {
        insertIntoSorted(sortedList.subList(0, midIndex), input);
      }
    }
  }

  private static void removeFromSorted(final List<Integer> sortedList, final int target) {
    int midIndex = sortedList.size() / 2;
    int mid = sortedList.get(midIndex);
    if (target == mid) {
      sortedList.remove(midIndex);
    } else if (target < mid) {
      removeFromSorted(sortedList.subList(0, midIndex), target);
    } else {
      removeFromSorted(sortedList.subList(midIndex, sortedList.size()), target);
    }
  }

  public static void main(String[] args) {
//    Assert.assertEquals(2, activityNotifications(new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5}, 5));
//    Assert.assertEquals(0, activityNotifications(new int[]{1, 2, 3, 4, 4}, 4));
//    Assert.assertEquals(1, activityNotifications(new int[]{10, 20, 30, 40, 50}, 3));
    Assert.assertEquals(1, activityNotifications(new int[]{10, 20, 30, 40, 50, 60, 70}, 4));
//    Assert.assertEquals(1, activityNotifications(new int[]{100, 1, 2, 3, 4}, 3));
//    Assert.assertEquals(3, activityNotifications(new int[]{0, 82, 180, 55, 168, 41, 179, 59, 139}, 3));
//    Assert.assertEquals(2, activityNotifications(new int[]{0, 82, 180, 55, 168, 41, 179, 59, 139}, 5));
//    Assert.assertEquals(1, activityNotifications(new int[]{0, 82, 180, 55, 168, 41, 179, 59, 139}, 4));
  }

//  private static final Scanner scanner = new Scanner(System.in);
//
//  public static void main(String[] args) throws IOException {
//    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("temp.txt"));
//
//    String[] nd = scanner.nextLine().split(" ");
//
//    int n = Integer.parseInt(nd[0]);
//
//    int d = Integer.parseInt(nd[1]);
//
//    int[] expenditure = new int[n];
//
//    String[] expenditureItems = scanner.nextLine().split(" ");
//    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//    for (int i = 0; i < n; i++) {
//      int expenditureItem = Integer.parseInt(expenditureItems[i]);
//      expenditure[i] = expenditureItem;
//    }
//
//    int result = activityNotifications(expenditure, d);
//
//    bufferedWriter.write(String.valueOf(result));
//    bufferedWriter.newLine();
//
//    bufferedWriter.close();
//
//    scanner.close();
//  }
}
