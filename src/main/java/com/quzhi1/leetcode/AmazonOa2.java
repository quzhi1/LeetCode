package com.quzhi1.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmazonOa2 {

  public static int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot) {
    if (lot == null || lot.size() == 0 || lot.get(0).size() == 0 || lot.size() != numRows
        || lot.get(0).size() != numColumns) {
      return -1;
    }
    List<Location> start = new ArrayList<>();
    start.add(new Location(0, 0));
    return proceed(lot, start, numRows, numColumns);
  }

  private static int proceed(List<List<Integer>> lot, List<Location> locs, int numRows, int numColums) {
    Location currLoc = locs.get(locs.size() - 1);
//    System.out.println("currLoc: " + currLoc.x + ", " + currLoc.y + " -> " + lot.get(currLoc.x).get(currLoc.y));
    if (lot.get(currLoc.x).get(currLoc.y).equals(9)) {
//      System.out.println("Found! " + (locs.size() - 1));
      return locs.size() - 1;
    }
    Location up = new Location(currLoc.x - 1, currLoc.y);
    Location down = new Location(currLoc.x + 1, currLoc.y);
    Location left = new Location(currLoc.x, currLoc.y - 1);
    Location right = new Location(currLoc.x, currLoc.y + 1);

    int min = Integer.MAX_VALUE;

    if (isLocValid(up, numRows, numColums, lot) && !locs.contains(up)) {
      locs.add(up);
      int result = proceed(lot, locs, numRows, numColums);
      if (result != -1 && result < min) {
        min = result;
      }
      locs.remove(up);
    }

    if (isLocValid(down, numRows, numColums, lot) && !locs.contains(down)) {
      locs.add(down);
      int result = proceed(lot, locs, numRows, numColums);
      if (result != -1 && result < min) {
        min = result;
      }
      locs.remove(down);
    }

    if (isLocValid(left, numRows, numColums, lot) && !locs.contains(left)) {
      locs.add(left);
      int result = proceed(lot, locs, numRows, numColums);
      if (result != -1 && result < min) {
        min = result;
      }
      locs.remove(left);
    }

    if (isLocValid(right, numRows, numColums, lot) && !locs.contains(right)) {
      locs.add(right);
      int result = proceed(lot, locs, numRows, numColums);
      if (result != -1 && result < min) {
        min = result;
      }
      locs.remove(right);
    }

    if (min == Integer.MAX_VALUE) {
      return -1;
    } else {
      return min;
    }
  }

  private static boolean isLocValid(Location loc, int numRows, int numColumns, List<List<Integer>> lot) {
    return loc.x > -1 && loc.x < numRows && loc.y > -1 && loc.y < numColumns && lot.get(loc.x).get(loc.y) != 0;
  }

  static class Location {

    int x, y;

    Location(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object target) {
      if (target instanceof Location) {
        return ((Location) target).x == this.x && ((Location) target).y == this.y;
      } else {
        return false;
      }
    }
  }

  public static void main(String[] args) {
    List<List<Integer>> lot1 = Arrays.asList(
        Arrays.asList(1, 0, 0),
        Arrays.asList(1, 0, 0),
        Arrays.asList(1, 9, 1)
    );
    System.out.println(removeObstacle(3, 3, lot1));

    List<List<Integer>> lot2 = Arrays.asList(
        Arrays.asList(1, 1, 1, 1),
        Arrays.asList(0, 1, 1, 1),
        Arrays.asList(0, 1, 0, 1),
        Arrays.asList(1, 1, 9, 1),
        Arrays.asList(0, 0, 1, 1)
    );
    System.out.println(removeObstacle(5, 4, lot2));

    List<List<Integer>> lot3 = Arrays.asList(
        Arrays.asList(9)
    );
    System.out.println(removeObstacle(1, 1, lot3));

    List<List<Integer>> lot4 = Arrays.asList(
        Arrays.asList(1, 1, 1),
        Arrays.asList(1, 1, 0),
        Arrays.asList(1, 0, 9));
    System.out.println(removeObstacle(3, 3, lot4));

    List<List<Integer>> lot5 = Arrays.asList(
        Arrays.asList(1, 0, 9),
        Arrays.asList(0, 1, 1),
        Arrays.asList(1, 1, 1)
    );
    System.out.println(removeObstacle(3, 3, lot5));

    List<List<Integer>> lot6 = Arrays.asList(
        Arrays.asList(1, 1, 1, 0),
        Arrays.asList(0, 0, 1, 0),
        Arrays.asList(1, 1, 1, 0),
        Arrays.asList(1, 1, 0, 0),
        Arrays.asList(0, 1, 1, 9)
    );
    System.out.println(removeObstacle(5, 4, lot6));
  }

}
