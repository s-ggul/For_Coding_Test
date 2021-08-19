def solution(participant, completion):
    #해싱은 데이터를 아주 빠르게 삽입하거나 가져올때 사용하는 기법.
    result = dict()
    
    for i in range(len(participant)):
        if(participant[i] in result):
            result[participant[i]] += 1
        else:
            result[participant[i]] = 1
        
    for i in range(len(completion)) : 
        result[completion[i]] -= 1
        
    for k, v in result.items() : 
        if v != 0:
            return(k)
            break