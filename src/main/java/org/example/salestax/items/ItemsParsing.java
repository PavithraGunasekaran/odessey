package org.example.salestax.items;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Pavithra Gunasekaran
 * Custom class to store the items purchased by the user
 */
public class ItemsParsing   {


    public int quantity;
    public String itemName;
    public float price;
    /**
     * Constructor to store the parsed items from user's basket
     * @param quantity
     * @param itemName
     * @param price
     */
    public ItemsParsing(int quantity, String itemName, float price) {
        this.quantity = quantity;
        this.itemName = itemName;
        this.price = price;
    }



}
