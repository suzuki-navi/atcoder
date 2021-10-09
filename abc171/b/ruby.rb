# AC

n, k = gets.strip.split(" ").map(&:to_i)
ps = gets.strip.split(" ").map(&:to_i)
puts(ps.sort.take(k).sum)
