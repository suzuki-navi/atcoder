import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    var max = 10;
    var sc = new Scanner(System.in);
    var n = sc.nextInt();
    var m = sc.nextInt();
    var q = sc.nextInt();
    var as = new int[q][4];
    for (int i = 0; i < q; i++) {
      as[i][0] = sc.nextInt() - 1;
      as[i][1] = sc.nextInt() - 1;
      as[i][2] = sc.nextInt();
      as[i][3] = sc.nextInt();
    }

    var arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = 1;
    }
    var i = 0;
    var count = 0;
    var answer = 0;
    while (true) {
      var point = 0;
      for (int k = 0; k < q; k++) {
        if (arr[as[k][1]] - arr[as[k][0]] == as[k][2]) {
          point += as[k][3];
        }
      }
      if (answer < point) {
        answer = point;
      }

      var j = n - 1;
      while (j >= 0 && arr[j] == m) {
        j--;
      }
      if (j < 0) {
        break;
      }
      arr[j]++;
      for (int k = j + 1;  k < n; k++) {
        arr[k] = arr[j];
      }
    }
    System.out.println(answer);
  }
}
