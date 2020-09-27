object Main extends App {
  val lst1 = List(30, 49, 28, 60);
  println(lst1.sorted);

  val lst2 = List((1, 30), (2, 49), (3, 28), (4, 60));
  println(lst2.sortBy(_._2));

  val lst3 = List((1, 30), (2, 49), (3, 28), (4, 60));
  println(lst3.sortWith((a, b) => a._2 < b._2));
}
