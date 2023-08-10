package org.example.salestax.SalesTaxService;

/**
 * @author Pavithra Gunasekaran
 * Custom class to generate the reciept for the items purchased items
 */
public class ItemReceipt {
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ItemReceipt(String itemName, int quantity, float price) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    public String itemName;
    public int quantity;
    public float price;
}
