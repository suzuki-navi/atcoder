import java.util.Scanner;

class Main {
  static int m = 1_000_000_007;

  static int pow2(int n) {
    long s = 1;
    long a = 2;
    while (n > 0) {
      if ((n & 1) != 0) s = s * a % m;
      a = a * a % m;
      n >>= 1;
    }
    return (int)s;
  }

  static int com(int n) {
    int s1 = 1;
    int s2 = 1;
    for (int i = 0; i < n; i++) {
      int t = (s1 + s2) % m;
      s1 = s2;
      s2 = t;
    }
    return s2;
  }

  public static void main(String[] args) {
    var sc = new Scanner(System.in);
    int n = sc.nextInt();
    boolean caa = (sc.next().equals("B"));
    boolean cab = (sc.next().equals("B"));
    boolean cba = (sc.next().equals("B"));
    boolean cbb = (sc.next().equals("B"));
    int answer = 0;
    if (n == 2) {
      answer = 1;
    } else if (cab && cbb) {
      // ABBB
      answer = 1;
    } else if (!cab && !caa) {
      // AAAB
      answer = 1;
    } else if (cab && !cba) {
      answer = pow2(n-3);
    } else if (cab) {
      answer = com(n-3);
    } else if (!cab && cba) {
      answer = pow2(n-3);
    } else if (!cab) {
      answer = com(n-3);
    }
    System.out.println(answer);
  }
}
