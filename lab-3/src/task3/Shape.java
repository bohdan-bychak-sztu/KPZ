package task3;

public abstract class Shape {
    protected Renderer renderer;
    public Shape(Renderer renderer) {
        this.renderer = renderer;
    }
    public abstract void draw();
}
