package com.quzhi1.leetcode;

public class Leet829 {

  // See https://leetcode.com/problems/consecutive-numbers-sum/solution/
  // 2 * n = k * (2 * x + k + 1)
  public int consecutiveNumbersSumStandard(int N) {
    while ((N & 1) == 0) {
      N >>= 1;
    }
    int ans = 1, d = 3;

    while (d * d <= N) {
      int e = 0;
      while (N % d == 0) {
        N /= d;
        e++;
      }
      ans *= e + 1;
      d += 2;
    }

    if (N > 1) {
      ans <<= 1;
    }
    return ans;
  }

  // Here is a more understandable solution
  int consecutiveNumbersSum(int N) {
    int ans = 0;
    for (int m = 1; ; m++) {
      int mx = N - m * (m-1) / 2;
      if (mx <= 0)
        break;
      if (mx % m == 0)
        ans++;
    }
    return ans;
  }
}
