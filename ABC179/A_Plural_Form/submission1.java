// AC

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    var sc = new Scanner(System.in);
    var s = sc.next();
    if (s.endsWith("s")) {
      System.out.println(s + "es");
    } else {
      System.out.println(s + "s");
    }
  }
}
