# AC

a, b, c, d = gets.strip.split(" ").map(&:to_i)

if a == b + c + d
  puts("Yes")
elsif a + b == c + d
  puts("Yes")
elsif a + c == b + d
  puts("Yes")
elsif a + b + c == d
  puts("Yes")
elsif a + d == b + c
  puts("Yes")
elsif a + b + d == c
  puts("Yes")
elsif a + c + d == b
  puts("Yes")
else
  puts("No")
end
