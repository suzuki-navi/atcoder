// 

object Main extends App {

  val bitCount = 20;
  val maxStatus = 1 << bitCount;

  def statusToString(status: Int): String = {
    (0 until bitCount).map { i =>
      if ((status & (1 << i)) != 0) {
        "o";
      } else {
        ".";
      }
    }.mkString("");
  }

  def integerBitCount(_i: Int): Int = {
    var i: Int = _i;
    i = i - ((i >>> 1) & 0x55555555);
    i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
    i = (i + (i >>> 4)) & 0x0f0f0f0f;
    i = i + (i >>> 8);
    i = i + (i >>> 16);
    i & 0x3f;
  }

  def integerBitReverse(_i: Int): Int = {
    var v: Int = _i << 1;
    v = (v & 0x55555555) <<  1 | (v >>  1 & 0x55555555);
    v = (v & 0x33333333) <<  2 | (v >>  2 & 0x33333333);
    v = (v & 0x0f0f0f0f) <<  4 | (v >>  4 & 0x0f0f0f0f);
    v = (v & 0x00ff00ff) <<  8 | (v >>  8 & 0x00ff00ff);
    v = (v & 0x0000ffff) << 16 | (v >> 16 & 0x0000ffff);
    return v;
  }
  val reversed = (0 until maxStatus).map { status =>
    (status, integerBitReverse(status));
  }.sortBy(_._2).map(_._1);

  val cache = Array.fill(maxStatus)(false);

  // S: true
  // F: false

  (0 until maxStatus).foreach { status =>
    var existsSecond: Boolean = false;
    (0 until bitCount).foreach { i =>
      if ((status & (1 << i)) != 0) {
        val status2 = status - (1 << i);
        //println("%s -> %s".format(statusToString(status), statusToString(status2)));
        existsSecond |= cache(status2);
        (0 until i).foreach { j =>
          val status3 = if ((status2 & (1 << j)) == 0) {
            status2 + (1 << j);
          } else {
            status2 - (1 << j);
          }
          //println("%s -> %s".format(statusToString(status), statusToString(status3)));
          existsSecond |= cache(status3);
        }
      }
    }
    val answer = !existsSecond;
    cache(status) = answer;
    //if (answer) {
    //  println("%4x %s".format(status, statusToString(status)));
    //}
    //val str = if (answer) "S" else "F";
    //println("%s: %s".format(str, statusToString(status)));
  }

  (0 until maxStatus).foreach { status =>
    if (cache(status)) {
      println("%5x %s".format(status, statusToString(status)));
    }
  }

/*
  (0 until maxStatus).foreach { status =>
    val answer = cache(status);
    val str = if (answer) "S" else "F";
    val xorValue = (0 until bitCount).foldLeft(0) { (a, b) =>
      if ((status & (1 << b)) != 0) {
        a ^ (b + 1);
      } else {
        a;
      }
    }
    println("%s %5x %5x %s".format(str, xorValue, status, statusToString(status)));
  }
*/

}
