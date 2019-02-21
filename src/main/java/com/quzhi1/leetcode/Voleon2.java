package com.quzhi1.leetcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Voleon2 {

  private static final PriorityQueue<Order> buyQueue = new PriorityQueue<>(
      (o1, o2) -> {
        if (o2.price - o1.price > 0) {
          return 1;
        } else if (o2.price - o1.price == 0) {
          return o1.id - o2.id;
        } else {
          return -1;
        }
      }
  );
  private static final PriorityQueue<Order> sellQueue = new PriorityQueue<>(
      (o1, o2) -> {
        if (o1.price - o2.price > 0) {
          return 1;
        } else if (o1.price - o2.price == 0) {
          return o1.id - o2.id;
        } else {
          return -1;
        }
      }
  );

  static class Order {

    private final int id;
    private final int amount;
    private final double price;

    Order(final int id, final int amount, final double price) {
      this.id = id;
      this.amount = amount;
      this.price = price;
    }

  }

  private static void newBuy(final int id, final int amount, final double price) {
//    System.out.println("Buy amount: " + amount + ", at " + price);
    if (sellQueue.isEmpty()) {
      buyQueue.add(new Order(id, amount, price));
    } else {
      int amountRemaining = amount;
      while (amountRemaining > 0 && !sellQueue.isEmpty() && sellQueue.peek().price <= price) {
        amountRemaining = checkQueue(sellQueue, amountRemaining, id);
      }
      if (amountRemaining > 0) {
        buyQueue.add(new Order(id, amountRemaining, price));
      }
    }
  }

  private static void newSell(final int id, final int amount, final double price) {
//    System.out.println("Sell amount: " + amount + ", at " + price);
    if (buyQueue.isEmpty()) {
      sellQueue.add(new Order(id, amount, price));
    } else {
      int amountRemaining = amount;
      while (amountRemaining > 0 && !buyQueue.isEmpty() && buyQueue.peek().price >= price) {
        amountRemaining = checkQueue(buyQueue, amountRemaining, id);
      }
      if (amountRemaining > 0) {
        sellQueue.add(new Order(id, amountRemaining, price));
      }
    }
  }

  private static int checkQueue(final PriorityQueue<Order> queue, final int amountRemaining, int id) {
    Order top = queue.poll();
    if (top.amount > amountRemaining) {
      // this order done
      System.out.printf("match %s %s %s %.2f\n", id, top.id, amountRemaining, top.price);
      queue.add(new Order(top.id, top.amount - amountRemaining, top.price));
      return 0;
    } else {
      // top done
      System.out.printf("match %s %s %s %.2f\n", id, top.id, top.amount, top.price);
      return amountRemaining - top.amount;
    }
  }

  public static void main(String args[]) throws Exception {
    // Read input
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int nextId = 1;
    while (true) {
      String line = reader.readLine();
      if (line == null || line.isEmpty()) {
        System.exit(0);
      }
      String[] lineParsed = line.split(" ");
      switch (lineParsed[1]) {
        case "buy":
          newBuy(nextId++, Integer.parseInt(lineParsed[2]), Double.parseDouble(lineParsed[3]));
          break;
        case "sell":
          newSell(nextId++, Integer.parseInt(lineParsed[2]), Double.parseDouble(lineParsed[3]));
          break;
        default:
          throw new UnsupportedOperationException("Operation " + lineParsed[1] + " not supported");
      }
    }
  }
}
