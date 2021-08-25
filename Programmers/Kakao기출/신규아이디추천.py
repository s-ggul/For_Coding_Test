from collections import deque

def solution(new_id):
    answer =''
    # 1단계 : 소문자 변환
    new_id = new_id.lower()
    
    # 2단계 : 특수문자 제거
    for c in new_id:
        if (97 <= ord(c) <= 122) or (48 <= ord(c) <= 57) or c == '-' or c == '_' or c == '.' :
            answer += c
        else : 
            continue
    

    # 3단계 : 마침표 줄이기
    temp =''
    dq = deque()
    for c in answer:
        if c == '.':
            dq.append(c)
        else : 
            if len(dq) > 0: 
                temp += dq.pop()
                dq.clear()
            temp += c
    answer = temp  
    
    
    
    # 4단계 : 처음과 끝 마침표 제거
    if len(answer) > 0 and answer[0] == '.' :
        answer = answer[1:]
        
    if len(answer) > 0 and answer[len(answer)-1] == '.':
        answer = answer[:len(answer)-1]
    
     # 5단계 : 빈 문자열의 경우 a로 치환   
    if answer == '':
        answer = 'a'
    
    # 6단계 : 길이가 16자 이상이라면 첫 15개의 문자만 추출
    if len(answer) >= 16 :
        answer = answer[0:15]
        
    print(answer)
    
    # 6-1단계: 만일 제거 후 마침표가 끝에 있다면 제거    
    if answer[len(answer)-1] == '.':
         answer = answer[:len(answer)-1]
            
    print(answer)
    
    # 7단계 : 길이가 2자 이하라면, 길이가 3이 될때까지 마지막 문자 반복
    if len(answer) <= 2:
        addChar = answer[len(answer)-1]
        while len(answer) != 3 :
            answer += addChar
    
    # 주의: 리스트 슬라이싱 사용시 뒷구간 열린 구간인 점 기억하기.
    
    return answer