# AC

n = int(input())
ds = [[int(s) for s in input().split()] for _ in range(n)]

count = 0
for i in range(n):
    if ds[i][0] == ds[i][1]:
        count += 1
        if count == 3:
            print("Yes")
            exit(0)
    else:
        count = 0
print("No")

