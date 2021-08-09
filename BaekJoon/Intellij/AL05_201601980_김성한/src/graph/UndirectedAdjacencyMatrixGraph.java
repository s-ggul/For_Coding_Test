package graph;

public class UndirectedAdjacencyMatrixGraph<E extends Edge> implements Graph<E>  {
    private static final int EDGE_EXIST = 1;
    private static final int EDGE_NONE = 0;

    private int     _numberOfVertices;
    private int     _numberOfEdges;
    private int[][] _adjacency;

    //public Setters & Getters>>
    public int numberOfVertices(){
        return this._numberOfVertices;
    }
    public int numberOfEdges(){
        return this._numberOfEdges;
    }
    //<<public Setters & Getters


    //protected Setters & Getters>>
    protected void setNumberOfVertices(int newNumberOfVertices){
        this._numberOfVertices = newNumberOfVertices;
    }
    protected void setNumberOfEdges(int newNumberOfEdges){
        this._numberOfEdges = newNumberOfEdges;
    }
    protected int[][] adjacency(){
        return this._adjacency;
    }
    protected void setAdjacency(int[][] newAdjacency){
        this._adjacency = newAdjacency;
    }
    //<<protected Setters & Getters

    protected int adjacencyOfEdge(int tailVertex, int headVertex){
        return this.adjacency()[tailVertex][headVertex];
    }
    protected void setAdjacencyOfEdgeAs(int tailVertex, int headVertex, int anAdjacencyOfEdges){
        this.adjacency()[tailVertex][headVertex] = anAdjacencyOfEdges;
    }
    private void setAdjacencyOfEdgeAsExist(int tailVertex, int headVertex){
        this.setAdjacencyOfEdgeAs(tailVertex, headVertex, UndirectedAdjacencyMatrixGraph.EDGE_EXIST);
    }
    protected void setAdjacencyOfEdgeAsNone(int tailVertex, int headVertex){
        this.setAdjacencyOfEdgeAs(tailVertex, headVertex, UndirectedAdjacencyMatrixGraph.EDGE_NONE);
    }


    protected UndirectedAdjacencyMatrixGraph(){

    }

    //생성자
    public UndirectedAdjacencyMatrixGraph(int givenNumberOfVertices){//주어진 vertex갯수로 이루어진 그래프 생성 Adjacency2차행렬 형태로 생성해준다.
        this.setNumberOfVertices(givenNumberOfVertices);//vertex의 수를 지정
        this.setNumberOfEdges(0);//edge의 수를 지정
        this.setAdjacency(new int[givenNumberOfVertices][givenNumberOfVertices]); //그래프를 표현할 2차원 배열 생성.
        for(int tailVertex = 0; tailVertex < this.numberOfVertices(); tailVertex++){// 그래프를 2차원 배열로 선언 후 2차원 배열의 모든 Value를 0으로 바꿔준다.
            for(int headVertex=0; headVertex < this.numberOfVertices(); headVertex++){
                this.setAdjacencyOfEdgeAsNone(tailVertex, headVertex);
            }
        }
    }



    protected boolean adjacencyOfEdgeDoesExist(int tailVertex, int headVetex){
        return(this.adjacency()[tailVertex][headVetex] != UndirectedAdjacencyMatrixGraph.EDGE_NONE);
    }
    //adjacency 2차원 배열내에 value가 0이 아니면 true를 반환하고, 0이면 false를 반환한다.


    //인터페이스 Graph의 공개함수 구현

    @Override
    public boolean vertexDoesExist(int aVertex) {
        return(aVertex >= 0 && aVertex < this.numberOfVertices());
    }
    //해당 vertex가 존재하는지 즉 vertex의 인덱스번호를 총 vertex의 수와 비교하여 존재하는지 판단한다.


    @Override
    public boolean edgeDoesExist(int aTailVertex, int aHeadVertex) {
        if(this.edgeIsValid(aTailVertex,aHeadVertex)){
            return (this.adjacencyOfEdgeDoesExist(aTailVertex,aHeadVertex));
        }
        return false;
    }//입력받은 edge가 유효한지 판단하고 해당 배열의 value가 0이 아니면 boolean값 True를 반환한다.

    @Override
    public boolean edgeDoesExist(E anEdge) {
        if(anEdge != null){
            return this.edgeDoesExist(anEdge.tailVertex(), anEdge.headVertex());
        }
        return false;
    } // Edge 객체가 null이 아니면 true, null이면 false를 반환

    @Override
    public boolean edgeIsValid(int aTailVertex, int aHeadVertex) {
        return (this.vertexDoesExist(aTailVertex) && this.vertexDoesExist(aHeadVertex));
    } //edge의 유효성을 검사한다. 해당 vertex들이 존재하는지 검사하고 존재한다면 true반환.

    @Override
    public boolean edgeIsValid(E anEdge) {
        if(anEdge != null){
            return(this.edgeIsValid(anEdge.tailVertex(), anEdge.headVertex()));
        }
        return false;
    } //Edge객체가 유효한지 검사한다. Edge객체가 null이 아니라면 해당 vertex들을 비교하고 존재한다면 true를 반환한다.



    @Override
    public E edge(int aTailVertex, int aHeadVertex) {
        if(this.edgeDoesExist(aTailVertex,aHeadVertex)){
            return (E) new Edge(aTailVertex, aHeadVertex);
        }
        return null;
    }
    //주어진 vertex들에 해당하는 edge를 얻는함수이다.

    @Override
    public boolean addEdge(E anEdge) { //생성된 edge객체를 matrix에 추가하는 함수
        if(anEdge != null){
            if(this.edgeIsValid(anEdge) && !this.edgeDoesExist(anEdge)){
                //edge가 유효할 수 있는지 그리고 현재 주어진 edge가 이미 존재하지는 않는지 검사한다.
                int tailVertex = anEdge.tailVertex();
                int headVertex = anEdge.headVertex();
                this.setAdjacencyOfEdgeAsExist(tailVertex,headVertex);
                this.setAdjacencyOfEdgeAsExist(headVertex,tailVertex);
                //undirectedgraph이므로 방향성이 없다. 따라서 tailvertex와 headvertex에 대하여 서로를 이어주는 edge를 두개 선언한다.
                this.setNumberOfEdges(this.numberOfEdges()+1);//edge의 수를 1개 늘려준다.
                return true;
            }
        }
        return false;
    }
}
