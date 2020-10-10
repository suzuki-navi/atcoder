#include <bits/stdc++.h>
using namespace std;

int *factorial_table;

void factorial_init(int max, int m) {
  factorial_table = new int[(max + 1) * 3];
  factorial_table[0] = 0;
  factorial_table[1] = 1;
  factorial_table[2] = 1;
  factorial_table[3] = 1;
  factorial_table[4] = 1;
  factorial_table[5] = 1;
  for (int i = 2; i <= max; i++) {
    int inv = m - (int)((long)factorial_table[3 * (m % i)] * (m / i) % m);
    int *p = factorial_table + 3 * i;
    p[0] = inv;
    p[1] = (int)((long)p[-2] * i % m);
    p[2] = (int)((long)p[-1] * inv % m);
  }
}

int combination(int n, int k, int m) {
  return (int)((long)factorial_table[3 * n + 1] * factorial_table[3 * k + 2] % m *
               factorial_table[3 * (n - k) + 2] % m);
}

int calc(int n, int k, int i, int m) {
  if (n - k < i - 1) {
    return 0;
  }
  int blue = combination(k - 1, i - 1, m);
  int red = combination(n - k + 1, i, m);
  return (int)((long)blue * red % m);
}

int main() {
  int m = 1000000007;
  int n, k;
  cin >> n >> k;

  factorial_init(n, m);

  for (int i = 1; i <= k; i++) {
    int answer = calc(n, k, i, m);
    cout << answer << endl;
  }
}
