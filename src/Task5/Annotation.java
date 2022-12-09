package Task5;

class Annotation {

    String name;
    Figure x;

    public Annotation(String name, Figure x) {
        this.name = name;
        this.x = x;
    }

    @Override
    public String toString() {
        return x + this.name;
    }
}
