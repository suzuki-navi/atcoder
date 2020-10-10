// AC

import java.util.Scanner;
 
class Main {
  public static void main(String[] args) {
    var sc = new Scanner(System.in);
    var n = sc.nextInt();
    var ps = new int[n];
    for (int i = 0; i < n; i++) {
      ps[i] = sc.nextInt();
    }
    var flags = new boolean[n + 1];
    int prev = 0;
    for (int i = 0; i < n; i++) {
      int p = ps[i];
      if (p <= n) {
        flags[p] = true;
      }
      while (true) {
        if (!flags[prev]) {
          System.out.printf("%d\n", prev);
          break;
        }
        prev++;
      }
    }
  }
}
