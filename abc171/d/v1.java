// AC

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    var sc = new Scanner(System.in);
    int n = sc.nextInt();
    var as = new int[n];
    for (int i = 0; i < n; i++) as[i] = sc.nextInt();
    int q = sc.nextInt();
    var bs = new int[q];
    var cs = new int[q];
    for (int i = 0; i < q; i++) {
      bs[i] = sc.nextInt();
      cs[i] = sc.nextInt();
    }

    var map = new java.util.HashMap<Integer, Integer>();
    long sum = 0;
    for (int i = 0; i < n; i++) {
      int a = as[i];
      sum += a;
      int count = map.getOrDefault(a, 0);
      map.put(a, count + 1);
    }
    for (int i = 0; i < q; i++) {
      int b = bs[i];
      int c = cs[i];
      int count = map.getOrDefault(b, 0);
      if (count > 0) {
        int count2 = map.getOrDefault(c, 0);
        map.put(b, 0);
        map.put(c, count + count2);
        sum += count * (c - b);
      }
      System.out.println(sum);
    }
  }
}
