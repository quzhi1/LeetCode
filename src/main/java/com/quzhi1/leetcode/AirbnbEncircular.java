package com.quzhi1.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Assert;

public class AirbnbEncircular {

  enum Direction {
    LEFT(1), RIGHT(2), UP(3), DOWN(4);

    final int hash;

    Direction(int hash) {
      this.hash = hash;
    }

    public int getHash() {
      return this.hash;
    }

    static Direction turnLeft(Direction prev) {
      switch (prev) {
        case LEFT:
          return DOWN;
        case UP:
          return LEFT;
        case RIGHT:
          return UP;
        case DOWN:
          return RIGHT;
        default:
          throw new RuntimeException("Can't turn left");
      }
    }

    static Direction turnRight(Direction prev) {
      switch (prev) {
        case LEFT:
          return UP;
        case UP:
          return RIGHT;
        case RIGHT:
          return DOWN;
        case DOWN:
          return LEFT;
        default:
          throw new RuntimeException("Can't turn left");
      }
    }
  }

  static class Position {

    final int x, y;
    final Direction direction;

    Position(int x, int y, Direction direction) {
      this.x = x;
      this.y = y;
      this.direction = direction;
    }

    @Override
    public boolean equals(Object position) {
      if (position instanceof Position) {
        Position p = (Position) position;
        return p.x == x && p.y == y && p.direction == direction;
      } else {
        return false;
      }
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + x;
      result = prime * result + y;
      result = prime * result + direction.getHash();
      return result;
    }

    static Position left(Position prev) {
      return new Position(prev.x, prev.y, Direction.turnLeft(prev.direction));
    }

    static Position right(Position prev) {
      return new Position(prev.x, prev.y, Direction.turnRight(prev.direction));
    }

    static Position forward(Position prev) {
      switch (prev.direction) {
        case LEFT:
          return new Position(prev.x - 1, prev.y, prev.direction);
        case RIGHT:
          return new Position(prev.x + 1, prev.y, prev.direction);
        case UP:
          return new Position(prev.x, prev.y - 1, prev.direction);
        case DOWN:
          return new Position(prev.x, prev.y + 1, prev.direction);
        default:
          throw new RuntimeException("Can't forward");
      }
    }
  }

  public static List<String> doesCircleExist(List<String> commands) {
    List<String> result = new ArrayList<>();
    for (String commandList : commands) {
      Position prev = new Position(0, 0, Direction.UP);
      Set<Position> totalPath = new HashSet<>();
      for (int i = 0; i < 4; i++) {
        prev = goOnce(commandList, prev, totalPath);
      }
      Set<Position> fifthTime = new HashSet<>();
      goOnce(commandList, prev, fifthTime);
      if (hasVisited(totalPath, fifthTime)) {
        result.add("YES");
      } else {
        result.add("NO");
      }
    }
    return result;
  }

  private static Position goOnce(String commandList, Position prev, Set<Position> totalPath) {
    for (char c : commandList.toCharArray()) {
      prev = advance(prev, c);
      totalPath.add(prev);
    }
    return prev;
  }

  private static boolean hasVisited(Set<Position> totalPath, Set<Position> newPath) {
    for (Position newPos : newPath) {
      if (!totalPath.contains(newPos)) {
        return false;
      }
    }
    return true;
  }

  private static Position advance(Position prev, char command) {
    switch (command) {
      case 'G':
        return Position.forward(prev);
      case 'L':
        return Position.left(prev);
      case 'R':
        return Position.right(prev);
      default:
        throw new IllegalArgumentException("Unknown command: " + command);
    }
  }

  public static void main(String[] args) {
    Assert.assertEquals(Collections.singletonList("NO"), doesCircleExist(Collections.singletonList("GRGL")));
    Assert.assertEquals(Collections.singletonList("NO"), doesCircleExist(Collections.singletonList("G")));
    Assert.assertEquals(Collections.singletonList("YES"), doesCircleExist(Collections.singletonList("L")));
    Assert.assertEquals(Collections.singletonList("NO"), doesCircleExist(Collections.singletonList("GRGLLGR")));
    Assert.assertEquals(Collections.singletonList("YES"), doesCircleExist(Collections.singletonList("GRGLLG")));
  }
}
