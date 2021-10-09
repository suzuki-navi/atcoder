s, p = gets.strip.split(" ").map(&:to_i)

sq = s * s - 4 * p;
sqrt = Integer.sqrt(sq)
if sqrt * sqrt != sq
  puts("No")
  exit(0)
end
if (s - sqrt) % 2 == 0
  puts("Yes")
else
  puts("No")
end
