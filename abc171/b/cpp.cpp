// AC

#include <bits/stdc++.h>
using namespace std;

int main() {
  int n, k;
  cin >> n >> k;
  int *ps = new int[n];
  for (int i = 0; i < n; i++) cin >> ps[i];

  sort(ps, ps + n);

  int sum = 0;
  for (int i = 0; i < k; i++) sum += ps[i];

  cout << sum << endl;
}
