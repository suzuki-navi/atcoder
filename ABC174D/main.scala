import java.util.Scanner;

object Main extends App {

  val sc = new Scanner(System.in);

  val len = sc.nextInt();
  val str = sc.next();
  val str2 = str.toArray;

  @scala.annotation.tailrec
  def sub(answer: Int, wi: Int, ri: Int): Int = {
    val wi2 = str2.indexOf('W', wi);
    val ri2 = str2.lastIndexOf('R', ri);
    if (ri2 < 0) {
      answer;
    } else if (wi2 < 0) {
      answer;
    } else if (wi2 > ri2) {
      answer;
    } else {
      str2(wi2) = 'R';
      str2(ri2) = 'W';
      sub(answer + 1, wi2 + 1, ri2 - 1);
    }
  }

  val answer = sub(0, 0, len - 1);
  println(answer);
}

