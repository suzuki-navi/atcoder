// AC

object Main extends App {
  val sc = new java.util.Scanner(System.in);
  val a, b, c, d = sc.nextLong();
  val answer = List(a * c, a * d, b * c, b * d).max;
  println(answer);
}
