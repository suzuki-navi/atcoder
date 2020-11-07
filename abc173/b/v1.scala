// AC

object Main extends App {
  val sc = new java.util.Scanner(System.in);
  val n = sc.nextInt();
  val ss = Array.fill(n)(sc.next());
  println("AC x " + ss.count(_ == "AC"));
  println("WA x " + ss.count(_ == "WA"));
  println("TLE x " + ss.count(_ == "TLE"));
  println("RE x " + ss.count(_ == "RE"));
}
