// AC

object Main extends App {
  val sc = new java.util.Scanner(System.in);
  val n = sc.nextInt();
  val abs = Array.fill(n)((sc.nextInt(), sc.nextInt()));
  val sum = abs.map { case (a, b) =>
    (b.toLong * (b + 1) - a.toLong * (a - 1)) / 2;
  }.sum;
  println(sum);
}
