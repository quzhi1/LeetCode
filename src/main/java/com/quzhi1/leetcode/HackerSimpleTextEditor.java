package com.quzhi1.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class HackerSimpleTextEditor {

  private static final Stack<Operation> opStack = new Stack<>();
  private static String buffer = "";

  private static class Operation {

    private final int type;
    private final String change;

    Operation(final int type, final String change) {
      this.type = type;
      this.change = change;
    }
  }

  private void append(final String input, final boolean isUndo) {
//    System.out.println("append " + input);
    if (!isUndo) {
      opStack.push(new Operation(1, input));
    }
    buffer += input;
  }

  private void delete(final int size, final boolean isUndo) {
//    System.out.println("delete " + size);
    String change = buffer.substring(buffer.length() - size);
    if (!isUndo) {
      opStack.push(new Operation(2, change));
    }
    buffer = buffer.substring(0, buffer.length() - size);
  }

  private void print(final int index) {
//    System.out.println("print " + index);
    System.out.println(buffer.charAt(index - 1));
  }

  private void undo() {
    Operation op = opStack.pop();
    switch (op.type) {
      case 1:
//        System.out.println("undo append");
        delete(op.change.length(), true);
        break;
      case 2:
//        System.out.println("undo delete");
        append(op.change, true);
        break;
      default:
        throw new UnsupportedOperationException("Undefined operation" + op.type);
    }
  }

  public static void main(String[] args) throws IOException {
    HackerSimpleTextEditor editor = new HackerSimpleTextEditor();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int queryNum = Integer.parseInt(reader.readLine());
    for (int i = 0; i < queryNum; i++) {
      String[] query = reader.readLine().split(" ");
      switch (Integer.parseInt(query[0])) {
        case 1:
          // append
          editor.append(query[1], false);
          break;
        case 2:
          // delete
          editor.delete(Integer.parseInt(query[1]), false);
          break;
        case 3:
          // print
          editor.print(Integer.parseInt(query[1]));
          break;
        case 4:
          // undo
          editor.undo();
          break;
        default:
          throw new UnsupportedOperationException("Undefined operation" + query[0]);
      }
    }
  }
}
