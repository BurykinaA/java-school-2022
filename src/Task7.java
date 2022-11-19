class ChessPosition{
    int x;
    int y;

    public int getX() {return this.x;}
    public int getY() {return this.y;}

    public void setX(int x) {
        if (x < 0 || x > 8) {
            throw new IllegalArgumentException();
        }
        this.x = x;
    }

    public void setY(int y) {
        if (y < 0 || y > 8) {
            throw new IllegalArgumentException();
        }
        this.y = y;
    }

    @Override
    public String toString() {
        return "" + (char)(this.x+97) + String.valueOf(this.y+1);
    }

}

class IllegalMoveException extends Exception {
    public IllegalMoveException(String errorMessage) {
        super(errorMessage);
    }
}



public class Task7 {

    static ChessPosition parse(String position) {
        int x = (int)position.charAt(0) - 97;
        int y = Character.digit(position.charAt(1),10) - 1;
        ChessPosition tmp = new ChessPosition();
        tmp.setY(y);
        tmp.setX(x);
        return tmp;
        // у меня тут утечка памяти, да? ой джава же все самма чистит, да?
        // мне получается нужно через обычный конструктор сделать
        // те в нем трай кетч прописать? или в нем сеттер вызывать?
    }

    public static Boolean Check(int x, int y, int x1, int y1){

        if(x-2==x1 || x+2==x1)
            if(y-1==y1 || y+1==y1)
                return true;
        if(x-1==x1 || x+1==x1)
            if(y-2==y1 || y+2==y1)
                return true;
        return false;
    }

    public void KnightMove(ChessPosition[] arr) throws IllegalMoveException{
        for(int i=1; i<arr.length; i++){
            if(!(Check(arr[i-1].getX(), arr[i-1].getY(), arr[i].getX(), arr[i].getY()))){
                throw new IllegalMoveException("конь так не ходит: " + arr[i-1] + " -> " + arr[i]);
            }
        }
        System.out.println("OK");
    }

    public static void KnightMove(String[] arr) throws IllegalMoveException{
        for(int i=1; i<arr.length; i++){
            ChessPosition a1 = parse(arr[i-1]);
            ChessPosition a2 = parse(arr[i]);
            if(!(Check(a1.getX(), a1.getY(), a2.getX(), a2.getY()))){
                throw new IllegalMoveException("конь так не ходит: " + arr[i-1] + " -> " + arr[i]);
            }
        }
        System.out.println("OK");
    }

    public void doSomething() throws IllegalArgumentException {
        System.out.println("Invalid value");
    }

    public static void main(String[] args) throws IllegalMoveException {
        String[] arr = {"g8", "e7", "e6"};
        String[] arr1 = {"g8", "e7", "c8"};
        KnightMove(arr1);
    }
}