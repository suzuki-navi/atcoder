object Main extends App {
  val sc = new java.util.Scanner(System.in);
  val n, m, t = sc.nextInt();

  var n1: Int = n;
  var t1: Int = 0;
  var result: Boolean = true;
  (0 until m).foreach { _ =>
    val a, b = sc.nextInt();
    n1 = n1 - (a - t1);
    if (n1 <= 0) {
      result = false;
    }
    n1 = n1 + (b - a);
    if (n1 > n) {
      n1 = n;
    }
    t1 = b;
  }
  n1 = n1 - (t - t1);
  if (n1 <= 0) {
    result = false;
  }
  if (result) {
    System.out.println("Yes");
  } else {
    System.out.println("No");
  }
}
