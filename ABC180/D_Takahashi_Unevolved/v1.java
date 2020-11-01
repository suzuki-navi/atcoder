// WA

import java.util.Scanner;

class Main {
  public static long pow(long a, long n) {
    long s = 1;
    while (n > 0) {
      if ((n & 1) != 0) s = s * a;
      a = a * a;
      n >>= 1;
    }
    return s;
  }
  public static void main(String[] args) {
    var sc = new Scanner(System.in);
    long x = sc.nextLong();
    long y = sc.nextLong();
    long a = sc.nextLong();
    long b = sc.nextLong();

    long th = b / (a - 1);
    long na = (long)(Math.log((double)th / x) / Math.log((double)a));
    long x2 = x * pow(a, na);
    long nb = (y - x2 - 1) / b;

    long answer = na + nb;
    System.out.println(answer);
  }
}
