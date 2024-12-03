package structural.bridge;

public class Rectangle extends Shape {
    public Rectangle(Color color) {
        super(color);
    }

    @Override
    void draw() {
        System.out.println("Drawing Rectangle with color");
        color.applyColor();
    }
}
