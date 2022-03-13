public class AdjacencyMatrixGraph {
    private static final int EDGE_EXIST = 1;
    private static final int EDGE_NONE = 0;

    private int     _numberOfVertices;
    private int     _numberOfEdges;
    private int[][] _adjacency;

    public AdjacencyMatrixGraph(int givenNumberOfVertices){//주어진 vertex갯수로 이루어진 그래프 생성 Adjacency2차행렬 형태로 생성해준다.
        this.setNumberOfVertices(givenNumberOfVertices);//vertex의 수를 지정
        this.setNumberOfEdges(0);//edge의 수를 지정
        this.setAdjacency(new int[givenNumberOfVertices][givenNumberOfVertices]); //그래프를 표현할 2차원 배열 생성.
        for(int tailVertex = 0; tailVertex < this.numberOfVertices(); tailVertex++){// 그래프를 2차원 배열로 선언 후 2차원 배열의 모든 Value를 0으로 바꿔준다.
            for(int headVertex=0; headVertex < this.numberOfVertices(); headVertex++){
                this.adjacency()[tailVertex][headVertex] = AdjacencyMatrixGraph.EDGE_NONE;
            }
        }
    }

    //public Setters & Getters>>
    public int numberOfVertices(){
        return this._numberOfVertices;
    }
    public int numberOfEdges(){
        return this._numberOfEdges;
    }
    //<<public Setters & Getters


    //private Setters & Getters>>
    private void setNumberOfVertices(int newNumberOfVertices){
        this._numberOfVertices = newNumberOfVertices;
    }
    private void setNumberOfEdges(int newNumberOfEdges){
        this._numberOfEdges = newNumberOfEdges;
    }
    private int[][] adjacency(){
        return this._adjacency;
    }
    private void setAdjacency(int[][] newAdjacency){
        this._adjacency = newAdjacency;
    }
    //<<private Setters & Getters
    //setter와 getter중 private으로 선언한 것들
    //이유 : 다른 클래스에서 조작하여 관련된 변수들을 재설정 하지 못하도록 하기위함이다.


    private boolean adjacencyOfEdgeDoesExist(int tailVertex, int headVetex){
        return(this.adjacency()[tailVertex][headVetex] != AdjacencyMatrixGraph.EDGE_NONE);
    }
    //adjacency 2차원 배열내에 value가 1이면 true를 반환하고, 0이면 false를 반환한다.

    public boolean vertexDoesExist(int aVertex){
        return(aVertex >= 0 && aVertex < this.numberOfVertices());
    }
    //배열의 인덱스를 고려하여 주어진 Vertex의 갯수에서 1을 뺀 범위 즉 최소 0개 ~ 최대 (numberOfVertices-1)개

    public boolean edgeDoesExist(Edge anEdge){
        if(anEdge != null){
            int tailVertex = anEdge.tailVertex();
            int headVertex = anEdge.headVertex();
            if(this.vertexDoesExist(tailVertex) && this.vertexDoesExist(headVertex)){
                return(this.adjacencyOfEdgeDoesExist(tailVertex,headVertex));
            }
        }
        return false;
    }
    //Edge의 객체 anEdge 선언 후 tailVertex와 headVertex를 선언한다.
    // 그 뒤에 Vertex들의 유효성을 검사 후 True가 반환되면 adjacency배열의 value에 따라 true or false를 반환함으로써 Edge들의 이웃관계를 확인한다.

    public boolean addEdge(Edge anEdge){
        if(anEdge != null){ //주어진 Edge 객체가 비어있지 않은지 확인한다.
            int tailVertex = anEdge.tailVertex();
            int headVertex = anEdge.headVertex();
            if(this.vertexDoesExist(tailVertex) && this.vertexDoesExist(headVertex)){ //edge에 의해 연결될 Vertex들이 유효한지 확인한다.
                if(!this.adjacencyOfEdgeDoesExist(tailVertex,headVertex)){//Vertex가 유효하다면, 그 Vertex간에 Edge가 존재하는지 확인한다. 이유는 이미 존재하면 넣지않아도 되기 때문.
                    this.adjacency()[tailVertex][headVertex] = AdjacencyMatrixGraph.EDGE_EXIST;
                    this.adjacency()[headVertex][tailVertex] = AdjacencyMatrixGraph.EDGE_EXIST; // 만일 Edge를 삽입한다면 그래프의 행렬이 대칭성인것을 고려하여 인덱스가 바뀌는 것도 생각하여 두개의 배열값을 1로 바꿔준다.
                    this.setNumberOfEdges((this.numberOfEdges()+1));// Edge가 삽입되었으므로 Edge의 수를 늘려준다.
                    return true;//일련의 과정 실행후 true 반환
                }
            }
        }
        return false;//제어문에 의하여 한가지라도 맞지 않았다면 false를 반환.
    }
}
