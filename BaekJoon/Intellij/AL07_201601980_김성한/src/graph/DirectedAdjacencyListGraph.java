package graph;

import list.Iterator;
import list.LinkedList;

public class DirectedAdjacencyListGraph<E extends Edge> extends AdjacencyGraph<E> {
    private LinkedList<E>[] _adjacency;

    protected LinkedList<E>[] adjacency(){
        return this._adjacency;
    }
    protected void setAdjacency(LinkedList<E>[] newAdjacency){
        this._adjacency = newAdjacency;
    }

    protected LinkedList<E> neighborListOf(int aTailVertex){
        return this.adjacency()[aTailVertex];
    }

    protected int adjacencyOfEdge(int aTailVertex, int aHeadVertex){
        if(this.vertexDoesExist(aTailVertex) && this.vertexDoesExist(aHeadVertex)){
            Iterator<E> iterator = this.neighborIteratorOf(aTailVertex);
            while(iterator.hasNext()){
                E neighborEdge = iterator.next();
                if(aHeadVertex == neighborEdge.headVertex()){
                    return AdjacencyGraph.EDGE_EXIST;
                }
            }
        }
        return AdjacencyGraph.EDGE_NONE;
    }

    public DirectedAdjacencyListGraph(int givenNumberOfVertices){
        this.setNumberOfVertices(givenNumberOfVertices);
        this.setAdjacency(new LinkedList[givenNumberOfVertices]);
        for(int tailVertex = 0; tailVertex < this.numberOfVertices(); tailVertex++){
            this.adjacency()[tailVertex] = new LinkedList<E>();
        }
        this.setNumberOfEdges(0);
    }

    @Override
    public boolean edgeDoesExist(int aTailVertex, int aHeadVertex) {
        return (this.adjacencyOfEdge(aTailVertex,aHeadVertex)!= AdjacencyGraph.EDGE_NONE);
    }

    @Override
    public boolean edgeDoesExist(E anEdge) {
        if(anEdge != null){
            return this.edgeDoesExist(anEdge.tailVertex(), anEdge.headVertex());
        }
        return false;
    }

    public E edge(int aTailVertex, int aHeadVertex){
        if(this.vertexDoesExist(aTailVertex)){
            Iterator<E> iterator = this.neighborIteratorOf(aTailVertex);
            while(iterator.hasNext()){
                E neighborEdge = iterator.next();
                if(aHeadVertex == neighborEdge.headVertex()){
                    return neighborEdge;
                }
            }
        }
        return null;
    }

    public boolean addEdge(E anEdge){
        if(this.edgeIsValid(anEdge)&&(! this.edgeDoesExist(anEdge))){
            this.neighborListOf(anEdge.tailVertex()).add(anEdge);
            this.setNumberOfEdges(this.numberOfEdges()+1);
            return true;
        }
        return false;
    }

    public Iterator<E> neighborIteratorOf(int aTailVertex){
        if(this.vertexDoesExist(aTailVertex)){
            return (Iterator<E>) this.adjacency()[aTailVertex].listIterator();
        }
        return null;
    }

}
