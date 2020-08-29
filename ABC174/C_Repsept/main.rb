k = gets.strip.to_i

if k % 2 == 0 || k % 5 == 0
  puts(-1)
  exit(0)
end

s = 0
for i in 1.upto(k)
  s = s * 10 + 7
  s = s % k
  if s == 0
    puts(i)
    exit()
  end
end

