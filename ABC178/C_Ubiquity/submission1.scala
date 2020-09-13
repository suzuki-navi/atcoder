// AC

object Main extends App {
  val m = 1000000007;
  def pow(a: Long, b: Int): Long = {
    var x: Long = 1;
    var a2: Long = a;
    var b2: Int = b;
    while (b2 > 0) {
      if ((b2 & 1) != 0) {
        x = x * a2 % m;
      }
      a2 = a2 * a2 % m;
      b2 = b2 >> 1;
    }
    x;
  }
  val sc = new java.util.Scanner(System.in);
  val n = sc.nextInt();
  val a1 = pow(10, n); // all
  val a2 = pow(8, n);  // 0も9も存在しない
  val a3 = (pow(9, n) + m - a2) % m;  // 0は存在するけど9は存在しない
  val answer = (a1 + 3L * m - 2L * a3 - a2) % m;
  println(answer);
}
