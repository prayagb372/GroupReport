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

public class AccountingReport {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        File output = new File("accountingReport.txt");
        CSVReader reader = new CSVReader(new FileReader("CSV/SalesJan2009.csv"));
        String [] nextLine;
        while ((nextLine = reader.readNext()) != null) {
           // nextLine[] is an array of values from the line
           System.out.println(nextLine[0] + nextLine[1] + "etc...");
        }
    }
    
}
