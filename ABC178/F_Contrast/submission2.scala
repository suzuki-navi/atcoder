// RE, WA, TLE

object Main extends App {
  val sc = new java.util.Scanner(System.in);
  val n = sc.nextInt();
  val as = IndexedSeq.fill(n)(sc.nextInt);
  val bs = IndexedSeq.fill(n)(sc.nextInt);

  val asx = new Array[Int](n + 1);
  val bsx = new Array[Int](n + 1);
  {
    var asv: Int = 0;
    var bsv: Int = 0;
    (0 to n).foreach { i =>
      while (i == n && asv <= n || i < n && as(i) > asv) {
        asv = asv + 1;
        asx(asv - 1) = i;
      }
      while (i == n && bsv <= n || i < n && bs(i) > bsv) {
        bsv = bsv + 1;
        bsx(bsv - 1) = i;
      }
    }
  }

  val asc = (0 until n).map(i => asx(i + 1) - asx(i)).toArray;
  val bsc = (0 until n).map(i => bsx(i + 1) - bsx(i)).toArray;

  if ((0 until n).exists(i => asc(i) + bsc(i) > n)) {
    println("No");
  } else {
    println("Yes");
    val answer = Array.fill(n)(0);
    val asc_sorted = asc.zipWithIndex.sortBy(  _._2).sortBy(- _._1);
    val bsc_sorted = bsc.zipWithIndex.sortBy(- _._2).sortBy(- _._1);
    var iai: Int = 0;
    var iaj: Int = 0;
    var ib1i: Int = 0;
    var ib2i: Int = 0;
    var ib2j: Int = 0;
    while (iai < n) {
      if (bsc_sorted(ib2i)._2 == asc_sorted(iai)._2) {
        ib2i = ib2i + 1;
      } else if (iaj == asc_sorted(iai)._1) {
        iai = iai + 1;
        iaj = 0;
      } else if (ib2j == bsc_sorted(ib2i)._1) {
        bsc(bsc_sorted(ib2j)._1) = 0;
        if (bsc(bsc_sorted(ib1i)._2) > 0) {
          ib2i = ib1i;
        } else {
          ib2i = ib2i + 1;
        }
        ib2j = 0;
      } else {
        val idx = asx(asc_sorted(iai)._2);
        val value = bsc_sorted(ib2i)._2 + 1;
        println("DEBUG " + idx + " " + iaj);
        answer(idx + iaj) = value;
        iaj = iaj + 1;
        ib2j = ib2j + 1;
      }

    }
    
    println(answer.mkString(" "));
  }
}
