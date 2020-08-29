import java.util.Scanner;

object Main extends App {

  val sc = new Scanner(System.in);

  val n = sc.nextInt();
  val k = sc.nextInt();
  val ls = Array.fill(n)(sc.nextInt());

  @scala.annotation.tailrec
  def search(answer1: Int, answer2: Int): Int = {
    val mid = (answer1 + answer2) / 2;
    val c = ls.map { l =>
      (l - 1) / mid;
    }.sum;
    if (answer1 + 1 >= answer2) {
      if (c > k) {
        answer2;
      } else {
        answer1;
      }
    } else {
      if (c > k) {
        search(mid, answer2);
      } else {
        search(answer1, mid);
      }
    }
  }

  val answer = search(1, ls.max);

  println(answer);
}

