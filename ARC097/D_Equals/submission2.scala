// 

// 1以上size以下の整数に特化したUnionFind
class UnionFindInt(size: Int) {

  private[this] val arr = new Array[Int](size + 1);

  def addPair(parent: Int, child: Int): Unit = {
    val pr = fetchRoot(parent);
    val cr = fetchRoot(child);
    if (pr != cr) {
      arr(cr) = pr;
    }
  }

  def fetchRoot(elem: Int): Int = {
    @scala.annotation.tailrec
    def sub(elem: Int, pendings: List[(Int, Int)]): Int = {
      val p = arr(elem);
      if (p == 0) {
        pendings.foreach { case (c, p) =>
          if (p != elem) {
            arr(c) = elem;
          }
        }
        elem;
      } else {
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

  val unionFind = new UnionFindInt(n);
  xys.foreach { case (x, y) =>
    unionFind.addPair(y, x);
  }

  val answer = ps.zipWithIndex.count { case (p, i) =>
    unionFind.fetchRoot(p) == unionFind.fetchRoot(i + 1);
  }
  println(answer);
}


