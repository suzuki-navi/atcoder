// AC

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    var sc = new Scanner(System.in);
    int n = sc.nextInt();
    var as = new int[n];
    for (int i = 0; i < n; i++) {
      as[i] = sc.nextInt();
    }
    int a0 = as[0];
    for (int i = 1; i < n; i++) {
      int a1 = as[i];
      while (true) {
        if (a0 > a1) {
          a0 = (a0-1) % a1 + 1;
        } else if (a0 < a1) {
          a1 = (a1-1) % a0 + 1;
        } else {
          break;
        }
      }
    }
    System.out.println(a0);
  }
}
