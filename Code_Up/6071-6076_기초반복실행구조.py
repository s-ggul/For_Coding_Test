'''
영문 소문자(a ~ z) 1개가 입력되었을 때,
a부터 그 문자까지의 알파벳을 순서대로 출력해보자.

c = ord(input())
start = ord('a')

while (start != c+1) :
    print(chr(start),end=' ')
    start += 1
'''

a = int(input())
for i in range(0,a+1) : 
    print(i)