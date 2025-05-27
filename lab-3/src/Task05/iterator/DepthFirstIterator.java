package Task05.iterator;

import Task05.LightElementNode;
import Task05.LightNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.ListIterator;

public class DepthFirstIterator implements NodeIterator {
    private final Deque<LightNode> stack = new ArrayDeque<>();

    public DepthFirstIterator(LightNode root) {
        if (root != null) {
            stack.push(root);
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public LightNode next() {
        LightNode current = stack.pop();
        if (current instanceof LightElementNode element) {
            List<LightNode> children = element.getChildren();
            ListIterator<LightNode> iter = children.listIterator(children.size());
            while (iter.hasPrevious()) {
                stack.push(iter.previous());
            }
        }
        return current;
    }
}
