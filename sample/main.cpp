// 

#include <bits/stdc++.h>
using namespace std;

//int pow(int a, int n, int m) {
//  long s = 1;
//  while (n > 0) {
//    if ((n & 1) != 0) s = s * a % m;
//    a = (int)((long)a * a % m);
//    n >>= 1;
//  }
//  return (int)s;
//}

//int inverse_fermat(int a, int m) {
//  // mが素数が条件
//  return pow(a, m - 2, m);
//}

//int inverse_euclid(int a, int m) {
//  int b = m, u = 1, v = 0;
//  while (b) {
//    int t = a / b;
//    a -= t * b; swap(a, b);
//    u -= t * v; swap(u, v);
//  }
//  u %= m;
//  if (u < 0) u += m;
//  return u;
//}

//int *inverse_table;
//void inverse_init(int max, int m) {
//  inverse_table = new int[max + 1];
//  inverse_table[1] = 1;
//  for (int i = 2; i <= max; i++) {
//    inverse_table[i] = m - (int)((long)inverse_table[m % i] * (m / i) % m);
//  }
//}
//int inverse_query(int a) {
//  return inverse_table[a];
//}

int main() {
  // vectorの使い方
  //vector<int> arr = {10, 20, 30, 40, 50, 60};
  //int len = sizeof(arr) / sizeof(arr[0]);
  //for (int i = 0; i < len; i++) {
  //  cout << arr[i] << endl;
  //}

  //int a, b, c;
  //cin >> a >> b >> c;
  //string t1, t2;
  //cin >> t1 >> t2;

  //int *as = new int[n];
  //for (int i = 0; i < n; i++) cin >> as[i];

  // samples of sort
  //vector<int> vec1 = {30, 49, 28, 60};
  //sort(vec1.begin(), vec1.end());
  //
  //vector<pair<int, int>> vec3 = {{1, 30}, {2, 49}, {3, 28}, {4, 60}};
  //sort(vec3.begin(), vec3.end(), [](pair<int, int> a, pair<int, int> b) { return a.second < b.second; });
  //
  //int arr1[] = {30, 49, 28, 60};
  //int len1 = sizeof(arr1) / sizeof(arr1[0]);
  //sort(arr1, arr1 + len1);
  //
  //pair<int, int> arr3[] = {{1, 30}, {2, 49}, {3, 28}, {4, 60}};
  //int len3 = sizeof(arr3) / sizeof(arr3[0]);
  //sort(arr3, arr3 + len3, [](pair<int, int> a, pair<int, int> b) { return a.second < b.second; });
  //
  // sortのかわりにstable_sortを使えば安定ソートになる

  //cout << (a + b + c) << endl;
  //cout << t1 << t2 << endl;
}
