// AC

object Main extends App {
  val sc = new java.util.Scanner(System.in);
  val n, k = sc.nextInt();
  val ps = Array.fill(n)(sc.nextInt());
  val answer = ps.sorted.take(k).sum;
  println(answer);
}
