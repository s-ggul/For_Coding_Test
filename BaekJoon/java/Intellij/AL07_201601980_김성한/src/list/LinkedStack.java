package list;

public class LinkedStack<E> implements Stack<E> {

    private int _size;
    private LinkedNode<E> _top;

    private LinkedNode<E> top(){
        return this._top;
    }

    private void setTop(LinkedNode<E> newTop){
        this._top = newTop;
    }

    @Override
    public void reset() {

    }

    @Override
    public int size() {
        return this._size;
    }

    public void setSize(int newSize){
        this._size = newSize;
    }

    public LinkedStack(){
        this.setSize(0);
        this.setTop(null);
    }

    @Override
    public boolean isEmpty() {
        return (this._size == 0);
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean push(E anElement) {
        LinkedNode<E> newTop = new LinkedNode<E>(anElement, this.top());
        this.setTop(newTop);
        this.setSize(this.size()+1);
        return true;
    }

    @Override
    public E pop() {
        if(this.isEmpty()){
            return null;
        }
        else{
            E removedElement = this.top().element();
            this.setTop(this.top().next());
            this.setSize(this.size()-1);
            return removedElement;
        }
    }

    @Override
    public E peek() {
        return null;
    }

    public IteratorForLinkedStack iterator(){
        return new IteratorForLinkedStack();
    }

    public class IteratorForLinkedStack implements Iterator<E>{
        LinkedNode<E> _nextNode;

        private LinkedNode<E> nextNode(){
            return this._nextNode;
        }
        private void setNextNode(LinkedNode<E> aLinkedNode){
            this._nextNode = aLinkedNode;
        }

        private IteratorForLinkedStack(){
            this.setNextNode(LinkedStack.this.top());
        }

        @Override
        public boolean hasNext() {
            return (this.nextNode() != null);
        }

        @Override
        public E next() {
            E nextElement = this.nextNode().element();
            this.setNextNode(this.nextNode().next());
            return nextElement;
        }
    }
}
