import java.util.Scanner;

// Base class
class Figure {
    protected double perimeter;
    protected double area;
    protected double volume;

    // Getters
    public double getPerimeter() { return perimeter; }
    public double getArea() { return area; }
    public double getVolume() { return volume; }

    // Setters
    public void setPerimeter(double perimeter) { this.perimeter = perimeter; }
    public void setArea(double area) { this.area = area; }
    public void setVolume(double volume) { this.volume = volume; }

    // Display method
    public void display() {
        if (perimeter > 0)
            System.out.println("Perimeter: " + perimeter);
        else
            System.out.println("Perimeter: Not applicable");

        if (area > 0)
            System.out.println("Area: " + area);
        else
            System.out.println("Area: Not applicable");

        if (volume > 0)
            System.out.println("Volume: " + volume);
        else
            System.out.println("Volume: Not applicable");
    }
}

// Derived class: Triangle
class Triangle extends Figure {
    private double a, b, c;

    public Triangle(double a, double b, double c) {
        this.a = a; this.b = b; this.c = c;

        if (isValidTriangle()) {
            calculate();
        } else {
            System.out.println("Error: Invalid triangle sides!");
        }
    }

    private boolean isValidTriangle() {
        return (a + b > c && a + c > b && b + c > a);
    }

    private void calculate() {
        // Perimeter
        setPerimeter(a + b + c);

        // Area using Heron's formula
        double s = getPerimeter() / 2;
        double areaVal = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        setArea(areaVal);

        // No volume for 2D triangle
        setVolume(0);
    }
}

// Derived class: Sphere
class Sphere extends Figure {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
        if (radius > 0) {
            calculate();
        } else {
            System.out.println("Error: Radius must be positive!");
        }
    }

    private void calculate() {
        // No perimeter for sphere
        setPerimeter(0);

        // Surface area
        setArea(4 * Math.PI * radius * radius);

        // Volume
        setVolume((4.0 / 3.0) * Math.PI * radius * radius * radius);
    }
}

// Main class
public class FigureDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Triangle input
            System.out.println("Enter 3 sides of the Triangle:");
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            double c = sc.nextDouble();

            Triangle t = new Triangle(a, b, c);
            System.out.println("\nTriangle Properties:");
            t.display();

            // Sphere input
            System.out.print("\nEnter radius of Sphere: ");
            double r = sc.nextDouble();

            Sphere s = new Sphere(r);
            System.out.println("\nSphere Properties:");
            s.display();

        } catch (Exception e) {
            System.out.println("Error: Invalid input! Please enter numeric values.");
        } finally {
            sc.close();
        }
    }
}
