// TLE

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    var sc = new Scanner(System.in);
    long n = sc.nextLong();
    int x = sc.nextInt();
    int m = sc.nextInt();

    long answer = 0;
    long x2 = x;

    var s = new int[m];
    for (long i = 0; ; i++) {
      if (i < m) {
        for (int j = (int)(i - 1); j >= 0; j--) {
          if (s[j] == x2) {
            long answer2 = 0;
            for (int k = j; k < (int)i; k++) {
              answer2 += s[k];
            }
            answer += (n - i) / (i - j) * answer2;
            i += (n - i) / (i - j) * (i - j);
            break;
          }
        }
      }
      if (i >= n) break;
      answer += x2;
      if (i < m) s[(int)i] = (int)x2;
      x2 = x2 * x2 % m;
    }

    System.out.println(answer);
  }
}
