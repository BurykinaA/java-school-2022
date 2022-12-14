import java.util.Scanner;

public class Task1 {

	static class Point {

		double x;
		double y;

		public Point(double x, double y){
			this.x = x;
			this.y = y;
		}
	}

	static Point getCoordinates(int num){
		Scanner in = new Scanner(System.in);

		System.out.print("Введите координату х вершины №" + num + " : ");
		double x = in.nextDouble();

		System.out.print("Введите координату y вершины №" + num + " : ");
		double y = in.nextDouble();

		in.close();
		return new Point(x, y);
	}
  
	static double area(Point a, Point b, Point c){
		return 0.5 * Math.abs((b.x - a.x)*(c.y-a.y) - (c.x - a.x)*(b.y-a.y));
	}

	public static void main(String[] args) {

		Point a = getCoordinates(1);
		Point b = getCoordinates(2);
		Point c = getCoordinates(3);

		System.out.println("Площадь треугольника: " + area(a,b,c));
	}
  }
  