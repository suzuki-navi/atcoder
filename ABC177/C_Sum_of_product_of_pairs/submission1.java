// TLE

import java.util.Scanner;

class Main {
  public static void main(String[] args) {

    var m = 1000000000 + 7;

    var sc = new Scanner(System.in);

    var n = sc.nextInt();
    var a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt() % m;
    }

    long answer = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        answer = (answer + (long)a[i] * a[j] % m) % m;
      }
    }

    System.out.println(answer);

  }
}
