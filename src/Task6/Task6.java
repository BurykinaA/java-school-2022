package Task6;


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