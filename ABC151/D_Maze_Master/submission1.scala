// AC

object Main extends App {
  val sc = new java.util.Scanner(System.in);
  val h, w = sc.nextInt();
  sc.nextLine(); // 行末スキップ
  val matrix = Array.fill(h)(sc.nextLine().map(ch => if(ch=='#') -1 else 0).toArray);

  def resetMatrix(): Unit = {
    (0 until h).foreach { y =>
      (0 until w).foreach { x =>
        if (matrix(y)(x) > 0) {
          matrix(y)(x) = 0;
        }
      }
    }
  }

  def maxDistance(x: Int, y: Int): Int = {
    @scala.annotation.tailrec
    def sub1(que: List[(Int, Int)], distance: Int): Int = {
      if (que.isEmpty) {
        distance - 2;
      } else {
        val que2 = sub2(que, Nil, distance);
        sub1(que2, distance + 1);
      }
    }
    @scala.annotation.tailrec
    def sub2(que1: List[(Int, Int)], que2: List[(Int, Int)], distance: Int): List[(Int, Int)] = {
      que1 match {
        case Nil => que2;
        case head :: q =>
          val x = head._1;
          val y = head._2;
          val que3 = List((x-1, y), (x, y-1), (x+1, y), (x, y+1)).filter { case (x, y) =>
            if (x >= 0 && x < w && y >= 0 && y < h) {
              if (matrix(y)(x) == 0) {
                matrix(y)(x) = distance + 1;
                true;
              } else {
                false;
              }
            } else {
              false;
            }
          } ::: que2;
          sub2(q, que3, distance);
      }
    }
    matrix(y)(x) = 1;
    sub1(List((x, y)), 1);
  }

  val answer = (0 until h).map { y =>
    (0 until w).map { x =>
      if (matrix(y)(x) >= 0) {
        resetMatrix();
        maxDistance(x, y);
      } else {
        -1;
      }
    }.max;
  }.max;

  println(answer);
}
