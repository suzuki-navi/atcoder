// AC

object Main extends App {
  val sc = new java.util.Scanner(System.in);
  val n = sc.nextInt();

  val answer = (1 to (n-1)).map(i => (n-1) / i).sum;
  println(answer);
}
