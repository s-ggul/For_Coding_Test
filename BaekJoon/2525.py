h, m = map(int,input().split())
time = int(input())

totalMinute = m + time

if totalMinute > 59 :
    m = totalMinute % 60
    h += totalMinute // 60
else:
    m = totalMinute

if h > 23 :
    h %= 24

print(h, m)