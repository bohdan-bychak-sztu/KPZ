package task5;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.write("Привіт, ");
        editor.write("світ!");
        System.out.println("Поточний текст: " + editor.getContent());

        editor.undo();
        System.out.println("Після undo: " + editor.getContent());

        editor.overwrite("Нове повідомлення.");
        System.out.println("Після overwrite: " + editor.getContent());

        editor.undo();
        System.out.println("Після другого undo: " + editor.getContent());
    }
}
