package Task11;

public class Lot {
    volatile int price;
    volatile String name;
    volatile String time;

    Lot(){
        this.price = 0;
        this.name = "";
        this.time = "";
    }

    Lot(int price, String name, String time){
        if(this.price < price) {
            this.price = price;
            this.name = name;
            this.time = time;
        }
    }

    synchronized void update(int price, String name){
        if(this.price < price) {
            this.price = price;
            this.name = name;
        }
    }

    String getName(){return this.name;}
    int getPrice(){return this.price;}
}
