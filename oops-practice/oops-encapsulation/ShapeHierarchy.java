abstract class Shape {

    public abstract double area();

    public abstract double perimeter();
}

class Circle extends Shape {

    private final double radius;

    Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be positive");
        }
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double area() {
        return Math.PI * getRadius() * getRadius();
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * getRadius();
    }
}

class Rectangle extends Shape {

    private final double length;
    private final double width;

    Rectangle(double length, double width) {
        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException("Length and width must be positive");
        }
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public double area() {
        return getLength() * getWidth();
    }

    @Override
    public double perimeter() {
        return 2 * (getLength() + getWidth());
    }
}

class Triangle extends Shape {

    private final double sideA;
    private final double sideB;
    private final double sideC;

    Triangle(double sideA, double sideB, double sideC) {
        if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            throw new IllegalArgumentException("Triangle sides must be positive");
        }
        if (sideA + sideB <= sideC || sideA + sideC <= sideB || sideB + sideC <= sideA) {
            throw new IllegalArgumentException("Invalid triangle sides");
        }
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    @Override
    public double area() {
        double semiPerimeter = perimeter() / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - getSideA()) * (semiPerimeter - getSideB()) * (semiPerimeter - getSideC()));
    }

    @Override
    public double perimeter() {
        return getSideA() + getSideB() + getSideC();
    }
}

public class ShapeHierarchy {

    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(7),
            new Rectangle(10, 5),
            new Triangle(3, 4, 5)
        };

        System.out.printf("%-12s %12s %12s%n", "Shape", "Area", "Perimeter");
        System.out.println("--------------------------------------");

        for (Shape shape : shapes) {
            System.out.printf("%-12s %12.2f %12.2f%n", shape.getClass().getSimpleName(), shape.area(), shape.perimeter());
        }
    }
}
