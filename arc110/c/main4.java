class Main {
  public static void main(String[] args) {
    var sc = new java.util.Scanner(System.in);
    int n = sc.nextInt();
    var ps = new int[n];
    for (int i = 0; i < n; i++) {
      ps[i] = sc.nextInt() - 1;
    }

    var f1 = new boolean[n]; // 右を先に交換
    var f2 = new boolean[n]; // 左を先に交換

    // 1 3 0 2
    // 1 0 3 2
    // 1 0 2 3
    // 0 1 2 3

    for (int i = 0; i < n; i++) { // 0 - 3
      var p = ps[i];
      if (p < i) {
        for (int j = p + 1; j < i; j++) {
          if (f2[j]) {
            System.out.println(-1);
            return;
          }
          f1[j] = true;
        }
        if (p > 0) {
          if (f1[p]) {
            System.out.println(-1);
            return;
          }
          f2[p] = true;
        }
        if (i < n - 1) {
          if (f1[i]) {
            System.out.println(-1);
            return;
          }
          f2[i] = true;
        }
      } else if (p > i) {
        for (int j = i + 1; j < p; j++) {
          if (f1[j]) {
            System.out.println(-1);
            return;
          }
          f2[j] = true;
        }
        if (i > 0) {
          if (f2[i]) {
            System.out.println(-1);
            return;
          }
          f1[i] = true;
        }
        if (p < n - 1) {
          if (f2[p]) {
            System.out.println(-1);
            return;
          }
          f1[p] = true;
        }
      } else {
        System.out.println(-1);
        return;
      }
    }

    int i = 1;
    while (i < n) {
      if (f1[i]) {
        int j = i + 1;
        while (f1[j]) {
          j++;
        }
        int j0 = j;
        while (j >= i) {
          System.out.println(j);
          j--;
        }
        i = j0 + 1;
      } else {
        System.out.println(i);
        i++;
      }
    }

  }
}

