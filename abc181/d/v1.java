// AC

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    var sc = new Scanner(System.in);
    var s = sc.next();
    int len = s.length();
    var table = new int[10];
    for (int i = 0; i < len; i++) {
      int c = (int)(s.charAt(i) - '0');
      table[c]++;
    }
    int is = 0;
    int ie = 125;
    if (len == 1) {
      ie = 2;
    } else if (len == 2) {
      is = 2;
      ie = 13;
    } else {
      is = 13;
      ie = 125;
    }
    for (int i = is; i < ie; i++) {
      String s2 = String.format("%d", 8 * i);
      int s2len = s2.length();
      var table2 = new int[10];
      for (int j = 0; j < s2len; j++) {
        int c = (int)(s2.charAt(j) - '0');
        table2[c]++;
      }
      boolean f = true;
      for (int j = 0; j < 10; j++) {
        if (table[j] < table2[j]) {
          f = false;
        }
      }
      if (f) {
        System.out.println("Yes");
        System.exit(0);
      }
    }
    System.out.println("No");
  }
}
