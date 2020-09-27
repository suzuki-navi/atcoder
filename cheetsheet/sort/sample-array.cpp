#include <bits/stdc++.h>
using namespace std;

int main() {
  int arr1[] = {30, 49, 28, 60};
  int len1 = sizeof(arr1) / sizeof(arr1[0]);
  sort(arr1, arr1 + len1);
  for (int i = 0; i < len1; i++) {
    cout << arr1[i] << " ";
  }
  cout << endl;
  // 28 30 49 60

  pair<int, int> arr3[] = {{1, 30}, {2, 49}, {3, 28}, {4, 60}};
  int len3 = sizeof(arr3) / sizeof(arr3[0]);
  sort(arr3, arr3 + len3, [](pair<int, int> a, pair<int, int> b) { return a.second < b.second; });
  for (int i = 0; i < len3; i++) {
    cout << "(" << arr3[i].first << "," << arr3[i].second << ") ";
  }
  cout << endl;
  // (3,28) (1,30) (2,49) (4,60)

  // sortのかわりにstable_sortを使えば安定ソートになる
}
