// TLE

import java.util.Scanner;

class Main {
  public static void main(String[] args) {

    var sc = new Scanner(System.in);

    var n = sc.nextInt();
    var m = sc.nextInt();

    var ab = new int[2 * m];
    for (int i = 0; i < m; i++) {
      var a = sc.nextInt() - 1;
      var b = sc.nextInt() - 1;
      if (a > b) {
        var t = b;
        b = a;
        a = t;
      }
      for (int j = i; j >= 0; j--) {
        if (j == 0 || ab[2 * j - 2] <= a) {
          ab[2 * j    ] = a;
          ab[2 * j + 1] = b;
          break;
        }
        ab[2 * j    ] = ab[2 * j - 2];
        ab[2 * j + 1] = ab[2 * j - 1];
      }
    }

    var cluster = new int[n];
    var ic = 1;
    while (true) {
      int i = 0;
      for (; i < n; i++) {
        if (cluster[i] == 0) {
          cluster[i] = ic;
          break;
        }
      }
      if (i >= n) {
        break;
      }
      int iab = 0;
      int j = i;
      int nextJ = n;
      while (iab < m) {
        if (ab[2 * iab] < j) {
          iab++;
          continue;
        }
        if (ab[2 * iab] > j) {
          j = nextJ;
          nextJ = n;
          continue;
        }
        if (cluster[j] == ic) {
          int jj = ab[2 * iab + 1];
          cluster[jj] = ic;
          if (jj < nextJ) {
            nextJ = jj;
          }
        }
        iab++;
      }
      ic++;
    }

    var count = new int[ic];
    for (int i = 0; i < n; i++) {
      count[cluster[i]]++;
    }

    var max = 1;
    for (int i = 1; i < ic; i++) {
      var c = count[i];
      if (c > max) {
        max = c;
      }
    }

    System.out.println(max);

  }
}
