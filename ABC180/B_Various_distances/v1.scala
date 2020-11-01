// AC

object Main extends App {
  val sc = new java.util.Scanner(System.in);
  val n = sc.nextInt();
  val xs = Array.fill(n)(sc.nextInt());
  val r1 = xs.map(x => (x max (-x)).toLong).sum;
  val r2 = Math.sqrt(xs.map(x => x.toLong * x).sum);
  val r3 = xs.map(x => (x max (-x)).toLong).max;
  println(r1);
  println(r2);
  println(r3);
}
