def solution(phone_book):
    l = len(phone_book)
    phone_book.sort()
    
    for i in range(l-1) :    
        if phone_book[i+1].startswith(phone_book[i]) :
            return False        
    
    return True

'''
[참고]
다른 사람 코드
hash map에 다 넣고 한글자씩 비교하면서 해당부분까지와 같은 번호가 있는지를 확인 
각각의 번호의 접두사를 조금씩 길이를 늘려가며 hash_map내에서의 다른원소와 비교함.
def solution(phone_book):
    answer = True
    hash_map = {}
    for phone_number in phone_book:
        hash_map[phone_number] = 1
    for phone_number in phone_book:
        temp = ""
        for number in phone_number:
            temp += number
            if temp in hash_map and temp != phone_number:
                return False
    return answerse 
'''