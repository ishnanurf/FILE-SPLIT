import java.util.LinkedList;
import java.util.Queue;

public class TextQueue {
    private Queue<String> queue;

    public TextQueue() {
        queue = new LinkedList<>();
    }

    public void enqueue(String data) {
        queue.add(data);
    }

    public String dequeue() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
