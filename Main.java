abstract class Shape {
    String color;
    abstract int getArea();
    public Shape(){
        this.color = "Black";
    }
}

class Rectangle extends Shape {
    int width;
    int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int getArea() {
        return this.width * this.height;
    }
}

class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(50, 45);
        System.out.println("Color: " + rectangle.color);
        System.out.println("Area: " + rectangle.getArea());
    }
}


