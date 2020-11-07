// AC

object Main extends App {
  val sc = new java.util.Scanner(System.in);
  val n, m = sc.nextInt();
  val as = IndexedSeq.fill(m)(sc.nextInt());
  val answer = n - as.sum;
  if (answer < 0) {
    println(-1);
  } else {
    println(answer);
  }
}
