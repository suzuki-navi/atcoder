// AC

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    var sc = new Scanner(System.in);
    long n = sc.nextLong();
    int x = sc.nextInt();
    int m = sc.nextInt();

    long answer = 0;
    int x2 = x;
    long i = 0;

    var s = new int[m];
    var sb = new int[(m + 31) / 32];
    for (; ; i++) {
      if ((sb[x2 / 32] & (1 << (x2 % 32))) != 0) {
        int j = (int)i - 1;
        for (; j >= 0; j--) {
          if (s[j] == x2) {
            break;
          }
        }
        long answer2 = 0;
        for (int k = j; k < i; k++) {
          answer2 += s[k];
        }
        answer += (n - i) / (i - j) * answer2;
        i += (n - i) / (i - j) * (i - j);
        break;
      }
      if (i >= n) break;
      answer += x2;
      s[(int)i] = x2;
      sb[x2 / 32] |= 1 << (x2 % 32);
      x2 = (int)((long)x2 * x2 % m);
    }
    for (; ; i++) {
      if (i >= n) break;
      answer += x2;
      x2 = (int)((long)x2 * x2 % m);
    }

    System.out.println(answer);
  }
}
