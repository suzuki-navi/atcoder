// RE

object Main extends App {
  val sc = new java.util.Scanner(System.in);
  val n = sc.nextInt();
  val as = Array.fill(n)(sc.nextInt);
  val bs = Array.fill(n)(sc.nextInt);

  val as_map = as.groupBy(x => x).map { case (k, v) => (k, v.size) }
  val bs_map = bs.groupBy(x => x).map { case (k, v) => (k, v.size) }

  val as_keys = as_map.keys.toArray.sorted;
  val bs_keys = bs_map.keys.toArray.sorted;
  val alen = as_keys.size;
  val blen = bs_keys.size;

  @scala.annotation.tailrec
  def sub(ia: Int, ib: Int): Boolean = {
    if (ia >= alen || ib >= blen) {
      true;
    } else {
      val a = as_keys(ia);
      val b = bs_keys(ib);
      if (a < b) {
        sub(ia + 1, ib);
      } else if (a > b) {
        sub(ia, ib + 1);
      } else {
        if (as_map(a) + bs_map(b) > n) {
          false;
	} else {
	  sub(ia + 1, ib + 1);
	}
      }
    }
  }
  val flag = sub(0, 0);
  println(if(flag) "Yes" else "No");
  if (flag) {
    val as_map2 = (0 until n).foldLeft[Map[Int, List[Int]]](Map.empty) { (map, i) =>
      val k = as(i);
      val v = i;
      map.concat(List(k -> (v :: map.getOrElse(k, Nil))));
    }

    val b2 = bs_keys.sortBy(k => - (as_map(k) + bs_map(k)));

  val answer = Array.fill(n)(0);
  (0 until bs_keys.size).foreach { i =>
    val k = b2(i);
    val b_count = bs_map(k);
    var count: Int = 0;
    var j: Int = i + 1;
    if (j == bs_keys.size) {
      j = 0;
    }
    while (count < b_count) {
      val k2 = b2(j);
      as_map2(k2).foreach { idx =>
        if (count < b_count && answer(idx) == 0) {
          answer(idx) = k;
   	  count = count + 1;
	}
      }
      j = j + 1;
      if (j == bs_keys.size) {
        j = 0;
      }
    }
  }

  println(answer.mkString(" "));
  }
}
