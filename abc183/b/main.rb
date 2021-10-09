# AC

sx, sy, gx, gy = gets.strip.split(" ").map(&:to_i)
answer = sy * (gx - sx).to_f / (sy + gy) + sx
puts(answer)

