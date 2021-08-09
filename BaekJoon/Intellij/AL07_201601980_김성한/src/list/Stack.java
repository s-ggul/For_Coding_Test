package list;

public interface Stack<T> {
    public void reset();

    public int size();

    public boolean isEmpty();
    public boolean isFull();

    public boolean push(T anElement);
    public T pop();

    public T peek();
}
