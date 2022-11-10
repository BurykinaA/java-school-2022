import java.util.Scanner;

class AnnotatedImage{

	private final String imagePath;

	private final Annotation[] annotations;

	public AnnotatedImage() {
		this.imagePath = "";
		this.annotations = new Annotation[0];
	}
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

	public Annotation(){
		this.name = "";
		this.x = new Figure();
	}
	public Annotation(String name, Figure x){
		this.name = name;
		this.x = x;
	}

	public Boolean isIn(int a, int b){
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

interface Movable {
	void move(int dx, int dy);
}


class Figure implements Movable{
	public Boolean isIn(int a, int b){
		return false;
	}

	@Override
	public void move(int dx, int dy) {
	}
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
	public Boolean isIn(int a, int b){
		return a>=this.x1 && a<=this.x2 && b>=this.y1 && b<=this.y2;
	}

	@Override
	public String toString() {
		return "C (" + String.valueOf(x1) + ", " + String.valueOf(y1) + "), (" + String.valueOf(x2) + ", " + String.valueOf(y2) + ") : ";
	}

	@Override
	public void move(int dx, int dy) {
		this.x1 += dx;
		this.x2 += dx;
		this.y1 += dy;
		this.y2 += dy;
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
	public Boolean isIn(int a, int b){
		return a<=this.x1 + this.r  && a<=this.x1 - this.r && b<=this.y1 + this.r  && b<=this.y1 - this.r;
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





public class Task6 {
	static AnnotatedImage aa = new AnnotatedImage();

	Annotation findByPoint(int x, int y) {
		Annotation[] arr = aa.getAnnotations();
		for(int i=0; i<arr.length; i++){
			if(arr[i].isIn(x, y))
				return arr[i];
		}
		return new Annotation();
	}

	Annotation findByLabel(String label) {
		Annotation[] arr = aa.getAnnotations();
		for(int i=0; i<arr.length; i++){
			if(arr[i].getName().contains(label))
				return arr[i];
		}
		return new Annotation();
	}


	public static void main(String[] args) {
		Annotation a = new Annotation("Tree", new Circle(100, 100, 10));
		aa = new AnnotatedImage("newIm", a);
		System.out.println(a);
	}
}