public class CircularQueue<T> implements QUEUE<T> { //Generic으로 선언

    private T[] _elements; //제네릭 타입의 배열 선언
    private int _capacity;
    private int _front;
    private int _rear;

    // private getter & setter >>
    private T[] elements(){
        return this._elements;
    }
    private void setElements(T[] newElements){
        this._elements = newElements;
    }
    private int capacity(){
        return this._capacity;
    }
    private void setCapacity(int newCapacity){
        this._capacity = newCapacity;
    }

    private int front(){
        return this._front;
    }
    private void setFront(int newFront){
        this._front = newFront;
    }
    private int rear(){
        return this._rear;
    }
    private void setRear(int newRear){
        this._rear = newRear;
    }

    // << private getter & setter

    private int nextRear(){
        return (this.rear()+1) % this.capacity(); // 배열의 크기로 나누었을때 나머지를 이용.이렇게 되면 배열내에서 인덱스를 순환할수 있다.
    }
    private int nextFront(){
        return (this.front()+1) % this.capacity(); // 배열의 크기로 나누었을때 나머지를 이용.이렇게 되면 배열내에서 인덱스를 순환할수 있다.
    }

    public CircularQueue(int maxNumberOfElements){ //사용자 지정 생성자
        this.setCapacity(maxNumberOfElements+1); // 원소를 저장하는 배열 _elements[]의 크기이다. 실제 저장 가능한 원소의 개수는 (_capacity – 1)
        this.setElements((T[]) new Object[this.capacity()]); // 제네릭타입의 배열로 초기화
        this.reset(); // front와 rear 인덱스 초기화
    }

    public void reset(){
        this.setFront(0);
        this.setRear(0);
    }

    @Override
    public int size() {
        if(this.front() <= this.rear()){
            return (this.rear() - this.front());
        }
        else{
            return(this.capacity() + this.rear() - this.front());
        }
    }

    @Override
    public boolean isEmpty() {
        return (this.front() == this.rear());
    } //배열이 공백상태인지 체크

    @Override
    public boolean isFull() {
        return (this.front() == this.nextRear());
    } //배열이 포화상태인지 체크

    @Override
    public boolean add(T anElement) {
        if(this.isFull()){ //배열이 포화상태인경우
            return false;
        }
        else{ //배열이 포화상태가 아닌경우
            this.setRear(this.nextRear());
            this.elements()[this.rear()] = anElement;
            return true;
        }
    }

    public T remove(){
        if(this.isEmpty()){ //배열이 공백이면 false 반환
            return null;
        }
        else{ //배열이 공백이 아닐때
            this.setFront(this.nextFront());
            return this.elements()[this.front()];
        }
    }

}
