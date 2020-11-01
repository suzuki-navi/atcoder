// AC

import java.util.Scanner;

class Main {
  private static int m = 1_000_000_007;
  private static int[] powTable;
  public static void initPow(int k, int m) {
    powTable = new int[k + 1];
    int p = 1;
    powTable[0] = p;
    for (int i = 1; i <= k; i++) {
      p = (int)(2L * p % m);
      powTable[i] = p;
    }
  }

  public static void main(String[] args) {
    var sc = new Scanner(System.in);
    int h = sc.nextInt();
    int w = sc.nextInt();
    var ss = new boolean[h][w];
    for (int i = 0; i < h; i++) {
      var t = sc.next();
      for (int j = 0; j < w; j++) {
        if (t.charAt(j) == '#') {
          ss[i][j] = true;
        }
      }
    }
    int k = 0;
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        if (!ss[i][j]) k++;
      }
    }
    initPow(k, m);
    int max = powTable[k];
    int sum = 0;
    var iwTable = new int[h][w];
    for (int i = 0; i < h; i++) {
      int jw = -1;
      for (int j = 0; j < w; j++) {
        if (ss[i][j]) {
          jw = -1; continue;
        }
        if (jw < 0) {
          jw = 0; for (int j2 = j; j2 < w && !ss[i][j2]; j2++) jw++;
        }
        int iw = iwTable[i][j];
        if (iw == 0) {
          for (int i2 = i+1; i2 < h && !ss[i2][j]; i2++) iw++;
          for (int i2 = i; i2 < h && !ss[i2][j]; i2++) iwTable[i2][j] = iw;
        }
        sum = (int)(((long)m + sum + max - powTable[k - (iw + jw)]) % m);
      }
    }
    System.out.println(sum);
  }
}
