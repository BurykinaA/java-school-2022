import java.util.Scanner;

class AnnotatedImage {

    private final String imagePath;

    private final Annotation[] annotations;

    public AnnotatedImage(String imagePath, Annotation... annotations) {
        this.imagePath = imagePath;
        this.annotations = annotations;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public Annotation[] getAnnotations() {
        return this.annotations;
    }
}

class Annotation{

    String name;
    Figure x;

    public Annotation(String name, Figure x){
        this.name = name;
        this.x = x;
    }

    @Override
    public String toString() {
        return x + this.name;
    }
}

class Figure{

}

class Rectangle extends Figure{
    int x1, y1, x2, y2;

    public Rectangle(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    @Override
    public String toString() {
        return "C (" + String.valueOf(x1) + ", " + String.valueOf(y1) + "), (" + String.valueOf(x2) + ", " + String.valueOf(y2) + ") : ";
    }
}

class Circle extends Figure{
    public int x1, y1, r;

    public Circle(int x1, int y1, int r){
        this.x1 = x1;
        this.y1 = y1;
        this.r = r;
    }

    @Override
    public String toString() {
        return "C (" + String.valueOf(x1) + ", " + String.valueOf(y1) + "), " + String.valueOf(r) + ": ";
    }
}


public class Task5 {
    public static void main(String[] args) {
        Annotation a = new Annotation("Tree", new Circle(100, 100, 10));
        System.out.println(a);
    }
}