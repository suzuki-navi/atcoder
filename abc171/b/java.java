// AC

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    var sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    var ps = new int[n];
    for (int i = 0; i < n; i++) {
      ps[i] = sc.nextInt();
    }

    java.util.Arrays.sort(ps);
    int sum = 0;
    for (int i = 0; i < k; i++) {
      sum += ps[i];
    }

    System.out.println(sum);
  }
}
