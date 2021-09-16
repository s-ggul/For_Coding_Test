#나의 풀이
from itertools import combinations 

N, M = map(int, input().split())
balls = list(map(int, input().split()))

firstList = list(combinations(balls, 2))
count = len(firstList)

for i in range(count):
    a, b = firstList[i]
    if a == b :
        count -= 1

print(count)