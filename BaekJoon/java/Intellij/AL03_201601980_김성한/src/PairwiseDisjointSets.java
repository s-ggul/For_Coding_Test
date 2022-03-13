public class PairwiseDisjointSets {
    private static final int INITIAL_SINGLETON_SET_SIZE = 1;
    private int _numberOfElements;
    private int[] _parentTree;

    public PairwiseDisjointSets(int givenNumberOfElements){
        this.setNumberOfElements(givenNumberOfElements);
        this.setParentTree(new int[this.numberOfElements()]);
        for(int rootOfSingletonSet = 0; rootOfSingletonSet < this.numberOfElements(); rootOfSingletonSet++){
            this.setSizeOfSetFor(rootOfSingletonSet,INITIAL_SINGLETON_SET_SIZE);
        }
    } // 초기 배열을 선언할때 각각의 인덱스별로 사이즈를 초기화해준다.

    //private getter & setter >>
    private int numberOfElements(){

        return this._numberOfElements;
    }
    private void setNumberOfElements(int newNumberOfElements){

        this._numberOfElements = newNumberOfElements;
    }
    private int[] parentTree(){

        return this._parentTree;
    }
    private void setParentTree(int[] newParentTree){

        this._parentTree = newParentTree;
    }
    // << private getter & setter

    private int parentOf(int aMember){ //주어진 aMember의 부모 원소를 얻는다.

        return this.parentTree()[aMember];
    }
    private void setParentOf(int aChildMember, int newParentMember){ //주어진 aChildMember의 parent를 newParentMember로 설정한다.
        this.parentTree()[aChildMember] = newParentMember;
    }
    private boolean parentDoesExist(int aMember){
        return (this.parentOf(aMember) >= 0);
    }
    private int sizeOfSetFor(int aRoot){
       return(-this.parentOf(aRoot));
    }
    private void setSizeOfSetFor(int aRoot, int newSize){
        this.setParentOf(aRoot,-newSize);
    }


    public int find(int aMember){
        int rootCandidate = aMember;
        while(this.parentDoesExist(rootCandidate)){
            rootCandidate = this.parentOf(rootCandidate);
        }
        int root = rootCandidate;

        //Collapsion Rule 적용
        int child = aMember;
        int parent = this.parentOf(child);
        if(parent >= 0){
            while(parent != root){ // 하위 child들의 값을 root 의 인덱스 값으로 설정해줌.
                this.setParentOf(child, root);
                child = parent;
                parent = this.parentOf(child);
            }
        }
        return root;
    }

    public void union(int aMemberA, int aMemberB){
        int rootOfSetA = find(aMemberA);

        int rootOfSetB = find(aMemberB);

        int sizeOfSetA = this.sizeOfSetFor(rootOfSetA);
        int sizeOfSetB = this.sizeOfSetFor(rootOfSetB);

        if(sizeOfSetA < sizeOfSetB){
            this.setParentOf(rootOfSetA,rootOfSetB);
            this.setSizeOfSetFor(rootOfSetB,(sizeOfSetA+sizeOfSetB));
        }
        else{
            this.setParentOf(rootOfSetB,rootOfSetA);
            this.setSizeOfSetFor(rootOfSetA, (sizeOfSetA+sizeOfSetB));
        }
    }

}
