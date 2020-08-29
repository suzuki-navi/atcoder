// AC

import java.util.Scanner;

object Main extends App {
  val sc = new Scanner(System.in);
  val s, t = sc.next();

  val answer = (0 to (s.length - t.length)).map { d =>
    t.length - (0 until t.length).count { i =>
      s(i + d) == t(i)
    }
  }.min;

  println(answer);
}
