package Queue;

public interface Queue {
    public boolean isEmpty();
    public int size();
    public Object front() throws QueueEmptyException;
    public void enqueue(Object data) throws QueueFullException;
    public Object dequeue() throws QueueEmptyException;
}
