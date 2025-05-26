package task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Renderer raster = new RasterRenderer();
        Renderer vector = new VectorRenderer();

        List<Shape> shapes = Arrays.asList(new Circle(raster), new Square(vector), new Triangle(raster));

        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}
