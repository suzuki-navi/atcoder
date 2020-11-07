// AC

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    var sc = new Scanner(System.in);
    int n = sc.nextInt();
    var as = new Integer[n];
    for (int i = 0; i < n; i++) {
      as[i] = sc.nextInt();
    }
    java.util.Arrays.sort(as, java.util.Comparator.comparingInt(x -> -x));
    long answer = 0;
    for (int i = 1; i < n; i++) {
      answer += as[i / 2];
    }
    System.out.println(answer);
  }
}
