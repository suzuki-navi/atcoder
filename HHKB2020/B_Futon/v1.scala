// AC

object Main extends App {
  val sc = new java.util.Scanner(System.in);
  val h, w = sc.nextInt();
  val ss = IndexedSeq.fill(h)(sc.next());
  val answer = (0 until h).map { i =>
    (0 until (w-1)).count { j =>
      ss(i)(j) == '.' && ss(i)(j+1) == '.'
    }
  }.sum + (0 until (h-1)).map { i =>
    (0 until w).count { j =>
      ss(i)(j) == '.' && ss(i+1)(j) == '.'
    }
  }.sum;
  println(answer);
}
