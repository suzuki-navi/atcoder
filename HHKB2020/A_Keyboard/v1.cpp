// AC

#include <bits/stdc++.h>
using namespace std;

int main() {
  string s, t;
  cin >> s >> t;

  if (s[0] == 'Y') {
    printf("%c\n", (char)(t[0] - 32));
  } else {
    printf("%c\n", t[0]);
  }

}
