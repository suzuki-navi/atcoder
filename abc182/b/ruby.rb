# AC

n = gets.strip.to_i
as = gets.strip.split(" ").map(&:to_i)
gcd = 0
answer = 0
for i in 2..as.max
  c = 0
  for j in as
    c+=1 if j % i == 0
  end
  if c > gcd
    gcd = c
    answer = i
  end
end
puts(answer)
