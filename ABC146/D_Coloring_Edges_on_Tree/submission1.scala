// AC

object Main extends App {

  val sc = new java.util.Scanner(System.in);
  val n = sc.nextInt();
  val ab = Array.fill(n - 1)((sc.nextInt() - 1, sc.nextInt() - 1));

  val nodes = Array.fill[List[Int]](n)(Nil);

  ab.foreach { case (a, b) =>
    nodes(a) = b :: nodes(a);
    nodes(b) = a :: nodes(b);
  }

  val colorCount = nodes.map(_.size).max;

  val flag = Array.fill[Boolean](n)(false);
  val parentColor = Array.fill[Int](n)(0);

  var que = List(0);
  var colors = scala.collection.mutable.Map.empty[(Int, Int), Int];

  while (!que.isEmpty) {
    val v = que.head;
    que = que.tail;
    flag(v) = true;
    var c = 1;
    nodes(v).foreach { u =>
      if (!flag(u)) {
        if (parentColor(v) == c) {
          c = c + 1;
        }
        colors((u, v)) = c;
        colors((v, u)) = c;
        parentColor(u) = c;
        que = u :: que;
        c = c + 1;
      }
    }
  }

  println(colorCount);
  ab.foreach { t =>
    println(colors(t));
  }

}
