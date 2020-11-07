// AC

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    var sc = new Scanner(System.in);
    int h = sc.nextInt();
    int w = sc.nextInt();
    int k = sc.nextInt();
    var ss = new boolean[h][w];
    for (int i = 0; i < h; i++) {
      var t = sc.next();
      for (int j = 0; j < w; j++) {
        if (t.charAt(j) == '#') ss[i][j] = true;
      }
    }
    int answer = 0;
    int h2 = 1 << h;
    int w2 = 1 << w;
    for (int i2 = 0; i2 < h2; i2++) {
      for (int j2 = 0; j2 < w2; j2++) {
        int count = 0;
        for (int i = 0; i < h; i++) {
          if ((i2 & (1 << i)) != 0) continue;
          for (int j = 0; j < w; j++) {
            if ((j2 & (1 << j)) != 0) continue;
            if (ss[i][j]) count++;
          }
        }
        if (count == k) answer++;
      }
    }
    System.out.println(answer);
  }
}
