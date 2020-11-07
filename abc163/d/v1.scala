// AC

object Main extends App {
  val m = 1_000_000_007;
  val sc = new java.util.Scanner(System.in);
  val n, k = sc.nextLong();
  val z = (n+1) * (n+2) / 2;
  val answer = (k to (n+1)).map { i =>
    val s = i * (i+1) / 2 % m;
    val e = (z - (n+1-i) * (n+2-i) / 2) % m;
    (m + e - s + 1) % m;
  }.sum % m;
  println(answer);
}
