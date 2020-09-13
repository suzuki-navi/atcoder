// AC

#include <bits/stdc++.h>
using namespace std;

int main() {
  long m = 1000000007;

  int s;
  cin >> s;

  if (s < 3) {
    cout << 0 << endl;
    return 0;
  }

  vector<long> series(s + 1);
  series[0] = 0;
  series[1] = 0;
  series[2] = 0;
  for (int i = 3; i <= s; i++) {
    long a = 1;
    for (int j = 0; j <= i - 3; j++) {
      a += series[j];
      a = a % m;
    }
    series[i] = a;
  }
  long answer = series[s];
  cout << answer << endl;
}
