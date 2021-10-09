// AC

object Main extends App {
  val sc = new java.util.Scanner(System.in);
  val n = sc.nextInt();
  val as = Array.fill(n)(sc.nextInt());
  val max = as.max;
  var gcd: Int = 0;
  var answer: Int = 0;
  (2 to max).foreach { i =>
    val c = as.count(_ % i == 0);
    if (c > gcd) {
      gcd = c;
      answer = i;
    }
  }
  println(answer);
}
