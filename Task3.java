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

        in.close();

        System.out.print (arr[indmin] + " "); 

        for (int i = 0; i < size; i++)
            if(i!= indmax && i!= indmin)
                System.out.print (arr[i] + " "); 
        
        System.out.print (arr[indmax] + " "); 

	}
  }
  