#include <bits/stdc++.h>
using namespace std;

int main() {
  int l;
  cin >> l;

  long long result = 1;
  for (int i = 1; i <= 11; i++) {
    result *= l - i;
    result /= i;
  }
  cout << result << endl;
}
