data = list(map(int, input().split()))

answer = [1, 1, 2, 2, 2, 8]

result = [0 for i in range(6)]

for i in range(6):
    num = answer[i] - data[i]
    print(num, end=' ')