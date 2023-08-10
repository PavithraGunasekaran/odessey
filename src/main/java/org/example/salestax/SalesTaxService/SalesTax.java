package org.example.salestax.SalesTaxService;

import org.example.salestax.items.Books;
import org.example.salestax.items.Food;
import org.example.salestax.items.ItemsParsing;
import org.example.salestax.items.Medicine;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author Pavithra Gunasekaran
 */
public class SalesTax {
    public static List<ItemSalesTax> allItemsWithSalesTax = new ArrayList<>();

    /**
     * Finds the item type to compute the respective tax percentage
     * @param item
     * @return
     */
    public static String getItemType(String item){

        if(item.isEmpty()){
            throw new NullPointerException("Input items cannot be empty");
        }
        for (Food enumValue : Food.values()) {
            if (enumValue.name().contains(item)) {
                return "food";
            }
        }
        for (Books enumValue : Books.values()) {
            if (enumValue.name().contains(item)) {
                return "book";
            }
        }
        for (Medicine enumValue : Medicine.values()) {
            if (enumValue.name().contains(item)) {
                return "medicine";
            }
        }
        return "";


    }

    /**
     * Computes the sales tax percentage and the sales tax amount for each item
     * @param itemsList
     * @return
     */
    public static List<ItemSalesTax> computeItemSalesTax(List<ItemsParsing> itemsList){

        if(itemsList.isEmpty()){
            throw new NullPointerException("Input items cannot be empty");
        }
        for(ItemsParsing eachItem: itemsList){
            float totalPrice = eachItem.quantity*eachItem.price;
            String itemType=getItemType(eachItem.itemName.toUpperCase(Locale.ROOT).replace(" ","_"));
            float salesTaxPercentage = 0.0F;
            if(!itemType.contains("food") && !itemType.contains("medicine") && !itemType.contains("book") && !eachItem.itemName.contains("import")){
                salesTaxPercentage= 10.0F;
            }
            if(!itemType.contains("food") && !itemType.contains("medicine") && !itemType.contains("book") && eachItem.itemName.contains("import")){
                salesTaxPercentage= 15.0F;
            }

            if((itemType.contains("food") || itemType.contains("medicine") || itemType.contains("book")) && eachItem.itemName.contains("import")){
                salesTaxPercentage= 5.0F;
            }
            float totalTax =  (totalPrice*salesTaxPercentage)/100;
            //DecimalFormat df_obj = new DecimalFormat("#.####");
            ItemSalesTax itemSalesTax = new ItemSalesTax(eachItem.itemName,salesTaxPercentage,roundOffSalesTax(totalTax));
            allItemsWithSalesTax.add(itemSalesTax);
        }

        return allItemsWithSalesTax;

    }

    /**
     * Computes the total sales tax of all items
     * @param allItemsWithSalesTax
     * @return
     */
    public static float computeTotalSalesTax(List<ItemSalesTax> allItemsWithSalesTax ){

        if(allItemsWithSalesTax.isEmpty()){
            throw new NullPointerException("SalesTax is not computed for the items");
        }
        float totalSalesTax= 0.0F;
        for(ItemSalesTax eachItemSalesTax : allItemsWithSalesTax){
            totalSalesTax+=eachItemSalesTax.tax;
        }
        totalSalesTax= roundOffSalesTax(totalSalesTax);
        return  totalSalesTax;
    }

    /**
     * Rounds off the sales tax to nearest 0.05
     * @param totalSalesTax
     * @return
     */
    public static float roundOffSalesTax (float totalSalesTax){

        // Multiply the number by 20 to shift the decimal two places to the right
        float multipliedSalesTax = (float) (totalSalesTax * 20.0);

        // Take the ceiling of the multiplied number to get the greatest integer value
        float roundedSalesTax = (float) Math.ceil(multipliedSalesTax);

        // Divide the rounded integer by 20 to shift the decimal back two places to the left
        roundedSalesTax /= 20.0;
        return  roundedSalesTax;

    }

}
