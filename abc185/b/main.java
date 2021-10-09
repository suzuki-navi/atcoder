class Main {
  public static void main(String[] args) {
    var sc = new java.util.Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int t = sc.nextInt();

    var abs = new int[2*m];
    for (int i = 0; i < m; i++) {
      abs[2*i  ] = sc.nextInt();
      abs[2*i+1] = sc.nextInt();
    }

    int c = n;
    int ct = 0;
    for (int i = 0; i < m; i++) {
      int a = abs[2*i ];
      int b = abs[2*i+1];
      c -= a - ct;
      if (c <= 0) {
        System.out.println("No");
        return;
      }
      c += b - a;
      if (c > n) c = n;
      ct = b;
    }
    c -= t - ct;
    if (c <= 0) {
      System.out.println("No");
      return;
    }
    System.out.println("Yes");
  }
}
