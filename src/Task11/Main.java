public class Main {

    static class LotThread implements Runnable{

        Lot res;

        int price;
        String name;

        LotThread(Lot res, int price, String name) {
            this.res = res;
            this.price = price;
            this.name = name;
        }

        @Override
        public void run() {
            res.update(price, name);
        }
    }

    public static void main(String[] args){
        Lot lot = new Lot();

        for (int i = 1; i < 6; i++){
            Thread t = new Thread(new LotThread(lot, i, "kkk"));
            t.setName("Thread "+ i);
            t.start();
        }

        System.out.println(lot.getName());
        System.out.println(lot.getPrice());
    }
}