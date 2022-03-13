import java.lang.reflect.Parameter;

public class AppController {
    private AdjacencyMatrixGraph _graph;
    private Coloring          _coloring;

    private Coloring coloring(){ // Coloring 객체 getter
        return this._coloring;
    }
    private void setColoring(Coloring aColoring){ //Coloring 객체의 setter
        this._coloring = aColoring;
    }

    private AdjacencyMatrixGraph graph(){
        return this._graph;
    }

    private void setGraph(AdjacencyMatrixGraph newGraph){ // 클래스내 _graph 변수에 매개변수 그래프를 대입해준다.
        this._graph = newGraph;
    }

    public AppController(){
        this.setGraph(null);
        this.setColoring(null); // Coloring객체에 matrix를 null로 선언
    }
    // AppController의 생성자
    // AppController 객체가 생성될 때 그래프는 생성되지 않으므로 null을 넣어준다.

    private void inputAndMakeGraph(){
        AppView.outputLine("> 입력할 그래프의 vertex 수와 edge 수를 먼저 입력해야 합니다. : ");
        int numberOfVertices = this.inputNumberOfVertices();//vertex수를 입력받는다.
        this.setGraph(new AdjacencyMatrixGraph(numberOfVertices));//Adjacency 2차원 배열 생성 후 value 초기화

        int numberOfEdges = this.inputNumberOfEdges();//edge수를 입력받는다.
        AppView.outputLine("");
        AppView.outputLine("> 이제부터 edge를 주어진 수 만큼 입력합니다. ");


        int edgeCount = 0;//총 edge의 갯수를 파악해줄 변수를 하나 선언한다.
        while(edgeCount < numberOfEdges){//현재까지 입력한 edge의 갯수가 처음 설정한 총 edge의 갯수보다 작으면 아래의 코드를 실행한다.
            Edge edge = this.inputEdge(); //inputEdge()를 통해 edge를 입력받는다.
            if(this.graph().edgeDoesExist(edge)){//edge가 존재하는 지 여부를 검사하고 만약 존재하면 오류를 출력한다.
                AppView.outputLine("(오류) 입력된 edge(" +
                        edge.tailVertex() + "," + edge.headVertex()+") 는 그래프에 이미 존재합니다.");
            }
            else{//edge가 존재하지 않을 때 그래프에 새로운 edge를 추가한 후 edgecount를 1 늘려준다. 그리고 성공적으로 삽입됨을 알려준다.
                edgeCount++;
                this.graph().addEdge(edge);
                AppView.outputLine("!새로운 edge (" +
                        edge.tailVertex() + "," + edge.headVertex() + ") 가 그래프에 삽입되었습니다.");
            }
        }
    }

    private void showGraph(){ //Graph를 화면상에 보여준다.
        AppView.outputLine("");
        AppView.outputLine("> 입력된 그래프는 다음과 같습니다. : ");
        for(int tailVertex = 0;tailVertex < this.graph().numberOfVertices(); tailVertex++){
            AppView.output("["+tailVertex+"] ->"); //tailVertex에 해당하는 vertex값 표시
            for (int headVertex = 0; headVertex < this.graph().numberOfVertices(); headVertex++){
                if(this.graph().edgeDoesExist(new Edge(tailVertex,headVertex))){ //인접하는 headVertex 출력전 tailVertex에 접합되는 Edge가 존재하는지를 확인해준다.
                    AppView.output(" " + headVertex);//tailVertex에 인접하는 headVertex값 표시
                }
            }
            AppView.outputLine("");
        }
    }

    private int inputNumberOfVertices () {//vertex의 수를 입력받는 함수.
        while ( true ) {
            AppView.output ("? Vertex 수를 입력하시오: ") ;
            try {
                int numberOfVertices = AppView.inputNumberOfVertices();//AppView클래스 내부 함수를 통해 입력을 받는다.
                if ( numberOfVertices < 1 ) {//vertex의 수가 1보다 작으면(= 0이하의 수를 입력했을때)
                    AppView.output ("[오류] Vertex 수는 0 보다 커야 합니다.") ;
                }
                return numberOfVertices ;//vertex의 갯수가 1이상이면 갯수를 리턴하면서 종료한다.
            }
            catch (NumberFormatException e) {
                AppView.outputLine ("[오류] 올바른 숫자가 입력되지 않았습니다.");
            }
        }
    }

