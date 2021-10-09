
n, m = gets.strip.split(" ").map(&:to_i)
a, b, c = gets.strip.split(" ").map(&:to_i)

b = b - a
c = c - a
m = m - a * n

result = [-1, -1, -1]
if c == 0
  for nb in 0 .. n do
    nc = m - nb * b
    if nc == 0
      na = n - nb
      result = [na, nb, nc]
      break
    end
  end
else
  for nb in 0 .. n do
    nc = m - nb * b
    if nc % c == 0
      nc = nc / c
      na = n - nb - nc
      result = [na, nb, nc]
      break
    end
  end
end

puts(result.join(" "))

