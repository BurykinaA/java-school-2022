import java.util.Scanner;
import java.util.ArrayList;

public class Task4 {

    static StringBuffer removeJavaComments(StringBuffer s){
        int i=0;
        int a=-1, b=-1;
        ArrayList<String> arr = new ArrayList<String>();
        while(i<s.length()-1){
            if(s.charAt(i)=='/' && s.charAt(i+1)=='*'){
                a = i;
                i++;
                while(!(s.charAt(i)=='*' && s.charAt(i+1)=='/') && i<s.length()-2)
                    i++;
                i+=2;
                b = i;
                arr.add(Integer.toString(a) + " " + Integer.toString(b));
            }
            else if(s.charAt(i)=='/' && s.charAt(i+1)=='/'){
                a = i;
                i++;
                while(s.charAt(i)!='\n'  && i<s.length()-1)
                    i++;
                //i++;
                b = i;
                arr.add(Integer.toString(a) + " " + Integer.toString(b));
            }
            else
                i++;
        }
        
        int dt = 0;
        for(String t : arr) {
            String[] tmp = t.split(" ");
            a = Integer.valueOf(tmp[0]);
            b = Integer.valueOf(tmp[1]);
            s.delete(a-dt, b-dt);
            dt+=b-a;
        }
        return s;
    }

    public static void main(String[] args) {

        String source = """
        /*
        * My first ever program in Java!
        */
        class Hello { // class body starts here 
         
        /* main method */
        public static void main(String[] args/* we put command line arguments here*/) {
        // this line prints my first greeting to the screen
        System.out.println("Hi!"); // :)
        }
        } // the end
        // to be continued...
        """;

        StringBuffer strBuffer = new StringBuffer(source);
        StringBuffer noComments = removeJavaComments(strBuffer);
        System.out.println(noComments.toString());
    }
}
