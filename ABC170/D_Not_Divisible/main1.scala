
// TLEになってしまう

import java.util.Scanner;

object Main extends App {

  val sc = new Scanner(System.in);

  val n = sc.nextInt();
  val as = List.fill(n)(sc.nextInt());

  @scala.annotation.tailrec
  def sub(as1: List[Int], as2: List[Int]): List[Int] = {
    as1 match {
      case Nil => as2;
      case h :: t =>
        val p = t.indexWhere(_ > h);
        if (p == 0) {
          val as1_1 = t.filter(_ % h != 0);
          sub(as1_1, h :: as2);
        } else if (p > 0) {
          val as1_1 = t.drop(p).filter(_ % h != 0);
          sub(as1_1, as2);
        } else {
          if (t.isEmpty) {
            h :: as2;
          } else {
            as2;
          }
        }
    }
  }

  println(sub(as.sorted, Nil).size);
}

