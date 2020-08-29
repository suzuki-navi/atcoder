// TLE

import java.util.Scanner;

class Main {
  public static void main(String[] args) {

    var sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();

    var ab = new int[2 * m];
    for (int i = 0; i < m; i++) {
      int a = sc.nextInt() - 1;
      int b = sc.nextInt() - 1;
      if (a > b) {
        int t = b;
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

    var group = new int[n];
    for (int i = 0; i < n; i++) {
      group[i] = i;
    }

    {
      int i = 0;
      int iab = 0;
      while (i < n && iab < m) {
        if (ab[2 * iab] > i) {
          i++;
        } else if (ab[2 * iab] < i) {
          iab++;
        } else {
          int t = ab[2 * iab + 1];
          group[t] = group[i];
          iab++;
        }
      }
    }

    var count = new int[n];
    for (int i = 0; i < n; i++) {
      count[group[i]]++;
    }
    int max = 0;
    for (int i = 0; i < n; i++) {
      int c = count[i];
      if (c > max) {
        max = c;
      }
    }

    System.out.println(max);

  }
}
