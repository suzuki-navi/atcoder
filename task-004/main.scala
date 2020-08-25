import java.util.Scanner;

object Main extends App {
  val sc = new Scanner(System.in);

  val count = sc.nextInt();
  val answer = (0 until count).map(_ => sc.nextInt()).toSet.size;
  println(answer);
}
