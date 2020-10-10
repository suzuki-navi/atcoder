// AC

object Main extends App {
  val m = 1_000_000_007;

  def pow(a: Int, b: Int): Int = {
    @scala.annotation.tailrec
    def sub(a: Long, b: Int, result: Long): Int = {
      if (b == 0) {
        result.toInt;
      } else {
        val result2 = if (b % 2 == 1) result * a % m else result;
        sub(a * a % m, b / 2, result2);
      }
    }
    sub(a, b, 1);
  }

  val sc = new java.util.Scanner(System.in);
  val n = sc.nextInt();

  val answer = (2L * m + pow(10, n) - 2L * pow(9, n) + pow(8, n)) % m;
  println(answer);
}
