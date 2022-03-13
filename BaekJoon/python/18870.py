num = int(input())
data = list(map(int, input().split()))

sorted_data = sorted(list(set(data)))
dic = {sorted_data[i] : i for i in range(len(sorted_data))}

for val in data:
    print(dic[val], end=' ')

# sort 문제와 관련하여 람다식 사용법 익히기
# dictionary를 활용한 참조에는 O(1) 상수시간 가능