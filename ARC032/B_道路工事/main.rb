# AC

n, m = gets.strip.split(" ").map(&:to_i)

ab = []

for i in 0..m-1
  a, b = gets.strip.split(" ").map(&:to_i)
  a -= 1
  b -= 1
  ab.push([a, b])
end

root = (0 .. n-1).to_a

def fetchRoot(root, p)
  ri = root[p]
  if ri == p
    return ri
  end
  ri2 = fetchRoot(root, ri)
  root[p] = ri2
  ri2
end

for i in 0..m-1
  a, b = ab[i]
  ra = fetchRoot(root, a)
  rb = fetchRoot(root, b)
  if ra != rb
    root[rb] = ra
  end
end

count = -1
for i in 0..n-1
  r = fetchRoot(root, i)
  if r == i
    count += 1
  end
end

p count

