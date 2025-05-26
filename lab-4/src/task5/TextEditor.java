package task5;

public class TextEditor {
    private final TextDocument document = new TextDocument();
    private final java.util.Stack<DocumentMemento> history = new java.util.Stack<>();

    public void write(String text) {
        history.push(document.save());
        document.appendContent(text);
    }

    public void undo() {
        if (!history.isEmpty()) {
            document.restore(history.pop());
        } else {
            System.out.println("Немає попередніх станів для відміни.");
        }
    }

    public String getContent() {
        return document.getContent();
    }

    public void overwrite(String newText) {
        history.push(document.save());
        document.setContent(newText);
    }
}
