# 나의 풀이
N = int(input())
adventurer = list(map(int, input().split()))

adventurer.sort()

count = 0 # 전체 그룹 수 카운트
numOfGroup = 0 # 현재 그룹이 포함된 사람의 수를 확인하기 위함.

for i in range(N):
    fear = adventurer[i]
    numOfGroup += 1
    if numOfGroup == fear :
        count += 1
        numOfGroup = 0

print(count) 