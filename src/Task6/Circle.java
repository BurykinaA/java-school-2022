package Task6;

class Circle extends Figure {
    public int x1, y1, r;

    public Circle(int x1, int y1, int r) {
        this.x1 = x1;
        this.y1 = y1;
        this.r = r;
    }

    @Override
    public Boolean isIn(int a, int b) {
        return a <= this.x1 + this.r && a <= this.x1 - this.r && b <= this.y1 + this.r && b <= this.y1 - this.r;
    }

    @Override
    public String toString() {
        return "C (" + String.valueOf(x1) + ", " + String.valueOf(y1) + "), " + String.valueOf(r) + ": ";
    }

    @Override
    public void move(int dx, int dy) {
        this.x1 += dx;
        this.y1 += dy;
    }
}
