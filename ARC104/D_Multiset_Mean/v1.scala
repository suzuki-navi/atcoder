// TLE

object Main extends App {
  val sc = new java.util.Scanner(System.in);
  val n, k, m = sc.nextInt();

  val table = (0 until n).map(i => Array.fill(i * (i+1) * k / 2 + 2)(0));
  table(0)(0) = 1;
  (1 until n).foreach { i =>
    val j_max = i * (i+1) * k / 2;
    val t1 = table(i - 1);
    val t2 = table(i);
    (0 to j_max).foreach { j =>
      val a1 = (((j - (i - 1) * i * k / 2) + i - 1) / i) max 0;
      val a2 = (j / i) min k;
      val s = (a1 to a2).map { a =>
        t1(j - a * i).toLong;
      }.sum % m;
      t2(j) = s.toInt;
    }
  }

  val table2 = Array.fill(n+1)(0);
  (1 to n).foreach { x =>
    if (x <= (n + 1) / 2) {
      val (n1, n2) = (x - 1, n - x);
      val s = (0 to (n1 * (n1+1) * k / 2)).map { i =>
        table(n1)(i).toLong * table(n2)(i) % m;
      }.sum % m;
      val answer = ((m.toLong + s * (k+1) - 1) % m).toInt;
      table2(x) = answer;
      println("%d".format(answer));
    } else {
      val answer = table2(n + 1 - x);
      println("%d".format(answer));
    }
  }
}
