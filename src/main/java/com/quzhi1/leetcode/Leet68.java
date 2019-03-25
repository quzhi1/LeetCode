package com.quzhi1.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leet68 {

  public static List<String> fullJustify(String[] words, int maxWidth) {
    List<String> result = new ArrayList<>();
    int start = 0;
    int lineBuffer = 0;
    for (int i = 0; i < words.length; i++) {
      lineBuffer += words[i].length() + 1;
      if (lineBuffer > maxWidth + 1) {
        StringBuilder sb = new StringBuilder();
        if (i - start == 1) {
          // one word case
          int spaceToPad = maxWidth - words[i - 1].length();
          sb.append(words[i - 1]);
          for (int k = 0; k < spaceToPad; k++) {
            sb.append(" ");
          }
        } else {
          // flush start to i - 1
          int size = i - start;
          int wordLength = lineBuffer - words[i].length() - 1 - size;
          int eachSpaceSizeMin = (maxWidth - wordLength) / (size - 1);
          int someMoreSpaces = maxWidth - wordLength - eachSpaceSizeMin * (size - 1);

          for (int j = start; j < i - 1; j++) {
            sb.append(words[j]);
            for (int k = 0; k < eachSpaceSizeMin; k++) {
              sb.append(" ");
            }
            if (someMoreSpaces > 0) {
              sb.append(" ");
              someMoreSpaces--;
            }
          }
          sb.append(words[i - 1]);
        }
        start = i;
        lineBuffer = 0;
        result.add(sb.toString());
        i--;
      }
    }
    if (lineBuffer > 0) {
      int progress = 0;
      StringBuilder sb = new StringBuilder();
      for (int k = start; k < words.length; k++) {
        sb.append(words[k]);
        sb.append(" ");
        progress += words[k].length() + 1;
      }
      // If enough
      if (progress > maxWidth) {
        sb.delete(sb.length() - 1, sb.length());
      } else {
        while (progress < maxWidth) {
          sb.append(" ");
          progress++;
        }
      }
      result.add(sb.toString());
    }
    return result;
  }

  public static void main(String[] args) {
//    System.out.println(
//        String
//            .join("\n", fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16)));
//    System.out.println(
//        String
//            .join("\n", fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16)));
    System.out.println(
        String
            .join("\n", fullJustify(
                new String[]{"ask", "not", "what", "your", "country", "can", "do", "for", "you", "ask", "what", "you",
                    "can", "do", "for", "your", "country"}, 16)));
  }
}
