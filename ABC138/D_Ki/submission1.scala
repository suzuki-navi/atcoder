// WA

object Main extends App {
  val sc = new java.util.Scanner(System.in);
  val n, q = sc.nextInt();
  val abs = Array.fill(n - 1)((sc.nextInt() - 1, sc.nextInt() - 1));
  val pxs = Array.fill(q)((sc.nextInt() - 1, sc.nextInt()));

  val arr = Array.fill(n)(0);
  pxs.foreach { case (p, x) =>
    arr(p) += x;
  }
  abs.sortBy(_._1).foreach { case (a, b) =>
    arr(b) += arr(a);
  }

  println(arr.mkString(" "));
}
