// AC

#include <bits/stdc++.h>
using namespace std;

int main() {
  // vectorの使い方
  //vector<int> arr = {10, 20, 30, 40, 50, 60};
  //int len = sizeof(arr) / sizeof(arr[0]);
  //for (int i = 0; i < len; i++) {
  //  cout << arr[i] << endl;
  //}

  int n;
  cin >> n;

  int s = ((n-1) / 1000 + 1) * 1000;
  cout << (s - n) << endl;
}
