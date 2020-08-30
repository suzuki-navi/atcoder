# 229s

$m = 1000000007

def pow(a, b)
  s = 1
  while b > 0
    if b & 1 != 0
      s = s * a % $m
    end
    a = a * a % $m
    b >>= 1
  end
  s
end

def reverse(a)
  pow(a, $m - 2)
end

def sub(n, a)
  if a > n / 2
    a = n - a
  end
  s1 = 1
  n2 = n - a
  for i in n2+1 .. n
    s1 = s1 * i % $m
  end
  s2 = 1
  for i in 1 .. a
    s2 = s2 * i % $m
  end
  s3 = reverse(s2)
  s1 * s3 % $m
end

n, a, b = gets.strip.split(" ").map(&:to_i)

all = 1
for i in 1 .. n
  all = all * 2 % $m
end

answer = (all + 2 * $m - sub(n, a) - sub(n, b) - 1) % $m

p answer

