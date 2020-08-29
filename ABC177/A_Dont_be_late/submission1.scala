// AC

import java.util.Scanner;

object Main extends App {
  val sc = new Scanner(System.in);
  val d, t, s = sc.nextInt();

  if (d <= s * t) {
    println("Yes");
  } else {
    println("No");
  }
}
