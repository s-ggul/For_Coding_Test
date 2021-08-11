'''
#6077
num = int(input())
sum = 0

for i in range(num+1) :
    if i % 2 == 0 :
        sum += i

print(sum)
'''

'''
#6078
while(True):
    c = input()
    if c == 'q' : 
        print(c)
        break
    else:
        print(c)
'''

'''
#6079
num = int(input())
index = 1
sum = 0
while(True):
    sum += index
    if sum >= num :
        print(index)
        break
    else:
        index += 1
'''

'''
#6080
n, m = map(int, input().split())

for i in range(1,n+1) : 
    for j in range(1, m+1):
        print(i, j)
'''

'''
#6081
a = int(input(),16)

for i in range(1,16) :
    print('%X'%a, '*%X'%i, '=%X'%(a*i), sep='')
'''
    
'''
#6082
num = int(input())

for i in range(1,num+1) :
    if (i % 10 == 3) or (i % 10 == 6) or (i % 10 == 9) :
        print('X', end=' ')
    elif (i // 10 == 3) or (i // 10 == 6) or (i // 10 == 9) :
        print('X', end=' ')
    else :
        print(i, end=' ')
'''

'''
#6083
r ,g ,b = map(int, input().split())
count = 0
for i in range(r):
    for j in range(g):
        for k in range(b):
            print(i, j, k)
            count+=1

print(count)
'''

'''
#6084
h, b, c, s = map(int, input().split())

print(format((h*b*c*s)/8/1024/1024, '.1f'), 'MB')
'''

'''
#6085
w, h, b = map(int, input().split())
print(format((w*h*b)/8/1024/1024,'.2f'),'MB')
'''

'''
#6086
num = int(input())
sum = 0
start = 1
while(sum < num):
    sum += start
    if sum >= num :
        break;
    start+=1
print(sum)
'''

'''
#6087
num = int(input())
start = 1
while(start != num+1):
    if start % 3 == 0:
        start+=1
        continue
    else:
        print(start, end=' ')
    start += 1
'''

'''
#6088
a, d, n = map(int, input().split())

print(a + d *(n-1))
'''

'''
#6089
a, r, n = map(int, input().split())
print(a*(r ** (n-1)))
'''

'''
#6090
a, m, d, n = map(int, input().split())

sum = 0
for i in range(1, n-1):
    sum += (m**i) * d

if n == 1 :
    print(a)
else :
    print((m**(n-1)) * a + sum + d)
'''

#6091
a, b, c = map(int, input().split())
d = 1
while d % a != 0 or d % b != 0 or d % c != 0 :
    d+=1
print(d)