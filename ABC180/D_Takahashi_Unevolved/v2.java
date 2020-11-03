// AC

import java.util.Scanner;

class Main {
  public static long lg(long a, long max) {
    return lg(a, max, 0);
  }
  public static long lg(long a, long max, long acc) {
    if (max <= 1) {
      return acc;
    }
    int n = 1;
    long s = a;
    while (true) {
      long s2 = s * s;
      if (s2 > max) break;
      s = s2;
      n <<= 1;
    }
    return lg(a, max / s, acc + n);
  }
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
    if (th >= y) th = y - 1;
    long na = lg(a, th / x);
    long x2 = x * pow(a, na);
    long nb = (y - x2 - 1) / b;

    long answer = na + nb;
    System.out.println(answer);
  }
}