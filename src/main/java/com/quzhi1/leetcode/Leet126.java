package com.quzhi1.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leet126 {

  public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    // Build graph (BFS)
    List<Node> thisLevel = new ArrayList<>();
    Node root = new Node(beginWord);
    thisLevel.add(root);
    List<Node> nextLevel = new ArrayList<>();
    while (!wordList.isEmpty()) {
      Set<String> wordsToRemove = new HashSet<>();
      for (Node node : thisLevel) {
        for (String wordInList : wordList) {
          if (isNeigh(node.word, wordInList)) {
            Node next = new Node(wordInList);
            node.addNext(next);
            wordsToRemove.add(wordInList);
            nextLevel.add(next);
          }
        }
      }
      wordList.removeAll(wordsToRemove);
      if (wordsToRemove.isEmpty()) {
        return Collections.emptyList();
      } else if (wordsToRemove.contains(endWord)) {
        break;
      }
      thisLevel = nextLevel;
      nextLevel = new ArrayList<>();
    }

    // DFS
    List<List<String>> result = new ArrayList<>();
    List<String> startPath = new ArrayList<>();
    startPath.add(beginWord);
    traverse(startPath, root, result, endWord);
    return result;
  }

  private static void traverse(List<String> path, Node node, List<List<String>> result, String endWord) {
    if (node.word.equals(endWord)) {
      result.add(new ArrayList<>(path));
    } else {
      for (Node next : node.nexts) {
        path.add(next.word);
        traverse(path, next, result, endWord);
        path.remove(path.size() - 1);
      }
    }
  }

  private static boolean isNeigh(String origin, String target) {
    if (origin.length() != target.length()) {
      return false;
    }
    int charChanged = 0;
    for (int i = 0; i < origin.length(); i++) {
      if (origin.charAt(i) != target.charAt(i)) {
        charChanged++;
      }
      if (charChanged > 1) {
        return false;
      }
    }
    return charChanged == 1;
  }

  static class Node {

    final String word;
    final List<Node> nexts = new ArrayList<>();

    Node(String word) {
      this.word = word;
    }

    void addNext(Node next) {
      nexts.add(next);
    }
  }

  public static void main(String[] main) {
//    System.out.println(isNeigh("hit", "hot"));
//    System.out.println(isNeigh("hit", "hit"));
//    System.out.println(isNeigh("hit", "hoo"));
//    List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
//    List<List<String>> result = findLadders("hit", "cog", wordList);
//    result.forEach(list -> {
//      list.forEach(node -> System.out.print(node + ", "));
//      System.out.println();
//    });
    List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dog"));
    List<List<String>> result = findLadders("hot", "dog", wordList);
    result.forEach(list -> {
      list.forEach(node -> System.out.print(node + ", "));
      System.out.println();
    });
  }
}
