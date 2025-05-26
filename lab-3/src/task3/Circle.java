package task3;

import java.awt.*;

public class Circle extends Shape {
    public Circle(Renderer renderer) {
        super(renderer);
    }

    @Override
    public void draw() {
        renderer.render("Circle");
    }
}
