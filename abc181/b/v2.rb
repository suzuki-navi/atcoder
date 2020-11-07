# AC

n = gets.strip.to_i
answer = 0
n.times do
  a, b = gets.strip.split(" ").map(&:to_i)
  answer += b * (b+1) - a * (a-1)
end
answer /= 2
puts(answer)
