package graph;

public class Edge {
    private int _tailVertex;
    private int _headVertex;

    public Edge(int givenTailVertex, int givenHeadVertex){
        this.setTailVertex(givenTailVertex);
        this.setHeadVertex(givenHeadVertex);
    }
    //주어진 tailvertex와 headvertex를 갖는 edge객체를 얻는다.
    //그 후 Setters를 이용하여 tailVertex와 headVertex의 값을 객체 생성시 주어진 매개변수들로 설정한다.

    public void setTailVertex(int newTailVertex){
        this._tailVertex = newTailVertex;
    }
    public int tailVertex(){
        return this._tailVertex;
    }

    public void setHeadVertex(int newHeadVertex){
        this._headVertex = newHeadVertex;
    }
    public int headVertex(){
        return this._headVertex;
    }
}
