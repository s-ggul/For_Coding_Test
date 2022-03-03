'''
h = int(input())

count = 0
for i in range(h+1):
    for j in range(60):
        for k in range(60) :
            #매 시각 안에 '3'이 포함되어 이ㅆ다면 카운트 증가
            if '3' in str(i) + str(j) + str(k) :
                count += 1

print(count)
'''

N = int(input())

count = 0
for h in range(N+1):
    for m in range(60):
        for s in range(60):
            if '3' in str(h) + str(m) + str(s) :
                count += 1

print(count)

