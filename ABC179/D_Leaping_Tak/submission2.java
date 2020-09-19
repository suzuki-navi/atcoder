// AC

import java.util.Scanner;

class Main {
  private static int[] table;
  private static int m = 998244353;
  private static int[][] lrs;

  private static void calc(int x) {
    long sum = table[x - 1];
    if (x == 2) sum = 0;
    for (int i = 0; i < lrs.length; i++) {
      int s = lrs[i][0];
      int e = lrs[i][1];
      if (x - e > 1) {
        sum = (sum + m - table[x - e - 1]) % m;
      }
      if (x - s >= 1) {
        sum = (sum + table[x - s]) % m;
      }
    }
    table[x] = (int)sum;
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
      calc(i);
    }
    var answer = table[n];
    System.out.println(answer);
  }
}
