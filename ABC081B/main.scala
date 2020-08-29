import java.util.Scanner;

object Main extends App {
  val sc = new Scanner(System.in);

  val count = sc.nextInt();
  var data = (0 until count).map { _ => sc.nextLong() }
  (0 until 34).foreach { i =>
    if (data.exists(_ % 2 == 1)) {
      println(i);
      System.exit(0);
    }
    data = data.map(_ / 2);
  }
}
