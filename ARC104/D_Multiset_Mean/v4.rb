# TLE

n, k, m = gets.strip.split(" ").map(&:to_i)

table = [[1]]
for i in 1..n-1
  t1 = table[i-1]
  t2 = []
  for j in 0 .. i * (i+1) * k / 2
    a1 = ((j - (i - 1) * i * k / 2) + i - 1) / i;
    a1 = 0 if a1 < 0
    a2 = j / i;
    a2 = k if a2 > k
    s = 0;
    for a in a1 .. a2
      s += t1[j - a * i]
    end
    s = s % m
    t2.push(s)
  end
  table.push(t2)
end

table2 = [0]
for x in 1 .. (n + 1) / 2
  n1 = x - 1
  n2 = n - x
  s = 0
  for i in 0 .. n1 * (n1+1) * k / 2
    s += table[n1][i] * table[n2][i] % m;
  end
  answer = (m + s * (k+1) - 1) % m
  table2.push(answer)
  p answer
end
for x in (n + 1) / 2 + 1 .. n
  p table2[n + 1 - x]
end

