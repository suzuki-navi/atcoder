import java.util.Scanner;

object Main extends App {
  val sc = new Scanner(System.in);
  val a, b, c = sc.nextInt();
  val t1 = sc.next();
  val t2 = sc.next();
  val s2 = sc.next(); // これでは1行入力にはならない
  println(a + b + c);
  println(t1 + t2);
  println(s2);
}
