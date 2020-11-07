// AC

object Main extends App {
  val sc = new java.util.Scanner(System.in);
  val n = sc.nextInt();
  val as = IndexedSeq.fill(n-1)(sc.nextInt());
  val answer = new Array[Int](n);
  (0 until (n-1)).foreach { i =>
    val p = as(i) - 1;
    answer(p) += 1;
  }
  answer.foreach { c =>
    println(c);
  }
}
