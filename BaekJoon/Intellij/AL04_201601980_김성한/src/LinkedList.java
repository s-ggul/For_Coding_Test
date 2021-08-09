public class LinkedList<T> {

    private LinkedNode<T> _head;
    private int _size;

    // getter & setter >>
    private LinkedNode<T> head(){
        return this._head;
    }
    private void setHead(LinkedNode<T> newHead){
        this._head = newHead;
    }
    public int size(){
        return this._size;
    }
    private void setSize(int newSize){
        this._size = newSize;
    }
    // << getter & setter

    public LinkedList(){ //생성자
        this.setSize(0); //size 초기화
        this.setHead(null); // head 노드 초기화
    }

    public boolean isEmpty(){ // 현재 크기가 0 이면 true 반환
        return (this.size() == 0);
    }
    public boolean isFull(){ // 포화상태일 때 False반환
        return false;
    }

    public boolean add (T anElement){ //제네릭 타입의 값을 할당함.
        LinkedNode<T> newHeadNode = new LinkedNode<T>(anElement,this.head()); //값을 할당하고 next를 head로 함.
        this.setHead(newHeadNode); // head를 새로운 객체 newHeadNode로 바꿔줌.
        this.setSize(this.size()+1); // 1개를 늘렸으니 크기에 1추가.
        return true; //true 반환
    }

    public T removeAny(){ //제거
        if(this.isEmpty()){ // 크기가 0이라면 null 반환
            return null;
        }
        else{ //크기가 0이 아닐경우
            T removedElement = this.head().element(); // node의 데이터 할당
            this.setHead(this.head().next()); //제거 한 후 next node 를 head로 지정.
            this.setSize(this.size()-1); // 크기 1 감소.
            return removedElement; // node 데이터 반환
        }
    }

    public IteratorForLinkedList iterator(){ // LinkedList를 탐색할때 사용하기 위한 iterator 객체 생성
        return new IteratorForLinkedList();
    }

    public class IteratorForLinkedList implements Iterator<T>{ // inner Class 
    
        LinkedNode<T> _nextNode; // linkedNode 선언

        private LinkedNode<T> nextNode(){ //
            return this._nextNode;
        }

        private void setNextNode(LinkedNode<T> newLinkedNode){
            this._nextNode = newLinkedNode;
        }

        private IteratorForLinkedList(){ //private 생성자.
            this.setNextNode(LinkedList.this.head()); 
            //초기 LinkedListIterator 객체를 생성 할 때 생성자를 통해 _nextNode가 head를 가리키도록 선언  
        }
        
        
        @Override
        public boolean hasNext() { //interface iterator의 공개함수 구현 다음 노드가 존재하는지 next가 null이 아닌지 판단.
            return (this.nextNode() != null); // 인스턴스 변수 nextNode가 null 이 아니면 true 반환
        }

        @Override
        public T next() { //interface iterator의 공개함수 구현
            T nextElement = this.nextNode().element(); //nextElement 변수에 next노드의 데이터 할당
            this.setNextNode(this.nextNode().next()); // nextNode를 다음 노드로 바꿔줌
            return nextElement; // 초기 선언한 변수 nextElement 반환
        }
    }


}




