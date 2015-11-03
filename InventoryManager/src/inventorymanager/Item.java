package inventorymanager;

public class Item {

    private String name;
    private int quantity;
    private double pricePerUnit;

    public Item() {

    }

    public Item(String n, int q, double ppu) {
        name = n;
        quantity = q;
        pricePerUnit = ppu;
    }

    public String getName() {
        return name;
    }

    public void setName(String nN) {
        name = nN;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int nQ) {
        quantity = nQ;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double nPPU) {
        pricePerUnit = nPPU;
    }

}
