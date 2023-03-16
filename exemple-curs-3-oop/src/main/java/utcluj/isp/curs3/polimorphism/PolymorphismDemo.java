package utcluj.isp.curs3.polimorphism;

class Shape {
    public void draw() {
        System.out.println("Drawing a generic shape...");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle...");
    }
}

class Rectangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle...");
        super.draw();
    }
}

public class PolymorphismDemo {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Shape();
        shapes[1] = new Circle();
        shapes[2] = new Rectangle();
        
        for (Shape shape : shapes) {
            shape.draw();
            shape.
        }
    }
}
