// AC

object Main extends App {
  val sc = new java.util.Scanner(System.in);
  val n = sc.nextInt();
  val s = sc.next();

  val answer = (1 to (n/2)).map(2 * _).map { m =>
    var k1 = (0 until m).count(i => s(i) == 'A');
    var k2 = (0 until m).count(i => s(i) == 'T');
    var k3 = (0 until m).count(i => s(i) == 'C');
    var k4 = (0 until m).count(i => s(i) == 'G');
    (0 to (n-m)).count { i =>
      if (i > 0) {
        s(i - 1) match {
          case 'A' => k1 -= 1;
          case 'T' => k2 -= 1;
          case 'C' => k3 -= 1;
          case 'G' => k4 -= 1;
          case _ => ;
        }
        s(i + m - 1) match {
          case 'A' => k1 += 1;
          case 'T' => k2 += 1;
          case 'C' => k3 += 1;
          case 'G' => k4 += 1;
          case _ => ;
        }
      }
      k1 == k2 && k3 == k4;
    }
  }.sum;

  println(answer);

}
