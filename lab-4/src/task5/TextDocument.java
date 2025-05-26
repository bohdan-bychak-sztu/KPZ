package task5;

public class TextDocument {
    private String content = "";

    public void setContent(String content) {
        this.content = content;
    }

    public void appendContent(String additional) {
        this.content += additional;
    }

    public String getContent() {
        return content;
    }

    public DocumentMemento save() {
        return new DocumentMemento(content);
    }

    public void restore(DocumentMemento memento) {
        this.content = memento.getSavedContent();
    }
}
