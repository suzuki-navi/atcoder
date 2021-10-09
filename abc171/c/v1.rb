# AC

n = gets.strip.to_i - 1

l = 1
max0 = 26
max1 = 26
max2 = 0
while max1 <= n
  max2 = max1
  l += 1
  max0 *= 26
  max1 += max0
end

d = n - max2

answer = ""
while l > 0
  d1 = d / 26
  d2 = d % 26
  answer = (0x61 + d2).chr + answer
  d = d1
  l -= 1
end

puts(answer)

