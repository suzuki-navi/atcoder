// AC

object Main extends App {
  val sc = new java.util.Scanner(System.in);
  val n, q = sc.nextInt();
  val abs = Array.fill(n - 1)((sc.nextInt() - 1, sc.nextInt() - 1));
  val pxs = Array.fill(q)((sc.nextInt() - 1, sc.nextInt()));

  val abs2 = Array.fill[List[Int]](n)(Nil);
  abs.foreach { case (a, b) =>
    abs2(a) = b :: abs2(a);
    abs2(b) = a :: abs2(b);
  }

  val answer = Array.fill(n)(0);
  pxs.foreach { case (p, x) =>
    answer(p) += x;
  }
  @scala.annotation.tailrec
  def sub(stack: List[(Int, List[Int])]): Unit = {
    stack match {
      case Nil => ;
      case (_, Nil) :: stack2 => sub(stack2);
      case (parent, h :: tail) :: stack2 =>
        val cs = abs2(h).filter(_ != parent);
        if (!cs.isEmpty) {
          cs.foreach { c =>
            answer(c) += answer(h);
          }
          sub((h, cs) :: (parent, tail) :: stack2);
        } else if (!tail.isEmpty) {
          sub((parent, tail) :: stack2);
        } else {
          sub(stack2);
        }
    }
  }
  sub((-1, List(0)) :: Nil);

  println(answer.mkString(" "));
}
