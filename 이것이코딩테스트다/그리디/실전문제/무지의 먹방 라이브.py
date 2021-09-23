#나의 풀이
def solution(food_times, k):
    index = 0
    count = 0
    l = len(food_times)

    while True :
        if index == l:
            index = 0

        if count == k:
            break
        
        if food_times[index] == 0:
            index += 1
            continue
        else:
            food_times[index] -= 1
            index += 1
            count += 1
        
    return (index + 1)