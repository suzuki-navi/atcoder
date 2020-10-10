// AC

class UnionFind[T] {

  private[this] var map = Map.empty[T, T];

  def addPair(parent: T, child: T): Unit = {
    val pr = fetchRoot(parent);
    val cr = fetchRoot(child);
    if (pr != cr) {
      map = map + (cr -> pr);
    }
  }

  def fetchRoot(elem: T): T = {
    @scala.annotation.tailrec
    def sub(elem: T, pendings: List[(T, T)]): T = {
      map.get(elem) match {
        case None =>
          pendings.foreach { case (c, p) =>
            if (p != elem) {
              map = map + (c -> elem);
            }
          }
          elem;
        case Some(p) =>
          sub(p, (elem, p) :: pendings);
      }
    }
    sub(elem, Nil);
  }

}

object Main extends App {
  val sc = new java.util.Scanner(System.in);
  val n, m = sc.nextInt();
  val ps = Array.fill(n)(sc.nextInt());
  val xys = Array.fill(m)((sc.nextInt(), sc.nextInt()));

  val unionFind = new UnionFind[Int];
  xys.foreach { case (x, y) =>
    unionFind.addPair(y, x);
  }

  val answer = ps.zipWithIndex.count { case (p, i) =>
    unionFind.fetchRoot(p) == unionFind.fetchRoot(i + 1);
  }
  println(answer);
}


