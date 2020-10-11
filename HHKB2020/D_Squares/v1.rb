# AC

m = 1_000_000_007
t = gets.strip.to_i
t.times do
  n, a, b = gets.strip.split(" ").map(&:to_i)
  if n < a + b
    puts(0)
  else
    s1 = (n - a + 1) * (n - b + 1)
    s2 = (n - a - b + 2) * (n - a - b + 1)
    answer = (s1 * s1 - (s1 - s2) * (s1 - s2)) % m
    puts(answer)
  end
end

