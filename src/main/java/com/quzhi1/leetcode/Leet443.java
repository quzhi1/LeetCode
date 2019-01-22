package com.quzhi1.leetcode;

import java.util.Arrays;

public class Leet443 {

  public static int compress(char[] chars) {
    char mark = ' ';
    int count = 0;
    int progress = 0;
    for (char eachChar : chars) {
      if (eachChar != mark) {
        if (mark != ' ') {
          if (count != 1) {
            String countStr = Integer.toString(count);
            for (char countChar : countStr.toCharArray()) {
              chars[progress++] = countChar;
            }
          }
          count = 0;
        }
        mark = eachChar;
        count++;
        chars[progress++] = eachChar;
      } else {
        count++;
      }
    }
    if (count != 1) {
      String countStr = Integer.toString(count);
      for (char countChar : countStr.toCharArray()) {
        chars[progress++] = countChar;
      }
    }
    chars = Arrays.copyOfRange(chars, 0, progress);
    return chars.length;
  }

  public static void main(String[] args) {
//    char[] input1 = "aabbccc".toCharArray();
//    System.out.println(compress(input1));
//    System.out.println(new String(input1));

    char[] input2 = "abc".toCharArray();
    System.out.println(compress(input2));
    System.out.println(new String(input2));
  }

}
