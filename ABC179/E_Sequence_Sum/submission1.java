// WA

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    var sc = new Scanner(System.in);
    long n = sc.nextLong();
    int x = sc.nextInt();
    int m = sc.nextInt();

    long answer = 0;
    long x2 = x;
    long m1 = m - 1;
    if (n < 2 * m1) {
      for (int i = 0; i < n; i++) {
        answer += x2;
        x2 = x2 * x2 % m;
      }
    } else {
      for (int i = 0; i < m1; i++) {
        answer += x2;
        x2 = x2 * x2 % m;
      }
      long answer2 = 0;
      for (int i = 0; i < m1; i++) {
        answer2 += x2;
        x2 = x2 * x2 % m;
      }
      answer += answer2 * ((n / m1) - 1);
      int n2 = (int)(n % m1);
      for (int i = 0; i < n2; i++) {
        answer += x2;
        x2 = x2 * x2 % m;
      }
    }

    System.out.println(answer);
  }
}
