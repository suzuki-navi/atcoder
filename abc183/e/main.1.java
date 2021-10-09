// TLE

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    int m = 1_000_000_007;

    var sc = new Scanner(System.in);
    int h = sc.nextInt();
    int w = sc.nextInt();
    var ss = new boolean[h][w];
    for (int i = 0; i < h; i++) {
      var t = sc.next();
      for (int j = 0; j < w; j++) {
        if (t.charAt(j) == '#') ss[i][j] = true;
      }
    }

    var table = new int[h][w];
    table[0][0] = 1;
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        if (ss[i][j]) continue;
        if (i == 0 && j == 0) continue;
        long x = 0;
        for (int i2 = i - 1; i2 >= 0; i2--) {
          if (ss[i2][j]) break;
          int z = table[i2][j];
          if (z == 0) break;
          x += z;
        }
        for (int j2 = j - 1; j2 >= 0; j2--) {
          if (ss[i][j2]) break;
          int z = table[i][j2];
          if (z == 0) break;
          x += z;
        }
        int max = (i > j)? j : i;
        for (int s = 1; s <= max; s++) {
          int i2 = i - s, j2 = j - s;
          if (ss[i2][j2]) break;
          int z = table[i2][j2];
          if (z == 0) break;
          x += z;
        }
        table[i][j] = (int)(x % m);
      }
    }
    int answer = table[h-1][w-1];
    System.out.println(answer);
  }
}
