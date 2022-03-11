'''
input_data = input()
row = int(input_data[1])
column = int(ord(input_data[0])) - int(ord('a')) + 1

# 나이트가 이동할 수 있는 8개의 방향 정의

steps = [(-2, -1), (-1, -2), (1, -2), (2, -1), (2, 1), (1, 2), (-1, 2), (-2, 1)]

result = 0
for step in steps :
    #이동하고자 하는 위치 확인
    next_row = row + step[0]
    next_column = column + step[1]

    # 해당 위치로 이동가능한 경우 카운트 증가

    if next_row >= 1 and next_row <= 8 and next_column >= 1 and next_column <= 8 :
        result += 1

print(result)
'''

input_data = input()
row = int(input_data[1])
column = int(ord(input_data[0]) - int(ord('a')) + 1)

steps = [(-2, -1), (-2, 1), (-1, -2), (-1, 2), (1, -2), (1, 2), (2, 1), (2, -1)]

result = 0
for step in steps : 
    next_row = row + step[0]
    next_col = column + step[1]

    if next_row < 1 or next_row > 8 or next_col < 1 or next_col > 8 :
        continue

    result += 1

print(result)