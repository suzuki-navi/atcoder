object Main extends App {
  def pow(a: Int, b: Int, m: Int): Int = {
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

  def inverse_fermat(a: Int, m: Int): Int = {
    // mが素数が条件
    pow(a, m - 2, m);
  }

  def inverse_euclid(a: Int, m: Int): Int = {
    var c: Int = a;
    var b: Int = m;
    var u: Int = 1;
    var v: Int = 0;
    while (b != 0) {
      val t = c / b;
      var tmp: Int = 0;
      c -= t * b; tmp = c; c = b; b = tmp;
      u -= t * v; tmp = u; u = v; v = tmp;
    }
    u %= m;
    if (u < 0) u += m;
    u;
  }

  case class InverseTable(max: Int, m: Int) {
    private val table = (2 to max).foldLeft(IndexedSeq(0, 1)) { (table, i) =>
      table :+ (m - table(m % i).toLong * (m / i) % m).toInt;
    }
    def apply(a: Int): Int = table(a);
  }

  val m = 1000000007;
  println(pow(2, 10, m));
  println(pow(2, 20, m));
  println(pow(2, 29, m));
  println(pow(2, 30, m));

  println(inverse_euclid(2, 7));
  println(inverse_euclid(3, 7));

  val table = InverseTable(6, 7);
  println(table(2));
  println(table(3));
}
