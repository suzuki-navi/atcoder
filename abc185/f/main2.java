class Main {
  public static void main(String[] args) {
    var sc = new java.util.Scanner(System.in);
    int n = sc.nextInt();
    int q = sc.nextInt();

    int max = 1 << 19;
    int[] segment = new int[max];
    int[] buf = new int[20];

    for (int i = 0; i < n; i++) {
      int a = sc.nextInt();
      updateSegment(i, a, segment, buf, max);
    }

    for (int i = 0; i < q; i++) {
      int t = sc.nextInt();
      int x = sc.nextInt();
      int y = sc.nextInt();
      if (t == 1) {
        x = x - 1;
        updateSegment(x, y, segment, buf, max);
      } else {
        x = x - 1;
        y = y - 1;
        int ax = fetchSegment(x, segment, buf);
        int ay = fetchSegment(y + 1, segment, buf);
        int answer = ay ^ ax;
        System.out.println(answer);
      }
    }

  }

  private static void updateSegment(int idx, int x, int[] segment, int[] buf, int max) {
    indexOfUpdateSegment(idx + 1, buf, max);
    int i = 0;
    while (true) {
      int s = buf[i];
      if (s < 0) break;
      segment[s] ^= x;
      i++;
    }
  }

  private static int fetchSegment(int idx, int[] segment, int[] buf) {
    indexOfFetchSegment(idx, buf);
    int i = 0;
    int ret = 0;
    while (true) {
      int s = buf[i];
      if (s < 0) break;
      ret ^= segment[s];
      i++;
    }
    return ret;
  }

  // 13 -> 13, 14, 16, 32, 64, 128
  private static void indexOfUpdateSegment(int idx, int[] buf, int max) {
    int offset = 0;
    while (idx < max) {
      int lastBit = idx & -idx;
      buf[offset] = idx;
      offset++;
      idx = idx + lastBit;
    }
    buf[offset] = -1;
  }

  // 13 -> 13, 12, 8
  private static void indexOfFetchSegment(int idx, int[] buf) {
    int offset = 0;
    while (idx != 0) {
      buf[offset] = idx;
      offset++;
      int lastBit = idx & -idx;
      idx = idx - lastBit;
    }
    buf[offset] = -1;
  }
}
