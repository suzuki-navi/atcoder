class Main {
  public static void main(String[] args) {
    var sc = new java.util.Scanner(System.in);
    int n = sc.nextInt();
    var ps = new int[n];
    for (int i = 0; i < n; i++) {
      ps[i] = sc.nextInt() - 1;
    }

    var f1 = new boolean[n]; // 右よりも後に交換. n-2 は必ずfalse
    var f2 = new boolean[n]; // 右よりも前に交換

    // 1 3 0 2
    // 1 0 3 2
    // 1 0 2 3
    // 0 1 2 3

    for (int i = 0; i < n; i++) { // 0 - 3
      var p = ps[i];
      if (p < i) {
        var i1 = i - 1;
        for (int j = p; j < i1; j++) {
          if (f1[j] || f2[j]) {
            System.out.println(-1);
            return;
          }
          f1[j] = true;
        }
      } else if (p > i) {
        var p1 = p - 1;
        for (int j = i; j < p1; j++) {
          if (f1[j] || f2[j]) {
            System.out.println(-1);
            return;
          }
          f2[j] = true;
        }
      } else {
        System.out.println(-1);
        return;
      }
    }

    var n1 = n - 1;

    int i = 0;
    while (i < n1) {
      if (f1[i]) {
        int j = i + 1;
        while (f1[j]) {
          j++;
        }
        int j0 = j;
        while (j >= i) {
          System.out.println(j + 1);
          j--;
        }
        i = j0 + 1;
      } else {
        System.out.println(i + 1);
        i++;
      }
    }
  }
}
