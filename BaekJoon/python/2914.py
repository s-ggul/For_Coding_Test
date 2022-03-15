a, i = map(int, input().split())

current = a * i
currentI = current / a

while True:
    current -= 1
    currentI = current / a

    if currentI <= i-1:
        current += 1
        break
    
    
print(current)