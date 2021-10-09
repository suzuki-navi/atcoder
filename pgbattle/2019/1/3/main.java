class Main {
  public static void main(String[] args) {
    var sc = new java.util.Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();

    var arr = new boolean[m];
    for (int i = 0; i < n; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int k = i - (a + b);
      if (k >= 0 && k < m) arr[k] = true;
    }

    int s = 0;
    for (int i = 0; i < m; i++) {
      if (arr[i]) s++;
    }

    System.out.println(s);
  }
}
