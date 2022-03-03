'''
N = int(input())
plans = input().split()
x, y = 1, 1

# L,R,U,D에 따른 이동 방향

dx = [0,0,-1,1]
dy = [-1,1,0,0]
move_types = ['L','R','U','D']

# 이동계획을 하나씩 확인
for plan in plans :
    # 이동 후 좌표 구하기
    for i in range(len(move_types)):
        if plan == move_types[i]:
            nx = x + dx[i]
            ny = y + dy[i]
        
    if nx < 1 or nx > N or ny < 1 or ny > N :
        continue

    x = nx
    y = ny
    # x, y = nx, ny 와 같이도 적을 수 있음

print(x, y)
'''
N = int(input())
plans = list(input().split())

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
move_type = ['L','R','U','D']

x, y = 1, 1

for plan in plans:
    for i in range(4):
        if plan == move_type[i]:
            nx = x + dx[i]
            ny = y + dy[i]

    if nx < 1 or nx > N or ny < 1 or ny > N :
        continue
    else :
        x = nx
        y = ny

print(x, y)