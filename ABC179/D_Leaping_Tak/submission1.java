// TLE

import java.util.Scanner;

class Main {
  private static int[] table;
  private static int m = 998244353;
  private static int[][] lrs;

  private static int fetch(int x) {
    if (table[x] > 0) {
      return table[x];
    }
    int sum = 0;
    for (int i = 0; i < lrs.length; i++) {
      int s = lrs[i][0];
      int e = lrs[i][1];
      for (int j = s; j <= e; j++) {
        int x2 = x - j;
        if (x2 <= 0) break;
        sum += fetch(x2);
        sum = sum % m;
      }
    }
    table[x] = sum;
    return sum;
  }

  public static void main(String[] args) {
    var sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    lrs = new int[k][2];
    for (int i = 0; i < k; i++) {
      lrs[i][0] = sc.nextInt();
      lrs[i][1] = sc.nextInt();
    }
    table = new int[n + 1];
    table[1] = 1;

    for (int i = 2; i <= n; i++) {
      fetch(i);
    }
    var answer = fetch(n);
    System.out.println(answer);
  }
}
