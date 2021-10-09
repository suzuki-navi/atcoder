// AC

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

    var table  = new int[h*w];
    var table1 = new int[h*w];
    var table2 = new int[h*w];
    var table3 = new int[h*w];
    table[0] = 1;
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        int g = w*i+j;
        if (ss[g]) continue;
        if (g == 0) continue;
        long x = 0;
        if (i > 0) {
          int k = g - w;
          int x1 = (table[k] + table1[k]) % m;
          table1[g] = x1;
          x += x1;
        }
        if (j > 0) {
          int k = g - 1;
          int x2 = (table[k] + table2[k]) % m;
          table2[g] = x2;
          x += x2;
        }
        if (i > 0 && j > 0) {
          int k = g - w - 1;
          int x3 = (table[k] + table3[k]) % m;
          table3[g] = x3;
          x += x3;
        }
        table[g] = (int)(x % m);
      }
    }
    int answer = table[h*w-1];
    System.out.println(answer);
  }
}
