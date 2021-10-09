import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    var sc = new Scanner(System.in);
    long s = sc.nextLong();
    long p = sc.nextLong();

    long sq = s * s - 4 * p;
    int sqrt = (int)(Math.sqrt((double)p));
    if (sqrt * sqrt != sq) {
      sqrt++;
      if (sqrt * sqrt != sq) {
        System.out.println("No");
        return;
      }
    }
    if ((s - sqrt) % 2 == 0) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }
}
