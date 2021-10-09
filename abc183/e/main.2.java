// TLE

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    int m = 1_000_000_007;

    var sc = new Scanner(System.in);
    int h = sc.nextInt();
    int w = sc.nextInt();
    var ss = new boolean[h*w];
    for (int i = 0; i < h; i++) {
      var t = sc.next();
      for (int j = 0; j < w; j++) {
        if (t.charAt(j) == '#') ss[w*i+j] = true;
      }
    }

    var table = new int[h*w];
    table[0] = 1;
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        int g = w*i+j;
        if (ss[g]) continue;
        if (g == 0) continue;
        long x = 0;
        int k = g;
        for (int i2 = i - 1; i2 >= 0; i2--) {
          k -= w;
          int z = table[k];
          if (z == 0) break;
          x += z;
        }
        k = g;
        for (int j2 = j - 1; j2 >= 0; j2--) {
          k -= 1;
          int z = table[k];
          if (z == 0) break;
          x += z;
        }
        int max = (i > j)? j : i;
        k = g;
        for (int s = 1; s <= max; s++) {
          k -= (w+1);
          int z = table[k];
          if (z == 0) break;
          x += z;
        }
        table[g] = (int)(x % m);
      }
    }
    int answer = table[h*w-1];
    System.out.println(answer);
  }
}
