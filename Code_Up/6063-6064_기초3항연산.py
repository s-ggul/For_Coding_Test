'''
파이썬 3항 연산 기본 사용법
a, b = map(int, input().split())
print(a if a>b else b)
'''

a, b, c = map(int, input().split())
min1 = (a if a < b else b) 
final_min = min1 if min1 < c else c
'''
또는 (a if a < b else b) if (a if a < b else b) < c else c
'''
print(final_min)  