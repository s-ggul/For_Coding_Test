package list;

public class LinkedNode<T> {
    private T _element; //제네릭타입의 변수 선언
    private LinkedNode<T> _next; // 연결된 다음 Node 생성

    // getter & setter >>
    public T element(){
        return this._element;
    }
    public void setElement(T newElement){
        this._element = newElement;
    }
    public LinkedNode<T> next(){
        return this._next;
    }
    public void setNext(LinkedNode<T> newNext){
        this._next = newNext;
    }
    // << getter & setter



    // 생성자들

    public LinkedNode(){ // 생성자 - 초기화
        this.setElement(null); // Node 내의 element 초기화
        this.setNext(null); // Node가 가르키는 다음 Node 초기화
    }

    public LinkedNode(T givenElement, LinkedNode<T> givenNext){
        //생성자 - Node의 element 및 next 할당.
        this.setElement(givenElement);
        this.setNext(givenNext);
    }
}
