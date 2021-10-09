// AC

object Main extends App {
  val sc = new java.util.Scanner(System.in);
  val n = sc.nextLong();
  val set = n.toString.map {ch: Char => (ch - '0') % 3};
  val count1 = set.count(_ == 1);
  val count2 = set.count(_ == 2);
  val sum = set.sum % 3;
  sum match {
    case 0 =>
      println(0);
    case 1 =>
      if (count1 >= 1 && set.size > 1) {
        println(1);
      } else if (count2 >= 2 && set.size > 2) {
        println(2);
      } else {
        println(-1);
      }
    case 2 =>
      if (count2 >= 1 && set.size > 1) {
        println(1);
      } else if (count1 >= 2 && set.size > 2) {
        println(2);
      } else {
        println(-1);
      }
  }
}
