package Queue;

public class QueueEmptyException extends RuntimeException {
    public QueueEmptyException() {
        super("Queue.Queue is empty!");
    }
}
