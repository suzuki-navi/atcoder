class Main {
  //static long pow(long a, long n) {
  //  long s = 1;
  //  while (n > 0) {
  //    if ((n & 1) != 0) s = s * a;
  //    a = a * a;
  //    n >>= 1;
  //  }
  //  return s;
  //}

  //static int pow(int a, int n, int m) {
  //  long s = 1;
  //  while (n > 0) {
  //    if ((n & 1) != 0) s = s * a % m;
  //    a = (int)((long)a * a % m);
  //    n >>= 1;
  //  }
  //  return (int)s;
  //}

  //static int[] powTable;
  //static void initPow(int max, int m) {
  //  powTable = new int[max + 1];
  //  int p = 1;
  //  powTable[0] = p;
  //  for (int i = 1; i <= max; i++) {
  //    p = (int)(2L * p % m);
  //    powTable[i] = p;
  //  }
  //}

  //public static long log(long a, long max) {
  //  long acc = 0;
  //  while (true) {
  //    if (max < a) return acc;
  //    int n = 1;
  //    long s = a;
  //    while (true) {
  //      long s2 = s * s;
  //      if (s2 > max) break;
  //      s = s2;
  //      n <<= 1;
  //    }
  //    max = max / s;
  //    acc = acc + n;
  //  }
  //}

  //public static int inverse_fermat(int a, int m) {
  //  // mが素数が条件
  //  return pow(a, m - 2, m);
  //}

  //public static int inverse_euclid(int a, int m) {
  //  int b = m, u = 1, v = 0;
  //  while (b != 0) {
  //    int t = a / b;
  //    int tmp;
  //    a -= t * b; tmp = a; a = b; b = tmp;
  //    u -= t * v; tmp = u; u = v; v = tmp;
  //  }
  //  u %= m;
  //  if (u < 0) u += m;
  //  return u;
  //}

  //private static int[] inverse_table;

  //public static void inverse_init(int max, int m) {
  //  inverse_table = new int[max + 1];
  //  inverse_table[1] = 1;
  //  for (int i = 2; i <= max; i++) {
  //    inverse_table[i] = m - (int)((long)inverse_table[m % i] * (m / i) % m);
  //  }
  //}

  //public static int inverse_query(int a) {
  //  return inverse_table[a];
  //}

  public static void main(String[] args) {
    //int m = 1_000_000_007;

    var sc = new java.util.Scanner(System.in);
    //int a = sc.nextInt();
    //int b = sc.nextInt();
    //int c = sc.nextInt();
    //var t1 = sc.next();
    //var t2 = sc.next();

    //var as = new int[n];
    //for (int i = 0; i < n; i++) {
    //  as[i] = sc.nextInt();
    //}

    //var ss = new boolean[h][w];
    //for (int i = 0; i < h; i++) {
    //  var t = sc.next();
    //  for (int j = 0; j < w; j++) {
    //    if (t.charAt(j) == '#') ss[i][j] = true;
    //  }
    //}

    // samples of sort
    //int[] arr1 = {30, 49, 28, 60};
    //java.util.Arrays.sort(arr1);
    //int[][] arr2 = {{1, 30}, {2, 49}, {3, 28}, {4, 60}};
    //java.util.Arrays.sort(arr2, java.util.Comparator.comparingInt(x -> x[1]));
    //int[][] arr3 = {{1, 30}, {2, 49}, {3, 28}, {4, 60}};
    //java.util.Arrays.sort(arr3, (a, b) -> a[1] - b[1]);

    //System.out.println(a + b + c);
    //System.out.println(t1 + t2);
  }
}
