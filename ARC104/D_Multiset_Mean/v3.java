// AC

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    var sc = new Scanner(System.in);
    var n = sc.nextInt();
    var k = sc.nextInt();
    var m = sc.nextInt();

    var table = new int[n][];
    table[0] = new int[2];
    table[0][0] = 1;
    for (int i = 1; i < n; i++) {
      var t1 = table[i-1];
      var t2 = new int[i * (i+1) * k / 2 + 2];
      int j_max = i * (i+1) * k / 2;
      for (int j = 0; j <= j_max; j++) {
        int a1 = ((j - (i - 1) * i * k / 2) + i - 1) / i;
        if (a1 < 0) a1 = 0;
        int a2 = j / i;
        if (a2 > k) a2 = k;
        long s = 0;
        for (int a = a1; a <= a2; a++) {
          s += t1[j - a * i];
        }
        s = s % m;
        t2[j] = (int)s;
      }
      table[i] = t2;
    }

    var table2 = new int[(n + 1) / 2 + 1];
    for (int x = 1; x <= (n + 1) / 2; x++) {
      int n1 = x - 1;
      int n2 = n - x;
      long s = 0;
      for (int i = 0; i <= n1 * (n1+1) * k / 2; i++) {
        s += (long)table[n1][i] * table[n2][i] % m;
      }
      int answer = (int)(((long)m + s * (k+1) - 1) % m);
      table2[x] = answer;
      System.out.printf("%d\n", answer);
    }
    for (int x = (n + 1) / 2 + 1; x <= n; x++) {
      System.out.printf("%d\n", table2[n + 1 - x]);
    }
  }
}
