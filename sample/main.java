// 

import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    var sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    var t1 = sc.next();
    var t2 = sc.next();
    var s2 = sc.next(); // これでは1行入力にはならない
    System.out.println(a + b + c);
    System.out.println(t1 + t2);
    System.out.println(s2);
  }
}
