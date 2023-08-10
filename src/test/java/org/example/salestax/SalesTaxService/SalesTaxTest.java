package org.example.salestax.SalesTaxService;

import org.example.salestax.items.ItemsParsing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Pavithra Gunasekaran
 */
class SalesTaxTest {

    @Test
    void getItemType() {
        assertEquals("food",SalesTax.getItemType("CHOCOLATE"));
    }

    @Test
    void testInputParametersforGetItemType(){
        NullPointerException exceptionForItemParsingList = Assertions.assertThrows(NullPointerException.class, () -> SalesTax.getItemType(""));
        Assertions.assertEquals("Input items cannot be empty",exceptionForItemParsingList.getMessage());
    }

    @Test
    void computeItemSalesTax() {
        List<ItemsParsing> itemsParsingList =  new ArrayList<>(Collections.singletonList(new ItemsParsing(2,"chocolate",5.0f)));
        assertEquals(0.0F,SalesTax.computeItemSalesTax(itemsParsingList).get(0).getTaxPercentage());

    }

    @Test
    void testInputParametersForComputeItemSalesTax(){
        List<ItemsParsing> itemsParsingListException1 = new ArrayList<>();
        NullPointerException exceptionForItemParsingList = Assertions.assertThrows(NullPointerException.class, () -> SalesTax.computeItemSalesTax(itemsParsingListException1));
        Assertions.assertEquals("Input items cannot be empty",exceptionForItemParsingList.getMessage());

    }

    @Test
    void computeTotalSalesTax() {
        List<ItemSalesTax> itemSalesTaxes = new ArrayList<>(Collections.singletonList(new ItemSalesTax("chocolate",0.0f,0.0f)));
        assertEquals(0.0F, SalesTax.computeTotalSalesTax(itemSalesTaxes));
    }

    @Test
    void testInputParametersforComputeTotalSalesTax(){
        List<ItemSalesTax> itemSalesTaxes= new ArrayList<>();
        NullPointerException exceptionForItemParsingList = Assertions.assertThrows(NullPointerException.class, () -> SalesTax.computeTotalSalesTax(itemSalesTaxes));
        Assertions.assertEquals("SalesTax is not computed for the items",exceptionForItemParsingList.getMessage());


    }

}