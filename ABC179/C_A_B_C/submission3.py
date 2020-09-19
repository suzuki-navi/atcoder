# AC

n = int(input())
answer = sum([(n - 1) // a for a in range(1, n)])
print(answer)

