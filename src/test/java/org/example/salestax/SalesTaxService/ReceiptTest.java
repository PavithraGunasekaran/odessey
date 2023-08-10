package org.example.salestax.SalesTaxService;

import org.example.salestax.items.ItemsParsing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.internal.matchers.Null;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Pavithra Gunasekaran
 */

class ReceiptTest {

    @InjectMocks
    private  static List<ItemsParsing> itemsParsingList;

    private static List<ItemSalesTax> itemSalesTaxList;

    private static  List<ItemReceipt> itemReceiptList;
    @BeforeAll
    public static void setUp(){
        itemsParsingList = new ArrayList<>(Collections.singletonList(new ItemsParsing(1, "food test", 10.0f)));
        itemSalesTaxList = new ArrayList<>(Collections.singletonList(new ItemSalesTax("food test", 1.0f, 0.01f)));
        itemReceiptList = new ArrayList<>(Collections.singletonList(new ItemReceipt("food test", 1, 10.01f)));

    }

    @Test
    void generateReceipt() {
    assertEquals(itemReceiptList.get(0).price,Receipt.generateReceipt(itemSalesTaxList,itemsParsingList).get(0).price);
    }

    @Test
    void testInputParamatersForGenerateReceipt() {

        List<ItemsParsing> itemsParsingListException1 = new ArrayList<>();
        List<ItemSalesTax> itemSalesTaxList = new ArrayList<>(Collections.singletonList(new ItemSalesTax("food test", 1.0f, 0.01f)));
        NullPointerException exceptionForItemParsingList = Assertions.assertThrows(NullPointerException.class, () -> Receipt.generateReceipt(itemSalesTaxList,itemsParsingListException1));
        Assertions.assertEquals("Input items cannot be empty",exceptionForItemParsingList.getMessage());

        List<ItemsParsing> itemsParsingList = new ArrayList<>(Collections.singletonList(new ItemsParsing(1, "food test", 10.0f)));
        List<ItemSalesTax> itemSalesTaxListException2 = new ArrayList<>();
        NullPointerException exceptionForItemSalesTaxList = Assertions.assertThrows(NullPointerException.class, () -> Receipt.generateReceipt(itemSalesTaxListException2,itemsParsingList));
        Assertions.assertEquals("Sales tax is not computed for the items",exceptionForItemSalesTaxList.getMessage());



   }
}