class Main {
  public static int pow(int a, int n, int m) {
    long s = 1;
    while (n > 0) {
      if ((n & 1) != 0) s = s * a % m;
      a = (int)((long)a * a % m);
      n >>= 1;
    }
    return (int)s;
  }

  public static int inverse_fermat(int a, int m) {
    // mが素数が条件
    return pow(a, m - 2, m);
  }

  public static int inverse_euclid(int a, int m) {
    int b = m, u = 1, v = 0;
    while (b != 0) {
      int t = a / b;
      int tmp;
      a -= t * b; tmp = a; a = b; b = tmp;
      u -= t * v; tmp = u; u = v; v = tmp;
    }
    u %= m;
    if (u < 0) u += m;
    return u;
  }

  private static int[] inverse_table;

  public static void inverse_init(int max, int m) {
    inverse_table = new int[max + 1];
    inverse_table[1] = 1;
    for (int i = 2; i <= max; i++) {
      inverse_table[i] = m - (int)((long)inverse_table[m % i] * (m / i) % m);
    }
  }

  public static int inverse_query(int a) {
    return inverse_table[a];
  }

  public static void main(String[] args) {
    int m = 1000000007;

    System.out.println(pow(2, 10, m));
    System.out.println(pow(2, 20, m));
    System.out.println(pow(2, 29, m));
    System.out.println(pow(2, 30, m));

    System.out.println(inverse_euclid(2, 7));
    System.out.println(inverse_euclid(3, 7));

    inverse_init(6, 7);
    System.out.println(inverse_query(2));
    System.out.println(inverse_query(3));
  }
}
