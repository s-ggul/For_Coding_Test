data = list(map(int, input().split()))

data.sort()
diff_count = 0
same_num = 0

for i in range(len(data)-1) :
    if data[i] != data[i+1] :
        diff_count += 1
    else:
        same_num = data[i]

if diff_count == 2 : 
    result = data[len(data)-1] * 100
elif diff_count == 1 : 
    result = same_num * 100 + 1000
else : 
    result = data[i] * 1000 + 10000

print(result)

