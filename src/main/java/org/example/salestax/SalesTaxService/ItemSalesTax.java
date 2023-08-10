package org.example.salestax.SalesTaxService;

/**
 * @author Pavithra Gunasekaran
 * Custom class to store the items and its sales tax details
 */
public class ItemSalesTax  {

    public ItemSalesTax(String item, float taxPercentage, float tax) {
        this.item = item;
        this.taxPercentage = taxPercentage;
        this.tax = tax;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public float getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(float taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    String item;
    float taxPercentage;
    float tax;





}
