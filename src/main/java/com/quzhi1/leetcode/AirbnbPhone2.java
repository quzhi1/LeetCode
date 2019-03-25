package com.quzhi1.leetcode;

public class AirbnbPhone2 {

  public static void main(String[] args) {
    justify("Now for   a      longer article. This one has a lot of text.", 12);
    // justify("This one has a lot of text.", 12);
  }

  private static void justify(String input, int maxWidth) {
    if (input == null) {
      return;
    }
    System.out.println("+------------+");
    int start = 0;
    int rollback = start;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) != ' ') {
        if (i - start >= maxWidth) {
          // flush
          // System.out.println("Before rollback: " + sb.toString()); // TODO
          // System.out.println("Length: " + (i - start));
          // System.out.println("clear start: " + (sb.length() - (i - rollback + 1)));
          // System.out.println("clear end: " + sb.length());
          // System.out.println("i: " + i);
          // System.out.println("rollback: " + rollback);
          sb.delete(sb.length() - (i - rollback), sb.length());
          // Pad spaces
          if (sb.length() < maxWidth) {
            int remainingSpace = maxWidth - sb.length();
            for (int j = 0; j < remainingSpace; j++) {
              sb.append(' ');
            }
          }
          System.out.println("|" + sb.toString() + "|");
          sb = new StringBuilder();
          i = rollback;
          start = i;
          // System.out.println("start: " + start + ", i: " + i);
        } else {
          sb.append(input.charAt(i));
        }
      } else {
        rollback = i;
        if (i - start >= maxWidth) {
          // flush
          // System.out.println("Before rollback: " + sb.toString()); // TODO
          // System.out.println("Length: " + (i - start));
          // System.out.println("clear start: " + (sb.length() - (i - rollback + 1)));
          // System.out.println("clear end: " + sb.length());
          // System.out.println("i: " + i);
          // System.out.println("rollback: " + rollback);
          sb.delete(sb.length() - (i - rollback), sb.length());
          // Pad spaces
          if (sb.length() < maxWidth) {
            int remainingSpace = maxWidth - sb.length();
            for (int j = 0; j < remainingSpace; j++) {
              sb.append(' ');
            }
          }
          System.out.println("|" + sb.toString() + "|");
          sb = new StringBuilder();
          i = rollback;
          start = i;
          // System.out.println("start: " + start + ", i: " + i);
        } else {
          sb.append(input.charAt(i));
        }
      }
    }

    // last line
    if (sb.length() > 0) {
      int remainingSpace = maxWidth - sb.length();
      for (int i = 0; i < remainingSpace; i++) {
        sb.append(' ');
      }
      System.out.println("|" + sb.toString() + "|");
    }
    System.out.println("+------------+");
  }

}
