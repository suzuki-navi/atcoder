object Main extends App {
  val sc = new java.util.Scanner(System.in);
  val n = sc.nextInt();
  val t = sc.next();

  val c = 10_000_000_000L;

  val answer = if (t == "1") {
    c * 2;
  } else if (t == "0") {
    c;
  } else if (t == "00") {
    0;
  } else if (t == "01") {
    c - 1;
  } else if (t == "10") {
    c;
  } else if (t == "11") {
    c;
  } else {
    val pre = t.substring(0, 3);
    val n3 = n / 3;
    val nm = n % 3;
    if ((1 until n3).exists(i => !t.startsWith(pre, i * 3))) {
      0;
    } else {
      val suf = t.substring(n3 * 3);
      if (!pre.startsWith(suf)) {
        0;
      } else {
        if (pre == "110") {
          if (nm == 0) {
            c - n3 + 1;
          } else {
            c - n3;
          }
        } else if (pre == "101") {
          c - n3;
        } else if (pre == "011") {
          if (nm <= 1) {
            c - n3;
          } else {
            c - n3 - 1;
          }
        } else {
          0;
        }
      }
    }
  }
  println(answer);
}
