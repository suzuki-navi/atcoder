// AC

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    var sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    var ts = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        ts[i][j] = sc.nextInt();
      }
    }
    int answer = 0;
    var order = new int[n-1];
    var flags = new int[n-1];
    order[0] = 2;
    flags[0] = 0x00;
    for (int i = 1; i < n-1; i++) {
      order[i] = i + 2;
      flags[i] = flags[i-1] | (0x1 << (i-1));
    }
    while (true) {
      //for (int i = 0; i < n-1; i++) {
      //  System.out.print(" " + order[i]);
      //}
      //System.out.println();
      long cost = 0;
      int p = 1;
      for (int i = 0; i < n-1; i++) {
        int p2 = order[i];
        cost += ts[p-1][p2-1];
        p = p2;
      }
      cost += ts[p-1][0];
      if (cost == k) answer++;

      int i = n-2;
      for (; i >= 0; i--) {
        int x = order[i] + 1;
        for (; x <= n; x++) {
          if ((flags[i] & (0x1 << (x-2))) == 0) break;
        }
        if (x <= n) {
          order[i] = x;
          break;
        }
      }
      if (i < 0) break;
      for (i++; i < n-1; i++) {
        flags[i] = flags[i-1] | (0x1 << (order[i-1]-2));
        int x = 2;
        for (; x <= n; x++) {
          if ((flags[i] & (0x1 << (x-2))) == 0) break;
        }
        order[i] = x;
      }
    }
    System.out.println(answer);
  }
}
