# 나의 풀이
from itertools import combinations 

N = int(input())
coins = list(map(int, input().split()))
maxVal = sum(coins)
result = [0 for i in range(maxVal+1)]

#조합으로 동전을 모두 뽑은 경우를 구한 뒤,
# 각 튜플의 합과 같은 result의 인덱스에 +1 진행
for i in range(1,N+1) :
    case = list(combinations(coins, i))
    for j in range(len(case)):
        result[sum(case[j])] += 1



for i in range(1,len(result)) : 
    if result[i] == 0 :
        print(i)
        break