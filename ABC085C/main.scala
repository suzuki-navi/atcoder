import java.util.Scanner;

object Main extends App {

  def search10000(count: Int, total: Int): Option[(Int, Int, Int)] = {
    val minCount = ((total / 5000) - count) max 0;
    val maxCount = (total / 10000) min count;
    (minCount to maxCount).reverse.foldLeft[Option[(Int, Int, Int)]](None) { (r, c) =>
      r match {
        case Some(t) => r;
        case None => search5000(c, count - c, total - 10000 * c);
      }
    }
  }

  def search5000(c10000: Int, count: Int, total: Int): Option[(Int, Int, Int)] = {
    val minCount = (((total / 1000) - count) / 4) max 0;
    val maxCount = (total / 5000) min count;
    (minCount to maxCount).reverse.foldLeft[Option[(Int, Int, Int)]](None) { (r, c) =>
      r match {
        case Some(t) => r;
        case None => search1000(c10000, c, count - c, total - 5000 * c);
      }
    }
  }

  def search1000(c10000: Int, c5000: Int, count: Int, total: Int): Option[(Int, Int, Int)] = {
    if (count * 1000 == total) {
      Some((c10000, c5000, count));
    } else {
      None;
    }
  }

  val sc = new Scanner(System.in);

  val count = sc.nextInt();
  val total = sc.nextInt();

  val (c10000, c5000, c1000) = {
    search10000(count, total) match {
      case None => (-1, -1, -1);
      case Some(t) => t;
    }
  }

  println("%d %d %d".format(c10000, c5000, c1000));
}

