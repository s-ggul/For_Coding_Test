N, M, K = map(int, input().split())
data = list(map(int,input().split()))

data.sort()
largestNum = data[N-1]
secondLarge = data[N-2]

result = 0

while True:
    for i in range(K):
        if M == 0:
            break
        result += largestNum    
        M -= 1 

    if M == 0:
        break

    result+= secondLarge
    M -= 1

print(result)

'''
더 효율적인 방법
N, M, K = map(int, input().split())
data = list(map(int,input().split()))

data.sort()
largestNum = data[N-1]
secondLarge = data[N-2]

#가장 큰 수가 더해지는 횟수 연산
count = int(m/(k+1)) * k
count += m % (k+1)

result = 0
result += (count) * largestNum # 가장 큰 수 더하기
result += (m - count) * secondLarge # 두 번째로 큰 수 더하기

print(result)
'''