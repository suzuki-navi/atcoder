#include <bits/stdc++.h>
using namespace std;

int pow(int a, int n, int m) {
  long s = 1;
  while (n > 0) {
    if ((n & 1) != 0) s = s * a % m;
    a = (int)((long)a * a % m);
    n >>= 1;
  }
  return (int)s;
}

int inverse_fermat(int a, int m) {
  // mが素数が条件
  return pow(a, m - 2, m);
}

int inverse_euclid(int a, int m) {
  int b = m, u = 1, v = 0;
  while (b) {
    int t = a / b;
    a -= t * b; swap(a, b);
    u -= t * v; swap(u, v);
  }
  u %= m;
  if (u < 0) u += m;
  return u;
}

int *inverse_table;

void inverse_init(int max, int m) {
  inverse_table = new int[max + 1];
  inverse_table[1] = 1;
  for (int i = 2; i <= max; i++) {
    inverse_table[i] = m - (int)((long)inverse_table[m % i] * (m / i) % m);
  }
}

int inverse_query(int a) {
  return inverse_table[a];
}

int main() {
  long m = 1000000007;

  cout << pow(2, 10, m) << endl;
  cout << pow(2, 20, m) << endl;
  cout << pow(2, 29, m) << endl;
  cout << pow(2, 30, m) << endl;

  cout << inverse_euclid(2, 7) << endl;
  cout << inverse_euclid(3, 7) << endl;

  inverse_init(6, 7);
  cout << inverse_query(2) << endl;
  cout << inverse_query(3) << endl;
}
