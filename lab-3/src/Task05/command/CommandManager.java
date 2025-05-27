package Task05.command;

import java.util.ArrayDeque;
import java.util.Deque;

public class CommandManager {
    private final Deque<Command> history = new ArrayDeque<>();

    public void executeCommand(Command command) {
        command.execute();
        history.push(command);
    }

    public void undoLast() {
        if (!history.isEmpty()) {
            Command last = history.pop();
            last.undo();
        }
    }
}
