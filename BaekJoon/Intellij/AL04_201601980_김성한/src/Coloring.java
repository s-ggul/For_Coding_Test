public class Coloring {
    private AdjacencyMatrixGraph _graph;
    private VertexColor[]        _vertexColor; //각 vertex의 color를 저장

    private int _startingVertex;
    private LinkedList<Edge> _sameColorEdges; // 끝 색이 같은 Edge들의 List
    // getter & setter >>
    private AdjacencyMatrixGraph graph() {
        return this._graph;
    }

    private void setGraph(AdjacencyMatrixGraph newGraph) {
        this._graph = newGraph;
    }

    private int startingVertex() {
        return this._startingVertex;
    }

    private void setStartingVertex(int newVertex) {
        this._startingVertex = newVertex;
    }

    private VertexColor[] vertexColor() {
        return this._vertexColor;
    }

    private void setVertexColor(VertexColor[] newVertexColors) {
        this._vertexColor = newVertexColors;
    }

    public VertexColor vertexColor(int aVertex){
        return this.vertexColor()[aVertex];
    }

    private void setVertexColor(int aVertex, VertexColor newColor){
        this.vertexColor()[aVertex] = newColor;
    }

    public LinkedList<Edge> sameColorEdges() {
        return this._sameColorEdges;
    }

    private void setSameColorEdges(LinkedList<Edge> newLinkedList) {
        this._sameColorEdges = newLinkedList;
    }
    // << getter & setter

    public Coloring(AdjacencyMatrixGraph givenGraph){ //생성자
        this.setGraph(givenGraph); //주어진 그래프를 인스턴스 그래프로 설정
        this.setVertexColor(new VertexColor[this.graph().numberOfVertices()]);
        //vertexColor를 저장할 배열 선언.

        for(int vertex = 0; vertex < this.graph().numberOfVertices(); vertex++){
            this.setVertexColor(vertex, VertexColor.NONE);
        }
        //반복문을 이용해서 vertexColor 배열의 value를 None으로 초기화.

        this.setSameColorEdges(new LinkedList<Edge>()); // sameColorEdge Linkedlist를 선언
        this.setStartingVertex(0);// 처음 시작 vertex를 0으로 초기화
    }

    public void runColoring(){ //전반적인 Coloring을 수행하는 함수 인스턴스 함수 두개를 포함한다.
        this.paintColorsOfVertices();
        this.findSameColorEdges();
    }

    public void paintColorsOfVertices(){ // 너비우선 탐색을 이용하여 vertex를 색칠함.
        this.setVertexColor(this.startingVertex(),VertexColor.RED);
        //처음 시작하는 vertex의 color를 Red로 설정
        CircularQueue<Integer> breadthFirstSearchQueue =
                new CircularQueue<Integer>(this.graph().numberOfVertices());
        breadthFirstSearchQueue.add(this.startingVertex());
        // Integer만을 저장하는 circularQueue 객체를 선언하고 startingVertex를 추가해준다.
        while(! breadthFirstSearchQueue.isEmpty()){ // 원형큐가 공백이 아닐때
            int tailVertex = breadthFirstSearchQueue.remove();
            //tailVertex에 현재 front가 가리키는 값을 할당
            VertexColor headVertexColor = (this.vertexColor(tailVertex) == VertexColor.RED)
                    ? VertexColor.BLUE : VertexColor.RED; //해당 값의 컬러가 RED 이면 Blue를 아니면 Red 를 할당함.
            for(int headVertex = 0; headVertex < this.graph().numberOfVertices(); headVertex++){
                Edge visitingEdge = new Edge(tailVertex,headVertex);
                // 현재 front가 가리키는 vertex가 이웃하는 headVertex들에 대하여 Edge 객체 생성
                if(this.graph().edgeDoesExist(visitingEdge)){ //만일 해당 edge가 그래프에 존재한다면
                    if(this.vertexColor(headVertex) == VertexColor.NONE){ // 만일 edge가 존재할때 headVertex의 컬러가 존재하지 않는다면
                        this.setVertexColor(headVertex, headVertexColor); // 컬러를 입혀줌.
                        breadthFirstSearchQueue.add(headVertex); // 그리곤 원형큐에 컬러를 입힌 vertex를 추가해줌.
                    }
                }
            }

        }

    }
    private void findSameColorEdges(){
        // 모든 edge를 검사하여 양끝 vertex의 컬러가 동일하면 연결리스트 sameColorEdge에 추가하여 보관한다.
        for(int tailVertex = 0; tailVertex < this.graph().numberOfVertices(); tailVertex++){
            for(int headVertex = 0; headVertex < this.graph().numberOfVertices(); headVertex++){
                Edge visitingEdge = new Edge(tailVertex, headVertex); //모든 edge를 검사하기 위해 이중 for문을 각각의 vertex별로 Edge 객체 생성
                if(this.graph().edgeDoesExist(visitingEdge)){ //만일 그래프에 해당 edge가 존재한다면
                    if(this.vertexColor(tailVertex) == this.vertexColor(headVertex)){ // 만일 tailVertex의 색깔과 headVetex의 색깔이 동일하다면
                        this.sameColorEdges().add(visitingEdge); // 연결리스트 sameColorEdge에 해당 edge를 추가해준다.
                    }
                }
            }
        }
    }

}
