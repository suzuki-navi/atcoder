
import java.util.Scanner;

object Main extends App {

  val sc = new Scanner(System.in);

  val n = sc.nextInt();
  val as = Array.fill(n)(sc.nextInt());

  val max = as.max;

  val ar = new Array[Boolean](max + 1);
  val at = new Array[Int](max + 1);

  (0 until n).foreach { i =>
    val a = as(i);
    (2 to (max / a)).foreach { j =>
      ar(j * a) = true;
    }
    at(a) = at(a) + 1;
  }

  val answer = (0 until n).count { i =>
    val a = as(i);
    !ar(a) && at(a) == 1;
  }

  println(answer);
}

