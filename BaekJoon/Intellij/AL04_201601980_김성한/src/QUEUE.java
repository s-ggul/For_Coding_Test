public interface QUEUE<T> {
    //QUEUE의 공개함수 선언
    public void reset();

    public int size();

    public boolean isEmpty();
    public boolean isFull();

    public boolean add(T anElement);
    public T remove();
}
