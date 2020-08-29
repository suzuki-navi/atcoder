// AC

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

    long sum1 = 0;
    long sum2 = 0;
    for (int i = 0; i < n; i++) {
      sum1 += a[i];
      sum2 += (long)a[i] * a[i] % m;
    }
    sum1 = sum1 % m;
    sum2 = sum2 % m;

    long t = (sum1 * sum1 - sum2) % m;
    long answer;
    if (t % 2 == 0) {
      answer = t / 2;
    } else {
      answer = (t + m) / 2;
    }

    System.out.println(answer);
  }
}