    private int inputNumberOfEdges () {//edge의 수를 입력받는 함수.
        while ( true ) {
            AppView.output ("? Edge 수를 입력하시오: ") ;
            try {
                int numberOfEdges = AppView.inputNumberOfEdges();//AppView클래스 내부 함수를 통해 입력을 받는다.
                if ( numberOfEdges < 0 ) {//edge의 수가 0보다 작으면(=음수를 입력했을때)
                    AppView.output ("[오류] Edge 수는 0 보다 크거나 같아야 합니다.") ;
                }
                else {
                    return numberOfEdges ;//edge의 갯수가 0이상이면 갯수를 리턴하면서 종료한다.
                }
            }
            catch (NumberFormatException e) {
                AppView.outputLine ("[오류] 올바른 숫자가 입력되지 않았습니다.") ;
            }
        }
    }

    private Edge inputEdge(){//edge를 입력해주는 함수.
        do{
            AppView.outputLine("- 입력할 edge의 두 vertex를 차례로 입력해야 합니다. : ");
            int tailVertex = AppView.inputTailVertex();//tailVertex를 입력받는다.
            int headVertex = AppView.inputHeadVertex();//headVertex를 입력받는다.
            if(this.graph().vertexDoesExist(tailVertex) && this.graph().vertexDoesExist(headVertex)){//입력받은 두 Vertex가 모두 존재하는지 여부를 검사한다.
                if(tailVertex == headVertex){//두 Vertex가 존재할때 두 Vertex의 값이 같다면 오류출력
                    AppView.outputLine("[오류] 두 vertex 번호가 동일합니다.");
                }
                else{//두 Vertex가 존재할때 두 Vertex가 값이 다르다면 새로운 edge를 추가한다.
                    return (new Edge(tailVertex,headVertex));//새로운 edge 추가.
                }
            }
            else {//만일 하나라도 존재하지 않는다면 경우에 따라 아래의 조건문 실행
                if(! this.graph().vertexDoesExist(tailVertex)){//tailvertex가 존재하지 않을때.
                    AppView.outputLine("[오류] 존재하지 않는 tail vertex 입니다. : " + tailVertex);
                }
                if(! this.graph().vertexDoesExist(headVertex)){//headvertex가 존재하지 않을때
                    AppView.outputLine("[오류] 존재하지 않는 head vertex 입니다. : " + headVertex);
                }
            }
        }while(true);
    }

    private void showColoring(){ //vertex의 컬러를 보여주는 함수
        AppView.outputLine("");
        AppView.outputLine("> 각 vertex에 칠해진 색깔은 다음과 같습니다. : ");
        for(int vertex = 0; vertex < this.graph().numberOfVertices(); vertex++){
            AppView.outputLine("["+vertex+"]" + this.coloring().vertexColor(vertex).name());
            //enum 라이브러리 name()을 이용해 색깔 호출
        }

        AppView.outputLine("");
        AppView.outputLine("> 양 끝 vertex의 색깔이 같은 edge들은 다음과 같습니다.");

        if(this.coloring().sameColorEdges().size() == 0){ //sameColorEdge 연결리스트의 크기가 0인경우
            AppView.outputLine("!! 모든 edge의 양 끝 vertex의 색깔이 다릅니다.");
        }
        else{// sameColorEdge 연결리스트의 크기가 0아닌 경우
            LinkedList<Edge>.IteratorForLinkedList iterator = this.coloring().sameColorEdges().iterator();
            // 현재 Coloring객체의 sameColorEdge 연결리스트의 iterator를 할당 초기 iterator는 head를 가리킴
            while(iterator.hasNext()){ // iterator의 next가 존재하면
                Edge currentEdge = iterator.next(); //현재 edge 객체에 iterator.next의 edge를 할당 그후에 현재 가리키는 노드를 다음노드로 바꿔줌.
                AppView.output("("+currentEdge.tailVertex() + ","+ currentEdge.headVertex()+"):");
                AppView.outputLine(" " + this.coloring().vertexColor(currentEdge.tailVertex()).name());
            }
        }
    }


    public void run(){
        AppView.outputLine("<<< 그래프 색칠하기를 시작합니다 >>>");
        this.inputAndMakeGraph();
        this.showGraph();

        this.setColoring(new Coloring(this.graph()));
        this.coloring().runColoring();
        this.showColoring();

        AppView.outputLine("");
        AppView.outputLine("<<< 그래프 색칠하기를 종료합니다 >>>");
    }
    // AppView가 final 클래스 이므로 객체를 생성할 필요가 없이 바로 AppView 클래스의 함수를 불러올 수 있다.
}
