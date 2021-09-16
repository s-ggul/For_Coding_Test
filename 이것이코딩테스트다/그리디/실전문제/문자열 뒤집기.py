#나의 풀이
numString = list(map(int,input()))

count = 0

numOfZeroGroup = 0 
numOfOneGroup = 0
# 1과 0 각각으로 이루어진 그룹의 최솟값 출력하도록 결정.

for i in range(len(numString)) :
    num = numString[i]

    if num == 1:
        if i != 0 and num == numString[i-1] :
            continue
        else:
            numOfOneGroup += 1

    else:
        if i != 0 and num == numString[i-1] :
            continue
        else:
            numOfZeroGroup += 1

print(min(numOfOneGroup,numOfZeroGroup))
          
    
