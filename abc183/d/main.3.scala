// AC

object Main extends App {
  val sc = new java.util.Scanner(System.in);
  val n, w = sc.nextInt();
  val n2 = n * 2;
  val list = new Array[(Int, Int)](n2);
  {
    var i: Int = 0;
    while (i < n) {
      val s, t, p = sc.nextInt();
      list(2*i  ) = (s, p);
      list(2*i+1) = (t, -p);
      i += 1;
    }
  }
  val list2 = list.sortBy(_._1);
  var max: Long = 0;
  {
    var curr: Long = 0;
    var prevTime: Int = -1;
    var i: Int = 0;
    while (i < n2) {
      val (time, delta) = list2(i);
      if (time != prevTime) {
        if (curr > max) {
          max = curr;
        }
        prevTime = time;
      }
      curr += delta;
      i += 1;
    }
    if (curr > max) {
      max = curr;
    }
  }
  if (max > w) {
    println("No");
  } else {
    println("Yes");
  }
}
