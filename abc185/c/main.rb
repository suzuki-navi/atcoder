l = gets.strip.to_i

s = 1
for i in 12..(l-1)
  s = s * i
end
for i in 2..(l-12)
  s = s / i
end
puts(s)


