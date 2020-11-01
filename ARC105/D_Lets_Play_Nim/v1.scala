// AC

object Main extends App {
  def solve(as: Array[Int]): Boolean = {
    if (as.size % 2 != 0) {
      false;
    } else {
      val s = as.foldLeft(Set.empty[Int]) { (s, a) => if (s.contains(a)) s - a else s + a }
      !s.isEmpty;
    }
  }
  val sc = new java.util.Scanner(System.in);
  val t = sc.nextInt();
  (0 until t).foreach { _ =>
    val n = sc.nextInt();
    val as = Array.fill(n)(sc.nextInt());
    if (solve(as)) {
      println("First");
    } else {
      println("Second");
    }
  }
}
