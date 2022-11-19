import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Task10 {

    final double maxx = Math.pow(26, 7);
    char[] arr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();

    private static synchronized String toHexString(byte[] bytes) {
        StringBuilder hex = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            hex.append(HEX_DIGITS[(b & 0xff) >> 4]);
            hex.append(HEX_DIGITS[b & 0x0f]);
        }
        return hex.toString();
    }

    private static String hashPassword(String password) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        digest.update(password.getBytes());
        byte[] bytes = digest.digest();
        return toHexString(bytes);
    }

    private static void GetStr(double a, double b){
        String hash = "40682260CC011947FC2D0B1A927138C5";
        char[] arr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        for(double j=a; j<b; j++){
            String ans = Long.toString((long) j, 26);
            String st = "";
            for(int k=0; k<ans.length(); k++){
                char tmp = ans.charAt(k);
                if(Character.isDigit(tmp)){
                    st+=arr[(int)(tmp - '0')];
                }
                else{
                    st+=arr[(int)(tmp - 'a' + 10)];
                }
            }
            if(hashPassword(st) == hash){
                System.out.println(st);
                return;
            }
        }
    }
    
    public static void main(String[] args){

        //System.out.println(hashPassword("Hello"));
        final double maxx = Math.pow(26, 7);
        GetStr(0,27);
        double cnt = maxx/4;
        for (int i = 0; i < 4; i++) {
            int finalI = i;
            new Thread(){
                @Override
                public void run() {
                    while (!Thread.currentThread().isInterrupted()){
                        if(finalI !=3)
                            GetStr(cnt* finalI, cnt*(finalI +1));
                        else
                            GetStr(cnt* finalI, maxx);
                    }
                }
            }.start();
        }

    }
}