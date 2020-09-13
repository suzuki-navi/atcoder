// AC

object Main extends App {
  val sc = new java.util.Scanner(System.in);
  val n = sc.nextInt();
  val xys = Array.fill(n)((sc.nextInt, sc.nextInt));
  val xys2 = xys.map { case (x, y) => (x + y, x - y) }
  val x_min = xys2.map(_._1).min;
  val x_max = xys2.map(_._1).max;
  val y_min = xys2.map(_._2).min;
  val y_max = xys2.map(_._2).max;
  val answer = (x_max - x_min) max (y_max - y_min);
  println(answer);
}
