// 

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    var sc = new Scanner(System.in);
    int n = sc.nextInt();
    long x = sc.nextLong();
    var as = new long[n];
    for (int i = 0; i < n; i++) {
      as[i] = sc.nextLong();
    }
    var as2 = new long[n];
    as2[0] = 1;
    for (int i = 1; i < n; i++) {
      as2[i] = as[i] / as[i-1];
    }
    var flags = new int[n];
    long x2 = x;
    for (int i = 1; i < n; i++) {
      var a = as2[i];
      var m = x2 % a;
      if (m > 0) {
        if (m < a-1) flags[i-1] = 1;
        else flags[i-1] = 2;
      }
      x2 = x2 / as2[i];
    }
    if (x2 > 0) flags[n-1] = 1;

    long answer = 1;
    int i = 0;
    while (i < n) {
      if (flags[i] > 0) break;
      i++;
    }
    while (i < n) {
      int j = i + 1;
      while (j < n) {
        if (flags[j] == 0) break;
        j++;
      }
      int k = j;
      while (k < n) {
        if (flags[k]) break;
        k++;
      }
      if (k == j && k == n) {
        answer *= (j - i);
      } else {
        answer *= ((k - j) * (j - i) + 1);
      }
      System.out.println(String.format("DEBUG %d %d %d %d", i, j, k, answer));
      i = k;
    }
    System.out.println(answer);
  }
}
