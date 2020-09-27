#include <bits/stdc++.h>
using namespace std;

int main() {
  vector<int> vec1 = {30, 49, 28, 60};
  sort(vec1.begin(), vec1.end());
  for (int i = 0; i < vec1.size(); i++) {
    cout << vec1[i] << " ";
  }
  cout << endl;

  vector<pair<int, int>> vec3 = {{1, 30}, {2, 49}, {3, 28}, {4, 60}};
  sort(vec3.begin(), vec3.end(), [](pair<int, int> a, pair<int, int> b) { return a.second < b.second; });
  for (int i = 0; i < vec3.size(); i++) {
    cout << "(" << vec3[i].first << "," << vec3[i].second << ") ";
  }
  cout << endl;

  // sortのかわりにstable_sortを使えば安定ソートになる
}
