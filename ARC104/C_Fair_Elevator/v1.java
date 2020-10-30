// AC

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    var sc = new Scanner(System.in);
    int n = sc.nextInt();
    int n2 = 2 * n;
    var abs = new int[n2];
    for (int i = 0; i < n; i++) {
      abs[2 * i    ] = sc.nextInt();
      abs[2 * i + 1] = sc.nextInt();
    }
    var table = new int[n2];
    var table2 = new boolean[n];
    for (int i = 0; i < n; i++) {
      var a = abs[2 * i    ];
      var b = abs[2 * i + 1];
      if (a > 0 && b > 0 && a >= b || a > 0 && table[a-1] != 0 || b > 0 && table[b-1] != 0) {
        System.out.println("No");
        return;
      }
      if (a > 0) table[a-1] = i + 1;
      if (b > 0) table[b-1] = -(i + 1);
      if (a > 0 && b > 0) table2[i] = true;
    }
    var dp = new boolean[n];
    for (int i = 0; i < n; i++) {
      for (int j = -1; j < i; j++) {
        boolean flag = (j < 0) || dp[j];
        if (!flag) continue;
        int ij2 = i - j;
        int l = 0;
        for (int k = 0; k < ij2; k++) {
          int a = table[2 * (j+1) + k];
          int b = table[2 * (j+1) + k + ij2];
          if (a < 0) {
            flag = false; break;
          } else if (b > 0) {
            flag = false; break;
          } else if (a > 0 && b < 0 && a + b != 0) {
            flag = false; break;
          }
          if (a > 0 && b == 0 && table2[a-1]) {
            flag = false; break;
          } else if (a == 0 && b < 0 && table2[-b-1]) {
            flag = false; break;
          }
        }
        if (l != 0) flag = false;
        if (flag) {
          dp[i] = flag;
          break;
        }
      }
    }
    if (dp[n-1]) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }
}
