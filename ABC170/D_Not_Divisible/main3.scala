
// TLEになってしまう

import java.util.Scanner;

object Main extends App {

  val sc = new Scanner(System.in);

  val n = sc.nextInt();
  val as = Array.fill(n)(sc.nextInt());
  val ab = Array.fill(n)(false);

  var i1: Int = 0;

  while (i1 < n) {
    var i2: Int = i1 + 1;
    while (i2 < n)pp {
      if (as(i1) % as(i2) == 0) {
        ab(i1) = true;
      }
      if (as(i2) % as(i1) == 0) {
        ab(i2) = true;
      }
      i2 = i2 + 1;
    }
    i1 = i1 + 1;
  }

  val answer = n - ab.count(f => f);
  println(answer);

}

