package com.quzhi1.leetcode;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;

public class HackerContacts {

  static int[] contacts(String[][] queries) {
    List<Integer> result = new ArrayList<>(queries.length);
    PrefixTree root = new PrefixTree('\t');
    for (String[] query : queries) {
      switch (query[0]) {
        case "add":
          root.addName(query[1]);
          break;
        case "find":
          result.add(root.prefixCount(query[1]));
          break;
        default:
          throw new UnsupportedOperationException("Unknown: " + query[0]);
      }
    }
    return result.stream().mapToInt(i -> i).toArray();
  }

  static class PrefixTree {

    private final char value;
    private int count;
    private final List<PrefixTree> children = new ArrayList<>();

    PrefixTree(final char value) {
      this.value = value;
      this.count = 1;
    }

    void addName(final String name) {
      if (name != null && !name.isEmpty()) {
        char head = name.charAt(0);
        for (PrefixTree child : children) {
          if (child.value == head) {
            child.count++;
            child.addName(name.substring(1));
            return;
          }
        }
        PrefixTree newChild = new PrefixTree(head);
        newChild.addName(name.substring(1));
        children.add(newChild);
      }
    }

    int prefixCount(final String target) {
      if (target == null || target.isEmpty()) {
        return 0;
      } else if (target.length() == 1) {
        for (PrefixTree child : children) {
          if (child.value == target.charAt(0)) {
            return child.count;
          }
        }
        return 0;
      } else {
        char head = target.charAt(0);
        for (PrefixTree child : children) {
          if (child.value == head) {
            return child.prefixCount(target.substring(1));
          }
        }
        return 0;
      }
    }
  }

  public static void main(String[] args) {
    int[] result = contacts(new String[][]{
        new String[]{"add", "hack" },
        new String[]{"add", "hackerrank" },
        new String[]{"find", "hac" },
        new String[]{"find", "hak" }
    });
    Assert.assertArrayEquals(new int[]{2, 0}, result);
//    int[] result = contacts(new String[][]{
//        new String[]{"add", "s" },
//        new String[]{"add", "ss" },
//        new String[]{"add", "sss" },
//        new String[]{"add", "ssss" },
//        new String[]{"add", "sssss" },
//        new String[]{"find", "s" },
//        new String[]{"find", "ss" },
//        new String[]{"find", "sss" },
//        new String[]{"find", "ssss" },
//        new String[]{"find", "sssss" },
//        new String[]{"find", "ssssss" }
//    });
//    Assert.assertArrayEquals(new int[]{5, 4, 3, 2, 1, 0}, result);
  }

}
