import java.util.Scanner;

public class Task3 {


	public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int size = in.nextInt();

        System.out.println("Insert array elements:");
        int arr[] = new int[size];
        
        arr[0] = in.nextInt(); 
        int min = arr[0], max= arr[0], indmin=0,indmax=0;

        for (int i = 1; i < size; i++){
            arr[i] = in.nextInt(); 
            if(arr[i] < min){
                min = arr[i];
                indmin = i;
            }
            if(arr[i] > max){
                max = arr[i];
                indmax = i;
            }
        }

        int tmp = arr[0];
        arr[0] = arr[indmin];
        arr[indmin] = tmp;

        if(indmax != 0){
            tmp = arr[size-1];
            arr[size-1] = arr[indmax];
            arr[indmax] = tmp;
        }

        for (int i = 0; i < size; i++)
            System.out.print (arr[i] + " "); 
	}
  }
  