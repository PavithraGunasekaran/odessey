package org.example.salestax.SalesTaxService;

import org.example.salestax.items.ItemsParsing;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Pavithra Gunasekaran
 */
public class Receipt {


    /**
     * Method to generate receipt for the items purchased
     * @param allItemSalesTax
     * @param allItems
     */
    public static List<ItemReceipt> generateReceipt(List<ItemSalesTax> allItemSalesTax, List<ItemsParsing> allItems){
    List<ItemReceipt> allItemsReceipt = new ArrayList<>();
    if(allItems.isEmpty()){
        throw new NullPointerException("Input items cannot be empty");
    }
    if(allItemSalesTax.isEmpty()){
        throw new NullPointerException("Sales tax is not computed for the items");
    }
    for(ItemsParsing inputItem: allItems){
        for(ItemSalesTax itemWithSalesTax: allItemSalesTax){
            if(Objects.equals(inputItem.itemName, itemWithSalesTax.item)){
                float tPrice = inputItem.price+itemWithSalesTax.tax;
                ItemReceipt itemReceipt = new ItemReceipt(inputItem.itemName, inputItem.quantity,  tPrice);
                allItemsReceipt.add(itemReceipt);
            }
        }
    }
    return allItemsReceipt;
    }
}
