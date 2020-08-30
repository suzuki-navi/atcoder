// AC

import java.util.Scanner;

object Main extends App {

  def sub(a: Int, b: Int, mx: Int): Int = {
    (1 to 6).map { n =>
      sub2(a, b, mx, n);
    }.sum;
  }

  def sub2(a: Int, b: Int, mx: Int, n: Int): Int = {
    if (n == 1) {
      if (a == b) {
        if (a <= mx) {
          1;
        } else {
          0;
        }
      } else {
        0;
      }
    } else if (n == 2) {
      if (a * 10 + b <= mx) {
        1;
      } else {
        0;
      }
    } else {
      val t1 = (1 until (n-1)).foldLeft(1)((s1, s2) => s1 * 10);
      if (t1 * 10 * (a + 1) <= mx) {
        t1;
      } else {
        val c = (mx / t1 - a * 10) min 9;
        (0 to c).map { i =>
          sub2(a * 10 + i, b, mx, n - 1);
        }.sum;
      }
    }
  }

  val sc = new Scanner(System.in);
  val mx = sc.nextInt();

  val count1 = (1 to 9).map { i =>
    ((i+1) to 9).map { j =>
      sub(i, j, mx) * sub(j, i, mx);
    }.sum;
  }.sum;
  val count2 = (1 to 9).map { i =>
    val s = sub(i, i, mx);
    s * s;
  }.sum;
  val answer = count1 * 2 + count2;
  println(answer);
}
