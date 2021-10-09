class Main {
  public static void main(String[] args) {
    var sc = new java.util.Scanner(System.in);
    int n = sc.nextInt();
    var ps = new int[n];
    for (int i = 0; i < n; i++) {
      ps[i] = sc.nextInt() - 1;
    }

    var fsa1 = new boolean[n];
    var fsa2 = new boolean[n];
    var fsb1 = new boolean[n];
    var fsb2 = new boolean[n];
    for (int i = 0; i < n; i++) {
      var p = ps[i];
      if (p > i) {
        for (int j = i; j < p; j++) {
          if (fsa1[j]) {
            System.out.println(-1);
            return;
          }
          fsa1[j] = true;
        }
        fsa2[i] = true;
      } else if (p < i) {
        for (int j = i-1; j >= p; j--) {
          if (fsb1[j]) {
            System.out.println(-1);
            return;
          }
          fsb1[j] = true;
        }
        fsb2[p] = true;
      } else {
        System.out.println(-1);
        return;
      }
    }
    for (int i = 0; i < n-1; i++) {
      if (!fsa1[i]) {
        System.out.println(-1);
        return;
      }
      if (!fsb1[i]) {
        System.out.println(-1);
        return;
      }
    }
    for (int i = n-2; i >= 0; i--) {
      if (fsa2[i]) {
        System.out.println(i+1);
      }
    }
    for (int i = 0; i < n-1; i++) {
      if (!fsa2[i]) {
        System.out.println(i+1);
      }
    }
  }
}
