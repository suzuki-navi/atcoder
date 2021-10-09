// AC

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    var sc = new Scanner(System.in);
    int n = sc.nextInt();
    int w = sc.nextInt();
    var list = new int[2 * n][2];
    for (int i = 0; i < n; i++) {
      int s = sc.nextInt();
      int t = sc.nextInt();
      int p = sc.nextInt();
      list[2 * i][0] = s;
      list[2 * i][1] = p;
      list[2 * i + 1][0] = t;
      list[2 * i + 1][1] = -p;
    }
    java.util.Arrays.sort(list, java.util.Comparator.comparingInt(x -> x[0]));
    long max = 0;
    long curr = 0;
    int prevTime = 0;
    int n2 = 2 * n;
    for (int i = 0; i < n2; i++) {
      int time = list[i][0];
      int delta = list[i][1];
      if (time != prevTime) {
        if (curr > max) max = curr;
        prevTime = time;
      }
      curr += delta;
    }
    if (curr > max) max = curr;
    if (max > w) {
      System.out.println("No");
    } else {
      System.out.println("Yes");
    }
  }
}
