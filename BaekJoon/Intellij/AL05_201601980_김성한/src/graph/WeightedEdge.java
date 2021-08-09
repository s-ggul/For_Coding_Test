package graph;

public class WeightedEdge extends Edge implements Comparable<WeightedEdge> {
    //Edge에 weight 속성만 부여하여 사용하기 위해 Edge 클래스를 상속받고 Comparable<WeightedEdge> 인터페이스를 상속받는데 이때
    //Generic 타입 <T>는 WeightedEdge 객체들과의 비교를 위해 <WeigtedEdge>로 설정해준다.
    private static final int DEFAULT_WEIGHT = 0; //
    private int _weight;

// getter & setter >>
    public int weight() {
        return this._weight;
    }

    public void setWeight(int newWeight) {
        this._weight = newWeight;
    }
// << getter & setter

    // 생성자 목록 : 두개의 생성자를 선언한다.
    public WeightedEdge(int givenTailVertex, int givenHeadVertex){ //클래스 생성자 tailvertex와 headVertex의 인덱스값을 매개변수로 가진다.
        super(givenTailVertex, givenHeadVertex); // 상속받는 클래스의 생성자는 super클래스의 생성자 중 하나를 반드시 call해야 하며 하지 않으면 기본 생성자를 call한 것으로 간주한다.
        this.setWeight(WeightedEdge.DEFAULT_WEIGHT); // 생성한 edge 객체의 weight 가 입력된 값이 없으므로 weight에 0을 할당
    }

    public WeightedEdge(int givenTailVertex, int givenHeadVertex, int givenWeight){ // weight를 같이 입력받는 경우의 생성자
        super(givenTailVertex, givenHeadVertex); // 부모클래스의 객체를 생성한다.
        this.setWeight(givenWeight); //입력받은 값으로 weight를 할당한다.
    }

    @Override
    public int compareTo(WeightedEdge otherEdge) { //인터페이스 Comparable의 공개함수
        if(this.weight() < otherEdge.weight()){ //현재 객체의 weight가 타객체의 weight보다 작은경우 -1을 반환
            return -1;
        }
        else if(this.weight() > otherEdge.weight()){ // 현재 객체의 weight가 타객체의 weight보다 큰 경우 +1을 반환
            return +1;
        }
        else{ //두 객체의 weight가 같은경우 0을 반환
            return 0;
        }
    }
}
