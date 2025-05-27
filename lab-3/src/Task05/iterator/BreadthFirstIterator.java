package Task05.iterator;

import Task05.LightElementNode;
import Task05.LightNode;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstIterator implements NodeIterator {
    private final Queue<LightNode> queue = new LinkedList<>();

    public BreadthFirstIterator(LightNode root) {
        if (root != null) {
            queue.offer(root);
        }
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public LightNode next() {
        LightNode current = queue.poll();
        if (current instanceof LightElementNode element) {
            queue.addAll(element.getChildren());
        }
        return current;
    }
}
