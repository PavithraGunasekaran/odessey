import org.example.salestax.SalesTaxService.ItemReceipt;
import org.example.salestax.SalesTaxService.ItemSalesTax;
import org.example.salestax.SalesTaxService.Receipt;
import org.example.salestax.SalesTaxService.SalesTax;
import org.example.salestax.items.ItemsParsing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Pavithra Gunasekaran
 */

//Users//pavithragunasekaran//Dalhousie//Leetcode//odyssey//src//main//resources//input.txt
public class SalesTaxApplication {

    public static List<ItemsParsing> parsedItems = new ArrayList<>();
    public static List<String> listItemInfo = new ArrayList<>();

    public static void getFileContent(String filePath){
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                listItemInfo.add(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void parseItemList(List<String> listItemInfo){


        for(String i : listItemInfo){
            String[] itemAndQuantity= i.split(" at")[0].split("\\s",2);
            String item = itemAndQuantity[1];
            int quantity = Integer.parseInt(itemAndQuantity[0]);
            float price = Float.parseFloat(i.split(" at")[1]);
            ItemsParsing itemObj = new ItemsParsing(quantity,item,price);
            parsedItems.add(itemObj);

        }
    }

    public static void main(String args[]){

        Scanner inputPath = new Scanner(System.in);
        System.out.println("Enter a file path:");
        String filePath = inputPath.nextLine();
        getFileContent(filePath);
        parseItemList(listItemInfo);
        List<ItemSalesTax> allItemSalesTaxes = SalesTax.computeItemSalesTax(parsedItems);
//        System.out.println("Sales tax info --------------------------");
//        for(ItemSalesTax eachItemSalesTax: allItemSalesTaxes){
//            System.out.println(eachItemSalesTax.getItem()+","+eachItemSalesTax.getTaxPercentage()+"%,"+eachItemSalesTax.getTax());
//        }
        List<ItemReceipt> receipt = Receipt.generateReceipt(allItemSalesTaxes,parsedItems);
        float total= 0.0F;
        System.out.println("Receipt ----------------------");
        for(ItemReceipt r : receipt){
            System.out.println(r.quantity+" "+r.itemName+" : "+r.price);
            total+=r.price;
        }
        float totalSalesTax = SalesTax.computeTotalSalesTax(allItemSalesTaxes);
        System.out.println("Sales Taxes: "+totalSalesTax);
        System.out.println("Total: "+total);
    }
}
