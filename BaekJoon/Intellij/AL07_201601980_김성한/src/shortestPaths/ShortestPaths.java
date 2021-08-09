package shortestPaths;

import app.AppView;
import graph.AdjacencyGraph;
import graph.SupplementForWeightedGraph;
import graph.WeightedEdge;
import list.LinkedStack;
import list.Iterator;

public class ShortestPaths<WE extends WeightedEdge> {
        private static final int UNDEFINED_SOURCE = -1;

        private static final boolean DEBUG_MODE = true;

        private static void showDebugMessage(String aMessage){
            if(DEBUG_MODE){
                AppView.outputDebugMessage(aMessage);
            }
        }

        private  AdjacencyGraph<WE> _graph;
        private  int                _source;
        private  int[]              _path;
        private  int[]              _distance;

    private AdjacencyGraph<WE> graph() {
        return this._graph;
    }

    private void setGraph(AdjacencyGraph<WE> newGraph) {
        this._graph = newGraph;
    }

    private int source() {
        return this._source;
    }

    private void setSource(int newSource) {
        this._source = newSource;
    }

    private int[] path() {
        return this._path;
    }

    private void setPath(int[] newPath) {
        this._path = newPath;
    }

    private int[] distance() {
        return this._distance;
    }

    private void setDistance(int[] newDistance) {
        this._distance = newDistance;
    }

    private int chooseVertexForNextShortestPath(boolean[] found){
        int currentForChoice = 0;
        while(currentForChoice < this.graph().numberOfVertices() && found[currentForChoice]){
            currentForChoice++;
        }
        for(int nextForChoice = currentForChoice+1;
                nextForChoice < this.graph().numberOfVertices();
                nextForChoice++){
            if((!found[nextForChoice])&&
                    (this.distance()[currentForChoice]>this.distance()[nextForChoice])){
                currentForChoice = nextForChoice;
            }
        }
        return currentForChoice;
    }
    private void debug_showIteration(int iteration, int u){
        ShortestPaths.showDebugMessage("[Debug] Iteration_"+iteration+": (u="+u+")");
        for(int w = 0; w<this.graph().numberOfVertices();w++){
            ShortestPaths.showDebugMessage("d["+w+"]=");
            if(this.distance()[w] >= Integer.MAX_VALUE){
                ShortestPaths.showDebugMessage("∞");
            }
            else{
                ShortestPaths.showDebugMessage(""+this.distance()[w]);
            }
        }
        ShortestPaths.showDebugMessage("\n");
    }

    public ShortestPaths(){
        this.setGraph(null);
        this.setSource(ShortestPaths.UNDEFINED_SOURCE);
        this.setDistance(null);
        this.setPath(null);
    }

     public boolean solve(AdjacencyGraph<WE> aGraph, int aSource){
        if(aGraph == null||aGraph.numberOfVertices()<2){
            return false;
        }
        if(!aGraph.vertexDoesExist(aSource)){
            return false;
        }
        this.setGraph(aGraph);
        this.setSource(aSource);
        this.setDistance(new int[this.graph().numberOfVertices()]);
        this.setPath(new int[this.graph().numberOfVertices()]);

        boolean[] found = new boolean[this.graph().numberOfVertices()];
        for(int vertex = 0; vertex < this.graph().numberOfVertices();vertex++){
            found[vertex] = false;
            this.distance()[vertex] =
                    ((SupplementForWeightedGraph<WE>)this.graph()).weightOfEdge(this.source(),vertex);
            this.path()[vertex] = this.source();
        }
        found[this.source()]= true;
        this.distance()[this.source()] = 0;
        this.path()[this.source()]=-1;
         //실행부분
        ShortestPaths.showDebugMessage("\n[Debug] 최단경로 찾기 반복 과정:\n");
        this.debug_showIteration(0,this.source());
        for(int i=1;i<this.graph().numberOfVertices()-1;i++){
            int u = chooseVertexForNextShortestPath(found);
            found[u] = true;
            Iterator<WE> iterator = this.graph().neighborIteratorOf(u);
            while(iterator.hasNext()){
                WE edge = iterator.next();
                int w = edge.headVertex();
                if(!found[w]){
                    if(this.distance()[w] > this.distance()[u] + edge.weight()){
                        this.distance()[w] = this.distance()[u] + edge.weight();
                        this.path()[w] = u;
                    }
                }
            }
            this.debug_showIteration(i,u);
        }
        ShortestPaths.showDebugMessage("[Debug] 반복 과정 보여주기를 마칩니다.\n");
        return true;
     }
     public int minCostOfPathToDestination(int aDestination){
        return this.distance()[aDestination];
     }

     public LinkedStack<Integer> pathToDestination(int aDestination){
        LinkedStack<Integer> pathStack = new LinkedStack<Integer>();
        for(int vertex = aDestination; vertex>=0; vertex=this.path()[vertex]){
            pathStack.push(Integer.valueOf(vertex));
        }
        return pathStack;
     }
}
