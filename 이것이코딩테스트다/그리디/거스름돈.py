'''
p.89 거스름돈 문제 - 분류 : 그리디 알고리즘
'''
'''
n = 1260
count = 0

# 큰 단위의 화폐부터 차례대로 확인
coin_types = [500, 100, 50, 10]

for coin in coin_types : 
    count += n // coin
    n %= coin

print(coin)
'''

#복습

N = int(input())

coins = [500, 100, 50, 10]

coinCount = 0

for coin in coins :
    coinCount += N // coin 
    N = N % coin 

print(coinCount)