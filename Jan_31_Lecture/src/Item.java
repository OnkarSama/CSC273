public class Item {

    private String name;
    private int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String toString() {

        return (this.name + " is priced at: " + ((this.price/100) + "." + (this.price%100)));

    }
}
