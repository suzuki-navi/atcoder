
// TLEになってしまう

import java.util.Scanner;

object Main extends App {

  val sc = new Scanner(System.in);

  val n = sc.nextInt();
  val as = Array.fill(n)(sc.nextInt());
  val as1 = as.sorted;
  val as2 = new Array[Int](n);

  @scala.annotation.tailrec
  def sub(as1: Array[Int], as1len: Int, count: Int, buf: Array[Int]): Int = {
    if (as1len == 0) {
      count;
    } else if (as1len == 1) {
      count + 1;
    } else {
      val h = as1(0);
      val p = as1.indexWhere(_ > h, 1);
      if (p < 0) {
        count;
      } else {
        var i2: Int = 0;
        (p until as1len).foreach { i1 =>
          val a = as1(i1);
          if (a % h != 0) {
            buf(i2) = a;
            i2 = i2 + 1;
          }
        }
        if (p > 1) {
          sub(buf, i2, count, as1);
        } else {
          sub(buf, i2, count + 1, as1);
        }
      }
    }
  }

  println(sub(as1, n, 0, as2));
}

