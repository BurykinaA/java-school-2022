import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task8 {

    public static void getWordCount(String filename) throws FileNotFoundException{
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        int words = 0;

        while (scanner.hasNextLine()) {
            String[] array = scanner.nextLine().split("\s+");
//            for(String num : array){
//                System.out.print(num + "|");
//            }
            words = words + array.length;
        }

        System.out.println("Number of words: " + words);
        scanner.close();
    }

    public static void main(String[] args) throws FileNotFoundException{
        getWordCount("src/test.txt");
    }
}