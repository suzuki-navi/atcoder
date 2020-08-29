import java.util.Scanner;

object Main extends App {

  val tokens = List("dream", "dreamer", "erase", "eraser");

  //@scala.annotation.tailrec
  def isDreamer(str: String, offs: List[Int]): Boolean = {
    offs match {
      case Nil => false;
      case off :: _ if (off == str.length) => true;
      case off :: offs2 =>
        val offs3 = tokens.foldLeft(offs2) { (offs, t) =>
          if (str.startsWith(t, off)) {
            (off + t.length) :: offs;
          } else {
            offs;
          }
        }.toSet.toList.sorted;
        isDreamer(str, offs3);
    }
  }

  val sc = new Scanner(System.in);

  val str = sc.next();

  if (isDreamer(str, List(0))) {
    println("YES");
  } else {
    println("NO");
  }
}

