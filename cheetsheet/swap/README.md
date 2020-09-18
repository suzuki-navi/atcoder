# 変数の値を入れ替える(swap)には

C++

```cpp
swap(a, b);
```

Ruby、Python

```ruby
a, b = b, a
```

PHP

```php
[$a, $b] = [$b, $a];
```

Perl

```perl
($a, $b) = ($b, $a);
```

Scalaは以下のようにしてもできない。(valでなくvarであってもできない)

```scala
(a, b) = (b, a);
```

Javaもできない。整数なら以下のようなことをしてもできるけど、まあ一時変数を使うのがわかりやすい。

```java
a = a + b;
b = a - b;
a = a - b;
```


