object Main extends App {
  val sc = new java.util.Scanner(System.in);
  val n, m = sc.nextInt();
  val as = Array.fill(m)(sc.nextInt());

  val as_sorted = as.sorted;

  val intervals = (0 to m).map { i =>
    if (m == 0) {
      n;
    } else if (i == m) {
      n - as_sorted(i-1);
    } else if (i == 0) {
      as_sorted(i) - 1;
    } else {
      as_sorted(i) - as_sorted(i-1) - 1;
    }
  }.filter(_ > 0);

  val answer = if (intervals.size == 0) {
    0;
  } else {
    val min = intervals.min;
    intervals.map { d =>
      (d-1) / min + 1;
    }.sum;
  }
  println(answer);
}
