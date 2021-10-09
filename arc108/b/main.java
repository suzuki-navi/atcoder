import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    var sc = new Scanner(System.in);
    int n = sc.nextInt();
    var str = sc.next();
    var arr = new char[n+2];
    for (int i = 0; i < n; i++) {
      arr[n-1-i] = str.charAt(i);
    }
    int size = n;
    int size2 = n;
    int i = n-3;
    while (i >= 0) {
      if (arr[i] == 'x' && arr[i+1] == 'o' && arr[i+2] == 'f') {
        for (int j = i+3; j < size2; j++) {
          arr[j-3] = arr[j];
        }
        size -= 3;
        size2 -= 3;
      } else if (arr[i] == 'o' || arr[i] == 'f') {
        // nothing
      } else {
        size2 = i;
      }
      i--;
    }
    System.out.println(size);
  }
}
