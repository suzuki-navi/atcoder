
// AC

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

    var n = sc.nextInt();
    var m = sc.nextInt();
    var k = sc.nextInt();

    var ab = new int[2 * m];
    for (int i = 0; i < m; i++) {
      var a = sc.nextInt() - 1;
      var b = sc.nextInt() - 1;
      ab[2 * i    ] = a;
      ab[2 * i + 1] = b;
    }

    var cd = new int[2 * k];
    for (int i = 0; i < k; i++) {
      var c = sc.nextInt() - 1;
      var d = sc.nextInt() - 1;
      cd[2 * i    ] = c;
      cd[2 * i + 1] = d;
    }

    var count = new int[n];
    var root = new int[n];
    var abcount = new int[n];
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
      abcount[a]++;
      abcount[b]++;
    }

    for (int i = 0; i < k; i++) {
      int c = cd[2 * i    ];
      int d = cd[2 * i + 1];
      int rc = root(root, c);
      int rd = root(root, d);
      if (rc == rd) {
        abcount[c]++;
        abcount[d]++;
      }
    }

    var answer = new int[n];
    for (int i = 0; i < n; i++) {
      int r = root(root, i);
      answer[i] = count[r] - abcount[i] - 1;
    }

    for (int i = 0; i < n; i++) {
      if (i > 0) {
        System.out.print(" ");
      }
      System.out.print(answer[i]);
    }
    System.out.print("\n");

  }
}
