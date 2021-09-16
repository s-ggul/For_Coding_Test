#나의 풀이
numString = list(map(int,input()))

result = 0

for i in range(len(numString)):
    num = numString[i]
    if num == 1 or num == 0 or result == 1 or result == 0:
        result += num
    else:
        result *= num

print(result)