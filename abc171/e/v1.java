// AC

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    var sc = new Scanner(System.in);
    int n = sc.nextInt();
    var as = new int[n];
    for (int i = 0; i < n; i++) as[i] = sc.nextInt();
    int total = 0;
    for (int i = 0; i < n; i++) {
      total ^= as[i];
    }
    for (int i = 0; i < n; i++) {
      if (i > 0) System.out.print(" ");
      System.out.print(as[i] ^ total);
    }
    System.out.println();
  }
}
