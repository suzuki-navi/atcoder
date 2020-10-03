# 配列のソート (Scala、Java、C++)

(2020/09/27投稿)


## 要素が比較可能な場合

ScalaのSeq

```scala
val lst1 = List(30, 49, 28, 60);

println(lst1.sorted);
// List(28, 30, 49, 60)
```

Javaの配列

```java
int[] arr1 = {30, 49, 28, 60};

java.util.Arrays.sort(arr1);

for (int i = 0; i < arr1.length; i++)
  System.out.print(arr1[i] + " ");
System.out.println();
// 28 30 49 60
```

C++の配列

```cpp
int arr1[] = {30, 49, 28, 60};
int len1 = sizeof(arr1) / sizeof(arr1[0]);

sort(arr1, arr1 + len1);

for (int i = 0; i < len1; i++) {
  cout << arr1[i] << " ";
}
cout << endl;
// 28 30 49 60
```

C++のvector

```cpp
vector<int> vec1 = {30, 49, 28, 60};

sort(vec1.begin(), vec1.end());

for (int i = 0; i < vec1.size(); i++) {
  cout << vec1[i] << " ";
}
cout << endl;
// 28 30 49 60
```


## ソートキーを指定

ScalaのSeq

```scala
val lst2 = List((1, 30), (2, 49), (3, 28), (4, 60));

println(lst2.sortBy(_._2));
// List((3,28), (1,30), (2,49), (4,60))
```

Javaの配列

```java
int[][] arr2 = {{1, 30}, {2, 49}, {3, 28}, {4, 60}};

java.util.Arrays.sort(arr2, java.util.Comparator.comparingInt(x -> x[1]));

for (int i = 0; i < arr2.length; i++)
  System.out.print("(" + arr2[i][0] + "," + arr2[i][1] + ") ");
System.out.println();
// (3,28) (1,30) (2,49) (4,60)
```


## 比較関数をラムダで指定

ScalaのSeq

```scala
val lst3 = List((1, 30), (2, 49), (3, 28), (4, 60));

println(lst3.sortWith((a, b) => a._2 < b._2));
// List((3,28), (1,30), (2,49), (4,60))
```

Javaの配列

```java
int[][] arr3 = {{1, 30}, {2, 49}, {3, 28}, {4, 60}};

java.util.Arrays.sort(arr3, (a, b) -> a[1] - b[1]);

for (int i = 0; i < arr3.length; i++)
  System.out.print("(" + arr3[i][0] + "," + arr3[i][1] + ") ");
System.out.println();
// (3,28) (1,30) (2,49) (4,60)
```

C++の配列

```cpp
pair<int, int> arr3[] = {{1, 30}, {2, 49}, {3, 28}, {4, 60}};
int len3 = sizeof(arr3) / sizeof(arr3[0]);

sort(arr3, arr3 + len3, [](pair<int, int> a, pair<int, int> b) { return a.second < b.second; });

for (int i = 0; i < len3; i++) {
  cout << "(" << arr3[i].first << "," << arr3[i].second << ") ";
}
cout << endl;
// (3,28) (1,30) (2,49) (4,60)
```

C++のvector

```cpp
vector<pair<int, int>> vec3 = {{1, 30}, {2, 49}, {3, 28}, {4, 60}};

sort(vec3.begin(), vec3.end(), [](pair<int, int> a, pair<int, int> b) { return a.second < b.second; });

for (int i = 0; i < vec3.size(); i++) {
  cout << "(" << vec3[i].first << "," << vec3[i].second << ") ";
}
cout << endl;
// (3,28) (1,30) (2,49) (4,60)
```

