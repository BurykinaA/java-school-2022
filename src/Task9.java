import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task9 {

    public static void getPath(String s) {
        String[] a = s.split("/");
        for(int i=0; i<a.length; i++){
            if(a[i].equals(".")) a[i]="";
            boolean flag = true;
            if(a[i].equals("..")){
                int j = i-1;
                while(j>=0){
                    if(!a[j].equals("") && !a[j].equals("..")){
                        a[j]="";
                        if(a[0].equals("") && i!= a.length-1)
                            break;
                        a[i]="";
                        break;
                    }
                    j--;
                }
                if(j == -1 && flag){
                    a[i]="";
                    flag = false;
                }
            }
        }
        for(int i=0; i<a.length-1; i++){
            if(a[i]!="")
                System.out.print(a[i] + "/");
        }
        System.out.print(a[a.length-1]);
    }

    public static void main(String[] args){
        getPath("../КРОК/работа/src/./../../универ/мемы/котики");
    }
}