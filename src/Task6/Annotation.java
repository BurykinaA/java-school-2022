package Task6;

class Annotation {

    String name;
    Figure x;

    public Annotation() {
        this.name = "";
        this.x = new Figure();
    }

    public Annotation(String name, Figure x) {
        this.name = name;
        this.x = x;
    }

    public Boolean isIn(int a, int b) {
        return this.x.isIn(a, b);
    }

    @Override
    public String toString() {
        return x + this.name;
    }

    public String getName() {
        return this.name;
    }
}
