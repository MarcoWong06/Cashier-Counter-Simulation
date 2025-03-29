package Queue;

public class LinkedQueue implements Queue {

    LinkedList qll;

    public LinkedQueue() {
        qll = new LinkedList();
    }

    @Override
    public boolean isEmpty() { return qll.isEmpty(); }

    @Override
    public int size() { return qll.getCount(); }

    @Override
    public Object front() throws QueueEmptyException {
        try {
            return qll.getItemAt(0);
        } catch (IndexOutOfBoundsException e) {
            throw new QueueEmptyException();
        }
    }

    @Override
    public void enqueue(Object data) throws QueueFullException {
        qll.addToTail(data);
    }

    @Override
    public Object dequeue() throws QueueEmptyException {
        try {
            return qll.removeFromHead();
        } catch (EmptyListException e) {
            throw new QueueEmptyException();
        }
    }

    @Override
    public String toString() { return qll.toString(); }
}