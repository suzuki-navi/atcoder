import java.util.Scanner;

object Main extends App {
  val sc = new Scanner(System.in);

  val count500 = sc.nextInt();
  val count100 = sc.nextInt();
  val count50 = sc.nextInt();
  val total = sc.nextInt();

  val answer = (0 to count500).flatMap { a =>
    (0 to count100).filter { b =>
      val c = (total - (500 * a + 100 * b)) / 50;
      c >= 0 && c <= count50;
    }
  }.size;
  println(answer);
}
