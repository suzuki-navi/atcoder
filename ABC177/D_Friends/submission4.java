// TLE

import java.util.Scanner;

class Main {
  public static int root(int[] root, int i) {
    int r = root[i];
    if (r == i) {
      return r;
    } else {
      int r2 = root(root, r);
      root[i] = r2;
      return r2;
    }
  }

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
      ab[2 * i    ] = a;
      ab[2 * i + 1] = b;
    }

    var count = new int[n];
    var root = new int[n];
    for (int i = 0; i < n; i++) {
      count[i] = 1;
      root[i] = i;
    }
    for (int i = 0; i < m; i++) {
      int a = ab[2 * i    ];
      int b = ab[2 * i + 1];
      int ra = root(root, a);
      int rb = root(root, b);
      if (ra != rb) {
        if (ra > rb) {
          int t = rb;
          rb = ra;
          ra = t;
        }
        root[rb] = ra;
        count[ra] += count[rb];
      }
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
