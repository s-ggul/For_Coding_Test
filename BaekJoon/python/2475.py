data = list(map(int,input().split()))

sum = 0

for num in data :
    sum += num * num

print(sum%10)