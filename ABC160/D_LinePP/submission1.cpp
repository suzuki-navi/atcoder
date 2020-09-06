// AC

#include <bits/stdc++.h>
using namespace std;

int main() {
  int n, x, y;
  cin >> n >> x >> y;

  vector<int> answer(n);
  for (int i = 1; i <= n - 1; i++) {
    answer[i] = 0;
  }
  for (int i = 1; i <= n; i++) {
    for (int j = i + 1; j <= n; j++) {
      int d = j - i;
      if        (i <= x                     && j >= y) {
        d = (x - i) + 1 + (j - y);
      }
      if (i > x && j < y) {
        d = min(d, (i - x) + 1 + (y - j));
      }
      if (i > x && j >= y) {
        d = min(d, (i - x) + 1 + (j - y));
      }
      if (i <= x && j < y) {
        d = min(d, (x - i) + 1 + (y - j));
      }
      answer[d]++;
    }
  }

  for (int i = 1; i <= n - 1; i++) {
    cout << answer[i] << endl;
  }
}
