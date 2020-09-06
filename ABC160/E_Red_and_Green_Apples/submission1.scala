// 

object Main extends App {
  val sc = new java.util.Scanner(System.in);
  val x, y, a, b, c = sc.nextInt();
  val ps = Array.fill(a)(-sc.nextInt());
  val qs = Array.fill(b)(-sc.nextInt());
  val rs = Array.fill(c)(-sc.nextInt());

  val answer = -(
    ps.sorted.take(x) ++
    qs.sorted.take(y) ++
    rs.sorted).sorted.take(x + y).map(_.toLong).sum;

  println(answer);
}
