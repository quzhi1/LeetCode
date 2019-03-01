package com.quzhi1.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HackerSortingComparator {

  static class Player {

    String name;
    int score;

    Player(String name, int score) {
      this.name = name;
      this.score = score;
    }

    @Override
    public String toString() {
      return name + ", " + score;
    }
  }

  static class Checker implements Comparator<Player> {

    // complete this method
    public int compare(Player a, Player b) {
      if (a.score != b.score) {
        return b.score - a.score;
      }
      for (int i = 0; i < Math.min(a.name.length(), b.name.length()); i++) {
        if (a.name.charAt(i) != b.name.charAt(i)) {
          return a.name.charAt(i) - b.name.charAt(i);
        }
      }
      return a.name.length() < b.name.length() ? -1 : 1;
    }
  }

  public static void main(String[] args) {
    List<Player> players = Arrays.asList(
        new Player("amy", 100),
        new Player("david", 100),
        new Player("davidson", 100),
        new Player("heraldo", 50),
        new Player("aakansha", 75),
        new Player("aleksa", 150)
    );
    players.sort(new Checker());
    players.forEach(System.out::println);
  }

}
