package task3;

public class Triangle extends Shape {
    public Triangle(Renderer renderer) {
        super(renderer);
    }

    @Override
    public void draw() {
        renderer.render("Triangle");
    }
}
