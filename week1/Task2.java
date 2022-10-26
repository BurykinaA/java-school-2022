import java.util.Scanner;

public class Task2 {

    static void printBytes(Double a){
        
        String[] arr = new String[] {"B", "KB", "MB", "GB", "TB"};
        int cnt =0;

        while((int)(a/1024) !=0){
            if(cnt >= 4)
                break;
            cnt++;
            a /= 1024;
        }
        
        System.out.println(String.format("%.1f", a) + " " + arr[cnt]);

    }

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		double x = in.nextDouble();
        printBytes(x);
	}
  }
  