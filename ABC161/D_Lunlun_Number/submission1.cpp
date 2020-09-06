// AC

#include <bits/stdc++.h>
using namespace std;

long countLunlun(int l, int h, map<pair<int, int>, long> cache) {
  pair<int, int> key = make_pair(l, h);
  if (cache.count(key))
    return cache[key];
  long sum = 0;
  if (l == 1) {
    sum = 1;
  } else {
    if (h > 0)
      sum += countLunlun(l - 1, h - 1, cache);
    sum += countLunlun(l - 1, h, cache);
    if (h < 9)
      sum += countLunlun(l - 1, h + 1, cache);
  }
  cache[key] = sum;
  return sum;
}

long kthLunlun(int k, map<pair<int, int>, long> cache) {
  int l = 1;
  long step = 1;
  int h = 1;
  long x = 1;
  int k2 = k;
  while (1) {
    if (k2 == 0 && l == 1) {
      return x;
    }
    int s = countLunlun(l, h, cache);
    if (k2 < s) {
      l--;
      step /= 10;
      h = h - 1;
      if (h < 0)
        h = 0;
      x += h * step;
      continue;
    }
    k2 -= s;
    h++;
    x += step;
    if (h == 10) {
      h = 1;
      l++;
      step *= 10;
      //k2 = k;
    }
  }
}

int main() {
  int k;
  cin >> k;

  map<pair<int, int>, long> cache;
  long answer = kthLunlun(k - 1, cache);

  cout << answer << endl;
}
