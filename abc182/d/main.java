// AC

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    var sc = new Scanner(System.in);
    int n = sc.nextInt();
    var as = new int[n];
    for (int i = 0; i < n; i++) {
      as[i] = sc.nextInt();
    }
    long pos = 0L;
    long sum = 0L;
    long max1 = 0L;
    long max2 = 0L;
    for (int i = 0; i < n; i++) {
      sum += as[i];
      if (sum > max1) max1 = sum;
      long p = pos + max1;
      pos += sum;
      if (p > max2) max2 = p;
    }
    System.out.println(max2);
  }
}
