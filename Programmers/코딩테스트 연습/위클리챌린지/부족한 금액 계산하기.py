def solution(price, money, count):
    total_price = 0
    for i in range(1,count+1):
        total_price += price * i
    answer = total_price - money if total_price > money else 0
    return answer