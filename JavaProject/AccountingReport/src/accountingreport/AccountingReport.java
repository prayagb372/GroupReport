/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountingreport;

/**
 *
 * @author pzp12
 */

import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountingReport {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<Integer> product1 = new ArrayList<>();
        ArrayList<Integer> product2 = new ArrayList<>();
        ArrayList<Integer> product3 = new ArrayList<>();
        ArrayList[] arrays = {product1,product2,product3};
        int[] arrayTotals = {0,0,0};
        
        try {
            // TODO code application logic here
            File output = new File("accountingReport.txt");
            CSVReader reader = new CSVReader(new FileReader("CSV/SalesJan2009.csv"));
            String [] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                // nextLine[] is an array of values from the line
                System.out.println(nextLine[1] + " " + nextLine[2]);
                if(nextLine[1].equals("Product1")) {
                    product1.add(Integer.valueOf(nextLine[2]));
                } else if(nextLine[1].equals("Product2")) {
                    product2.add(Integer.valueOf(nextLine[2]));
                } else if(nextLine[1].equals("Product3")) {
                    product3.add(Integer.valueOf(nextLine[2]));
                }
            }
            
            for(int i = 0; i<arrays.length; i++) {
                arrayTotals[i] = sumArrayList(arrays[i]);
            }
            
            PrintWriter pw = new PrintWriter(output);
            pw.println("Product\tNumber Sold\tTotal (in $)");
            pw.println("Product 1\t" + product1.size() + "\t" + arrayTotals[0]);
            pw.println("Product 2\t" + product2.size() + "\t" + arrayTotals[1]);
            pw.println("Product 3\t" + product3.size() + "\t" + arrayTotals[2]);
            pw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AccountingReport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AccountingReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static int sumArrayList(ArrayList<Integer> products) {
        int sum = 0;
        for(int product: products) {
            sum += product;
        }
        
        return sum;
    }
    
}
