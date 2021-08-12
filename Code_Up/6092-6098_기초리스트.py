'''
#6092
num = int(input())
l = input().split()
result = [0 for _ in range(23)] 

for i in range(num) :
    result[int(l[i])-1] += 1

for i in range(len(result)):
    print(result[i],end=' ')
'''

'''

#6093
num = int(input())
l = input().split()
for i in range(num-1,-1,-1):
    print(l[i],end=' ')
'''

'''
#6094
num = int(input())
l = map(int,input().split())
print(min(l))
'''

'''
#6095
num = int(input())
result = [[0 for _ in range(20)] for _ in range(20)]

for i in range(num):
    x, y = map(int, input().split())
    result[x-1][y-1] = 1

for i in range(19):
    for j in range(19):
        print(result[i][j], end=' ') 
    if(i!=19):
        print()
'''


'''
!!!
1. arr[i] 하나씩 입력받기
for i in range(B):    
	arr[i] = list(map(int, input().split()))

2. arr 에 한 list씩 append 하기
for i in range(B):    
	arr.append(list(map(int, input().split())))


3. 선언과 동시에 입력받기
arr = [list(map(int, input().split())) for _ in range(B)]    
'''
'''
#6096
board = [list(map(int, input().split())) for _ in range(19)]
num = int(input())

for _ in range(num):
    x, y = map(int, input().split())
    x -= 1
    y -= 1
    
    for i in range(19):
            if board[i][y] == 0 :
                board[i][y] = 1
            else:
                board[i][y] = 0
    for i in range(19):
        if board[x][i] == 0:
            board[x][i] = 1
        else :
            board[x][i] = 0

for i in range(19):
    for j in range(19):
        print(board[i][j], end=' ')
    print()
'''

'''
#6097
h, w = map(int,input().split())
n = int(input())
board = [[0 for _ in range(w)] for _ in range(h)]
for _ in range(n):
    l, d, x, y = map(int, input().split())
    x -= 1
    y -= 1

    board[x][y] = 1
    if d == 0 :
        for i in range(1,l):
            board[x][y+i] = 1

    else : 
        for i in range(1,l):
            board[x+i][y] = 1

for row in range(h):
    for col in range(w):
        print(board[row][col], end=' ')
    print()    
'''

#6098
board = [list(map(int,input().split())) for _ in range(10)]
startX = 1
startY = 1
board[startX][startY] = 9
while(True):
    if board[startX][startY+1] == 0 :
        board[startX][startY+1] = 9
        startY += 1
    elif board[startX+1][startY] == 0:
        board[startX+1][startY] = 9
        startX += 1
    elif board[startX+1][startY] == 2 :
        board[startX+1][startY] = 9
        break
    elif board[startX][startY+1] == 2:
        board[startX][startY+1] = 9
        break
    else : 
        break

for i in range(10):
    for j in range(10):
        print(board[i][j], end=' ')
    print()