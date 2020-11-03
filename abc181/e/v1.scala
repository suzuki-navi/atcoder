// AC

object Main extends App {
  val sc = new java.util.Scanner(System.in);
  val n, m = sc.nextInt();
  val size = n + m;
  val hs = IndexedSeq.fill(n)(sc.nextInt());
  val ws = IndexedSeq.fill(m)(sc.nextInt());
  val list: Array[(Int, Boolean)] = (hs.map(h => (h, true)) ++ ws.map(w => (w, false))).sortBy(_._1).toArray;
  val dis: Array[Int] = new Array[Int](size);
  val flags: Array[Boolean] = new Array[Boolean](size);
  var w_index: Int = -1;
  var minimumCost: Long = 0;
  var cost: Long = 0;
  {
    var f: Boolean = true;
    if (!list(0)._2) w_index = 0;
    (1 until size).foreach { i =>
      dis(i) = list(i)._1 - list(i-1)._1;
      flags(i) = f;
      if (f) cost += dis(i);
      if (list(i)._2) {
        f = !f;
      } else if (w_index < 0) {
        w_index = i;
        f = !f;
      }
    }
    minimumCost = cost;
  }
  while (w_index < size) {
    var w_index2 = w_index + 1;
    while (w_index2 < size && list(w_index2)._2) w_index2 += 1;
    if (w_index2 < size) {
      var i: Int = w_index + 1;
      while (i <= w_index2) {
        if (flags(i)) {
          flags(i) = false;
          cost -= dis(i);
        } else {
          flags(i) = true;
          cost += dis(i);
        }
        i += 1;
      }
      if (cost < minimumCost) minimumCost = cost;
    }
    w_index = w_index2;
  }
  println(minimumCost);
}
