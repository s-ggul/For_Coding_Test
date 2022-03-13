package graph;

import list.Iterator;

public interface Graph<E> { //Generic 타입을 사용하여 Graph 인터페이스 선언
    //공개함수들의 구현 -> 추후에 상속받는 클래스에서 overriding 하여 사용할 예정이다.
    public int numberOfVertices();
    public int numberOfEdges();

    public boolean vertexDoesExist(int aVertex);
    public boolean edgeDoesExist(int aTailVertex, int aHeadVertex);
    public boolean edgeDoesExist(E anEdge);

    public boolean edgeIsValid(int aTailVertex, int aHeadVertex);
    public boolean edgeIsValid(E anEdge);


    public E edge(int aTailVertex, int aHeadVertex);
    public boolean addEdge(E anEdge);

    public Iterator<E> neighborIteratorOf(int aTailVertex);
}
