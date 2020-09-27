class Main {
  public static void main(String[] args) {
    int[] arr1 = {30, 49, 28, 60};
    java.util.Arrays.sort(arr1);
    for (int i = 0; i < arr1.length; i++)
      System.out.print(arr1[i] + " ");
    System.out.println();

    int[][] arr2 = {{1, 30}, {2, 49}, {3, 28}, {4, 60}};
    java.util.Arrays.sort(arr2, java.util.Comparator.comparingInt(x -> x[1]));
    for (int i = 0; i < arr2.length; i++)
      System.out.print("(" + arr2[i][0] + "," + arr2[i][1] + ") ");
    System.out.println();

    int[][] arr3 = {{1, 30}, {2, 49}, {3, 28}, {4, 60}};
    java.util.Arrays.sort(arr3, (a, b) -> a[1] - b[1]);
    for (int i = 0; i < arr3.length; i++)
      System.out.print("(" + arr3[i][0] + "," + arr3[i][1] + ") ");
    System.out.println();
x  }
}
