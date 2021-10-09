object Main extends App {
  val sc = new java.util.Scanner(System.in);
  val n = sc.nextInt();
  val t = sc.next();

  val c = 10_000_000_000L;

  val answer = if (t == "1") {
    c * 2;
  } else if (t == "11") {
    c;
  } else {
    if (("110" * (n / 3 + 3)).indexOf(t) < 0) {
      0;
    } else {
      def count(str: String, pattern: String): Int = {
        @scala.annotation.tailrec
        def sub(offset: Int, result: Int): Int = {
          val p = str.indexOf(pattern, offset);
          if (p < 0) result else sub(p + 1, result + 1);
        }
        sub(0, 0);
      }
      if (t.endsWith("0")) {
        c - count(t, "0") + 1;
      } else {
        c - count(t, "0");
      }
    }
  }
  println(answer);
}

