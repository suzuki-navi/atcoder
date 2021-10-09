// AC

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    var sc = new Scanner(System.in);
    int h = sc.nextInt();
    int w = sc.nextInt();
    int n = sc.nextInt();
    int m = sc.nextInt();
    int hw = h * w;
    var table = new int[hw];
    var as = new int[n];
    var bs = new int[n];
    for (int i = 0; i < n; i++) { // 電球
      int a = sc.nextInt()-1;
      int b = sc.nextInt()-1;
      as[i] = a;
      bs[i] = b;
    }
    for (int i = 0; i < m; i++) { // ブロック
      int c = sc.nextInt()-1;
      int d = sc.nextInt()-1;
      table[w*c+d] = 8;
    }
    for (int i = 0; i < n; i++) {
      int a = as[i];
      int b = bs[i];
      int g = w*a+b;
      if ((table[g] & 0x1) == 0) {
        int k = g;
        for (int b2 = b-1; b2 >= 0; b2--) {
          k--;
          if (table[k] == 8) break;
          table[k] |= 0x1;
        }
        k = g;
        for (int b2 = b+1; b2 < w; b2++) {
          k++;
          if (table[k] == 8) break;
          table[k] |= 0x1;
        }
      }
      if ((table[g] & 0x2) == 0) {
        int k = g;
        for (int a2 = a-1; a2 >= 0; a2--) {
          k-=w;
          if (table[k] == 8) break;
          table[k] |= 0x2;
        }
        k = g;
        for (int a2 = a+1; a2 < h; a2++) {
          k+=w;
          if (table[k] == 8) break;
          table[k] |= 0x2;
        }
      }
      table[g] |= 0x3;
    }
    int answer = 0;
    for (int i = 0; i < hw; i++) {
      if ((table[i] & 0x3) != 0) answer++;
    }
    System.out.println(answer);
  }
}
