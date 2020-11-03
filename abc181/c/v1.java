// AC

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    var sc = new Scanner(System.in);
    int n = sc.nextInt();
    var xys = new int[2 * n];
    for (int i = 0; i < n; i++) {
      xys[2 * i + 0] = sc.nextInt();
      xys[2 * i + 1] = sc.nextInt();
    }
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        for (int k = j + 1; k < n; k++) {
          int x1 = xys[2 * j + 0] - xys[2 * i + 0];
          int x2 = xys[2 * k + 0] - xys[2 * i + 0];
          int y1 = xys[2 * j + 1] - xys[2 * i + 1];
          int y2 = xys[2 * k + 1] - xys[2 * i + 1];
          if (x1 * y2 - x2 * y1 == 0) {
            System.out.println("Yes");
            System.exit(0);
          }
        }
      }
    }
    System.out.println("No");
  }
}
