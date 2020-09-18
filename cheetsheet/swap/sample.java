class Main {
  public static void main(String[] args) {
    int a = 1, b = 2;
    System.out.println(String.format("%d %d", a, b));

    { int tmp = a; a = b; b = tmp; }
    System.out.println(String.format("%d %d", a, b));
  }
}
