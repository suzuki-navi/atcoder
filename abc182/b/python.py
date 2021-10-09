# AC

n = int(input())
ass = list(map(int, input().split(" ")))
gcd = 0
answer = 0
for i in range(2, max(ass)+1):
    c = 0
    for j in ass:
        if j % i == 0: c += 1
    if c > gcd:
        gcd = c
        answer = i
print(answer)

