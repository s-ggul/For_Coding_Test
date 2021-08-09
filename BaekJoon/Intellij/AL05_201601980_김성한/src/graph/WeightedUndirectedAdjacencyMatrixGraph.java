package graph;

public class WeightedUndirectedAdjacencyMatrixGraph<WE extends WeightedEdge> extends  UndirectedAdjacencyMatrixGraph<WE>
implements  SupplementForWeightedGraph<WE>{
// UndirectedAdjacencyMatrixGraph 클래스를 상속받고 있으며, SupplementForWeightedGraph 인터페이스의 공개함수를 overriding 해야함.
    private static final int WEIGHTED_EDGE_NONE = -1;

    private void setWeightOfEdge(int aTailVertex, int aHeadVertex, int newWeight){
        this.adjacency()[aTailVertex][aHeadVertex] = newWeight;
    }
    //상속받은 UndirectedAdjacencyMatrixGraph 클래스의 인스턴스 변수 adjacency 배열의 value를 새로운 weight로 할당하는 setter

    private void setWeightOfEdgeAsNone(int aTailVertex, int aHeadVertex){
        this.setWeightOfEdge(aTailVertex, aHeadVertex, WeightedUndirectedAdjacencyMatrixGraph.WEIGHTED_EDGE_NONE);
    }
    //상속받은 UndirectedAdjacencyMatrixGraph 클래스의 인스턴스 변수 adjacency 배열의 value를 weight = 0으로 할당

    //생성자
    public WeightedUndirectedAdjacencyMatrixGraph(int givenNumberOfVertices){
        super();//상속받은 부모클래스인 UndirectedAdjacencyMatrixGraph 클래스의 생성자를 호출. 기본생성자 호출로 객체를 생성한다.
        this.setNumberOfVertices(givenNumberOfVertices);//vertex의 수를 지정
        this.setNumberOfEdges(0);//edge의 수를 지정
        this.setAdjacency(new int[givenNumberOfVertices][givenNumberOfVertices]); //그래프를 표현할 2차원 배열 생성.
        for(int tailVertex = 0; tailVertex < this.numberOfVertices(); tailVertex++){// 그래프를 2차원 배열로 선언 후 2차원 배열의 모든 Value를 0으로 바꿔준다.
            for(int headVertex=0; headVertex < this.numberOfVertices(); headVertex++){
                this.setWeightOfEdgeAsNone(tailVertex, headVertex);
            }
        }
    } // 해당생성자는 부모클래스인 UndirectedAdjacencyMatrixGraph 클래스의 객체를 생성하고 해당 객체의 인스턴스 변수들을 초기화하고 있다.



    @Override
    protected boolean adjacencyOfEdgeDoesExist(int aTailVertex, int aHeadVertex){
        return (this.adjacencyOfEdge(aTailVertex,aHeadVertex) != WeightedUndirectedAdjacencyMatrixGraph.WEIGHTED_EDGE_NONE);
        //adjacency 2차원 배열내에 value가 0이 아니면 true를 반환하고, 0이면 false를 반환한다.
    }
    //protected로 선언되었다는 것은 타 클래스에서 수정이 될 경우가 있는경우 사용된다.
    // 이때 부모클래스인 UndirectedAdjacencyMatrixGraph 클래스에서 adjacencyOfEdgeDoesExist함수가 protected로 선언되었으며 해당 클래스에서 필요에 맞게 재설정하는 모습을 볼 수 있다.

    // 공개함수의 구현

    @Override
    public int weightOfEdge(WE anEdge) { //edge의 weight를 리턴한다.
        if(anEdge != null){ //Edge객체가 null이 아니면 해당 edge의 weight를 반환한다.
            return this.weightOfEdge(anEdge.tailVertex(), anEdge.headVertex());
        }
        return WeightedUndirectedAdjacencyMatrixGraph.WEIGHTED_EDGE_NONE;//edge객체가 null인경우 0을 반환
    }

    @Override
    public int weightOfEdge(int aTailVertex, int aHeadVertex) { // 주어진 vertex의 edge가 존재하면 해당 배열의 value를 반환한다.
        if(this.edgeDoesExist(aTailVertex, aHeadVertex)){
            return this.adjacencyOfEdge(aTailVertex,aHeadVertex);
        }
        return  WeightedUndirectedAdjacencyMatrixGraph.WEIGHTED_EDGE_NONE;//존재하지 않을 시 0을 반환한다.
    }

    @Override
    public boolean addEdge(WE anEdge) { //그래프에 추가하는 Edge의 타입이 바뀌었다. 기존 : Edge -> 변경 : WeightedEdge
        if(anEdge != null){
            if(this.edgeIsValid(anEdge) && !this.edgeDoesExist(anEdge)){
                int tailVertex = anEdge.tailVertex();
                int headVertex = anEdge.headVertex();
                this.setWeightOfEdge(tailVertex,headVertex,anEdge.weight());
                this.setWeightOfEdge(headVertex,tailVertex, anEdge.weight());
                this.setNumberOfEdges(this.numberOfEdges()+1);
                return true;
                }
            }
        return false;
        }
    } // Edge의 타입이 바뀜으로 인해 addEdge 함수를 override해준다.

