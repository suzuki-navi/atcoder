// TLE

import java.util.Scanner;

object Main extends App {
  val sc = new Scanner(System.in);

  val n, m = sc.nextInt();

  val ps = List.fill(n)(sc.nextInt() - 1);

  val xy = List.fill(m)((sc.nextInt() - 1, sc.nextInt() - 1));

  val root = (0 until n).toArray;

  def fetchRoot(i: Int): Int = {
    val r = root(i);
    if (r == i) {
      r;
    } else {
      val r2 = fetchRoot(r);
      root(i) = r2;
      r2;
    }
  }

  xy.foreach { case (x, y) =>
    val rx = fetchRoot(x);
    val ry = fetchRoot(y);
    if (rx != ry) {
      root(ry) = rx;
    }
  }

  val answer = (0 until n).count { i =>
    val p = ps(i);
    val rp = fetchRoot(p);
    val ri = fetchRoot(i);
    ri == rp;
  }

  println(answer);
}
