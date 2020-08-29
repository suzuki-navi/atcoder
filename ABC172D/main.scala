import java.util.Scanner;

object Main extends App {

  val sc = new Scanner(System.in);

  val n = sc.nextInt();

  val answer = (1 to n).foldLeft(0L) { (sum, k) =>
    val m = n / k;
    sum + m.toLong * (m + 1) / 2 * k;
  }

  println(answer);
}

