object Main extends App {
  var (a, b) = (1, 2);
  println("%d %d".format(a, b));

  { val tmp = a; a = b; b = tmp; }
  println("%d %d".format(a, b));
}
