#include <bits/stdc++.h>
using namespace std;

int main() {
  int n, q;
  cin >> n >> q;

  int count = 1 << 19 + 1;
  int as[count];
  for (int i = 0; i < n; i++) {
    cin >> as[i];
  }
  for (int i = n; i < count; i++) {
    as[i] = 0;
  }
  int *ass[19];
  for (int di = 0; di < 19; di++) {
    int d = 1 << di;
    int c = count >> (di+1);
    ass[di] = new int[c];
    for (int i = 0; i < c; i++) {
      int id = i << (di+1);
      int xo = 0;
      for (int j = 0; j < d; j++) {
        xo = xo ^ as[id + j];
      }
      ass[di][i] = xo;
    }
  }

  /*
    cout << "DEBUG ";
    for (int x = 0; x < n; x++) {
      int zo = 0;
      int z = x + 1;
      for (int di = 0; di < 19; di++) {
        if (((z >> di) & 1) != 0) {
          zo = zo ^ ass[di][z >> (di+1)];
        }
      }
      z = x;
      for (int di = 0; di < 19; di++) {
        if (((z >> di) & 1) != 0) {
          zo = zo ^ ass[di][z >> (di+1)];
        }
      }
      cout << zo << " ";
    }
    cout << endl;
  */

  for (int i = 0; i < q; i++) {
    int t, x, y;
    cin >> t >> x >> y;
    if (t == 1) {
      int z = x - 1;
      for (int di = 0; di < 19; di++) {
        if (((z >> di) & 1) == 0) {
          int zi = z >> (di+1);
          ass[di][zi] = ass[di][zi] ^ y;
        }
      }
      /*
    cout << "DEBUG ";
    for (int x = 0; x < n; x++) {
      int zo = 0;
      int z = x + 1;
      for (int di = 0; di < 19; di++) {
        if (((z >> di) & 1) != 0) {
          zo = zo ^ ass[di][z >> (di+1)];
        }
      }
      z = x;
      for (int di = 0; di < 19; di++) {
        if (((z >> di) & 1) != 0) {
          zo = zo ^ ass[di][z >> (di+1)];
        }
      }
      cout << zo << " ";
    }
    cout << endl;
      */

    } else {
      int zo = 0;
      int z = y;
      for (int di = 0; di < 19; di++) {
        if (((z >> di) & 1) != 0) {
          zo = zo ^ ass[di][z >> (di+1)];
        }
      }
      z = x - 1;
      for (int di = 0; di < 19; di++) {
        if (((z >> di) & 1) != 0) {
          zo = zo ^ ass[di][z >> (di+1)];
        }
      }
      cout << zo << endl;
    }
  }
}
