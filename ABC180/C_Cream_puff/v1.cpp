// AC

#include <bits/stdc++.h>
using namespace std;

int main() {
  long n;
  cin >> n;
  int n2 = (int)sqrt((double)n);
  vector<int> vec = {};
  int last = 0;
  for (int i = 1; i <= n2; i++) {
    if (n % i == 0) {
      cout << i << endl;
      vec.push_back(i);
      last = i;
    }
  }
  for (int i = vec.size() - 1; i >= 0; i--) {
    long i2 = n / vec.at(i);
    if (i2 != last) {
      cout << i2 << endl;
    }
  }
}
