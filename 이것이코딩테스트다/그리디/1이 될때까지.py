'''
# 나의 풀이.
N, K = map(int, input().split())
count = 0

while True:
    if N == 1:
        break

    if N >= K and N % K == 0 and K != 1:
        N /= K 
        count += 1
    else:
        N -= 1
        count += 1 

print(count)

교재 풀이 1
n, k = map(int, input().split())
result = 0

while n >= k :
    while n % k != 0:
        n -= 1
        result += 1
    n //= k
    result += 1

while n > 1 : 
    n -= 1
    result += 1

print(result)

교재 풀이 2
n, k = map(int, input().split())
result = 0

while True :
    target = (n // k) * k
    result += (n - target)
    n = target

    if n < k :
        break

    result += 1
    n //= k

result += (n-1)
print(result)
'''

n, k = map(int, input().split())

count = 0

while True :
    if n == 1 :
        break    
    
    if (n%k) != 0 : 
        n -= 1
        count += 1
    else:
        n = n // k
        count += 1

print(count)
