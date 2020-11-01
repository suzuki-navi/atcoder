// 

import java.util.Scanner;

class Main {
  private static int cost(int[] x, int[] y, int[] z, int k, int j) {
    if (j == 16) j = 0; else j = j + 1;
    if (k == 16) k = 0; else k = k + 1;
    int rx = x[j] - x[k];
    int ry = y[j] - y[k];
    int rz = z[j] - z[k];
    if (rx < 0) rx = -rx;
    if (ry < 0) ry = -ry;
    if (rz < 0) rz = 0;
    return rx + ry + rz;
  }
  public static void main(String[] args) {
    var sc = new Scanner(System.in);
    int n = sc.nextInt();
    var x = new int[n];
    var y = new int[n];
    var z = new int[n];
    for (int i = 0; i < n; i++) {
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
      z[i] = sc.nextInt();
    }

    var dp = new int[(1 << 16) * 16];
    int i_max = (1 << (n-1)) - 1;
    for (int i = 0; i <= i_max; i++) {
      for (int j = 0; j < 16; j++) {
        if ((i & (1 << j)) == 0) continue;
        int i2 = i ^ (1 << j);
        int cost = Integer.MAX_VALUE;
        for (int k = 0; k < 16; k++) {
          if ((i2 & (1 << k)) == 0) continue;
          int c = dp[i2 * 16 + k] + cost(x, y, z, k, j);
          if (c < cost) cost = c;
        }
        if (cost == Integer.MAX_VALUE) {
          cost = cost(x, y, z, 16, j);
        }
        dp[i * 16 + j] = cost;
      }
    }

    int cost = Integer.MAX_VALUE;
    for (int j = 0; j < (n-1); j++) {
      if ((i_max & (1 << j)) == 0) continue;
      int c = dp[i_max * 16 + j] + cost(x, y, z, j, 16);
      if (c < cost) cost = c;
    }
    System.out.println(cost);
  }
}
