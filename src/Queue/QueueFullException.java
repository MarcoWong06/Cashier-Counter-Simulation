package Queue;

public class QueueFullException extends RuntimeException {
    public QueueFullException() {
        super("Queue.Queue is full!");
    }
}
