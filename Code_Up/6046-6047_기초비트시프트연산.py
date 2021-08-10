'''
a = int(input())
print(a<<1)
'''
#문제 6047 - 비트시프트 연산
a, b = map(int, input().split())
back_num = 1<<b
print(a * back_num)