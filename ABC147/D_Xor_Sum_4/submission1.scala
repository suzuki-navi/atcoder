// AC

object Main extends App {

  val m = 1000000007;

  val sc = new java.util.Scanner(System.in);
  val n = sc.nextInt();
  val as = Array.fill(n)(sc.nextLong());

  val answer = (0 until 60).map { bit =>
    val count = (0 until n).map { i =>
      ((as(i) >> bit) & 1).toInt;
    }.sum;
    val u = (1L << bit) % m;
    u * count % m * (n - count) % m;
  }.sum % m;

  println(answer);
}
