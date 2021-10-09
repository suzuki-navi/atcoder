# AC

n = gets.strip.to_i - 1

answer = ""
while true
  answer = (0x61 + (n % 26)).chr + answer
  n = n / 26
  break if n == 0
  n -= 1
end

puts(answer)

