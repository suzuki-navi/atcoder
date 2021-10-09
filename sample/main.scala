// 

object Main extends App {
  //def pow(a: Int, b: Int, m: Int): Int = {
  //  @scala.annotation.tailrec
  //  def sub(a: Long, b: Int, acc: Long): Int = {
  //    if (b == 0) {
  //      acc.toInt;
  //    } else {
  //      val acc2 = if (b % 2 == 1) acc * a % m else acc;
  //      sub(a * a % m, b / 2, acc2);
  //    }
  //  }
  //  sub(a, b, 1);
  //}

  //def inverse_fermat(a: Int, m: Int): Int = {
  //  // mが素数が条件
  //  pow(a, m - 2, m);
  //}

  //def inverse_euclid(a: Int, m: Int): Int = {
  //  var c: Int = a;
  //  var b: Int = m;
  //  var u: Int = 1;
  //  var v: Int = 0;
  //  while (b != 0) {
  //    val t = c / b;
  //    var tmp: Int = 0;
  //    c -= t * b; tmp = c; c = b; b = tmp;
  //    u -= t * v; tmp = u; u = v; v = tmp;
  //  }
  //  u %= m;
  //  if (u < 0) u += m;
  //  u;
  //}

  //case class InverseTable(max: Int, m: Int) {
  //  private val table = (2 to max).foldLeft(IndexedSeq(0, 1)) { (table, i) =>
  //    table :+ (m - table(m % i).toLong * (m / i) % m).toInt;
  //  }
  //  def apply(a: Int): Int = table(a);
  //}

  //case class FactorialTable(max: Int, m: Int) {
  //  // inv, fact, fact_inv
  //  private val table = (2 to max).foldLeft(IndexedSeq((0, 1, 1), (1, 1, 1))) { (table, i) =>
  //    val inv = m - (table(m % i)._1.toLong * (m / i) % m).toInt;
  //    table :+ (
  //      inv,
  //      (table(i - 1)._2.toLong * i % m).toInt,
  //      (table(i - 1)._3.toLong * inv % m).toInt,
  //    );
  //  }
  //  def fact(a: Int): Int = table(a)._2;
  //  def fact_inv(a: Int): Int = table(a)._3;
  //  def combination(n: Int, k: Int): Int = {
  //    (table(n)._2.toLong * table(k)._3 % m * table(n - k)._3 % m).toInt;
  //  }
  //}

  //val m = 1_000_000_007;

  val sc = new java.util.Scanner(System.in);
  //val a, b, c = sc.nextInt();
  //val t1, t2 = sc.next();
  //val s2 = sc.nextLine(); // 行末スキップ

  //val as = Array.fill(n)(sc.nextInt());
  //val ss = Array.fill(n)(sc.next());

  // samples of sort
  //val lst1 = List(30, 49, 28, 60);
  //val sorted = lst1.sorted;
  //val lst2 = List((1, 30), (2, 49), (3, 28), (4, 60));
  //val sorted = lst2.sortBy(_._2);
  //val lst3 = List((1, 30), (2, 49), (3, 28), (4, 60));
  //val sorted = lst3.sortWith((a, b) => a._2 < b._2);

  //println(a + b + c);
  //println(t1 + t2);
}
