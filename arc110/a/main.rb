n = gets.strip.to_i

p = 1
i = n
while i >= 2
  p = p.lcm(i)
  i -= 1
end

puts(p + 1)


