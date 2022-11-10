import java.util.Scanner;

public class Task4 {

    static StringBuffer removeJavaComments(StringBuffer s){
        int i=0;
        int a=-1, b=-1;

        
        System.out.println(s.charAt(s.length()-21));
        System.out.println(s.charAt(s.length()-22));
        System.out.println(s.charAt(s.length()-23));
        System.out.println(s.charAt(s.length()-24));

        while(i<s.length()-1){
            if(s.charAt(i)=='/' && s.charAt(i+1)=='*'){
                a = i;
                i++;
                while(!(s.charAt(i)=='*' && s.charAt(i+1)=='/') && i<s.length()-2)
                    i++;
                i+=2;
                b = i;
                s.delete(a,b);
            }
            else if(s.charAt(i)=='/' && s.charAt(i+1)=='/'){
                a = i;
                i++;
                while(s.charAt(i)!='\n' && s.charAt(i)!='\t' && s.charAt(i)!='\r' && s.charAt(i)!='\\' && s.charAt(i)!='\'' && s.charAt(i)!='\"' && s.charAt(i)!=s.charAt(s.length()-23) && s.charAt(i)!='\b' && s.charAt(i)!='\f' && i<s.length()-1)
                    i++;
                i++;
                b = i;
                s.delete(a, b);
            }
            else
                i++;
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
  