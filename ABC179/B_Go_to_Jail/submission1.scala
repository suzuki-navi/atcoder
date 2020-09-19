// AC

object Main extends App {
  val sc = new java.util.Scanner(System.in);
  val n = sc.nextInt();
  val ds = Array.fill(n)((sc.nextInt(), sc.nextInt()));
  val ds2 = ds.map { case (a, b) => a == b }
  var c1: Int = 0;
  var c2: Int = 0;
  (0 until n).foreach { i =>
    if (ds2(i)) {
      c2 += 1;
      if (c1 < c2) {
        c1 = c2;
      }
    } else {
      c2 = 0;
    }
  }
  println(if (c1 >= 3) "Yes" else "No");
}
