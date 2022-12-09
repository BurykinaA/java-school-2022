package Task5;

class Circle extends Figure {
    public int x1, y1, r;

    public Circle(int x1, int y1, int r) {
        this.x1 = x1;
        this.y1 = y1;
        this.r = r;
    }

    @Override
    public String toString() {
        return "C (" + String.valueOf(x1) + ", " + String.valueOf(y1) + "), " + String.valueOf(r) + ": ";
    }
}
