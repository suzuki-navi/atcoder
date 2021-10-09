// WA

object Main extends App {
  val sc = new java.util.Scanner(System.in);
  val n, w = sc.nextInt();
  val stps = Array.fill(n)((sc.nextInt(), sc.nextInt(), sc.nextInt()));
  val list = stps.zipWithIndex.flatMap { case (t, i) => Array((t._1, t._3), (t._2, -t._3)) }.sortBy(_._1);
  var max: Int = 0;
  var curr: Int = 0;
  var prevTime: Int = -1;
  list.foreach { case (time, delta) =>
    if (time != prevTime) {
      if (curr > max) {
        max = curr;
      }
      prevTime = time;
    }
    curr += delta;
  }
  if (curr > max) {
    max = curr;
  }
  if (max > w) {
    println("No");
  } else {
    println("Yes");
  }
}
