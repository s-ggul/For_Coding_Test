package graph;

public interface SupplementForWeightedGraph<E> {
    //공개함수 선언
    public int weightOfEdge(E anEdge);
    public int weightOfEdge(int aTailVertex, int aHeadVertex);
}
