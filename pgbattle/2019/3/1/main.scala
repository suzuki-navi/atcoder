object Main extends App {
  val sc = new java.util.Scanner(System.in);
  val n = sc.nextInt();
  val as = Array.fill(2 * n)(sc.nextInt()).sorted;
  val result = (0 until n).map { i =>
    as(i + n) - as(i);
  }.min;
  println(result);
}
