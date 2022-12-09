package Task5;

class Rectangle extends Figure {
    int x1, y1, x2, y2;

    public Rectangle(int x1, int y1, int x2, int y2) {
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
