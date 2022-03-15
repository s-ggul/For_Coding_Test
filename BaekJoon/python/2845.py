L, P = map(int, input().split())
data = list(map(int, input().split()))

totalPeople = L * P 
for num in data:
    print(num - totalPeople,end=' ')