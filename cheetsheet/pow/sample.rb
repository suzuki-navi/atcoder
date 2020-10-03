def pow(a, n, m)
  s = 1
  while n > 0
    if (n & 1) != 0 then s = s * a % m end
    a = a * a % m
    n >>= 1
  end
  s
end

def inverse_fermat(a, m)
  # mが素数が条件
  pow(a, m - 2, m)
end

def inverse_euclid(a, m)
  b = m; u = 1; v = 0
  while b != 0
    t = a / b
    a -= t * b; tmp = a; a = b; b = tmp
    u -= t * v; tmp = u; u = v; v = tmp
  end
  u = u % m
  if u < 0 then u += m end
  u
end

def inverse_table(max, m)
  table = [0, 1]
  for i in 2..max
    table.push(m - table[m % i] * (m / i) % m)
  end
  table
end

m = 1000000007

p pow(2, 10, m)
p pow(2, 20, m)
p pow(2, 29, m)
p pow(2, 30, m)

p inverse_euclid(2, 7)
p inverse_euclid(3, 7)

table = inverse_table(6, 7)
p table[2]
p table[3]

